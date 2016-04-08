/**
 * B E A   S Y S T E M S
 *
 * Copyright (c) 2002-2004  BEA Systems, Inc.
 *
 * All Rights Reserved. Unpublished rights reserved under the copyright laws
 * of the United States. The software contained on this media is proprietary
 * to and embodies the confidential technology of BEA Systems, Inc. The
 * possession or receipt of this information does not convey any right to
 * disclose its contents, reproduce it, or use,  or license the use, for
 * manufacture or sale, the information or anything described therein. Any
 * use, disclosure, or reproduction without BEA System's prior written
 * permission is strictly prohibited.
 *
 */
package com.bea.jsptools.portal.util;

import com.bea.jsptools.common.Utility;
import com.bea.jsptools.portal.PortalVisitorConstants;
import com.bea.jsptools.portal.PortalVisitorManager;
import com.bea.netuix.application.definition.BookDefinition;
import com.bea.netuix.application.definition.PageDefinition;
import com.bea.netuix.application.identifier.BookInstanceId;
import com.bea.netuix.application.identifier.MenuDefinitionId;
import com.bea.netuix.application.identifier.PlaceableInstanceId;
import com.bea.netuix.application.identifier.PortletInstanceId;
import com.bea.netuix.application.localization.definition.LocalizationResource;
import com.bea.netuix.application.manager.CustomizationContext;
import com.bea.netuix.application.manager.entitlements.PortalEntitlementHelper;
import com.bea.netuix.application.view.MenuView;
import com.bea.netuix.application.view.PageView;
import com.bea.netuix.application.view.PlaceableView;
import com.bea.netuix.application.view.PlaceholderView;
import com.bea.netuix.servlets.controls.PresentationContext;
import com.bea.netuix.servlets.controls.application.ThemePresentationContext;
import com.bea.netuix.servlets.controls.page.BookPresentationContext;
import com.bea.netuix.servlets.controls.page.PagePresentationContext;
import com.bea.netuix.servlets.controls.portlet.PortletPresentationContext;
import com.bea.p13n.management.ApplicationHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

public class VisitorToolsHtmlUtil
{
    protected static String RESOURCE_BUNDLE = "visitorTools";
    protected static String UP_GIF = "/visitorTools/images/up.gif'";
    protected static String DOWN_GIF = "/visitorTools/images/down.gif'";
    protected static String LEFT_GIF = "/visitorTools/images/left.gif'";
    protected static String RIGHT_GIF = "/visitorTools/images/right.gif'";
    protected static String BOOK_16_GIF = "/visitorTools/images/book-16.gif";
    protected static String PAGE_16_GIF = "/visitorTools/images/page-16.gif";
    protected static String PORTLET_16_GIF = "/visitorTools/images/portlet-16.gif";
    protected static String CLASS_BEA_PORTAL_WINDOW = "bea-portal-window";
    protected static String CLASS_PORTLET_SECTION_ALT = "portlet-section-alternate";
    protected static String CLASS_BOOKCHILD = "bookchild";
    protected static String CLASS_BOOK = "book";
    protected static String CLASS_PAGE_CHILD = "pagechild";
    protected static String CLASS_PAGE = "page";
    protected static String CLASS_PORTLET_CHILD = "portletchild";
    
    private static String QUOTE = "\"";
    private static String END_BRACE = ">\n";
    private final static Pattern quotePattern = Pattern.compile( "\"" );
    private final static Pattern singleQuotePattern = Pattern.compile( "\'" );
    private final static String TWO_SEVEN = "\\\\u0027";
    private final static String TWO_TWO = "\\\\u0022";

    /**
     * Return the html representing the current placeholders in the given PageView.  Currently implementation is difficult in jsp due to use of <layout>.html.text files
     * that are parsed and used for actual table layout, which requires much string manipulation ( index of , replacements ) here.
     *
     * @param pageContext
     * @param request
     * @param pageView
     * @param ep
     * @param pageId
     * @return
     */
    public static String getPlaceholdersHtml( PageContext pageContext, HttpServletRequest request, PageView pageView, EntitledPresentations ep, String pageId )
    {
        String newLayoutHTML = "";
        String webAppName = ApplicationHelper.getWebAppName(request);
        // path in format of '/portalpath/desktoppath'
        String pathInfo = request.getPathInfo();
        String portalPath = pathInfo.substring(1, pathInfo.lastIndexOf("/"));
        String desktopPath = pathInfo.substring(pathInfo.lastIndexOf("/") + 1, pathInfo.length());
        String layoutHTMLPath   = pageView.getLayoutView().getHtmlLayoutUri();
        String layoutHTML = PortalVisitorManager.getLayoutHtml(layoutHTMLPath, webAppName);
        PlaceholderView[] placeholderViews = pageView.getPlaceholderViews();

        if (layoutHTML != null)
        {
            int     startIndex            = 0;
            int     placeholderStartIndex = 0;
            int     placeholderEndIndex   = 0;
            placeholderStartIndex = layoutHTML.indexOf("<placeholder", startIndex);

            while (placeholderStartIndex != -1)
            {
                placeholderEndIndex = layoutHTML.indexOf(">", placeholderStartIndex);
                String tmpPlaceholder = layoutHTML.substring(placeholderStartIndex, placeholderEndIndex);
                String[] vals = tmpPlaceholder.split("\"");
                boolean isLocked = PortalVisitorManager.isPlaceholderLocked(webAppName, portalPath, desktopPath, pageId, vals[1], request);
                int placeholderIndex = Integer.parseInt( vals[ 1 ] );
                newLayoutHTML += layoutHTML.substring( startIndex, placeholderStartIndex );
                newLayoutHTML += VisitorToolsHtmlUtil.getPlaceholderHtml( pageContext, placeholderViews[ placeholderIndex ], isLocked, ep, webAppName, placeholderIndex );
                startIndex = placeholderEndIndex + 1;
                placeholderStartIndex = layoutHTML.indexOf("<placeholder", startIndex);
            }

            newLayoutHTML = newLayoutHTML + layoutHTML.substring(startIndex, layoutHTML.length());
        }
        else
        {
            newLayoutHTML = Utility.getMessage( pageContext, "edit.book.error", RESOURCE_BUNDLE );
        }

        return newLayoutHTML;
    }

    /**
     * Return a String[] of options for a select.representing the Book Definitions for the given request...
     *
     * @param request
     * @param webAppName
     * @param portalPath
     * @param desktopPath
     *
     * @return
     */
    public static String[] getBookDefinitionOptions( HttpServletRequest request, String webAppName, String portalPath,
                                                     String desktopPath )
    {
        ArrayList options = new ArrayList();
        BookDefinition[] books = PortalVisitorManager.getPublicBookDefinitions(webAppName, portalPath, desktopPath, request.getLocale(), request);

        for( int j = 0; j < books.length; j++ )
        {
            BookDefinition tmp2 = books[j];
            if( tmp2.isPublic() )
            {
                LocalizationResource lr2 = tmp2.getLocalizationResource();
                String title2 = "";
                if( lr2 != null )
                {
                    title2 = lr2.getTitle();
                }

                int id2 = tmp2.getBookDefinitionId().getId();
                options.add("<option value=\"" + id2 + "\">" + PortalVisitorManager.crossSiteScriptFix(title2));
            }
        }

        return ( String[] ) options.toArray(new String[0]);
    }

    /**
     * Return a String[] of options for a select.representing the Page Definitions for the given request...
     *
     * @param request
     * @param webAppName
     * @param portalPath
     * @param desktopPath
     *
     * @return
     */
    public static String[] getPageDefinitionOptions( HttpServletRequest request, String webAppName, String portalPath,
                                                     String desktopPath )
    {
        ArrayList options = new ArrayList();
        PageDefinition[] pages = PortalVisitorManager.getPublicPageDefinitions(webAppName, portalPath, desktopPath, request.getLocale(), request);

        for( int i = 0; i < pages.length; i++ )
        {
            PageDefinition tmp = pages[i];
            if( tmp.isPublic() )
            {
                LocalizationResource lr = tmp.getLocalizationResource();
                String title = "";

                if( lr != null )
                {
                    title = lr.getTitle();
                }
                int id = tmp.getPageDefinitionId().getId();
                options.add("<option value=\"" + id + "\">" + PortalVisitorManager.crossSiteScriptFix(title));
            }
        }

        return ( String[] ) options.toArray(new String[0]);
    }

    /**
     * Return a String[] of select options representing the entitled page presentations for the given BookPresentationContext.
     * @param theBookPC
     * @return
     */
    public static String[] getBookItemOptions( BookPresentationContext theBookPC )
    {
        ArrayList options = new ArrayList();
        List bp = theBookPC.getEntitledPagePresentationContexts();
        Iterator it = bp.iterator();
        
        for( int i = 0; it.hasNext(); i++ )
        {
            String navId = "";
            String title = "";
            PresentationContext pc = ( PresentationContext ) it.next();

            if( pc instanceof BookPresentationContext )
            {
                BookPresentationContext bpc = ( BookPresentationContext ) pc;
                String bookInstanceId = bpc.getInstanceId();
                title = bpc.getTitle();

                navId = PortalVisitorConstants.BOOK + "_" + bookInstanceId;
            }
            else
            {
                if( pc instanceof PagePresentationContext )
                {
                    PagePresentationContext ppc = ( PagePresentationContext ) pc;
                    String pageInstanceId = ppc.getInstanceId();
                    title = ppc.getTitle();

                    navId = PortalVisitorConstants.PAGE + "_" + pageInstanceId;
                }
            }

            options.add("<option value=\"" + navId + "\">" + PortalVisitorManager.crossSiteScriptFix(title));
        }

        return ( String[] ) options.toArray(new String[0]);
    }

    /**
     * Return the html representing a placeholder for the visitorToolsEditPage.jsp
     *
     * @param page
     * @param view
     * @param placeholderLocked
     * @param ep
     * @param webAppName
     * @param placeholderIndex
     * @return
     */
    public static String getPlaceholderHtml( PageContext page, PlaceholderView view, boolean placeholderLocked,
                                             EntitledPresentations ep, String webAppName, int placeholderIndex )
    {
        String tableId = "portlets_" + placeholderIndex;
        String lockedString = placeholderLocked ? "disabled=\"true\" " : "";
        String checkedString = placeholderLocked ? "checked " : "";
        String placeholderList = "placeholderList" + placeholderIndex;

        StringBuffer html = new StringBuffer();

        html.append("   <div class=\"" + CLASS_BEA_PORTAL_WINDOW + QUOTE + " id=\"placeholder" + placeholderIndex + QUOTE + END_BRACE);
        html.append("    <input style=\"display:none;\" type=\"checkbox\" " + checkedString + "id=\"lockPlaceholder" + placeholderIndex + "\" name=\"lockPlaceholder" + placeholderIndex + "\">");
        html.append("     <div class=\"" + CLASS_PORTLET_SECTION_ALT + QUOTE + " style='white-space:nowrap;'>\n");
        html.append("        <div " + lockedString + "id=\"portlets" + placeholderIndex + QUOTE + END_BRACE);
        html.append("          <table id=\"" + tableId + QUOTE + END_BRACE);
        html.append("            <tr>\n");
        html.append("              <td width=\"99%" + QUOTE + END_BRACE);
        html.append("                 <select " + lockedString + "id=\"" + placeholderList + "\" name=\"" + placeholderList + "\" size=\"5\" style=\"width:100%;\">\n");

        PlaceableView[] portletViews = view.getPlaceableViews();
        
        for( int k = 0; k < portletViews.length; k++ )
        {
            String portletId = "";
            boolean entitled = false;

            PlaceableInstanceId pInstanceId = portletViews[k].getPlaceableInstance().getPlaceableInstanceId();
            if( pInstanceId instanceof PortletInstanceId )
            {
                PortletInstanceId portletInstanceId = ( PortletInstanceId ) pInstanceId;
                if( ep.getEntitledPortlets().contains(Integer.toString(portletInstanceId.getId())) )
                {
                    entitled = true;
                }
                portletId = PortalVisitorConstants.PORTLET + "_" + Integer.toString(portletInstanceId.getId());
            }
            else
            {
                if( pInstanceId instanceof BookInstanceId )
                {
                    BookInstanceId bookInstanceId = ( BookInstanceId ) pInstanceId;
                    if( ep.getEntitledBooks().contains(Integer.toString(bookInstanceId.getId())) )
                    {
                        entitled = true;
                    }
                    portletId = PortalVisitorConstants.BOOK + "_" + Integer.toString(bookInstanceId.getId());
                }
            }
            
            String portletTitle = PortalVisitorManager.crossSiteScriptFix(portletViews[k].getTitle());

            if( entitled )
            {
                html.append("                       <option value=\"" + portletId + "\">" + portletTitle);
            }
            // CR232222 Add a label value of notEntitled which is checked in page.js
            else
            {
                html.append("                       <option value=\"" + portletId + "\" label=\"notEntitled\" class=\"portlet-font-dim\">" + portletTitle);                
            }
            
        }

        html.append("                </select>\n");
        html.append("              </td>\n");
        html.append("              <td width=\"1%\">\n");
        html.append("                <a href='javascript:moveUp(\"" + placeholderIndex + "\")'><img border='0' src='/" + webAppName + UP_GIF);
        html.append(" title='" + Utility.getMessage(page, "edit.page.move.up", RESOURCE_BUNDLE) + "'></a><br>\n");
        html.append("                <a href='javascript:moveDown(\"" + placeholderIndex + "\")'><img border='0' src='/" + webAppName + DOWN_GIF);
        html.append(" title='" + Utility.getMessage(page, "edit.page.move.down", RESOURCE_BUNDLE) + "'></a>\n");
        html.append("              </td>\n");
        html.append("            </tr>\n");
        html.append("            <tr>\n");
        html.append("              <td align='center'>\n");
        html.append("                 <a href='javascript:moveLeft(\"" + placeholderIndex + "\")'><img border='0' src='/" + webAppName + LEFT_GIF);
        html.append(" title='" + Utility.getMessage(page, "edit.page.move.prev", RESOURCE_BUNDLE) + "'></a>\n");
        html.append("                 <a href='javascript:moveRight(\"" + placeholderIndex + "\")'><img border='0' src='/" + webAppName + RIGHT_GIF);
        html.append(" title='" + Utility.getMessage(page, "edit.page.move.next", RESOURCE_BUNDLE) + "'></a>\n");
        html.append("              </td>\n");
        html.append("            </tr>\n");
        html.append("            <tr>\n");
        html.append("              <td valign=\"top\" colspan=\"2\" align=\"center\">\n");
        
        String remove = Utility.getMessage(page, "edit.page.button.remove", RESOURCE_BUNDLE);

        if( lockedString.equals("") )
        {
            // "<i18n:getMessage messageName='no.selected.item.remove'/>"
            html.append("                  <input type='button' value='" + remove + "' onClick='removeItem(\"" + placeholderIndex + "\", \"" + 
                                                 Utility.getMessage(page, "no.selected.item.remove", RESOURCE_BUNDLE) + "\", \"" + 
                                                 Utility.getMessage(page, "not.entitled.to.remove", RESOURCE_BUNDLE) + "\")'");
        }
        else
        {
            html.append("                  <input type='button' value='" + remove + "'");
        }

        html.append(" title='" + Utility.getMessage(page, "edit.page.button.remove.title", RESOURCE_BUNDLE) + "'>\n");
        html.append("              </td>\n");
        html.append("            </tr>\n");
        html.append("            <tr>\n");
        html.append("              <td valign=\"top\" colspan=\"2\" align=\"center\">\n");

        String add = Utility.getMessage(page, "edit.page.button.add", RESOURCE_BUNDLE);

        if( lockedString.equals("") )
        {
            // "Add New Item"
            html.append("                <br><input type='button' value='" + add + "' onClick='addContent(\"" + placeholderIndex + "\", \"" + Utility.getMessage(page, "edit.page.button.add.single" , RESOURCE_BUNDLE) + "\")'");
        }
        else
        {
            html.append("                <br><input type='button' value='" + add + "'");
        }

        html.append(" title='" + Utility.getMessage(page, "edit.page.button.add.title", RESOURCE_BUNDLE) + "'>\n");
        html.append("              </td>\n");
        html.append("            </tr>\n");
        html.append("          </table>\n");
        html.append("        </div>\n");
        html.append("      </div>\n");
        html.append("    </div>\n");

        return html.toString();
    }

    public static String fixupQuotes( String x )
    {
        x= quotePattern.matcher( x ).replaceAll( TWO_TWO );
        return singleQuotePattern.matcher( x ).replaceAll( TWO_SEVEN );
    }

    /**
     *
     *
     * @param bookPC
     * @param request
     * @param mode
     * @param taxonomy
     * @param theResourceCount
     * @return
     */
    public static String getBookChildren( PageContext pageContext, BookPresentationContext bookPC, HttpServletRequest request, boolean mode,
                                          String taxonomy, ResourceCount theResourceCount )
    {
        String webAppName1 = ApplicationHelper.getWebAppName(request);
        StringBuffer html = new StringBuffer();

        String parentBookInstanceId = bookPC.getInstanceId();
        int originalResourceCount = theResourceCount.getResourceCount();

        List bp = bookPC.getEntitledPagePresentationContexts();
        Iterator it = bp.iterator();

        for( int i = 0; it.hasNext(); i++ )
        {
            PresentationContext pc = ( PresentationContext ) it.next();

            if( pc instanceof BookPresentationContext )
            {
                BookPresentationContext bpc = ( BookPresentationContext ) pc;
                String bookInstanceId = bpc.getInstanceId();

                String nextBookTitle = PortalVisitorManager.crossSiteScriptFix(bpc.getTitle());
                String fixedBookTitle = fixupQuotes( nextBookTitle );

                ThemePresentationContext themePresentationContext = bpc.getThemePresentationContext();

                String bookThemeId = "-1";

                if( themePresentationContext != null )
                {
                    bookThemeId = themePresentationContext.getDefinitionId();
                }

                if( mode )
                {
                    String tax = taxonomy + "B" + bookInstanceId + ".";
                    html.append("    resourcesArray.push(new Array(2));\n");
                    html.append("    resourcesArray[" + theResourceCount.getResourceCount() + "][0] = \"book" + String.valueOf(theResourceCount.getBookCount()) + "\"\n");
                    html.append("    resourcesArray[" + theResourceCount.getResourceCount() + "][1] = \"" + tax + "\"\n");
                    theResourceCount.setResourceCount(theResourceCount.getResourceCount() + 1);
                    theResourceCount.setBookCount(theResourceCount.getBookCount() + 1);
                    html.append(getBookChildren(pageContext, bpc, request, mode, tax, theResourceCount));
                }
                else
                {
                    String tax = taxonomy + "B" + bookInstanceId + ".";

                    if( originalResourceCount != 0 )
                    {
                        html.append("  <div class=\"" + CLASS_BOOKCHILD + QUOTE + " style=\"display:none;position:relative\">\n");
                    }
                    else
                    {
                        html.append("  <div class=\"" + CLASS_BOOK + QUOTE + " style=\"position:relative\">\n");
                    }
                    html.append("    <blockquote style='margin-left:21px;margin-right:0px;margin-top:0px;margin-bottom:0px'>\n");
                    html.append("      <div style=\"display:block;\" id=\"book" + String.valueOf(theResourceCount.getBookCount()) + "On\">\n");
                    html.append("        <img src=\"/" + webAppName1 + BOOK_16_GIF + "\"><a href='javascript:selectBook(\"" + bookInstanceId + "\", \"" + parentBookInstanceId + "\", \"book\", \"" + bookThemeId + "\", \"" + fixedBookTitle + "\", \"" + String.valueOf(theResourceCount.getBookCount()) + "\", \"" + tax + "\", \"" + Utility.getMessage(pageContext, "selected.book", RESOURCE_BUNDLE)+ "\")'>" + nextBookTitle + "</a>\n");
                    html.append("      </div>\n");
                    html.append("      <div style=\"display:none;color:#999999;\" id=\"book" + String.valueOf(theResourceCount.getBookCount()) + "Off\">\n");
                    html.append("        <img src=\"/" + webAppName1 + BOOK_16_GIF + "\">" + nextBookTitle + "\n");
                    html.append("      </div>\n");
                    
                    theResourceCount.setResourceCount(theResourceCount.getResourceCount() + 1);
                    theResourceCount.setBookCount(theResourceCount.getBookCount() + 1);
                    
                    html.append(getBookChildren(pageContext, bpc, request, mode, tax, theResourceCount));
                    html.append("    </blockquote>\n");
                    html.append("  </div>\n");
                }
            }
            else
            {
                if( pc instanceof PagePresentationContext )
                {
                    PagePresentationContext ppc = ( PagePresentationContext ) pc;
                    String pageInstanceId = ppc.getInstanceId();

                    String pageTitle = PortalVisitorManager.crossSiteScriptFix(ppc.getTitle());

                    String fixedPageTitle = fixupQuotes( pageTitle );
                    ThemePresentationContext themePresentationContext = ppc.getThemePresentationContext();

                    String pageThemeId = "-1";

                    if( themePresentationContext != null )
                    {
                        pageThemeId = themePresentationContext.getDefinitionId();
                    }

                    if( mode )
                    {
                        String tax = taxonomy + "P" + pageInstanceId + ".";
                        html.append("    resourcesArray.push(new Array(2));\n");
                        html.append("    resourcesArray[" + theResourceCount.getResourceCount() + "][0] = \"page" + String.valueOf(theResourceCount.getPageCount()) + "\"\n");
                        html.append("    resourcesArray[" + theResourceCount.getResourceCount() + "][1] = \"" + tax + "\"\n");
                        theResourceCount.setResourceCount(theResourceCount.getResourceCount() + 1);
                        theResourceCount.setPageCount(theResourceCount.getPageCount() + 1);
                        html.append(getPageChildren(pageContext, ppc, request, mode, tax, theResourceCount));
                    }
                    else
                    {
                        String tax = taxonomy + "P" + pageInstanceId + ".";

                        if( originalResourceCount != 0 )
                        {
                            html.append("  <div class=\"" + CLASS_PAGE_CHILD + QUOTE + " style=\"display:none;position:relative\">\n");
                        }
                        else
                        {
                            html.append("  <div class=\"" + CLASS_PAGE + QUOTE + " style=\"position:relative\">\n");
                        }
                        html.append("    <blockquote style='margin-left:21px;margin-right:0px;margin-top:0px;margin-bottom:0px'>\n");
                        html.append("      <div style=\"display:block;\" id=\"page" + String.valueOf(theResourceCount.getPageCount()) + "On\">\n");
                        html.append("        <img src=\"/" + webAppName1 + PAGE_16_GIF + "\"><a href='javascript:selectPage(\"" + pageInstanceId + "\", \"" + parentBookInstanceId + "\", \"book\", \"" + pageThemeId + "\", \"" + fixedPageTitle + "\", \"" + tax + "\", \"" + Utility.getMessage(pageContext, "selected.page", RESOURCE_BUNDLE)+"\")'>" + pageTitle + "</a>\n");
                        html.append("      </div>\n");
                        html.append("      <div style=\"display:none;color:#999999\" id=\"page" + String.valueOf(theResourceCount.getPageCount()) + "Off\">\n");
                        html.append("        <img src=\"/" + webAppName1 + PAGE_16_GIF + "\">" + pageTitle + "\n");
                        html.append("      </div>\n");
                        theResourceCount.setResourceCount(theResourceCount.getResourceCount() + 1);
                        theResourceCount.setPageCount(theResourceCount.getPageCount() + 1);
                        html.append(getPageChildren(pageContext, ppc, request, mode, tax, theResourceCount));
                        html.append("    </blockquote>\n");
                        html.append("  </div>\n");
                    }
                }
            }
        }

        return html.toString();
    }

    /**
     *
     * @param pagePC
     * @param request
     * @param mode
     * @param taxonomy
     * @param theResourceCount
     * @return
     */
    public static String getPageChildren( PageContext pageContext, PagePresentationContext pagePC, HttpServletRequest request, boolean mode,
                                          String taxonomy, ResourceCount theResourceCount )
    {
        String webAppName1 = ApplicationHelper.getWebAppName(request);
        StringBuffer html = new StringBuffer();
        String parentPageInstanceId = pagePC.getInstanceId();

        List pp = pagePC.getWindowPresentationContexts();
        Iterator it = pp.iterator();
        for( int i = 0; it.hasNext(); i++ )
        {
            PresentationContext pc = ( PresentationContext ) it.next();

            if( pc instanceof PortletPresentationContext )
            {
                PortletPresentationContext ppc = ( PortletPresentationContext ) pc;
                String portletInstanceId = ppc.getInstanceId();
                
                String portletTitle = PortalVisitorManager.crossSiteScriptFix(ppc.getTitle());
                String fixedPortletTitle = fixupQuotes( portletTitle );
                ThemePresentationContext themePresentationContext = ppc.getThemePresentationContext();

                String portletThemeId = "-1";

                if( themePresentationContext != null )
                {
                    portletThemeId = themePresentationContext.getDefinitionId();
                }

                if( !mode )
                {
                    html.append("  <div class=\"" + CLASS_PORTLET_CHILD + QUOTE + " style=\"display:none;position:relative\">\n");
                    html.append("    <blockquote style='margin-left:21px;margin-right:0px;margin-top:0px;margin-bottom:0px'>\n");
                    html.append("      <div style=\"display:block;\" id=\"portlet" + String.valueOf(theResourceCount.getPortletCount()) + "On\">\n");
                    html.append("        <img src=\"/" + webAppName1 + PORTLET_16_GIF + "\"><a href='javascript:selectPortlet(\"" + portletInstanceId + "\", \"" + parentPageInstanceId + "\", \"page\", \"" + portletThemeId + "\", \"" + fixedPortletTitle + "\", \"" + taxonomy + "\", \"" + Utility.getMessage(pageContext, "selected.portlet", RESOURCE_BUNDLE)+ "\")'>" + portletTitle + "</a>\n");
                    html.append("      </div>\n");
                    html.append("      <div style=\"display:none;color:#999999;\" id=\"portlet" + String.valueOf(theResourceCount.getPortletCount()) + "Off\">\n");
                    html.append("        <img src=\"/" + webAppName1 + PORTLET_16_GIF + "\">" + portletTitle + "\n");
                    html.append("      </div>\n");
                    html.append("    </blockquote>\n");
                    html.append("  </div>\n");
                    theResourceCount.setPortletCount(theResourceCount.getPortletCount() + 1);
                }
            }
            else
            {
                BookPresentationContext bpc = ( BookPresentationContext ) pc;
                String bookInstanceId = bpc.getInstanceId();
                String bookTitle = PortalVisitorManager.crossSiteScriptFix(bpc.getTitle());
                String fixedBookTitle = fixupQuotes( bookTitle ) ;

                if( bookInstanceId != null )
                {
                    ThemePresentationContext themePresentationContext = bpc.getThemePresentationContext();
                    String bookThemeId = "-1";

                    if( themePresentationContext != null )
                    {
                        bookThemeId = themePresentationContext.getDefinitionId();
                    }

                    if( mode )
                    {
                        String tax = taxonomy + "B" + bookInstanceId + ".";
                        html.append("    resourcesArray.push(new Array(2));\n");
                        html.append("    resourcesArray[" + theResourceCount.getResourceCount() + "][0] = \"book" + String.valueOf(theResourceCount.getBookCount()) + "\"\n");
                        html.append("    resourcesArray[" + theResourceCount.getResourceCount() + "][1] = \"" + tax + "\"\n");
                        theResourceCount.setResourceCount(theResourceCount.getResourceCount() + 1);
                        theResourceCount.setBookCount(theResourceCount.getBookCount() + 1);
                        html.append(getBookChildren(pageContext, bpc, request, mode, tax, theResourceCount));
                    }
                    else
                    {
                        String tax = taxonomy + "B" + bookInstanceId + ".";
                        html.append("  <div class=\"" + CLASS_BOOKCHILD + QUOTE + " style=\"display:none;position:relative\">\n");
                        html.append("    <blockquote style='margin-left:21px;margin-right:0px;margin-top:0px;margin-bottom:0px'>\n");
                        html.append("      <div style=\"display:block;\" id=\"book" + String.valueOf(theResourceCount.getBookCount()) + "On\">\n");
                        html.append("        <img src=\"/" + webAppName1 + BOOK_16_GIF + "\"><a href='javascript:selectBook(\"" + bookInstanceId + "\", \"" + parentPageInstanceId + "\", \"page\", \"" + bookThemeId + "\", \"" + fixedBookTitle + "\" , \"" + String.valueOf(theResourceCount.getBookCount()) + "\", \"" + tax + "\", \"" + Utility.getMessage(pageContext, "selected.page", RESOURCE_BUNDLE)+"\")'>" + bookTitle + "</a>\n");
                        html.append("      </div>\n");
                        html.append("      <div style=\"display:none;color:#999999;\" id=\"book" + String.valueOf(theResourceCount.getBookCount()) + "Off\">\n");
                        html.append("        <img src=\"/" + webAppName1 + BOOK_16_GIF + "\">" + bookTitle + "\n");
                        html.append("      </div>\n");
                        
                        theResourceCount.setResourceCount(theResourceCount.getResourceCount() + 1);
                        theResourceCount.setBookCount(theResourceCount.getBookCount() + 1);

                        html.append(getBookChildren(pageContext, bpc, request, mode, tax, theResourceCount));
                        html.append("    </blockquote>\n");
                        html.append("  </div>\n");
                    }
                }
            }
        }

        return html.toString();
    }

    /**
     * return the selected menu  id.
     *
     * @param request
     * @param bookId
     * @param webAppName
     * @param portalPath
     * @param desktopPath
     *
     * @return
     */
    public static int getSelectedMenuId( HttpServletRequest request, String bookId, String webAppName,
                                         String portalPath, String desktopPath )
    {
        MenuView mv = PortalVisitorManager.getBookView(bookId, webAppName, portalPath, desktopPath, request.getLocale(), request).getMenuView();

        if( mv != null )
        {
            MenuDefinitionId mdi = mv.getMenuDefinitionId();
            if( mdi != null )
            {
                return mdi.getId();
            }
        }

        return -1;
    }
}


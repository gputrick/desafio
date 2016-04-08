package com.bea.jsptools.portal.backing;

import com.bea.jsptools.portal.PortalVisitorConstants;
import com.bea.jsptools.portal.PortalVisitorManager;
import com.bea.jsptools.portal.placement.BookPlacement;
import com.bea.jsptools.portal.placement.NavigablePlacement;
import com.bea.jsptools.portal.placement.PagePlacement;
import com.bea.netuix.servlets.controls.content.JspContentContext;
import com.bea.netuix.servlets.controls.content.backing.AbstractJspBacking;
import com.bea.portlet.GenericURL;
import com.bea.portlet.PostbackURL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.StringTokenizer;


/**
 * A simple backing file to fire a page change event
 */
public class VisitorToolsEditBookBacking
        extends AbstractJspBacking
{


    public boolean handlePostbackData( HttpServletRequest request, HttpServletResponse response )
    {

        if( request.getUserPrincipal() == null )
        {
            return true;
        }

        JspContentContext contentContext = JspContentContext.getJspContentContext( request );

        assert contentContext != null;

        String newPageLabel = request.getParameter( PortalVisitorConstants.TARGET_PAGE_ID );


        if( newPageLabel != null )
        {
            contentContext.setActivePage( newPageLabel );
        }
        else
        {
            return true;
        }

        String webAppName = request.getParameter( PortalVisitorConstants.WEB_APP_NAME );
        String portalPath = request.getParameter( PortalVisitorConstants.PORTAL_PATH );
        String desktopPath = request.getParameter( PortalVisitorConstants.DESKTOP_PATH );
        String bookId = request.getParameter( PortalVisitorConstants.EDIT_BOOK );
        String mainBook = request.getParameter( PortalVisitorConstants.MAIN_BOOK );

        PostbackURL url = PostbackURL.createPostbackURL( request, response );
        url.addParameter(GenericURL.TREE_OPTIMIZATION_PARAM, "false");
        if (newPageLabel != null)
        {
            url.addParameter(GenericURL.PAGE_LABEL_PARAM, newPageLabel);
        }

        if( mainBook != null )
        {
            url.addParameter( GenericURL.WINDOW_LABEL_PARAM, mainBook );
        }
        url.addParameter( GenericURL.MODE_PARAM, PortalVisitorConstants.EDIT );

        // clear out these set parameters (from setting the menu) if we're going back...
        // redirect
        if( request.getParameter( PortalVisitorConstants.CANCEL_BOOK ) != null )
        {
//            if( request.getParameter( PortalVisitorConstants.EDIT_BOOK ) == null )
//            {
            url.addParameter( PortalVisitorConstants.PAGE_LABEL, PortalVisitorConstants.VISITOR_TOOLS_MAIN_PAGE );
//            }

            contentContext.sendRedirect( url.toString() );
            return true;
        }


        // Change Menu, is redirect
        String menuId = request.getParameter( PortalVisitorConstants.MENU_ID );
        if( menuId != null )
        {
            if( menuId.equals( PortalVisitorConstants.NEGATIVE_ONE ) )
            {
                menuId = null;
            }
            int newBookInstanceId = PortalVisitorManager.updateBookInstanceMenu( bookId, menuId, webAppName, portalPath, desktopPath, request.getLocale(), request );
            
            // Set new book instance id as current id, as it has changed.  We don't want to edit/view the old one.
            url.addParameter( PortalVisitorConstants.EDIT_BOOK, Integer.toString( newBookInstanceId ) );
            String bookName = request.getParameter( PortalVisitorConstants.EDIT_BOOK_NAME );
            if( bookName != null )
            {
                url.addParameter( PortalVisitorConstants.EDIT_BOOK_NAME, bookName );
            }
            url.addParameter( PortalVisitorConstants.PAGE_LABEL, PortalVisitorConstants.VISITOR_TOOLS_EDIT_BOOK );
            contentContext.sendRedirect( url.toString() );
            return true;
        }

        // save changes in the book, could be move,add,deletes
        if( request.getParameter( PortalVisitorConstants.SAVE_BOOK ) != null )
        {
            String moveNavigableIds = request.getParameter( PortalVisitorConstants.MOVE_NAVIGABLE_IDS );
            String moveNavigablePositions = request.getParameter( PortalVisitorConstants.MOVE_NAVIGABLE_POSITIONS );
            String deleteNavigableIds = request.getParameter( PortalVisitorConstants.DELETE_NAVIGABLE_IDS );
            String addNavigableIds = request.getParameter( PortalVisitorConstants.ADD_NAVIGABLE_IDS );
            String addNavigablePositions = request.getParameter( PortalVisitorConstants.ADD_NAVIGABLE_POSITIONS );

            if( moveNavigableIds != null && moveNavigablePositions != null )
            {
                moveNavigables( request, webAppName, portalPath, desktopPath, moveNavigableIds, moveNavigablePositions, bookId );
            }

            if( addNavigableIds != null && addNavigablePositions != null )
            {
                addNavigables( request, webAppName, portalPath, desktopPath, addNavigableIds, addNavigablePositions, bookId );
            }

            if( deleteNavigableIds != null )
            {
                deleteNavigables( request, webAppName, portalPath, desktopPath, deleteNavigableIds );
            }        

            // Need to add this for the case where you delete all the pages/books in your main book.  Otherwise
            // the main main doesn't refresh correctly.  
            url.addParameter( PortalVisitorConstants.CUSTOMIZE_PORTAL, PortalVisitorConstants.VISITOR_TOOLS_MAIN_PAGE );
            contentContext.sendRedirect( url.toString() );
            return true;
        }

        return true;
    }


    /**
     * Move the given navigables.
     *
     * @param request
     * @param webAppName
     * @param portalPath
     * @param desktopPath
     * @param moveNavigableIds
     * @param moveNavigablePositions
     * @param bookId
     */
    protected void moveNavigables( HttpServletRequest request, String webAppName, String portalPath,
                                   String desktopPath, String moveNavigableIds, String moveNavigablePositions,
                                   String bookId )
    {
        StringTokenizer navigableIds = new StringTokenizer( moveNavigableIds, PortalVisitorConstants.COMMA );
        StringTokenizer navigablePositions = new StringTokenizer( moveNavigablePositions, PortalVisitorConstants.COMMA );

        int idLength = navigableIds.countTokens();
        int positionLength = navigablePositions.countTokens();

        if( idLength != positionLength )
        {
            //error
        }
        else
        {
            NavigablePlacement[] navigables = new NavigablePlacement[idLength];
            int pCount = 0;

            while( navigableIds.hasMoreTokens() )
            {
                String tmp = navigableIds.nextToken();
                String tmp2[] = tmp.split( "_", 2 );
                String navigableType = tmp2[0];
                String navigableId = tmp2[1];

                if( navigableType.equals( PortalVisitorConstants.PAGE ) )
                {
                    navigables[pCount] = new PagePlacement( navigableId, bookId, bookId, navigablePositions.nextToken() );
                }
                else
                {
                    if( navigableType.equals( PortalVisitorConstants.BOOK ) )
                    {
                        navigables[pCount] = new BookPlacement( navigableId, bookId, bookId, navigablePositions.nextToken() );
                    }
                }
                pCount++;
            }

            PortalVisitorManager.moveNavigableInstances( navigables, webAppName, portalPath, desktopPath, request );
        }
    }


    /**
     * Add the given Navigables.
     *
     * @param request
     * @param webAppName
     * @param portalPath
     * @param desktopPath
     * @param addNavigableIds
     * @param addNavigablePositions
     * @param bookId
     */
    protected void addNavigables( HttpServletRequest request, String webAppName, String portalPath, String desktopPath,
                                  String addNavigableIds, String addNavigablePositions, String bookId )
    {
        StringTokenizer addNavigableIdsTok = new StringTokenizer( addNavigableIds, PortalVisitorConstants.COMMA );
        StringTokenizer addNavigablePositionsTok = new StringTokenizer( addNavigablePositions, PortalVisitorConstants.COMMA );

        int addIdLength = addNavigableIdsTok.countTokens();
        int addPositionLength = addNavigablePositionsTok.countTokens();

        if( addIdLength != addPositionLength )
        {
            //error
        }
        else
        {
            NavigablePlacement[] addNavigables = new NavigablePlacement[addIdLength];
            int addPCount = 0;

            while( addNavigableIdsTok.hasMoreTokens() )
            {
                String addTmp = addNavigableIdsTok.nextToken();
                String addTmp2[] = addTmp.split( "_", 3 );
                String addNavigableType = addTmp2[0];
                // addTmp2[1] is garbage used only for correct dhtml functionality
                String addNavigableId = addTmp2[2];

                if( addNavigableType.equals( PortalVisitorConstants.PAGE ) )
                {
                    addNavigables[addPCount] = new PagePlacement( addNavigableId, PortalVisitorConstants.NEGATIVE_ONE, bookId, addNavigablePositionsTok.nextToken() );
                }
                else
                {
                    if( addNavigableType.equals( PortalVisitorConstants.BOOK ) )
                    {
                        addNavigables[addPCount] = new BookPlacement( addNavigableId, PortalVisitorConstants.NEGATIVE_ONE, bookId, addNavigablePositionsTok.nextToken() );
                    }
                    else
                    {
                        if( addNavigableType.equals( PortalVisitorConstants.NEW_PAGE ) )
                        {
                            String newPageStuff[] = addNavigableId.split( PortalVisitorConstants.COLAN, 2 );
                            String newPageLayout = newPageStuff[0];
                            String newPageName = newPageStuff[1];

                            String newPageId = PortalVisitorManager.createPageDefinition( webAppName, newPageName, PortalVisitorConstants.EMPTY, newPageLayout, request.getLocale(), request );
                            addNavigables[addPCount] = new PagePlacement( newPageId, PortalVisitorConstants.NEGATIVE_ONE, bookId, addNavigablePositionsTok.nextToken() );
                        }
                        else
                        {
                            if( addNavigableType.equals( PortalVisitorConstants.NEW_BOOK ) )
                            {
                                String newBookStuff[] = addNavigableId.split( PortalVisitorConstants.COLAN, 2 );
                                String newBookMenu = newBookStuff[0];
                                String newBookName = newBookStuff[1];

                                if( newBookMenu.equals( PortalVisitorConstants.NEGATIVE_ONE ) )
                                {
                                    newBookMenu = null;
                                }

                                String newBookId = PortalVisitorManager.createBookDefinition( webAppName, newBookName, PortalVisitorConstants.EMPTY, newBookMenu, request.getLocale(), request );
                                addNavigables[addPCount] = new BookPlacement( newBookId, PortalVisitorConstants.NEGATIVE_ONE, bookId, addNavigablePositionsTok.nextToken() );
                            }
                        }
                    }
                }

                addPCount++;
            }

            PortalVisitorManager.addNavigableInstances( addNavigables, webAppName, portalPath, desktopPath, request );
        }
    }


    /**
     * Delete the givenNavigables.
     *
     * @param request
     * @param webAppName
     * @param portalPath
     * @param desktopPath
     * @param deleteNavigableIds
     */
    protected void deleteNavigables( HttpServletRequest request, String webAppName, String portalPath,
                                     String desktopPath, String deleteNavigableIds )
    {
        StringTokenizer deletedIds = new StringTokenizer( deleteNavigableIds, PortalVisitorConstants.COMMA );
        int deletedLength = deletedIds.countTokens();

        NavigablePlacement[] deleteNavigables = new NavigablePlacement[deletedLength];
        int pCount2 = 0;

        while( deletedIds.hasMoreTokens() )
        {
            String tmp3 = deletedIds.nextToken();
            String tmp4[] = tmp3.split( "_", 2 );
            String navigableType2 = tmp4[0];
            String navigableId2 = tmp4[1];

            if( navigableType2.equals( PortalVisitorConstants.PAGE ) )
            {
                deleteNavigables[pCount2] = new PagePlacement( navigableId2, PortalVisitorConstants.NEGATIVE_ONE, PortalVisitorConstants.NEGATIVE_ONE, PortalVisitorConstants.NEGATIVE_ONE );
            }
            else
            {
                if( navigableType2.equals( PortalVisitorConstants.BOOK ) )
                {
                    deleteNavigables[pCount2] = new BookPlacement( navigableId2, PortalVisitorConstants.NEGATIVE_ONE, PortalVisitorConstants.NEGATIVE_ONE, PortalVisitorConstants.NEGATIVE_ONE );
                }
            }
            pCount2++;
        }

        PortalVisitorManager.removeNavigableInstances( deleteNavigables, webAppName, portalPath, desktopPath, request );
    }

}

package com.bea.jsptools.portal.backing;

import com.bea.jsptools.portal.PortalVisitorConstants;
import com.bea.jsptools.portal.PortalVisitorManager;
import com.bea.jsptools.portal.placement.BookPlacement;
import com.bea.jsptools.portal.placement.PlaceablePlacement;
import com.bea.jsptools.portal.placement.PortletPlacement;
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
public class VisitorToolsEditPageBacking
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

        PostbackURL url = PostbackURL.createPostbackURL( request, response );
        url.addParameter(GenericURL.TREE_OPTIMIZATION_PARAM, "false");
        if (newPageLabel != null)
        {
            url.addParameter(GenericURL.PAGE_LABEL_PARAM, newPageLabel);
        }

        String mainBook = request.getParameter( PortalVisitorConstants.MAIN_BOOK );
        if( mainBook != null )
        {
            url.addParameter( GenericURL.WINDOW_LABEL_PARAM, mainBook );
        }
        url.addParameter( GenericURL.MODE_PARAM, PortalVisitorConstants.EDIT );

        // clear out these set parameters (from setting the layout) if we're going back...
        if( request.getParameter( PortalVisitorConstants.CANCEL_PAGE ) != null )
        {
//            if( request.getParameter( PortalVisitorConstants.EDIT_PAGE ) == null )
//            {
            url.addParameter( PortalVisitorConstants.PAGE_LABEL, PortalVisitorConstants.VISITOR_TOOLS_MAIN_PAGE );
//            }
            contentContext.sendRedirect( url.toString() );
            return true;
        }

        String webAppName = request.getParameter( PortalVisitorConstants.WEB_APP_NAME );
        String portalPath = request.getParameter( PortalVisitorConstants.PORTAL_PATH );
        String desktopPath = request.getParameter( PortalVisitorConstants.DESKTOP_PATH );
        String pageId = request.getParameter( PortalVisitorConstants.EDIT_PAGE );

        // Save New Page Placement.  
        if( request.getParameter( PortalVisitorConstants.SAVE_PLACEHOLDERS ) != null )
        {
            String movePlaceableIds = request.getParameter( PortalVisitorConstants.MOVE_PLACEABLE_IDS );
            String movePlaceablePlaceholders = request.getParameter( PortalVisitorConstants.MOVE_PLACEABLE_PLACEHOLDERS );
            String movePlaceablePositions = request.getParameter( PortalVisitorConstants.MOVE_PLACEABLE_POSITIONS );
            String deletePlaceableIds = request.getParameter( PortalVisitorConstants.DELETE_PLACEABLE_IDS );
            String addPlaceableIds = request.getParameter( PortalVisitorConstants.ADD_PLACEABLE_IDS );
            String addPlaceablePlaceholders = request.getParameter( PortalVisitorConstants.ADD_PLACEABLE_PLACEHOLDERS );
            String addPlaceablePositions = request.getParameter( PortalVisitorConstants.ADD_PLACEABLE_POSITIONS );

            if( movePlaceableIds != null && movePlaceablePlaceholders != null && movePlaceablePositions != null )
            {
                movePlaceables( request, webAppName, portalPath, desktopPath, movePlaceableIds, movePlaceablePlaceholders, movePlaceablePositions, pageId );
            }

            if( addPlaceableIds != null && addPlaceablePlaceholders != null && addPlaceablePositions != null )
            {
                addPlaceables( request, webAppName, portalPath, desktopPath, addPlaceableIds, addPlaceablePlaceholders, addPlaceablePositions, pageId );
            }

            if( deletePlaceableIds != null )
            {
                deletePlaceables( request, webAppName, portalPath, desktopPath, deletePlaceableIds );
            }

            url.addParameter( PortalVisitorConstants.PAGE_LABEL, PortalVisitorConstants.VISITOR_TOOLS_MAIN_PAGE );
            contentContext.sendRedirect( url.toString() );
            return true;
        }

        // Change Layout.  
        String layoutId = request.getParameter( PortalVisitorConstants.LAYOUT_ID );
        if( layoutId != null )
        {
            int newPageInstanceId = PortalVisitorManager.updatePageInstanceLayout( pageId, layoutId, webAppName, portalPath, desktopPath, request.getLocale(), request );

            // Set new page instance id as current id, as it has changed.  We don't want to edit/view the old one.
            url.addParameter( PortalVisitorConstants.EDIT_PAGE, Integer.toString( newPageInstanceId ) );
            String pageName = request.getParameter( PortalVisitorConstants.EDIT_PAGE_NAME );
            if( pageName != null )
            {
                url.addParameter( PortalVisitorConstants.EDIT_PAGE_NAME, pageName );
            }
            url.addParameter( PortalVisitorConstants.PAGE_LABEL, PortalVisitorConstants.VISITOR_TOOLS_EDIT_PAGE );
            contentContext.sendRedirect( url.toString() );
            return true;
        }

        return true;
    }


    /**
     * Move the given Placeables.
     *
     * @param request
     * @param webAppName
     * @param portalPath
     * @param desktopPath
     * @param movePlaceableIds
     * @param movePlaceablePlaceholders
     * @param movePlaceablePositions
     * @param pageId
     */
    protected void movePlaceables( HttpServletRequest request, String webAppName, String portalPath,
                                   String desktopPath, String movePlaceableIds, String movePlaceablePlaceholders, String movePlaceablePositions,
                                   String pageId )
    {
        StringTokenizer placeableIds = new StringTokenizer( movePlaceableIds, PortalVisitorConstants.COMMA );
        StringTokenizer placeablePlaceholders = new StringTokenizer( movePlaceablePlaceholders, PortalVisitorConstants.COMMA );
        StringTokenizer placeablePositions = new StringTokenizer( movePlaceablePositions, PortalVisitorConstants.COMMA );

        int idLength = placeableIds.countTokens();
        int placeholderLength = placeablePlaceholders.countTokens();
        int positionLength = placeablePositions.countTokens();

        if( ( idLength != placeholderLength ) || ( idLength != positionLength ) )
        {
            //error
        }
        else
        {
            PlaceablePlacement[] placeables = new PlaceablePlacement[idLength];
            int pCount = 0;

            while( placeableIds.hasMoreTokens() )
            {
                String tmp = placeableIds.nextToken();
                String tmp2[] = tmp.split( "_", 2 );
                String placeableType = tmp2[0];
                String placeableId = tmp2[1];

                if( placeableType.equals( PortalVisitorConstants.PORTLET ) )
                {
                    placeables[pCount] = new PortletPlacement( placeableId, pageId, pageId, placeablePlaceholders.nextToken(), placeablePositions.nextToken() );
                }
                else
                {
                    if( placeableType.equals( PortalVisitorConstants.BOOK ) )
                    {
                        placeables[pCount] = new BookPlacement( placeableId, pageId, pageId, placeablePlaceholders.nextToken(), placeablePositions.nextToken() );
                    }
                }
                pCount++;
            }

            PortalVisitorManager.movePlaceableInstances( placeables, webAppName, portalPath, desktopPath, request );
        }
    }


    /**
     * Add the given Placeables.
     *
     * @param request
     * @param webAppName
     * @param portalPath
     * @param desktopPath
     * @param addPlaceableIds
     * @param addPlaceablePlaceholders
     * @param addPlaceablePositions
     * @param pageId
     */
    protected void addPlaceables( HttpServletRequest request, String webAppName, String portalPath, String desktopPath,
                                  String addPlaceableIds, String addPlaceablePlaceholders,
                                  String addPlaceablePositions, String pageId )
    {

        StringTokenizer addPlaceableIdsTok = new StringTokenizer( addPlaceableIds, PortalVisitorConstants.COMMA );
        StringTokenizer addPlaceablePlaceholdersTok = new StringTokenizer( addPlaceablePlaceholders, PortalVisitorConstants.COMMA );
        StringTokenizer addPlaceablePositionsTok = new StringTokenizer( addPlaceablePositions, PortalVisitorConstants.COMMA );

        int addIdLength = addPlaceableIdsTok.countTokens();
        int addPlaceholderLength = addPlaceablePlaceholdersTok.countTokens();
        int addPositionLength = addPlaceablePositionsTok.countTokens();

        if( ( addIdLength != addPlaceholderLength ) || ( addIdLength != addPositionLength ) )
        {
            //error
        }
        else
        {
            PlaceablePlacement[] addPlaceables = new PlaceablePlacement[addIdLength];
            int addPCount = 0;

            while( addPlaceableIdsTok.hasMoreTokens() )
            {
                String addTmp = addPlaceableIdsTok.nextToken();
                String addTmp2[] = addTmp.split( PortalVisitorConstants.UNDERSCORE, 3 );
                String addPlaceableType = addTmp2[0];
                // addTmp2[1] is garbage used only for correct dhtml functionality
                String addPlaceableId = addTmp2[2];

                if( addPlaceableType.equals( PortalVisitorConstants.PORTLET ) )
                {
                    addPlaceables[addPCount] = new PortletPlacement( addPlaceableId, PortalVisitorConstants.NEGATIVE_ONE, pageId, addPlaceablePlaceholdersTok.nextToken(), addPlaceablePositionsTok.nextToken() );
                }
                else
                {
                    if( addPlaceableType.equals( PortalVisitorConstants.BOOK ) )
                    {
                        addPlaceables[addPCount] = new BookPlacement( addPlaceableId, PortalVisitorConstants.NEGATIVE_ONE, pageId, addPlaceablePlaceholdersTok.nextToken(), addPlaceablePositionsTok.nextToken() );
                    }
                    else
                    {
                        if( addPlaceableType.equals( PortalVisitorConstants.NEW_BOOK ) )
                        {
                            String newBookStuff[] = addPlaceableId.split( PortalVisitorConstants.COLAN, 2 );
                            String newBookMenu = newBookStuff[0];
                            String newBookName = newBookStuff[1];

                            if( newBookMenu.equals( PortalVisitorConstants.NEGATIVE_ONE ) )
                            {
                                newBookMenu = null;
                            }

                            String newBookId = PortalVisitorManager.createBookDefinition( webAppName, newBookName, PortalVisitorConstants.EMPTY, newBookMenu, request.getLocale(), request );
                            addPlaceables[addPCount] = new BookPlacement( newBookId, PortalVisitorConstants.NEGATIVE_ONE, pageId, addPlaceablePlaceholdersTok.nextToken(), addPlaceablePositionsTok.nextToken() );
                        }
                    }
                }

                addPCount++;
            }

            PortalVisitorManager.addPlaceableInstances( addPlaceables, webAppName, portalPath, desktopPath, request );
        }

    }


    /**
     * Delete the given Placeables.
     *
     * @param request
     * @param webAppName
     * @param portalPath
     * @param desktopPath
     * @param deletePlaceableIds
     */
    protected void deletePlaceables( HttpServletRequest request, String webAppName, String portalPath,
                                     String desktopPath, String deletePlaceableIds )
    {
        StringTokenizer deletedIds = new StringTokenizer( deletePlaceableIds, PortalVisitorConstants.COMMA );
        int deletedLength = deletedIds.countTokens();

        PlaceablePlacement[] placeables2 = new PlaceablePlacement[deletedLength];
        int pCount2 = 0;

        while( deletedIds.hasMoreTokens() )
        {
            String tmp3 = deletedIds.nextToken();
            String tmp4[] = tmp3.split( "_", 2 );
            String placeableType2 = tmp4[0];
            String placeableId2 = tmp4[1];

            if( placeableType2.equals( PortalVisitorConstants.PORTLET ) )
            {
                placeables2[pCount2] = new PortletPlacement( placeableId2, PortalVisitorConstants.NEGATIVE_ONE, PortalVisitorConstants.NEGATIVE_ONE, PortalVisitorConstants.NEGATIVE_ONE, PortalVisitorConstants.NEGATIVE_ONE );
            }
            else
            {
                if( placeableType2.equals( PortalVisitorConstants.BOOK ) )
                {
                    placeables2[pCount2] = new BookPlacement( placeableId2, PortalVisitorConstants.NEGATIVE_ONE, PortalVisitorConstants.NEGATIVE_ONE, PortalVisitorConstants.NEGATIVE_ONE, PortalVisitorConstants.NEGATIVE_ONE );
                }
            }
            pCount2++;
        }

        PortalVisitorManager.removePlaceableInstances( placeables2, webAppName, portalPath, desktopPath, request );
    }


}

package com.bea.jsptools.portal;

import com.bea.jsptools.portal.placement.BookPlacement;
import com.bea.jsptools.portal.placement.NavigablePlacement;
import com.bea.jsptools.portal.placement.PagePlacement;
import com.bea.jsptools.portal.placement.PlaceablePlacement;
import com.bea.jsptools.portal.placement.PortletPlacement;
import com.bea.netuix.application.definition.BookDefinition;
import com.bea.netuix.application.definition.LayoutDefinition;
import com.bea.netuix.application.definition.LookAndFeelDefinition;
import com.bea.netuix.application.definition.MenuDefinition;
import com.bea.netuix.application.definition.PageDefinition;
import com.bea.netuix.application.definition.PlaceholderDefinition;
import com.bea.netuix.application.definition.PortletCategoryDefinition;
import com.bea.netuix.application.definition.PortletDefinition;
import com.bea.netuix.application.definition.ThemeDefinition;
import com.bea.netuix.application.exception.ObjectNotFoundException;
import com.bea.netuix.application.identifier.BookDefinitionId;
import com.bea.netuix.application.identifier.BookInstanceId;
import com.bea.netuix.application.identifier.DesktopDefinitionId;
import com.bea.netuix.application.identifier.DesktopPath;
import com.bea.netuix.application.identifier.LayoutDefinitionId;
import com.bea.netuix.application.identifier.NavigableDefinitionId;
import com.bea.netuix.application.identifier.NavigableInstanceId;
import com.bea.netuix.application.identifier.PageDefinitionId;
import com.bea.netuix.application.identifier.PageInstanceId;
import com.bea.netuix.application.identifier.PlaceableDefinitionId;
import com.bea.netuix.application.identifier.PlacementId;
import com.bea.netuix.application.identifier.PortalPath;
import com.bea.netuix.application.identifier.PortletCategoryDefinitionId;
import com.bea.netuix.application.identifier.PortletDefinitionId;
import com.bea.netuix.application.identifier.PortletInstanceId;
import com.bea.netuix.application.instance.BookInstance;
import com.bea.netuix.application.instance.NavigableInstance;
import com.bea.netuix.application.instance.PageInstance;
import com.bea.netuix.application.instance.PlaceableInstance;
import com.bea.netuix.application.instance.PortletInstance;
import com.bea.netuix.application.localization.definition.LocalizationResource;
import com.bea.netuix.application.manager.CustomizationContext;
import com.bea.netuix.application.manager.persistence.PageDefinitionManager;
import com.bea.netuix.application.manager.persistence.PortalCustomizationManager;
import com.bea.netuix.application.view.BookView;
import com.bea.netuix.application.view.DesktopView;
import com.bea.netuix.application.view.PageView;
import com.bea.netuix.application.view.PortletView;

import javax.servlet.http.HttpServletRequest;
import java.rmi.RemoteException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Set;

/**
 * Visitor Tool wrapper around the PortalManager.  Customizations of visitor tool processing can be done in this class.
 */
public class PortalVisitorManager
{

    public static void updateDesktopInstance( String webapp, String portalPath, String desktopPath, String lookId,
                                              Locale locale, HttpServletRequest request )
    {
        try
        {
            PortalManager.updateDesktopInstance( webapp, portalPath, desktopPath, lookId, true, locale, request );
        }
        catch( Exception e )
        {
            log( "PortalVisitorManager", e );
        }
    }

    public static BookDefinition[] getPublicBookDefinitions( String webapp, String portalPath, String desktopPath,
                                                             Locale locale, HttpServletRequest request )
    {
        try
        {
            return PortalManager.getPublicBookDefinitions( webapp, portalPath, desktopPath, locale, request );
        }
        catch( Exception e )
        {
            log( "PortalVisitorManager", e );
            return null;
        }
    }

    public static PageDefinition[] getPublicPageDefinitions( String webapp, String portalPath, String desktopPath,
                                                             Locale locale, HttpServletRequest request )
    {
        try
        {
            return PortalManager.getPublicPageDefinitions( webapp, portalPath, desktopPath, true, locale, request );
        }
        catch( Exception e )
        {
            log( "PortalVisitorManager", e );
            return null;
        }
    }

    public static PortletDefinition[] getPortletDefinitions( String webapp, Locale locale, HttpServletRequest request )
    {
        try
        {
            return PortalManager.getPortletDefinitions( webapp, locale, request );
        }
        catch( Exception e )
        {
            log( "PortalVisitorManager", e );
            return null;
        }

    }

    public static PortletInstance getPortletInstance( String id, Locale locale, HttpServletRequest request )
    {
        try
        {
            return PortalManager.getPortletInstance( id, locale, request );
        }
        catch( Exception e )
        {
            log( "PortalVisitorManager", e );
            return null;
        }

    }

    public static String getLayoutHtml( String layoutHTMLPath, String currentWebApp )
    {
        try
        {
            return PortalManager.getLayoutHtml( layoutHTMLPath, currentWebApp );
        }
        catch( Exception e )
        {
            log( "PortalVisitorManager", e );
            return null;
        }

    }

    public static int updateBookInstanceMenu( String bookId, String newMenuId, String webapp, String portalPath,
                                              String desktopPath, Locale locale, HttpServletRequest request )
    {
        try
        {
            return PortalManager.updateBookInstanceMenu( bookId, newMenuId, webapp, portalPath, desktopPath, true, locale, request );
        }
        catch( Exception e )
        {
            log( "PortalVisitorManager", e );
            return -1;
        }


    }

    public static void updateBookInstanceTheme( String bookId, String newThemeId, String webapp, String portalPath,
                                                String desktopPath, Locale locale, HttpServletRequest request )
    {
        try
        {
            PortalManager.updateBookInstanceTheme( bookId, newThemeId, webapp, portalPath, desktopPath, true, locale, request );
        }
        catch( Exception e )
        {
            log( "PortalVisitorManager", e );
        }

    }

    public static void updatePortletInstanceTheme( String portletId, String newThemeId, String webapp,
                                                   String portalPath, String desktopPath, Locale locale,
                                                   HttpServletRequest request )
    {
        try
        {
            PortalManager.updatePortletInstanceTheme( portletId, newThemeId, webapp, portalPath, desktopPath, true, locale, request );
        }
        catch( Exception e )
        {
            log( "PortalVisitorManager", e );
        }

    }

    public static void updatePageInstanceTheme( String pageId, String newThemeId, String webapp, String portalPath,
                                                String desktopPath, Locale locale, HttpServletRequest request )
    {
        try
        {
            PortalManager.updatePageInstanceTheme( pageId, newThemeId, webapp, portalPath, desktopPath, true, locale, request );
        }
        catch( Exception e )
        {
            log( "PortalVisitorManager", e );
        }

    }

    public static int updatePageInstanceLayout( String pageId, String layoutId, String webapp, String portalPath,
                                                String desktopPath, Locale locale, HttpServletRequest request )
    {
        try
        {
            PageInstance newInstance = PortalManager.updatePageInstanceLayout( pageId, layoutId, webapp, portalPath, desktopPath, true, locale, request );
            return newInstance.getPageInstanceId().getId();
        }
        catch( Exception e )
        {
            log( "PortalVisitorManager", e );
            return -1;
        }

    }

    public static void updatePageInstanceTitle( String pageId, String newTitle, String webapp, String portalPath,
                                                String desktopPath, Locale locale, HttpServletRequest request )
    {
        try
        {
            PortalManager.updatePageInstanceTitle( pageId, newTitle, webapp, portalPath, desktopPath, true, locale, request );
        }
        catch( Exception e )
        {
            log( "PortalVisitorManager", e );
        }

    }

    public static void updateBookInstanceTitle( String bookId, String newTitle, String webapp, String portalPath,
                                                String desktopPath, Locale locale, HttpServletRequest request )
    {
        try
        {
            PortalManager.updateBookInstanceTitle( bookId, newTitle, webapp, portalPath, desktopPath, true, locale, request );
        }
        catch( Exception e )
        {
            log( "PortalVisitorManager", e );
        }

    }

    public static void updatePortletInstanceTitle( String portletId, String newTitle, String webapp, String portalPath,
                                                   String desktopPath, Locale locale, HttpServletRequest request )
    {
        try
        {
            PortalManager.updatePortletInstanceTitle( portletId, newTitle, webapp, portalPath, desktopPath, true, locale, request );
        }
        catch( Exception e )
        {
            log( "PortalVisitorManager", e );
        }

    }

    public static LookAndFeelDefinition[] getLookAndFeelDefinitions( String webapp, Locale locale,
                                                                     HttpServletRequest request )
    {
        try
        {
            return PortalManager.getLookAndFeelDefinitions( webapp, locale, request );
        }
        catch( Exception e )
        {
            log( "PortalVisitorManager", e );
            return null;
        }

    }

    public static MenuDefinition[] getMenuDefinitions( String webapp, Locale locale, HttpServletRequest request )
    {
        try
        {
            return PortalManager.getMenuDefinitions( webapp, locale, request );
        }
        catch( Exception e )
        {
            log( "PortalVisitorManager", e );
            return null;
        }

    }

    public static ThemeDefinition[] getThemeDefinitions( String webapp, Locale locale, HttpServletRequest request )
    {
        try
        {
            return PortalManager.getThemeDefinitions( webapp, locale, request );
        }
        catch( Exception e )
        {
            log( "PortalVisitorManager", e );
            return null;
        }

    }

    public static LayoutDefinition[] getLayoutDefinitions( String webapp, Locale locale, HttpServletRequest request )
    {
        try
        {
            return PortalManager.getLayoutDefinitions( webapp, locale, request );
        }
        catch( Exception e )
        {
            log( "PortalVisitorManager", e );
            return null;
        }

    }

    // todo delegate to portalmanager
    public static void addPlaceableInstances( PlaceablePlacement[] placeables, String webapp, String portalPath,
                                              String desktopPath, HttpServletRequest request )
    {
        PlaceableDefinitionId placeableDefinitionId = null;

        /* Sort array based on placeable order so everything gets placed correctly... */
        Arrays.sort( placeables );

        try
        {
            PortalCustomizationManager cmgr = PortalBeanManager.getPortalCustomizationManager();
            CustomizationContext customizationContext = new CustomizationContext( Locale.getDefault(), request );
            customizationContext.setVisitorMode( true );
            DesktopView desktopView = cmgr.getDesktopView( customizationContext, webapp, new PortalPath( portalPath ), new DesktopPath( desktopPath ) );
            customizationContext.setAdminDesktopInstanceId( desktopView.getDesktopInstanceId() );
            for( int i = 0; i < placeables.length; i++ )
            {
                PlaceablePlacement placeable = placeables[i];

                PageInstanceId pii = new PageInstanceId( placeable.getContainerId() );

                if( placeable instanceof PortletPlacement )
                {
                    placeableDefinitionId = new PortletDefinitionId( placeable.getId() );
                }
                else
                {
                    if( placeable instanceof BookPlacement )
                    {
                        placeableDefinitionId = new BookDefinitionId( placeable.getId() );
                    }
                }

                PageInstance thePage = cmgr.getPageInstance( customizationContext, pii );
                LayoutDefinitionId ldi = thePage.getLayoutDefinitionId();
                LayoutDefinition layoutDefinition = PortalBeanManager.getPageDefinitionManager().getLayoutDefinition( customizationContext, ldi );

                PlaceholderDefinition[] placeholderDefinitions = layoutDefinition.getPlaceholderDefinitions();

                int placePos = placeable.getPlaceholder();

                if( placeholderDefinitions.length > placePos )
                {
                    PlaceholderDefinition thePlaceholder = placeholderDefinitions[placePos];
                    cmgr.addPlaceable( customizationContext, new DesktopDefinitionId( webapp, new PortalPath( portalPath ), new DesktopPath( desktopPath ) ), pii, placeableDefinitionId, thePlaceholder.getPlaceholderDefinitionId(), placeable.getPosition() );
                }
            }

        }
        catch( Exception e )
        {
            log( "PortalVisitorManager", e );
        }
    }

    // todo delegate to portalmanager
    public static void removePlaceableInstances( PlaceablePlacement[] placeables, String webapp, String portalPath,
                                                 String desktopPath, HttpServletRequest request )
    {
        PortalCustomizationManager cmgr = PortalBeanManager.getPortalCustomizationManager();
        PlaceableInstance placeableInstance = null;
        try
        {
            CustomizationContext customizationContext = new CustomizationContext( request.getLocale(), request );
            customizationContext.setVisitorMode( true );

            for( int i = 0; i < placeables.length; i++ )
            {
                PlaceablePlacement placeable = placeables[i];

                if( placeable instanceof PortletPlacement )
                {
                    PortletInstanceId pii = new PortletInstanceId( placeable.getId() );
                    placeableInstance = cmgr.getPortletInstance( customizationContext, pii );
                }
                else
                {
                    if( placeable instanceof BookPlacement )
                    {
                        BookInstanceId bii = new BookInstanceId( placeable.getId() );
                        placeableInstance = cmgr.getBookInstance( customizationContext, bii );
                    }
                }

                cmgr.removePlaceable( customizationContext, new DesktopDefinitionId( webapp, new PortalPath( portalPath ), new DesktopPath( desktopPath ) ), placeableInstance );
            }
        }
        catch( Exception e )
        {
            log( "PortalVisitorManager", e );
        }
    }

    // todo delegate to portalmanager
    public static void movePlaceableInstances( PlaceablePlacement[] placeables, String webapp, String portalPath,
                                               String desktopPath, HttpServletRequest request )
    {
        PlacementId placementId = null;

        /* Sort array based on placeable order so everything gets placed correctly... */
        Arrays.sort( placeables );
        PortalCustomizationManager cmgr = PortalBeanManager.getPortalCustomizationManager();
        PageDefinitionManager pmgr = PortalBeanManager.getPageDefinitionManager();
        try
        {
            for( int i = 0; i < placeables.length; i++ )
            {
                CustomizationContext customizationContext = new CustomizationContext( Locale.getDefault(), request );
                customizationContext.setVisitorMode( true );

                PlaceablePlacement placeable = placeables[i];

                PageInstanceId pii = new PageInstanceId( placeable.getParentId() );
                //DesktopView desktopView = PortalBeanManager.getPortalCustomizationManager().getDesktopView(customizationContext, webapp, new PortalPath(portalPath), new DesktopPath(desktopPath));
                //customizationContext.setAdminDesktopInstanceId(desktopView.getDesktopInstanceId());
                DesktopDefinitionId ddi = new DesktopDefinitionId( webapp, new PortalPath( portalPath ), new DesktopPath( desktopPath ) );
                PageView pageView = cmgr.getPageView( customizationContext, ddi, pii );

                if( placeable instanceof PortletPlacement )
                {
                    PortletView portletView = pageView.getPortletView( new PortletInstanceId( placeable.getId() ) );
                    if( portletView != null )
                    {
                        placementId = portletView.getPlacementId();
                    }
                }
                else
                {
                    if( placeable instanceof BookPlacement )
                    {
                        BookView bookView = pageView.getBookView( new BookInstanceId( placeable.getId() ) );
                        if( bookView != null )
                        {
                            placementId = bookView.getPlacementId();
                        }
                    }
                }

                PageInstanceId pageToMoveTo = new PageInstanceId( placeable.getContainerId() );
                PageInstance thePage = cmgr.getPageInstance( customizationContext, pageToMoveTo );
                LayoutDefinitionId ldi = thePage.getLayoutDefinitionId();
                LayoutDefinition layoutDefinition = pmgr.getLayoutDefinition( customizationContext, ldi );

                PlaceholderDefinition[] placeholderDefinitions = layoutDefinition.getPlaceholderDefinitions();

                int placePos = placeable.getPlaceholder();

                if( placeholderDefinitions.length > placePos )
                {
                    PlaceholderDefinition thePlaceholder = placeholderDefinitions[placePos];
                    cmgr.movePlaceable( customizationContext, new DesktopDefinitionId( webapp, new PortalPath( portalPath ), new DesktopPath( desktopPath ) ), placementId, pageToMoveTo, thePlaceholder.getPlaceholderDefinitionId(), placeable.getPosition() );
                }
            }

        }
        catch( Exception e )
        {
            log( "PortalVisitorManager", e );
        }
    }


    // todo delegate to portal manager
    public static void addNavigableInstances( NavigablePlacement[] navigables, String webapp, String portalPath,
                                              String desktopPath, HttpServletRequest request )
    {
        NavigableDefinitionId navigableDefinitionId = null;
        
        /* Sort array based on placeable order so everything gets placed correctly... */
        Arrays.sort( navigables );

        PortalCustomizationManager cmgr = PortalBeanManager.getPortalCustomizationManager();
        try
        {
            CustomizationContext customizationContext = new CustomizationContext( request.getLocale(), request );
            customizationContext.setVisitorMode( true );

            for( int i = 0; i < navigables.length; i++ )
            {
                NavigablePlacement navigable = navigables[i];
                BookInstanceId bookInstanceId = new BookInstanceId( navigable.getContainerId() );

                if( navigable instanceof PagePlacement )
                {
                    navigableDefinitionId = new PageDefinitionId( navigable.getId() );
                }
                else
                {
                    if( navigable instanceof BookPlacement )
                    {
                        navigableDefinitionId = new BookDefinitionId( navigable.getId() );
                    }
                }

                //TODO: deal with alignment (passing in "0" right now)
                cmgr.addNavigable( customizationContext, new DesktopDefinitionId( webapp, new PortalPath( portalPath ), new DesktopPath( desktopPath ) ), bookInstanceId, navigableDefinitionId, navigable.getPosition(), 0 );
            }
        }
        catch( Exception e )
        {
            log( "PortalVisitorManager", e );
        }
    }


    // todo delegate to portalmanager
    public static void removeNavigableInstances( NavigablePlacement[] navigables, String webapp, String portalPath,
                                                 String desktopPath, HttpServletRequest request )
    {
        NavigableInstance navigableInstance = null;
        try
        {
            PortalCustomizationManager cmgr = PortalBeanManager.getPortalCustomizationManager();
            CustomizationContext customizationContext = new CustomizationContext( request.getLocale(), request );
            customizationContext.setVisitorMode( true );

            for( int i = 0; i < navigables.length; i++ )
            {
                NavigablePlacement navigable = navigables[i];

                if( navigable instanceof PagePlacement )
                {
                    PageInstanceId pii = new PageInstanceId( navigable.getId() );
                    navigableInstance = cmgr.getPageInstance( customizationContext, pii );
                }
                else
                {
                    if( navigable instanceof BookPlacement )
                    {
                        BookInstanceId bii = new BookInstanceId( navigable.getId() );
                        navigableInstance = cmgr.getBookInstance( customizationContext, bii );
                    }
                }

                cmgr.removeNavigable( customizationContext, new DesktopDefinitionId( webapp, new PortalPath( portalPath ), new DesktopPath( desktopPath ) ), navigableInstance );
            }
        }
        catch( Exception e )
        {
            log( "PortalVisitorManager", e );
        }
    }

    // todo delegate to portalmanager
    public static void moveNavigableInstances( NavigablePlacement[] navigables, String webapp, String portalPath,
                                               String desktopPath, HttpServletRequest request )
    {
        /* Sort array based on placeable order so everything gets placed correctly... */
        Arrays.sort( navigables );
        NavigableInstanceId navigableInstanceId = null;
        try
        {
            PortalCustomizationManager cmgr = PortalBeanManager.getPortalCustomizationManager();
            CustomizationContext customizationContext = new CustomizationContext( request.getLocale(), request );
            customizationContext.setVisitorMode( true );

            for( int i = 0; i < navigables.length; i++ )
            {
                NavigablePlacement navigable = navigables[i];
                int position = navigable.getPosition();
                BookInstanceId fromBookInstanceId = new BookInstanceId( navigable.getParentId() );
                BookInstanceId toBookInstanceId = new BookInstanceId( navigable.getContainerId() );

                if( navigable instanceof PagePlacement )
                {
                    navigableInstanceId = new PageInstanceId( navigable.getId() );
                }
                else
                {
                    if( navigable instanceof BookPlacement )
                    {
                        navigableInstanceId = new BookInstanceId( navigable.getId() );
                    }
                }
    
                //TODO: deal with alignment (passing in "0" right now)
                cmgr.moveNavigable( customizationContext, new DesktopDefinitionId( webapp, new PortalPath( portalPath ), new DesktopPath( desktopPath ) ), fromBookInstanceId, toBookInstanceId, navigableInstanceId, position, 0 );
            }
        }
        catch( Exception e )
        {
            log( "PortalVisitorManager", e );
        }
    }

    public static String createBookDefinition( String webapp, String title, String desc, String menuId, Locale locale,
                                               HttpServletRequest request )
    {
        try
        {
            return PortalManager.createBookDefinition( webapp, title, desc, menuId, false, locale, request );
        }
        catch( Exception e )
        {
            log( "PortalVisitorManager", e );
            return null;
        }

    }

    public static String createPageDefinition( String webapp, String title, String desc, String layoutId,
                                               Locale locale, HttpServletRequest request )
    {
        try
        {
            return PortalManager.createPageDefinition( webapp, title, desc, layoutId, false, locale, request );
        }
        catch( Exception e )
        {
            log( "PortalVisitorManager", e );
            return null;
        }

    }

    public static boolean isPlaceholderLocked( String webApp, String portalPath, String desktopPath, String pageId,
                                               String placeholderNum, HttpServletRequest request )
    {
        try
        {
            return PortalManager.isPlaceholderInstanceLocked( webApp, portalPath, desktopPath, pageId, placeholderNum, request );
        }
        catch( Exception e )
        {
            log( "PortalVisitorManager", e );
            return false;
        }

    }


    public static BookView getBookView( String bookInstanceId, String webAppName, String portalPath,
                                        String desktopPath, Locale locale, HttpServletRequest request )
    {
        try
        {
            return PortalManager.getBookView( bookInstanceId, webAppName, portalPath, desktopPath, true, locale, request );
        }
        catch( Exception e )
        {
            log( "PortalVisitorManager", e );
            return null;
        }

    }

    public static PageView getPageView( String pageInstanceId, String webAppName, String portalPath,
                                        String desktopPath, Locale locale, HttpServletRequest request )
    {
        try
        {
            return PortalManager.getPageView( pageInstanceId, webAppName, portalPath, desktopPath, true, locale, request );
        }
        catch( Exception e )
        {
            log( "PortalVisitorManager", e );
            return null;
        }


    }

    public static DesktopView getDesktopView( String portalPath, String webAppName, String desktopPath, Locale locale,
                                              HttpServletRequest request )
    {
        try
        {
            return PortalManager.getDesktopView( portalPath, webAppName, desktopPath, true, locale, request );
        }
        catch( Exception e )
        {
            log( "PortalVisitorManager", e );
            return null;
        }

    }

    public static PageInstance getPageInstance( String id, Locale locale, HttpServletRequest request )
    {
        try
        {
            return PortalManager.getPageInstance( id, locale, request );
        }
        catch( Exception e )
        {
            log( "PortalVisitorManager", e );
            return null;
        }

    }

    public static BookInstance getBookInstance( String id, Locale locale, HttpServletRequest request )
    {
        try
        {
            return PortalManager.getBookInstance( id, locale, request );
        }
        catch( Exception e )
        {
            log( "PortalVisitorManager", e );
            return null;
        }

    }

    public static String[] generatePortletCategoryArrays( String webAppName, String indentStr, Locale locale,
                                                          HttpServletRequest request )
    {
        // Return portlet category strings in form of array
        // categoryOptions is 0 element
        // allPortletOptions is 1 element
        // categoryJavaScriptArrays is 2 element
        // hasAnyCategories is 3 element 
        String[] returnVals = new String[4];

        // Create the option for the default implicit "All Portlets" root category
        returnVals[0] = "<option value='categoryAll'>All Portlets</option>\n";
        returnVals[1] = "";
        returnVals[3] = "0";

        // Get the root category definition
        PortletCategoryDefinition rootCategoryDef = getPortletRootCategoryDefinition( webAppName, locale, request );

        PortletDefinition[] portlets = getPortletDefinitions( webAppName, locale, request );
        HashMap portletTitlesHash = getPortletsHash( portlets );

        Set sortedKeySet = portletTitlesHash.keySet();
        ArrayList rootPortlets = new ArrayList( sortedKeySet );
        Collections.sort( rootPortlets, Collator.getInstance( locale ) );
        String categoryAllJavaScriptArray = "var categoryAll = new Array(";
        String categoryAllValuesJavaScriptArray = "var categoryAllValues = new Array(";

        for( int i = 0; i < rootPortlets.size(); i++ )
        {
            String title = ( String ) rootPortlets.get( i );
            ArrayList portletsOfKey = ( ArrayList ) portletTitlesHash.get( title );
            for( int j = 0; j < portletsOfKey.size(); j++ )
            {
                HashMap portletInfoHash = ( HashMap ) portletsOfKey.get( j );
                int id = ( ( Integer ) portletInfoHash.get( title ) ).intValue();
                returnVals[1] += "<option value='" + id + "'>" + title + "</option>\n";
                categoryAllJavaScriptArray += ( ( i > 0 ) ? "," : "" ) + "\"" + title + "\"";
                categoryAllValuesJavaScriptArray += ( ( i > 0 ) ? "," : "" ) + "\"" + id + "\"";
            }
        }

        categoryAllJavaScriptArray += ");\n";
        categoryAllValuesJavaScriptArray += ");\n";
        returnVals[2] = categoryAllJavaScriptArray + categoryAllValuesJavaScriptArray;

        // Create options and arrays for all child categories
        if( rootCategoryDef != null )
        {
            getChildrenCategoryNodes( rootCategoryDef, indentStr, 1, returnVals, locale, request );
        }

        return returnVals;
    }

    /*
     *  This is a recursive function that gets all of the children for the passed in portlet category definition.
     *  It also creates the strings needed to generate the <option ...>s needed for each category
     */
    private static void getChildrenCategoryNodes( PortletCategoryDefinition pcd, String indentStr, int indentLevels,
                                                  String[] returnVals, Locale locale, HttpServletRequest request )
    {
        PortletCategoryDefinition[] portletCatDefs = getPortletSubCategoryDefinitions( pcd.getPortletCategoryDefinitionId(), locale, request );
        if( portletCatDefs.length > 0 )
        {
            returnVals[3] = "1";
        }
        for( int i = 0; i < portletCatDefs.length; i++ )
        {
            String categoryName = portletCatDefs[i].getLocalizationResource().getTitle();
            String categoryId = portletCatDefs[i].getPortletCategoryDefinitionId().toString();
            String thisIndent = "";
            for( int j = 0; j < indentLevels; j++ )
            {
                thisIndent += indentStr;
            }
            returnVals[0] += "<option value='category" + categoryId + "'>" + thisIndent + crossSiteScriptFix( categoryName ) + "</option>\n";

            HashMap portletTitlesHash = getPortletsForCategory( portletCatDefs[i], locale, request );

            Set sortedKeySet = portletTitlesHash.keySet();
            ArrayList portlets = new ArrayList( sortedKeySet );
            Collections.sort( portlets, Collator.getInstance( locale ) );
            String categoryJavaScriptArray = "var category" + categoryId + " = new Array(";
            String categoryValuesJavaScriptArray = "var category" + categoryId + "Values = new Array(";

            for( int k = 0; k < portlets.size(); k++ )
            {
                String title = ( String ) portlets.get( k );
                ArrayList portletsOfKey = ( ArrayList ) portletTitlesHash.get( title );
                for( int m = 0; m < portletsOfKey.size(); m++ )
                {
                    HashMap portletInfoHash = ( HashMap ) portletsOfKey.get( m );
                    int id = ( ( Integer ) portletInfoHash.get( title ) ).intValue();
                    categoryJavaScriptArray += ( ( k > 0 ) ? "," : "" ) + "\"" + title + "\"";
                    categoryValuesJavaScriptArray += ( ( k > 0 ) ? "," : "" ) + "\"" + id + "\"";
                }
            }

            categoryJavaScriptArray += ");\n";
            categoryValuesJavaScriptArray += ");\n";
            returnVals[2] += categoryJavaScriptArray + categoryValuesJavaScriptArray;

            // Now recursively get the children of this child category
            getChildrenCategoryNodes( portletCatDefs[i], indentStr, indentLevels + 1, returnVals, locale, request );
        }

    }

    public static PortletCategoryDefinition getPortletRootCategoryDefinition( String webAppName, Locale locale,
                                                                              HttpServletRequest request )
    {
        PortletCategoryDefinition portletCategory = null;
        CustomizationContext customizationContext = null;

        try
        {
            if( locale == null )
            {
                customizationContext = new CustomizationContext( Locale.getDefault(), request );
            }
            else
            {
                customizationContext = new CustomizationContext( locale, request );
            }
            customizationContext.setVisitorMode(true);

            portletCategory = PortalBeanManager.getPortletCategoryManager().getRootCategory( customizationContext, webAppName );
        }
        catch( RemoteException re )
        {
            log( "PortalVisitorManager", re );
        }
        catch( ObjectNotFoundException onfe )
        {
            // todo log?
            // No root category - no categories have been created.
        }
        catch( Exception e )
        {
            log( "PortalVisitorManager", e );
        }

        return portletCategory;

    }

    public static PortletCategoryDefinition[] getPortletSubCategoryDefinitions( PortletCategoryDefinitionId pcdId,
                                                                                Locale locale,
                                                                                HttpServletRequest request )
    {
        PortletCategoryDefinition[] portletCategories = null;
        CustomizationContext customizationContext = null;

        try
        {
            if( locale == null )
            {
                customizationContext = new CustomizationContext( Locale.getDefault(), request );
            }
            else
            {
                customizationContext = new CustomizationContext( locale, request );
            }
            customizationContext.setVisitorMode(true);

            portletCategories = PortalBeanManager.getPortletCategoryManager().getSubCategories( customizationContext, pcdId, 0, 9999 );
        }
        catch( Exception e )
        {
            log( "PortalVisitorManager", e );
        }

        return portletCategories;

    }

    public static HashMap getPortletsForCategory( PortletCategoryDefinition portletCategoryDefinition, Locale locale,
                                                  HttpServletRequest request )
    {
        HashMap portletTitlesHash = new HashMap();
        CustomizationContext cc;
        try
        {
            if( locale == null )
            {
                cc = new CustomizationContext( Locale.getDefault(), request );
            }
            else
            {
                cc = new CustomizationContext( locale, request );
            }
            cc.setVisitorMode(true);

            //Now get all of the portlets that belong to theis category
            PortletDefinition[] portlets = null;
            portlets = PortalBeanManager.getPortletCategoryManager().getPortletDefinitions( cc, portletCategoryDefinition.getPortletCategoryDefinitionId(), 0, 9999 );
            portletTitlesHash = getPortletsHash( portlets );
        }
        catch( Exception e )
        {
            log( "PortalVisitorManager", e );
        }
        return portletTitlesHash;

    }

    public static HashMap getPortletsHash( PortletDefinition[] portlets )
    {
        HashMap portletTitlesHash = new HashMap();
        for( int i = 0; i < portlets.length; i++ )
        {
            PortletDefinition tmp = portlets[i];
            if( tmp != null )
            {
                LocalizationResource lr = tmp.getLocalizationResource();
                String title = "&nbsp;";
                if( lr != null )
                {
                    title = lr.getTitle();
                }
                int id = tmp.getPortletDefinitionId().getId();

                ArrayList hashList;
                if( portletTitlesHash.containsKey( title ) )
                {
                    hashList = ( ArrayList ) portletTitlesHash.get( title );
                }
                else
                {
                    hashList = new ArrayList();
                }

                HashMap tempHash = new HashMap();
                tempHash.put( title, new Integer( id ) );
                hashList.add( tempHash );
                portletTitlesHash.put( title, hashList );
            }
        }
        return portletTitlesHash;
    }

    public static String crossSiteScriptFix( String stringInput )
    {
        if( stringInput == null )
        {
            return null;
        }

        // create the string buffer as long as the input string
        // it is guaranteed to be at least that long
        StringBuffer stringOutput = new StringBuffer( stringInput.length() );
        char[] input = stringInput.toCharArray();
        for( int i = 0; i < input.length; i++ )
        {
            char c = input[i];
            switch( c )
            {
                case '<':
                    stringOutput.append( "&lt;" );
                    break;
                case '>':
                    stringOutput.append( "&gt;" );
                    break;
                case '(':
                    stringOutput.append( "&#40;" );
                    break;
                case ')':
                    stringOutput.append( "&#41;" );
                    break;
                case '#':
                    stringOutput.append( "&#35;" );
                    break;
                case '&':
                    stringOutput.append( "&#38;" );
                    break;
                default:
                    stringOutput.append( c );
                    break;
            }
        }

        return stringOutput.toString();
    }


    private static PortalAdminLogger logger = new PortalAdminLogger();

    protected static void log( String message, Exception e )
    {
        logger.logError( message, e );
    }
}

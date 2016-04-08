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

import com.bea.jsptools.portal.PortalVisitorManager;
import com.bea.netuix.application.identifier.MenuDefinitionId;
import com.bea.netuix.application.view.MenuView;
import com.bea.netuix.servlets.controls.PresentationContext;
import com.bea.netuix.servlets.controls.page.BookPresentationContext;
import com.bea.netuix.servlets.controls.page.PagePresentationContext;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.List;


/**
 * Utility calls for Visitor Tools.
 */
public class VisitorToolsUtil
{


    /**
     * Find a particular PagePresentationContext inside of another PagePresentationContext.
     *
     * @param pagePC
     * @param pageIdToFind
     * @param request
     *
     * @return
     */
    public static PagePresentationContext findPageInPage( PagePresentationContext pagePC, String pageIdToFind,
                                                          HttpServletRequest request )
    {
        PagePresentationContext theFoundPage = null;
        List pp = pagePC.getWindowPresentationContexts();
        Iterator it = pp.iterator();
        for( int i = 0; it.hasNext(); i++ )
        {
            PresentationContext pc = ( PresentationContext ) it.next();

            if( pc instanceof BookPresentationContext )
            {
                BookPresentationContext bpc = ( BookPresentationContext ) pc;
                String bookInstanceId = bpc.getInstanceId();

                if( bookInstanceId != null )
                {
                    theFoundPage = findPageInBook(bpc, pageIdToFind, request);
                    if( theFoundPage != null )
                    {
                        return theFoundPage;
                    }
                }
            }
        }
        return null;
    }


    /**
     * Find a particular PagePresenationContext inside of a BookPresentationContext.
     *
     * @param bookPC
     * @param pageIdToFind
     * @param request
     *
     * @return
     */
    public static PagePresentationContext findPageInBook( BookPresentationContext bookPC, String pageIdToFind,
                                                          HttpServletRequest request )
    {
        PagePresentationContext theFoundPage = null;
        List bp = bookPC.getEntitledPagePresentationContexts();
        Iterator it = bp.iterator();
        for( int i = 0; it.hasNext(); i++ )
        {
            PresentationContext pc = ( PresentationContext ) it.next();

            if( pc instanceof BookPresentationContext )
            {
                BookPresentationContext bpc = ( BookPresentationContext ) pc;
                theFoundPage = findPageInBook(bpc, pageIdToFind, request);
                if( theFoundPage != null )
                {
                    return theFoundPage;
                }
            }
            else
            {
                if( pc instanceof PagePresentationContext )
                {
                    PagePresentationContext ppc = ( PagePresentationContext ) pc;
                    String pageInstanceId = ppc.getInstanceId();

                    if( pageInstanceId != null )
                    {
                        if( pageInstanceId.equals(pageIdToFind) )
                        {
                            return ppc;
                        }
                        else
                        {
                            theFoundPage = findPageInPage(ppc, pageIdToFind, request);
                            if( theFoundPage != null )
                            {
                                return theFoundPage;
                            }
                        }
                    }
                }
            }
        }
        return null;
    }


    /**
     * Find a BookPresentationContext inside of another BookPresenationContext.
     *
     * @param bookPC
     * @param bookIdToFind
     * @param request
     *
     * @return
     */
    public static BookPresentationContext findBookInBook( BookPresentationContext bookPC, String bookIdToFind,
                                                          HttpServletRequest request )
    {
        BookPresentationContext theFoundBook = null;
        List bp = bookPC.getEntitledPagePresentationContexts();
        Iterator it = bp.iterator();
        for( int i = 0; it.hasNext(); i++ )
        {
            PresentationContext pc = ( PresentationContext ) it.next();

            if( pc instanceof BookPresentationContext )
            {
                BookPresentationContext bpc = ( BookPresentationContext ) pc;
                String bookInstanceId = bpc.getInstanceId();

                if( bookInstanceId != null )
                {
                    if( bookInstanceId.equals(bookIdToFind) )
                    {
                        return bpc;
                    }
                    else
                    {
                        theFoundBook = findBookInBook(bpc, bookIdToFind, request);
                        if( theFoundBook != null )
                        {
                            return theFoundBook;
                        }
                    }
                }
            }
            else
            {
                if( pc instanceof PagePresentationContext )
                {
                    PagePresentationContext ppc = ( PagePresentationContext ) pc;
                    theFoundBook = findBookInPage(ppc, bookIdToFind, request);
                    if( theFoundBook != null )
                    {
                        return theFoundBook;
                    }
                }
            }
        }

        return null;

    }


    /**
     * Find a particular BookPresenationContext inside of a PagePresentationContext.
     *
     * @param pagePC
     * @param bookIdToFind
     * @param request
     *
     * @return
     */
    public static BookPresentationContext findBookInPage( PagePresentationContext pagePC, String bookIdToFind,
                                                          HttpServletRequest request )
    {
        BookPresentationContext theFoundBook = null;

        List pp = pagePC.getWindowPresentationContexts();
        Iterator it = pp.iterator();
        for( int i = 0; it.hasNext(); i++ )
        {
            PresentationContext pc = ( PresentationContext ) it.next();

            if( pc instanceof BookPresentationContext )
            {
                BookPresentationContext bpc = ( BookPresentationContext ) pc;
                String bookInstanceId = bpc.getInstanceId();

                if( bookInstanceId != null )
                {
                    if( bookInstanceId.equals(bookIdToFind) )
                    {
                        return bpc;
                    }
                    else
                    {
                        theFoundBook = findBookInBook(bpc, bookIdToFind, request);
                        if( theFoundBook != null )
                        {
                            return theFoundBook;
                        }
                    }
                }
            }
        }
        return null;
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

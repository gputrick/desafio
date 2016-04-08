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



import com.bea.netuix.application.manager.CustomizationContext;
import com.bea.netuix.application.manager.entitlements.PortalEntitlementHelper;
import com.bea.netuix.servlets.controls.PresentationContext;
import com.bea.netuix.servlets.controls.page.BookPresentationContext;
import com.bea.netuix.servlets.controls.page.PagePresentationContext;
import com.bea.netuix.servlets.controls.portlet.PortletPresentationContext;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;





public class EntitledPresentations

{



    private ArrayList entitledPortlets;

    private ArrayList entitledBooks;



    public EntitledPresentations( BookPresentationContext bookPresentationContext, String pageId, HttpServletRequest request )

    {

        entitledPortlets = new ArrayList();

        entitledBooks = new ArrayList();

        load( bookPresentationContext, pageId, request );

    }



    private void load( BookPresentationContext bookPresentationContext, String pageId, HttpServletRequest request )

    {

        PagePresentationContext thePagePC = VisitorToolsUtil.findPageInBook( bookPresentationContext, pageId, request );

        if( thePagePC != null )

        {

            List pp = thePagePC.getWindowPresentationContexts();

            Iterator it = pp.iterator();

            for( int i = 0; it.hasNext(); i++ )

            {

                PresentationContext pc = ( PresentationContext ) it.next();



                if( pc instanceof BookPresentationContext )

                {

                    BookPresentationContext bpc = ( BookPresentationContext ) pc;

                    entitledBooks.add( bpc.getInstanceId() );

                }

                else if( pc instanceof PortletPresentationContext )

                {
                    boolean isAllowed = true;

                    PortletPresentationContext ppc = ( PortletPresentationContext ) pc;

                    // CR232222 - Check the entitlement of the portlet to see if the user has delete priveledge
                    //            This value is checked in VisitorToolsHtmlUtil.getPlaceholderHtml
                    try
                    {
                        isAllowed = PortalEntitlementHelper.checkPortletDelete(new CustomizationContext(request.getLocale(), request),
                                                                            ppc.getDefinitionLabel());                                                                                                                                                    
                    }
                    catch (Exception e) { e.printStackTrace(); }

                    if (isAllowed)
                        entitledPortlets.add( ppc.getInstanceId() );
                }

            }

        }



    }



    public List getEntitledPortlets()

    {

        return entitledPortlets;

    }



    public List getEntitledBooks()

    {

        return entitledBooks;

    }

}

 


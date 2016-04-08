<%@ page import="com.bea.netuix.servlets.controls.application.DesktopPresentationContext,
                 com.bea.netuix.servlets.controls.page.BookPresentationContext,
                 com.bea.netuix.servlets.controls.window.WindowCapabilities,
                 com.bea.netuix.servlets.manager.AppContext,
                 java.util.List,
                 java.util.Iterator,
                 com.bea.netuix.servlets.controls.window.Edit,
                 com.bea.netuix.servlets.controls.page.Menu,
                 com.bea.netuix.servlets.controls.page.MenuPresentationContext,
                 com.bea.netuix.servlets.controls.window.ToggleButtonPresentationContext,
                 java.security.Principal,
                 com.bea.netuix.servlets.controls.Capability"%>
<%@ taglib uri="render.tld" prefix="render" %>

<table width="100%" border="0" cellpadding="0" cellspacing="0">
<%
    // Verify that this is not a .portal file
    AppContext ac = AppContext.getAppContext(request);
    if ( !ac.isDotPortal() )
    {
        DesktopPresentationContext desktopPresentationContext =
            DesktopPresentationContext.getDesktopPresentationContext(request);

        BookPresentationContext bookPresentationContext =
            desktopPresentationContext.getBookPresentationContext();

        boolean foundEdit = false;

        Capability cap =
                bookPresentationContext.getCapability (WindowCapabilities.EDIT);
        foundEdit = cap != null;

        if( foundEdit )
        {
            String mainBookName = bookPresentationContext.getDefinitionLabel();
            if (WindowCapabilities.EDIT.equals(bookPresentationContext.getWindowMode()))
            {
%>
                <tr>
                    <td align="right" colspan="2" nowrap>
                        <a id="returnToPortalLinkId" href='<render:windowUrl windowLabel="<%=mainBookName%>" windowMode="<%=WindowCapabilities.VIEW.getName()%>"/>&_nfls=false'><span class="header-links">Return to Portal</span></a>&nbsp;
                    </td>
                </tr>
<%
            }
            else
            {
%>
                <tr>
                    <td align="left" nowrap>
                    &nbsp;
                    </td>
                    <td align="right" nowrap>
<%
                Principal principal = request.getUserPrincipal();
                String username = ( principal == null ? null : principal.getName() );

                if (username == null)
                {
%>
                    &nbsp;
<%
                }
                else
                {
%>
                    &nbsp;<a href='<render:jspContentUrl windowLabel="<%= mainBookName %>" windowMode="<%=WindowCapabilities.EDIT.getName()%>"/>&customizePortal=VisitorToolsMainPage'><span class="header-links">Customize My Portal</span></a>&nbsp;
<%
                }
%>
                </td>
            </tr>
<%
            }
        }
    }
%>

</table>

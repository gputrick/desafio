<%@ page import="com.bea.netuix.servlets.controls.ControlContext,
                 com.bea.netuix.servlets.controls.page.MenuPresentationContext,
                 com.bea.netuix.servlets.controls.window.TitlebarPresentationContext,
                 java.util.List,
                 java.util.LinkedList,
                 com.bea.netuix.servlets.controls.PresentationContext,
                 com.bea.netuix.servlets.controls.window.ButtonPresentationContext,
                 com.bea.netuix.servlets.controls.window.AbstractButtonPresentationContext"
%>
<%@ page session="false"%>
<%@ taglib uri="render.tld" prefix="render" %>

<%
    PresentationContext ctx = (PresentationContext) request.getAttribute(PresentationContext.class.getName() + ".current");

    if (ctx == null)
    {
        return;
    }

    List standards = new LinkedList();
    List extensions = new LinkedList();
    List buttons = ctx.getChildren();

    for (int i = 0, size = buttons.size(); i < size; i++)
    {
        AbstractButtonPresentationContext button = (AbstractButtonPresentationContext) buttons.get(i);
        String tagName = button.getTagName();

        if (tagName.equals("window:minimized") || tagName.equals("window:maximized") || tagName.equals("window:delete"))
        {
            standards.add(button);
        }
        else
        {
            extensions.add(button);
        }
    }

    int stdSize = standards.size();
    int extSize = extensions.size();

    if (stdSize > 0 || extSize > 0)
    {
%>
    <div class="bea-portal-window-buttonbar">
        <table class="bea-portal-window-buttonbar-layout" cellspacing="0">
            <tr>
                <td class="bea-portal-window-buttonbar-layout-extensions"
><%
    for (int i = 0; i < extSize; i++)
    {
%><render:renderChild presentationContext="<%= (AbstractButtonPresentationContext) extensions.get(i) %>"/><%
    }
%></td>
                <td class="bea-portal-window-buttonbar-layout-standard"
><%
    for (int i = 0; i < stdSize; i++)
    {
%><render:renderChild presentationContext="<%= (AbstractButtonPresentationContext) standards.get(i) %>"/><%
    }
%></td>
            </tr>
        </table>
    </div>
<%
    }
%>

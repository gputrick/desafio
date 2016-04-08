<%@ page import="com.bea.netuix.servlets.controls.window.TitlebarPresentationContext,
                 com.bea.netuix.servlets.controls.window.WindowPresentationContext"
%>
<%@ page session="false"%>
<%@ taglib uri="render.tld" prefix="render" %><render:beginRender><%
    WindowPresentationContext window = WindowPresentationContext.getWindowPresentationContext(request);
    TitlebarPresentationContext titlebar = TitlebarPresentationContext.getTitlebarPresentationContext(request);
    String title = window.getTitle();
    title = (title == null) ? "" : title;
%>
    <div class="bea-portal-ie-table-buffer-div">
        <table
            <render:writeAttribute name="id" value="<%= titlebar.getPresentationId() %>"/>
            <render:writeAttribute name="class" value="<%= titlebar.getPresentationClass() %>" defaultValue="bea-portal-window-titlebar"/>
            <render:writeAttribute name="style" value="<%= titlebar.getPresentationStyle() %>"/>
        >
            <tr>
                <td class="bea-portal-window-titlebar-title"><%= title %></td>
                <td class="bea-portal-window-titlebar-buttons">
</render:beginRender>
<render:endRender>
                </td>
            </tr>
        </table>
    </div>
</render:endRender>

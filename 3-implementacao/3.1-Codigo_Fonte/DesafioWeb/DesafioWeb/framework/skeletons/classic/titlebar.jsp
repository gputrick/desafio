<%@ page import="com.bea.netuix.servlets.controls.window.TitlebarPresentationContext,
                 com.bea.netuix.servlets.controls.window.WindowPresentationContext,
                 com.bea.netuix.servlets.controls.PresentationContext"
%>
<%@ taglib uri="render.tld" prefix="render" %>
<%@ page session="false"%>
<render:beginRender>
<%
    WindowPresentationContext window = WindowPresentationContext.getWindowPresentationContext(request);
    TitlebarPresentationContext titlebar = TitlebarPresentationContext.getTitlebarPresentationContext(request);
    String title = window.getTitle();
    title = (title == null) ? "" : title;
    String imageIcon = titlebar.getIconUrl();
    boolean useIcon = (imageIcon != null && imageIcon.length() > 0);
%>
    <div
        <render:writeAttribute name="id" value="<%= titlebar.getPresentationId() %>"/>
        <render:writeAttribute name="class" value="<%= titlebar.getPresentationClass() %>" defaultValue="bea-portal-window-titlebar"/>
        <render:writeAttribute name="style" value="<%= titlebar.getPresentationStyle() %>"/>
    >
<%
    if (useIcon)
    {
%>
        <img class="bea-portal-window-icon" src="<%= imageIcon %>"/>
<%
    }
%>
        <span class="bea-portal-window-titlebar-title"><%= title %></span>
    </div>
<%
    String ctxId = PresentationContext.class.getName() + ".current";
    request.setAttribute(ctxId, titlebar);
%>
    <jsp:include page="buttonbar.jsp"/>
</render:beginRender>
<render:endRender>
</render:endRender>

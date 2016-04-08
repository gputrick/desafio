<%@ page import="com.bea.netuix.servlets.controls.window.WebflowPresentationContext,
                 com.bea.netuix.servlets.controls.window.TitlebarPresentationContext,
                 com.bea.netuix.servlets.controls.window.WindowCapabilities"%>
<%@ page session="false"%>
<%@ taglib uri="render.tld" prefix="render" %>

<render:beginRender>
<%
    WebflowPresentationContext window = WebflowPresentationContext.getWebflowPresentationContext(request);
    TitlebarPresentationContext titlebar = (TitlebarPresentationContext) window.getFirstChild("window:titlebar");
    String expandWidth = "100%";
%>
    <%-- Begin Window --%>
    <div
        <render:writeAttribute name="id" value="<%= window.getPresentationId() %>"/>
        <render:writeAttribute name="class" value="<%= window.getPresentationClass() %>" defaultValue="bea-portal-window"/>
        <render:writeAttribute name="style" value="<%= window.getPresentationStyle() %>"/>
        <render:writeAttribute name="width" value="<%= window.isPacked() ? null : expandWidth %>"/>
    >
        <render:renderChild presentationContext="<%= titlebar %>"/>
        <%-- Begin Window Content --%>
        <div class="bea-portal-window-content">
<%
    if (window.getHeaderUri() != null)
    {
%>
            <jsp:include page="<%= window.getHeaderUri() %>"/>
<%
    }

    if (window.getContentUri() != null && !window.getWindowState().equals(WindowCapabilities.MINIMIZED))
    {
%>
            <jsp:include page="<%= window.getContentUri() %>"/>
<%
    }

    if (window.getFooterUri() != null)
    {
%>
            <jsp:include page="<%= window.getFooterUri() %>"/>
<%
    }
%>
</render:beginRender>
<render:endRender>
        </div>
        <%-- End Window Content --%>
    </div>
    <%-- End Window --%>
</render:endRender>

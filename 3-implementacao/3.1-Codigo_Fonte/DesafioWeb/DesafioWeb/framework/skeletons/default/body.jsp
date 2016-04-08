<%@ page import="com.bea.netuix.servlets.controls.application.BodyPresentationContext" %>
<%@ page session="false"%>
<%@ taglib uri="render.tld" prefix="render" %>
<render:beginRender>
<%
    BodyPresentationContext body = BodyPresentationContext.getBodyPresentationContext(request);
%><body
        <render:writeAttribute name="id" value="<%= body.getPresentationId() %>" />
        <render:writeAttribute name="class" value="<%= body.getPresentationClass() %>" defaultValue="bea-portal-body"/>
        <render:writeAttribute name="style" value="<%= body.getPresentationStyle() %>"/>
        <render:writeAttribute name="onload" value="<%= body.getOnloadScript() %>"/>
        <render:writeAttribute name="onunload" value="<%= body.getOnunloadScript() %>"/>
    ><%-- Begin Body Content
    --%><div class="bea-portal-body-content">
</render:beginRender>
<render:endRender>
        </div><%-- End Body Content
--%></body>
</render:endRender>

<%@ page import="com.bea.netuix.servlets.controls.application.HeaderPresentationContext" %>
<%@ page session="false"%>
<%@ taglib uri="render.tld" prefix="render" %>

<%
    HeaderPresentationContext header = HeaderPresentationContext.getHeaderPresentationContext(request);
%>

<render:beginRender>
    <%-- Begin Body Header --%>
    <div
        <render:writeAttribute name="id" value="<%= header.getPresentationId() %>"/>
        <render:writeAttribute name="class" value="<%= header.getPresentationClass() %>" defaultValue="bea-portal-body-header"/>
        <render:writeAttribute name="style" value="<%= header.getPresentationStyle() %>"/>
    >
</render:beginRender>
<render:endRender>
    </div>
    <%-- End Body Header --%>
</render:endRender>

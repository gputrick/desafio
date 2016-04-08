<%@ page import="com.bea.netuix.servlets.controls.application.FooterPresentationContext"
%>
<%@ page session="false"%>
<%@ taglib uri="render.tld" prefix="render" %>

<%
    FooterPresentationContext footer = FooterPresentationContext.getFooterPresentationContext(request);
%>

<render:beginRender>
    <%-- Begin Body Footer --%>
    <div
        <render:writeAttribute name="id" value="<%= footer.getPresentationId() %>"/>
        <render:writeAttribute name="class" value="<%= footer.getPresentationClass() %>" defaultValue="bea-portal-body-footer"/>
        <render:writeAttribute name="style" value="<%= footer.getPresentationStyle() %>"/>
    >
</render:beginRender>
<render:endRender>
    </div>
    <%-- End Body Footer --%>
</render:endRender>

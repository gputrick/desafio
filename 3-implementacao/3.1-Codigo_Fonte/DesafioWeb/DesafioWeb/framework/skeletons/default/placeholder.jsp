<%@ page import="com.bea.netuix.servlets.controls.layout.PlaceholderPresentationContext"%><%@
    taglib uri="render.tld" prefix="render"
%>
<%@ page session="false"%>
<%
    PlaceholderPresentationContext placeholder = PlaceholderPresentationContext.getPlaceholderPresentationContext(request);
%><render:beginRender><div
        <render:writeAttribute name="id" value="<%= placeholder.getPresentationId() %>"/>
        <render:writeAttribute name="class" value="<%= placeholder.getPresentationClass() %>" defaultValue="bea-portal-layout-placeholder"/>
        <render:writeAttribute name="style" value="<%= placeholder.getPresentationStyle() %>"/>
></render:beginRender><render:endRender></div></render:endRender>

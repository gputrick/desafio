<%@ page import="com.bea.netuix.servlets.controls.window.ButtonPresentationContext"
%><%@ page session="false"%><%@ taglib uri="render.tld" prefix="render" %><%
    ButtonPresentationContext button = ButtonPresentationContext.getButtonPresentationContext(request);
    String buttonClass = button.getPresentationClass();
    String defaultButtonClass = "bea-portal-button-float";
%><render:resourceUrl var="rolloverImgSrc" path="<%= button.getRolloverImageSrc() %>"/><render:beginRender><a target="_blank"
<render:writeAttribute name="id" value="<%= button.getPresentationId() %>"/>
<render:writeAttribute name="class" value="<%= buttonClass %>" defaultValue="<%= defaultButtonClass %>"/>
<render:writeAttribute name="style" value="<%= button.getPresentationStyle() %>"/>href="<render:standalonePortletUrl/>">
<%= button.getAltText() %></render:beginRender><render:endRender></a><br/></render:endRender>
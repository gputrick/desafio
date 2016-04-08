<%@ page import="com.bea.netuix.servlets.controls.window.ToggleButtonPresentationContext,
                 com.bea.netuix.servlets.controls.window.TitlebarPresentationContext,
                 com.bea.netuix.servlets.controls.window.WindowPresentationContext"
%><%@ page session="false"%><%@ taglib uri="render.tld" prefix="render" %><render:beginRender><%
    ToggleButtonPresentationContext button = ToggleButtonPresentationContext.getToggleButtonPresentationContext(request);
    String buttonClass = button.getPresentationClass();
    String defaultButtonClass = "bea-portal-button";
%><render:resourceUrl var="rolloverImgSrc" path="<%= button.getRolloverImageSrc() %>"/><a <render:writeAttribute name="id" value="<%= button.getPresentationId() %>"/>
<render:writeAttribute name="class" value="<%= buttonClass %>" defaultValue="<%= defaultButtonClass %>"/>
<render:writeAttribute name="style" value="<%= button.getPresentationStyle() %>"/>href="<render:toggleButtonUrl/>"><img src="<render:resourceUrl path="<%= button.getImageSrc() %>"/>"
<render:writeAttribute name="alt" value="<%= button.getAltText() %>"/><render:writeAttribute name="title" value="<%= button.getAltText() %>"/><render:writeAttribute name="longdesc" value="<%= rolloverImgSrc %>"/>/></a></render:beginRender><render:endRender></a></render:endRender>
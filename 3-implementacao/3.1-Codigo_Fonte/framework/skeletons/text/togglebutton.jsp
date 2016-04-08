<%@ page import="com.bea.netuix.servlets.controls.window.ToggleButtonPresentationContext,
                 com.bea.netuix.servlets.controls.window.TitlebarPresentationContext,
                 com.bea.netuix.servlets.controls.window.WindowPresentationContext"
%>
<%@ page session="false"%>
<%@ taglib uri="render.tld" prefix="render" %><render:beginRender><%
    ToggleButtonPresentationContext button = ToggleButtonPresentationContext.getToggleButtonPresentationContext(request);
    String buttonClass = button.getPresentationClass();
    String defaultButtonClass = "bea-portal-button";
%><a
    <render:writeAttribute name="id" value="<%= button.getPresentationId() %>"/>
    <render:writeAttribute name="class" value="<%= buttonClass %>" defaultValue="<%= defaultButtonClass %>"/>
    <render:writeAttribute name="style" value="<%= button.getPresentationStyle() %>"/>
    href="<render:toggleButtonUrl/>"><%= button.getAltText() %></render:beginRender><render:endRender></a><br/></render:endRender>
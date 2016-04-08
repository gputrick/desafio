<%@ page import="com.bea.netuix.servlets.controls.application.ThemePresentationContext"
%><%@ page session="false"%><%@ taglib uri="render.tld" prefix="render"
%><%
    ThemePresentationContext theme = ThemePresentationContext.getThemePresentationContext(request);
    String name = theme.getName();
    name = (name == null) ? null : ("bea-portal-theme-" + name);
%><render:beginRender><% if (name != null) {
%><span class="<%= name %>"><% }
%></render:beginRender><render:endRender><% if (name != null) {
%></span><% } %></render:endRender>

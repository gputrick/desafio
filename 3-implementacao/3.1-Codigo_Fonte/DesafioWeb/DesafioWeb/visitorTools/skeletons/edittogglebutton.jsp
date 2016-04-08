<%@ page import="com.bea.portlet.GenericURL,
                 com.bea.netuix.servlets.controls.page.BookPresentationContext,
                 com.bea.netuix.servlets.controls.window.*"
%><%@ taglib uri="render.tld" prefix="render" %><render:beginRender><%
    ToggleButtonPresentationContext button = ToggleButtonPresentationContext.getToggleButtonPresentationContext(request);
    String buttonClass = button.getPresentationClass();
    String defaultButtonClass = "bea-portal-button";
    boolean isEditMode = false;

    WindowPresentationContext windowPresentationContext = BookPresentationContext.getBookPresentationContext(request);
    if (windowPresentationContext != null && windowPresentationContext.getWindowMode().getName().equals(WindowCapabilities.EDIT.getName()))
    {
        isEditMode = true;
    }

%><render:resourceUrl var="rolloverImgSrc" path="<%= button.getRolloverImageSrc() %>"/><a <render:writeAttribute name="id" value="<%= button.getPresentationId() %>"/>
<render:writeAttribute name="class" value="<%= buttonClass %>" defaultValue="<%= defaultButtonClass %>"/>
<render:writeAttribute name="style" value="<%= button.getPresentationStyle() %>"/>href="<render:toggleButtonUrl><%if (isEditMode){ %><render:param name="<%=GenericURL.LOADSTATE_PARAM%>" value="false"/><%}%></render:toggleButtonUrl>
"><img src="<render:resourceUrl path="<%= button.getImageSrc() %>"/>"
<render:writeAttribute name="alt" value="<%= button.getAltText() %>"/><render:writeAttribute name="title" value="<%= button.getAltText() %>"/><render:writeAttribute name="longdesc" value="<%= rolloverImgSrc %>"/>/></render:beginRender><render:endRender></a></render:endRender>
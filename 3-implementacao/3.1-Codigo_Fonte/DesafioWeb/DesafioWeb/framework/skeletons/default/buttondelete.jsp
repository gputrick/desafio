<%@ page import="com.bea.netuix.servlets.manager.AppDescriptor,
                 com.bea.netuix.servlets.manager.AppContext,
                 com.bea.netuix.servlets.controls.window.*,
                 com.bea.netuix.servlets.controls.page.Page,
                 java.security.Principal"
%><%@ page session="false"%><%@ taglib uri="render.tld" prefix="render" %><%
    ButtonPresentationContext button = ButtonPresentationContext.getButtonPresentationContext(request);
    String buttonClass = "bea-portal-button";
    // if parent window is not Page it is a Portlet
	boolean isParentPortlet = false;
    if ( button.isParentPortlet() )
    {
        buttonClass = "bea-portal-button-delete";
		isParentPortlet = true;
    }
    String defaultButtonClass = "bea-portal-button";

%><render:resourceUrl var="rolloverImgSrc" path="<%= button.getRolloverImageSrc() %>"/><%
    Principal principal = request.getUserPrincipal();
    String userName = ( principal == null ? null : principal.getName() );

     boolean isCustomizationEnabled = AppDescriptor.getInstance().isCustomizationEnabled();
     if(userName != null && isCustomizationEnabled && buttonClass != null &&
        isParentPortlet && ! AppContext.getAppContext(request).isDotPortal())
     {
%><render:beginRender><span><a <render:writeAttribute name="id" value="<%= button.getPresentationId() %>"/>
<render:writeAttribute name="class" value="<%= buttonClass %>" defaultValue="<%= defaultButtonClass %>"/>
<render:writeAttribute name="style" value="<%= button.getPresentationStyle() %>"/>href="<render:toggleButtonUrl/>"><img src="<render:resourceUrl path="<%= button.getImageSrc() %>"/>"
<render:writeAttribute name="alt" value="<%= button.getAltText() %>"/><render:writeAttribute name="title" value="<%= button.getAltText() %>"/><render:writeAttribute name="longdesc" value="<%= rolloverImgSrc %>"/>/></render:beginRender><render:endRender></a></span></render:endRender><%}
     else if(buttonClass != null && isParentPortlet) {
%><render:beginRender><a <render:writeAttribute name="id" value="<%= button.getPresentationId() %>"/>
<render:writeAttribute name="class" value="<%= buttonClass %>" defaultValue="<%= defaultButtonClass %>"/>
<render:writeAttribute name="style" value="<%= button.getPresentationStyle() %>"/>href="<render:toggleButtonUrl/>"><img src="<render:resourceUrl path="<%= button.getImageSrc() %>"/>"
<render:writeAttribute name="alt" value="<%= button.getAltText() %>"/><render:writeAttribute name="title" value="<%= button.getAltText() %>"/><render:writeAttribute name="longdesc" value="<%= rolloverImgSrc %>"/>/></render:beginRender><render:endRender></a></render:endRender><%
}%>
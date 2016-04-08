<%@ page import="com.bea.netuix.servlets.manager.AppDescriptor,
                 com.bea.netuix.servlets.manager.AppContext,
                 com.bea.netuix.servlets.controls.window.*,
                 com.bea.netuix.servlets.controls.page.Page,
                 java.security.Principal"
%><%@ page session="false"%><%@ taglib uri="render.tld" prefix="render" %><%
    ButtonPresentationContext button = ButtonPresentationContext.getButtonPresentationContext(request);
    String buttonClass = "bea-portal-button";
    // if parent window is not Page it is a Portlet
    if ( button.isParentPortlet() )
    {
        buttonClass = "bea-portal-button-delete";
    }
    String defaultButtonClass = "bea-portal-button";

%><render:resourceUrl var="rolloverImgSrc" path="<%= button.getRolloverImageSrc() %>"/><%
    Principal principal = request.getUserPrincipal();
    String userName = ( principal == null ? null : principal.getName() );

     boolean isCustomizationEnabled = AppDescriptor.getInstance().isCustomizationEnabled();
     if(userName != null && isCustomizationEnabled && buttonClass != null &&
        buttonClass.equals("bea-portal-button-delete") && ! AppContext.getAppContext(request).isDotPortal())
     {
%><render:beginRender><span><a <render:writeAttribute name="id" value="<%= button.getPresentationId() %>"/>
<render:writeAttribute name="class" value="<%= buttonClass %>" defaultValue="<%= defaultButtonClass %>"/>
<render:writeAttribute name="style" value="<%= button.getPresentationStyle() %>"/>href="<render:toggleButtonUrl/>"><%= button.getAltText()%>
</render:beginRender><render:endRender></a></span></render:endRender><%}
     else if(buttonClass != null && buttonClass.equals("bea-portal-button-delete")) {
%><render:beginRender><a <render:writeAttribute name="id" value="<%= button.getPresentationId() %>"/>
<render:writeAttribute name="class" value="<%= buttonClass %>" defaultValue="<%= defaultButtonClass %>"/>
<render:writeAttribute name="style" value="<%= button.getPresentationStyle() %>"/>href="<render:toggleButtonUrl/>"><%=button.getAltText()%>
</render:beginRender><render:endRender></a><br /></render:endRender><%
}%>

<%@ taglib uri="render.tld" prefix="render" %>

<%@ page import="java.util.*,
                 com.bea.jsptools.portal.util.VisitorToolsUtil,
                 com.bea.jsptools.portal.util.EntitledPresentations,
                 com.bea.jsptools.portal.util.VisitorToolsHtmlUtil,
                 com.bea.jsptools.common.Utility" %>

<%@ page import="com.bea.netuix.servlets.controls.application.DesktopPresentationContext" %>
<%@ page import="com.bea.netuix.servlets.controls.PresentationContext" %>
<%@ page import="com.bea.netuix.servlets.controls.page.BookPresentationContext" %>
<%@ page import="com.bea.netuix.servlets.controls.page.PagePresentationContext" %>
<%@ page import="com.bea.netuix.servlets.controls.portlet.PortletPresentationContext" %>
<%@ page import="com.bea.netuix.application.view.PageView" %>
<%@ page import="com.bea.netuix.application.view.PlaceableView" %>
<%@ page import="com.bea.netuix.application.view.PlaceholderView" %>
<%@ page import="com.bea.netuix.application.identifier.BookInstanceId" %>
<%@ page import="com.bea.netuix.application.identifier.PortletInstanceId" %>
<%@ page import="com.bea.netuix.application.identifier.PlaceableInstanceId" %>
<%@ page import="com.bea.netuix.application.definition.BookDefinition" %>
<%@ page import="com.bea.netuix.application.definition.LayoutDefinition" %>
<%@ page import="com.bea.netuix.application.definition.MenuDefinition" %>
<%@ page import="com.bea.netuix.application.definition.PortletDefinition" %>
<%@ page import="com.bea.jsptools.portal.PortalVisitorConstants" %>
<%@ page import="com.bea.jsptools.portal.PortalVisitorManager" %>
<%@ page import="com.bea.jsptools.portal.placement.BookPlacement" %>
<%@ page import="com.bea.jsptools.portal.placement.PlaceablePlacement" %>
<%@ page import="com.bea.jsptools.portal.placement.PortletPlacement" %>
<%@ page import="com.bea.p13n.management.ApplicationHelper"%>
<%@ page import="com.bea.netuix.application.localization.definition.LocalizationResource" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>

<%@ taglib uri="i18n.tld" prefix="i18n" %>
<i18n:localize bundleName="visitorTools" />
<%@ taglib uri="es.tld" prefix="es" %>


<script language="JavaScript" src="<%=request.getContextPath()%>/visitorTools/js/dialog.js" type="text/javascript"></script>

<%java.security.Principal user = request.getUserPrincipal();%>
<%-- if user is null present login message--%>
<es:isNull item="<%=user%>">
  <i18n:getMessage messageName="login.message" />
</es:isNull>
<%-- else user is logged in --%>
<es:notNull item="<%=user%>" >
<%
    String webAppName = ApplicationHelper.getWebAppName(request);
    // path in format of '/portalpath/desktoppath'
    String pathInfo = request.getPathInfo();
    String portalPath = pathInfo.substring(1, pathInfo.lastIndexOf("/"));
    String desktopPath = pathInfo.substring(pathInfo.lastIndexOf("/") + 1, pathInfo.length());
    // check to see if we set a new page id in the backing file, pointing to our possible new instance
    String pageId = (String) request.getAttribute(PortalVisitorConstants.EDIT_PAGE);
    if (pageId == null)
    {
        pageId = request.getParameter(PortalVisitorConstants.EDIT_PAGE);
        if (pageId == null)
        {
            pageId = "0";
        }
    }
    String pageName = "" + PortalVisitorManager.crossSiteScriptFix(request.getParameter(PortalVisitorConstants.EDIT_PAGE_NAME));
    pageName = VisitorToolsHtmlUtil.fixupQuotes( pageName );
    String fixedPageName = pageName;
    String newLayoutHTML = "";
    String layoutLockedString = "";
    int selectedLayoutId = 0;

    DesktopPresentationContext desktopPresentationContext = DesktopPresentationContext.getDesktopPresentationContext(request);
    BookPresentationContext bookPresentationContext = desktopPresentationContext.getBookPresentationContext();
    String theBook = bookPresentationContext.getLabel();
    EntitledPresentations ep = new EntitledPresentations( bookPresentationContext, pageId, request );
    PageView pageView =  PortalVisitorManager.getPageView(pageId, webAppName, portalPath, desktopPath, request.getLocale(), request);
    if (pageView != null)
    {
        PlaceholderView[] placeholderViews = pageView.getPlaceholderViews();
        for( int i = 0; i < placeholderViews.length; i++ )
        {
            boolean isLocked = PortalVisitorManager.isPlaceholderLocked(webAppName, portalPath, desktopPath, pageId, "" + i , request);
            if( isLocked )
            {
                layoutLockedString = " disabled=\"true\"";
                break;
            }
        }

        selectedLayoutId = pageView.getLayoutView().getLayoutDefinitionId().getId();
        newLayoutHTML = VisitorToolsHtmlUtil.getPlaceholdersHtml( pageContext, request, pageView, ep, pageId );
    }

    // Generate Portlet Category information
    String[] portletCategoryStrings = PortalVisitorManager.generatePortletCategoryArrays(webAppName, "&nbsp;&nbsp;", request.getLocale(), request);
%>
<script language="JavaScript">
<%= portletCategoryStrings[2] %>
function SetOptions(the_select, text_array, value_array) {
    the_select.options.length = text_array.length;
    for (loop=0; loop < text_array.length; loop++) {
        the_select.options[loop].text = text_array[loop];
        the_select.options[loop].value = value_array[loop];
    }
}
</script>
<div style="padding-left:6px;padding-right:6px;padding-bottom:6px;padding-top:0px;">
  <h2><i18n:getMessage messageName="edit.page.title" /></h2>
    <table cellpadding="0" cellspacing="0" border="0" align="left" width="1%">
	<tr>
		<td width="300" valign="top" align="left" nowrap>
            <p><i18n:getMessage messageName="edit.page.desc.change" /></p>
			<p><i18n:getMessage messageName="edit.page.desc.remove" /></p>
			<p><i18n:getMessage messageName="edit.page.desc.add" /></p>
			<p><i18n:getMessage messageName="edit.page.desc.order" /></p>
		</td>
		<td width="1%" valign="top" align="left" nowrap>
			<div class="bea-portal-window">
				<div class="bea-portal-window-titlebar"><i18n:getMessage messageName="edit.page.editing.page" /> <%=pageName%></div>
				<div>
					<form method="post" name="UpdateLayoutForm" id="UpdateLayoutForm">
					<table border="0" cellpadding="3" cellspacing="0" width="100%" class="portlet-section-alternate">
						<tr>
							<td valign="middle" align="left" width="1%" nowrap><span style="font-weight:normal;">&nbsp;&nbsp;&nbsp;&nbsp;<i18n:getMessage messageName="edit.page.label.layout" /></span></td>
							<td valign="middle" align="left" width="1%" nowrap>
								<select <%=layoutLockedString%> name="<%=PortalVisitorConstants.LAYOUT_ID%>" id="<%=PortalVisitorConstants.LAYOUT_ID%>">
                                    <es:forEachInArray array="<%=PortalVisitorManager.getLayoutDefinitions(webAppName, request.getLocale(), request)%>"
                                            id="tmpLayout"
                                            type="com.bea.netuix.application.definition.LayoutDefinition"  >
                                            <%LocalizationResource lr = tmpLayout.getLocalizationResource();%>
                                            <%int layoutId = tmpLayout.getLayoutDefinitionId().getId();%>
                                            <option value="<%=layoutId%>" <% if (layoutId == selectedLayoutId){%>selected<%}%>><%=lr.getTitle()%>
                                    </es:forEachInArray>
 								</select>
							</td>
							<td valign="middle" align="left" width="98%" nowrap>
								<input type="submit" value="<i18n:getMessage messageName="edit.page.button.layout" />">
								<input type="hidden" name="<%=PortalVisitorConstants.EDIT_PAGE%>" value="<%=pageId%>"/>
								<input type="hidden" name="<%=PortalVisitorConstants.EDIT_PAGE_NAME%>" value="<%=fixedPageName%>"/>
								<input type="hidden" name="<%=PortalVisitorConstants.WEB_APP_NAME%>" value="<%=webAppName%>"/>
								<input type="hidden" name="<%=PortalVisitorConstants.PORTAL_PATH%>" value="<%=portalPath%>"/>
								<input type="hidden" name="<%=PortalVisitorConstants.DESKTOP_PATH%>" value="<%=desktopPath%>"/>
								<input type="hidden" name="<%=PortalVisitorConstants.TARGET_PAGE_ID%>" value="<%=PortalVisitorConstants.VISITOR_TOOLS_EDIT_PAGE%>"/>
                                <input type="hidden" name="<%=PortalVisitorConstants.MAIN_BOOK%>" value="<%=theBook%>"/>
							</td>
						</tr>
					</table>
					</form>
				</div>
				<div style="padding:20px">
					<%=newLayoutHTML%>
					<br><i18n:getMessage messageName="layout.has.not.changed" id="txt44"/>
					<input type="button" value="<i18n:getMessage messageName="edit.page.button.save" />" onClick="saveChanges('<%=Utility.fixQuotes(txt44)%>')">&nbsp;&nbsp;
					<input type="button" value="<i18n:getMessage messageName="edit.page.button.back" />" onClick="cancelChanges()">
				</div>
			</div>
        </td>
	  </tr>
    </table>
</div>

<div id="AddContentDialog" align="center" class="bea-portal-window" style="position:absolute;visibility:hidden;left:0;top:0;height:0;width:0;z-index:5001">
  <table width='400' height='250' cellpadding="0" cellspacing="12">
    <tr>
      <td valign="top" align="left" nowrap class="bea-portal-window" width="50%">
        <div class="bea-portal-window-titlebar">
			<table>
				<tr>
					<td align="left" valign="middle"><i18n:getMessage messageName="edit.page.portlets" />&nbsp;</td>
<%
                    if (portletCategoryStrings[3].equals("1"))
                    {
%>
					<td align="right" valign="middle">
						<select name="selectPortletCategory"
                                id="selectPortletCategory"
                                onchange="SetOptions(document.getElementById('allPortlets'), eval(document.getElementById('selectPortletCategory').options[selectedIndex].value), eval(document.getElementById('selectPortletCategory').options[selectedIndex].value + 'Values'))">
							<%= portletCategoryStrings[0] %>
						</select>
					</td>
<%
                    }
%>
				</tr>
			</table>
        </div>
        <div id="portletSelectList" class="portlet-section-alternate" align="center" style="height:100%;">
            <select MULTIPLE name="allPortlets" id="allPortlets" size="10" style="width:80%;">
                <%= portletCategoryStrings[1] %>
            </select>
            <br>
            <input type="button" value="<i18n:getMessage messageName="edit.page.button.add.portlet" />" onClick="addPortlet()">
        </div>
      </td>
      <td valign="top" align="left" nowrap class="bea-portal-window" width="50%">
        <div class="bea-portal-window-titlebar"><i18n:getMessage messageName="edit.page.books" /></div>
        <div id="bookSelectList" class="portlet-section-alternate" align="center" style="height:100%;">
            <select MULTIPLE name="allBooks" id="allBooks" size="10" style="width:80%;">
              <es:forEachInArray array="<%=VisitorToolsHtmlUtil.getBookDefinitionOptions( request, webAppName, portalPath, desktopPath )%>"
                                                              id="option"
                                                              type="java.lang.String"  >
                  <%=option%>
              </es:forEachInArray>
            </select>
            <br><i18n:getMessage messageName="edit.page.button.add.newbook" id="txt1" /><i18n:getMessage messageName="select.book.add" id="txt2" />
            <input type="button" value="<i18n:getMessage messageName="edit.page.button.add.book" />" onClick="addBook('<%=Utility.fixQuotes(txt2)%>')"><br>
            <input type="button" value="<i18n:getMessage messageName="edit.page.button.add.newbook" />" onClick="addNewBook('<%=Utility.fixQuotes(txt1)%>')">
        </div>
      </td>
    </tr>
    <tr>
      <td colspan="2" valign="middle" align="center">
          <input type="button" value="<i18n:getMessage messageName="edit.page.button.cancel" />" onClick="toggleDialogBox('AddContentDialog')">
      </td>
    </tr>
  </table>
</div><%-- end Add content dialog div --%>

<div id="AddNewBookDialog" align="center" class="bea-portal-window" style="position:absolute;visibility:hidden;left:0;top:0;height:0;width:0;z-index:5002">
  <table width="100%" cellpadding="0" cellspacing="12">
    <tr>
      <td valign="top" align="left" nowrap class="bea-portal-window" width="100%">
            <div class="bea-portal-window-titlebar"><i18n:getMessage messageName="edit.page.menu.tabs" /></div>
            <div style="padding:6px;white-space:nowrap;">
                <i18n:getMessage messageName="edit.page.choose.menu" />
                <select name="newBookMenuId" id="newBookMenuId">
                    <option value="-1"><i18n:getMessage messageName="edit.page.no.menu" />
                        <es:forEachInArray array="<%=PortalVisitorManager.getMenuDefinitions(webAppName, request.getLocale(), request)%>"
                                            id="tmpMenu"
                                            type="com.bea.netuix.application.definition.MenuDefinition"  >
                                            <%LocalizationResource lr = tmpMenu.getLocalizationResource();%>
                                            <%int menuId = tmpMenu.getMenuDefinitionId().getId();%>
                                            <option value="<%=menuId%>"> <%=lr.getTitle()%>
                        </es:forEachInArray>
               </select>
            </div>
      </td>
    </tr>
    <tr>
      <td valign="top" align="left" nowrap class="bea-portal-window" width="100%">
        <div class="bea-portal-window-titlebar"><i18n:getMessage messageName="edit.page.book.properties" /></div>
        <div style="padding:6px;white-space:nowrap;">
            <i18n:getMessage messageName="edit.page.book.name" /> <input type="text" size="20" name="newBookName" id="newBookName">
        </div>
      </td>
    </tr>
    <tr>
      <td valign="middle" align="center">
          <input type="button" value="<i18n:getMessage messageName="edit.page.button.ok" />" onClick="saveNewBook()">
          <input type="button" value="<i18n:getMessage messageName="edit.page.button.cancel" />" onClick="toggleDialogBox2('AddNewBookDialog')">
      </td>
    </tr>
  </table>
</div><%-- end Add New Book dialog div --%>

    <form method="post" name="CancelChangesForm" id="CancelChangesForm">
        <input type="hidden" name="cancel_page" value="1" />
        <input type="hidden" name="<%=PortalVisitorConstants.TARGET_PAGE_ID%>" value="<%=PortalVisitorConstants.VISITOR_TOOLS_MAIN_PAGE%>"/>
    </form>

    <form method="post" name="SavePlaceholdersForm" id="SavePlaceholdersForm">
        <input type="hidden" name="<%=PortalVisitorConstants.SAVE_PLACEHOLDERS%>" value="1" />
        <input type="hidden" name="<%=PortalVisitorConstants.EDIT_PAGE%>" value="<%=pageId%>" />
        <input type="hidden" name="<%=PortalVisitorConstants.MOVE_PLACEABLE_IDS%>" value="" />
        <input type="hidden" name="<%=PortalVisitorConstants.MOVE_PLACEABLE_POSITIONS%>" value="" />
        <input type="hidden" name="<%=PortalVisitorConstants.MOVE_PLACEABLE_PLACEHOLDERS%>" value="" />
        <input type="hidden" name="<%=PortalVisitorConstants.DELETE_PLACEABLE_IDS%>" value="" />
        <input type="hidden" name="<%=PortalVisitorConstants.ADD_PLACEABLE_IDS%>" value="" />
        <input type="hidden" name="<%=PortalVisitorConstants.ADD_PLACEABLE_POSITIONS%>" value="" />
        <input type="hidden" name="<%=PortalVisitorConstants.ADD_PLACEABLE_PLACEHOLDERS%>" value="" />
        <input type="hidden" name="<%=PortalVisitorConstants.WEB_APP_NAME%>" value="<%=webAppName%>"/>
        <input type="hidden" name="<%=PortalVisitorConstants.PORTAL_PATH%>" value="<%=portalPath%>"/>
        <input type="hidden" name="<%=PortalVisitorConstants.DESKTOP_PATH%>" value="<%=desktopPath%>"/>
        <input type="hidden" name="<%=PortalVisitorConstants.TARGET_PAGE_ID%>" value="<%=PortalVisitorConstants.VISITOR_TOOLS_MAIN_PAGE%>"/>
        <input type="hidden" name="<%=PortalVisitorConstants.MAIN_BOOK%>" value="<%=theBook%>"/>
    </form>


<div id="dialogBackgroundDiv" style="position: absolute;visibility: hidden;left: 0;top: 0;height: 0;width: 0;background-color: #000000;z-index: 5000;filter: alpha(opacity=50);-moz-opacity:0.5;">
  &nbsp;
</div>

</es:notNull>
<script language="JavaScript" src="<%=request.getContextPath()%>/visitorTools/js/page.js" type="text/javascript"></script>

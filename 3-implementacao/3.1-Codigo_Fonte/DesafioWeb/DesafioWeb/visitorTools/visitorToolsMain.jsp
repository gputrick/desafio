
<%@ page import="java.util.*,
                 com.bea.netuix.servlets.controls.application.ThemePresentationContext,
                 com.bea.jsptools.portal.util.ResourceCount,
                 com.bea.jsptools.portal.util.VisitorToolsUtil,
                 com.bea.jsptools.portal.util.VisitorToolsHtmlUtil,
                 com.bea.jsptools.common.Utility" %>
<%@ page import="com.bea.netuix.servlets.controls.application.DesktopPresentationContext" %>
<%@ page import="com.bea.netuix.servlets.controls.PresentationContext" %>
<%@ page import="com.bea.netuix.servlets.controls.page.BookPresentationContext" %>
<%@ page import="com.bea.netuix.servlets.controls.page.PagePresentationContext" %>
<%@ page import="com.bea.netuix.servlets.controls.portlet.PortletPresentationContext" %>

<%@ page import="com.bea.netuix.application.instance.BookInstance" %>
<%@ page import="com.bea.netuix.application.instance.PageInstance" %>
<%@ page import="com.bea.netuix.application.instance.PortletInstance" %>

<%@ page import="com.bea.netuix.application.view.BookView" %>
<%@ page import="com.bea.netuix.application.view.DesktopView" %>
<%@ page import="com.bea.netuix.application.view.NavigableView" %>
<%@ page import="com.bea.netuix.application.view.PageView" %>
<%@ page import="com.bea.netuix.application.view.PlaceableView" %>
<%@ page import="com.bea.netuix.application.view.PortletView" %>

<%@ page import="com.bea.netuix.application.identifier.ThemeDefinitionId" %>

<%@ page import="com.bea.netuix.application.definition.BookDefinition" %>
<%@ page import="com.bea.netuix.application.definition.LookAndFeelDefinition" %>
<%@ page import="com.bea.netuix.application.definition.PageDefinition" %>
<%@ page import="com.bea.netuix.application.definition.ThemeDefinition" %>

<%@ page import="com.bea.jsptools.portal.PortalVisitorConstants" %>
<%@ page import="com.bea.jsptools.portal.PortalVisitorManager" %>

<%@ page import="com.bea.jsptools.portal.placement.BookPlacement" %>
<%@ page import="com.bea.jsptools.portal.placement.NavigablePlacement" %>
<%@ page import="com.bea.jsptools.portal.placement.PagePlacement" %>
<%@ page import="com.bea.jsptools.portal.placement.PlaceablePlacement" %>
<%@ page import="com.bea.jsptools.portal.placement.PortletPlacement" %>

<%@ page import="com.bea.p13n.management.ApplicationHelper"%>

<%@ page import="com.bea.netuix.application.localization.definition.LocalizationResource" %>

<%@ page import="javax.servlet.http.HttpServletRequest" %>                       

<%@ taglib uri="es.tld" prefix="es" %>
<%@ taglib uri="render.tld" prefix="render" %>
<%@ taglib uri="i18n.tld" prefix="i18n" %>
<i18n:localize bundleName="visitorTools" />


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
   String pathInfo = request.getPathInfo();
%>

<%-- the pathinfo is NOT good and there are no desktops present --%>
<es:isNull item="<%=pathInfo%>" >
       <div align="center">
           <i18n:getMessage messageName="main.nodesktops.message" /><br />
           <i18n:getMessage messageName="main.nodesktops.message1" />
       </div>
</es:isNull>
<%-- the pathinfo is good and desktops are present, present edit page --%>
<es:notNull item="<%=pathInfo%>" >
<%
    String portalPath = pathInfo.substring(1, pathInfo.lastIndexOf("/"));
    String desktopPath = pathInfo.substring(pathInfo.lastIndexOf("/") + 1, pathInfo.length());
    DesktopPresentationContext desktopPresentationContext = DesktopPresentationContext.getDesktopPresentationContext(request);
    BookPresentationContext bookPresentationContext = desktopPresentationContext.getBookPresentationContext();
    String theBook = bookPresentationContext.getLabel();
    String primaryBookInstanceId = bookPresentationContext.getInstanceId();
    ThemePresentationContext themePresentationContext = bookPresentationContext.getThemePresentationContext();
    String primaryBookThemeId = themePresentationContext == null ? "-1" : themePresentationContext.getDefinitionId();
%>
<div style="padding-left:6px;padding-right:6px;padding-bottom:6px;padding-top:0px;">
  <h2><i18n:getMessage messageName="main.customize.portal" /></h2>

  <table border="0" cellpadding="3" cellspacing="0" align="left">
    <tr>
      <td valign="top" align="left" width="250" nowrap>
        <i18n:getMessage messageName="main.desc" />
      </td>
      <td valign="top" align="left">
          <div class="bea-portal-window">
              <div class="bea-portal-window-titlebar"><i18n:getMessage messageName="main.portal.resources" /></div>
              <div class="portlet-section-alternate">
                 &nbsp;
                 <input id="showPageContentsCheckbox" type="checkbox" name="showPageContentsName" onClick="showPageContents()" style="margin:0px;"/>
                 <span style="font-weight:normal;font-size:80%;"><i18n:getMessage messageName="main.show.page.contents" /></span>
              </div>
              <table border="0" cellpadding="0" cellspacing="0">
                <tr>
                  <td valign="top" align="left" nowrap>
                    <div id="PortalTree" style="margin:12px;">
                        <div style="display:block;" id="book0On"><img src="/<%=webAppName%>/visitorTools/images/portal-16.gif"/><a href='javascript:selectPortal("<%=primaryBookInstanceId%>", "<%=primaryBookThemeId%>", "Portal", "<i18n:getMessage messageName="selected.portal.pre" />", "<i18n:getMessage messageName="selected.portal.post" />")'><i18n:getMessage messageName="main.portal" /></a>
                        </div>
                        <div style="display:none;color:#999999;" id="book0Off">
                            <img src="/<%=webAppName%>/visitorTools/images/portal-16.gif"/><i18n:getMessage messageName="main.portal" />
                        </div>
<%
                    ResourceCount count = new ResourceCount(0, 0, 1, 0);
                    out.println( VisitorToolsHtmlUtil.getBookChildren(pageContext, bookPresentationContext, request, false, "B" + primaryBookInstanceId + ".", count));
%>
                    </div>
                  </td>
                  <td valign="top" align="left">
                    <div class="bea-portal-window" style="margin:12px;">
                        <div id="selectedResourceDiv" class="portlet-section-alternate" style="white-space: nowrap;text-align:left;"><i18n:getMessage messageName="main.selected.item.none" /></div>
                        <div id="moveDiv" style="visibility:hidden;position:absolute">
                          <br />
                          <table border="0" cellpadding="6" cellspacing="0">
                            <tr>
                              <td valign="top" align="right" nowrap><b><i18n:getMessage messageName="main.move.to" /></b></td>
                              <td id="itemToMoveTo" valign="top" align="left" nowrap> </td>
                            </tr>
                            <tr>
                              <td nowrap>
                                 <div id="finishMoveButtonOn" style="position:absolute;visibility:hidden;">
                                     <input type="button" value="<i18n:getMessage messageName="main.button.finish.move" />" onClick="finishMoveResource()">
                                 </div>
                                 <div id="finishMoveButtonOff">
                                     <input type="button" value="<i18n:getMessage messageName="main.button.finish.move" />" disabled="true">
                                 </div>
                               </td>
                              <td nowrap> <input type="button" value="<i18n:getMessage messageName="main.button.cancel.move" />" onClick="cancelMove()">
                              </td>
                            </tr>
                          </table>
                        </div>

                  <div id="editItemDiv" style="position:relative;padding:6px;white-space:nowrap;">
                    <form method="post" name="UpdateThemeForm" id="UpdateThemeForm">
                      <div id="editContentsButtonOn" style="display:none;">
                        <input type="button" value="<i18n:getMessage messageName="main.button.edit.contents" />" onClick="editResource()">
                      </div>
                      <div id="editContentsButtonOff" style="display:block;">
                        <input type="button"
                                   value="<i18n:getMessage messageName="main.button.edit.contents" />"
                                   disabled="true"
                                   style="color:#999999"
                                   alt="<i18n:getMessage messageName="main.button.edit.contents.alt" />"
                                   title="<i18n:getMessage messageName="main.button.edit.contents.title" />">
                      </div>
                      <div id="renameButtonOn" style="display:none;">
                        <input type="button" value="<i18n:getMessage messageName='main.button.rename' />" onClick="renameResource('<i18n:getMessage messageName='main.button.rename.dialog.title' />')">
                      </div>
                      <div id="renameButtonOff" style="display:block;">
                        <input type="button"
                                   value="<i18n:getMessage messageName="main.button.rename" />"
                                   disabled="true"
                                   style="color:#999999"
                                   alt="<i18n:getMessage messageName="main.button.rename.alt" />"
                                   title="<i18n:getMessage messageName="main.button.rename.title" />">
                      </div>
                      <div id="moveButtonOn" style="display:none;">
                        <input type="button" value="<i18n:getMessage messageName="main.button.move" />" onClick="moveResource('<i18n:getMessage messageName='moveresource.click.page'/>', '<i18n:getMessage messageName='moveresource.click.book.or.portal'/>')">
                      </div>
                      <div id="moveButtonOff"  style="display:block;">
                        <input type="button"
                               value="<i18n:getMessage messageName="main.button.move" />"
                               disabled="true"
                               style="color:#999999"
                               alt="<i18n:getMessage messageName="main.button.move.alt" />"
                               title="<i18n:getMessage messageName="main.button.move.title" />">
                      </div>
                      <hr/>
                      <div id="chooseThemeButtonOn" style="display:none;text-align:left;">
                        <b><i18n:getMessage messageName="main.choose.theme" /></b><br />
                        <div style="width:1%;"> &nbsp;&nbsp;&nbsp;&nbsp;
                          <select name="<%=PortalVisitorConstants.THEME_ID%>" id="<%=PortalVisitorConstants.THEME_ID%>">
                            <option value="-1"><i18n:getMessage messageName="main.option.none" />
                            <es:forEachInArray array="<%=PortalVisitorManager.getThemeDefinitions(webAppName, request.getLocale(), request)%>"
                                    id="tmpTheme"     
                                    type="com.bea.netuix.application.definition.ThemeDefinition"  >
                                    <%LocalizationResource lr2 = tmpTheme.getLocalizationResource();%>
                                    <%int themeId = tmpTheme.getThemeDefinitionId().getId();%>
                                    <option value="<%="" + themeId%>" <% if (themeId == 0){%>selected<%}%>><%=lr2.getTitle()%>
                            </es:forEachInArray>
                          </select>
                          <br/>
                          &nbsp;&nbsp;&nbsp;&nbsp;
                          <input type="button" value="<i18n:getMessage messageName="main.button.apply.theme" />" onClick="applyTheme()">
                        </div>
                      </div>
                      <div id="chooseThemeButtonOff" style="display:block;color:#999999;" >
                        <b><i18n:getMessage messageName="main.choose.theme" /></b><br />
                        <div style="width:1%;"> &nbsp;&nbsp;&nbsp;&nbsp;
                          <select name="themeIdDisabled" id="themeIdDisabled" disabled="true">
                            <option value="-1"><i18n:getMessage messageName="main.option.none" /></option>
                          </select>
                          <br/>
                          &nbsp;&nbsp;&nbsp;&nbsp;
                          <input type="button"
                                   disabled="true"
                                   value="<i18n:getMessage messageName="main.button.apply.theme" />"
                                   style="color:#999999"
                                   alt="<i18n:getMessage messageName="main.button.apply.theme.alt" />"
                                   title="<i18n:getMessage messageName="main.button.apply.theme.title" />">
                        </div>
                      </div>
                      <input type="hidden" name="<%=PortalVisitorConstants.RESOURCE_ID%>" value=""/>
                      <input type="hidden" name="<%=PortalVisitorConstants.RESOURCE_TYPE%>" value=""/>
                      <input type="hidden" name="<%=PortalVisitorConstants.SHOW_PAGE_CONTENTS%>" value=""/>
                      <input type="hidden" name="<%=PortalVisitorConstants.TARGET_PAGE_ID%>" value="<%=PortalVisitorConstants.VISITOR_TOOLS_MAIN_PAGE%>"/>
                      <input type="hidden" name="<%=PortalVisitorConstants.WEB_APP_NAME%>" value="<%=webAppName%>"/>
                      <input type="hidden" name="<%=PortalVisitorConstants.PORTAL_PATH%>" value="<%=portalPath%>"/>
                      <input type="hidden" name="<%=PortalVisitorConstants.DESKTOP_PATH%>" value="<%=desktopPath%>"/>
                      <input type="hidden" name="<%=PortalVisitorConstants.MAIN_BOOK%>" value="<%=theBook%>"/>
                    </form>
                  </div>
                    </div>
                  </td>
                </tr>
              </table>
            </div>
        </td>
    </tr>
    <tr>
      <td valign="top" align="left">
        <i18n:getMessage messageName="main.select.apply.lookandfeel" />
      </td>
      <td valign="top" align="left">
          <div class="bea-portal-window">
                <div class="bea-portal-window-titlebar"><i18n:getMessage messageName="main.lookandfeel" /></div>
                <div style="padding:6px;">
                    <form method="post" name="UpdateLookAndFeelForm" id="UpdateLookAndFeelForm">
                  <b><i18n:getMessage messageName="main.choose.lookandfeel" /></b>
                  <br />
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <%int selectedLookId = desktopPresentationContext.getLookAndFeelDefinitionId().getId();%>
                    <select name="<%=PortalVisitorConstants.LOOK_AND_FEEL_ID%>" id="<%=PortalVisitorConstants.LOOK_AND_FEEL_ID%>">
                    <es:forEachInArray array="<%=PortalVisitorManager.getLookAndFeelDefinitions(webAppName, request.getLocale(), request)%>"
                                    id="tmpLAF"
                                    type="com.bea.netuix.application.definition.LookAndFeelDefinition"  >
                                    <%LocalizationResource lr = tmpLAF.getLocalizationResource();%>
                                    <%int lookId = tmpLAF.getLookAndFeelDefinitionId().getId();%>
                                    <option value="<%=lookId%>" <% if (lookId == selectedLookId){%>selected<%}%>><%=lr.getTitle()%>
                    </es:forEachInArray>
                      </select>&nbsp;<input type="button" value="<i18n:getMessage messageName="main.button.apply.lookandfeel" />" onClick="applyLookAndFeel()">
                      <input type="hidden" name="<%=PortalVisitorConstants.SHOW_PAGE_CONTENTS%>" value=""/>
                      <input type="hidden" name="<%=PortalVisitorConstants.TARGET_PAGE_ID%>" value="<%=PortalVisitorConstants.VISITOR_TOOLS_MAIN_PAGE%>"/>
                      <input type="hidden" name="<%=PortalVisitorConstants.WEB_APP_NAME%>" value="<%=webAppName%>"/>
                      <input type="hidden" name="<%=PortalVisitorConstants.PORTAL_PATH%>" value="<%=portalPath%>"/>
                      <input type="hidden" name="<%=PortalVisitorConstants.DESKTOP_PATH%>" value="<%=desktopPath%>"/>
                      <input type="hidden" name="<%=PortalVisitorConstants.MAIN_BOOK%>" value="<%=theBook%>"/>
                    </form>
                </div>
            </div>
        </td>
    </tr>
  </table>
</div>
<div id="renameResourceDialog" align="center" class="bea-portal-window" style="position:absolute;visibility:hidden;left:0;top:0;height:0;width:0;z-index:5001">
  <table width='250' height='125' cellpadding="3" cellspacing="0">
    <tr>
      <td valign="top" align="center" nowrap>
       <input name="renameInput" id="renameInput" type="text" value=""/>
      </td>
    </tr>
    <tr>
      <td valign="top" align="center"><i18n:getMessage messageName="must.enter.name" id="alertTxt22" />
          <input type="button" value="<i18n:getMessage messageName="main.button.rename" />" onClick="renameResourceSubmit(getElementById('renameInput').value, '<%=Utility.fixQuotes(alertTxt22)%>');">&nbsp;&nbsp;&nbsp;&nbsp;
          <input type="button" value="<i18n:getMessage messageName="main.button.cancel" />" onClick="toggleDialogBox('renameResourceDialog')">
      </td>
    </tr>
  </table>
</div><%-- end Add content dialog div --%>

<form method="post" name="MoveToBookForm" id="MoveToBookForm" action="<%=request.getRequestURI()%>">
    <input type="hidden" name="<%=PortalVisitorConstants.BOOK_TO_MOVE_RESOURCE_TO%>" value=""/>
    <input type="hidden" name="<%=PortalVisitorConstants.RESOURCE_TO_MOVE%>" value=""/>
    <input type="hidden" name="<%=PortalVisitorConstants.RESOURCE_TYPE_TO_MOVE%>" value=""/>
    <input type="hidden" name="<%=PortalVisitorConstants.RESOURCE_TO_MOVE_FROM%>" value=""/>
    <input type="hidden" name="<%=PortalVisitorConstants.RESOURCE_TYPE_TO_MOVE_FROM%>" value=""/>
    <input type="hidden" name="<%=PortalVisitorConstants.SHOW_PAGE_CONTENTS%>" value=""/>
    <input type="hidden" name="<%=PortalVisitorConstants.TARGET_PAGE_ID%>" value="<%=PortalVisitorConstants.VISITOR_TOOLS_MAIN_PAGE%>"/>
    <input type="hidden" name="<%=PortalVisitorConstants.WEB_APP_NAME%>" value="<%=webAppName%>"/>
    <input type="hidden" name="<%=PortalVisitorConstants.MAIN_BOOK%>" value="<%=theBook%>"/>
    <input type="hidden" name="<%=PortalVisitorConstants.PORTAL_PATH%>" value="<%=portalPath%>"/>
    <input type="hidden" name="<%=PortalVisitorConstants.DESKTOP_PATH%>" value="<%=desktopPath%>"/>
</form>

<form method="post" name="EditBookForm" id="EditBookForm">
    <input type="hidden" name="<%=PortalVisitorConstants.EDIT_BOOK%>" value=""/>
    <input type="hidden" name="<%=PortalVisitorConstants.EDIT_BOOK_NAME%>" value=""/>
    <input type="hidden" name="<%=PortalVisitorConstants.SHOW_PAGE_CONTENTS%>" value=""/>
    <input type="hidden" name="<%=PortalVisitorConstants.TARGET_PAGE_ID%>" value="<%=PortalVisitorConstants.VISITOR_TOOLS_EDIT_BOOK%>"/>
</form>

<form method="post" name="MoveToPageForm" id="MoveToPageForm" action="<%=request.getRequestURI()%>">
    <input type="hidden" name="<%=PortalVisitorConstants.PAGE_TO_MOVE_RESOURCE_TO%>" value=""/>
    <input type="hidden" name="<%=PortalVisitorConstants.RESOURCE_TO_MOVE%>" value=""/>
    <input type="hidden" name="<%=PortalVisitorConstants.RESOURCE_TYPE_TO_MOVE%>" value=""/>
    <input type="hidden" name="<%=PortalVisitorConstants.RESOURCE_TO_MOVE_FROM%>" value=""/>
    <input type="hidden" name="<%=PortalVisitorConstants.RESOURCE_TYPE_TO_MOVE_FROM%>" value=""/>
    <input type="hidden" name="<%=PortalVisitorConstants.SHOW_PAGE_CONTENTS%>" value=""/>
    <input type="hidden" name="<%=PortalVisitorConstants.TARGET_PAGE_ID%>" value="<%=PortalVisitorConstants.VISITOR_TOOLS_MAIN_PAGE%>"/>
    <input type="hidden" name="<%=PortalVisitorConstants.WEB_APP_NAME%>" value="<%=webAppName%>"/>
    <input type="hidden" name="<%=PortalVisitorConstants.MAIN_BOOK%>" value="<%=theBook%>"/>
    <input type="hidden" name="<%=PortalVisitorConstants.PORTAL_PATH%>" value="<%=portalPath%>"/>
    <input type="hidden" name="<%=PortalVisitorConstants.DESKTOP_PATH%>" value="<%=desktopPath%>"/>
</form>

<form method="post" name="EditPageForm" id="EditPageForm">
    <input type="hidden" name="<%=PortalVisitorConstants.EDIT_PAGE%>" value=""/>
    <input type="hidden" name="<%=PortalVisitorConstants.EDIT_PAGE_NAME%>" value=""/>
    <input type="hidden" name="<%=PortalVisitorConstants.SHOW_PAGE_CONTENTS%>" value=""/>
    <input type="hidden" name="<%=PortalVisitorConstants.TARGET_PAGE_ID%>" value="<%=PortalVisitorConstants.VISITOR_TOOLS_EDIT_PAGE%>"/>
</form>

<form method="post" name="RenameResourceForm" id="RenameResourceForm">
    <input type="hidden" name="<%=PortalVisitorConstants.RESOURCE_ID%>" value=""/>
    <input type="hidden" name="<%=PortalVisitorConstants.RESOURCE_TYPE%>" value=""/>
    <input type="hidden" name="<%=PortalVisitorConstants.RENAME_RESOURCE%>" value=""/>
    <input type="hidden" name="<%=PortalVisitorConstants.SHOW_PAGE_CONTENTS%>" value=""/>
    <input type="hidden" name="<%=PortalVisitorConstants.TARGET_PAGE_ID%>" value="<%=PortalVisitorConstants.VISITOR_TOOLS_MAIN_PAGE%>"/>
    <input type="hidden" name="<%=PortalVisitorConstants.WEB_APP_NAME%>" value="<%=webAppName%>"/>
    <input type="hidden" name="<%=PortalVisitorConstants.MAIN_BOOK%>" value="<%=theBook%>"/>
    <input type="hidden" name="<%=PortalVisitorConstants.PORTAL_PATH%>" value="<%=portalPath%>"/>
    <input type="hidden" name="<%=PortalVisitorConstants.DESKTOP_PATH%>" value="<%=desktopPath%>"/>
</form>



<SCRIPT LANGUAGE="JavaScript">
    var resourcesArray = new Array(0);
<%
       count = new ResourceCount(0, 0, 1, 0);
       out.println( VisitorToolsHtmlUtil.getBookChildren(pageContext, bookPresentationContext, request, true, "B" + primaryBookInstanceId + ".", count));
%>
</SCRIPT>


<div id="dialogBackgroundDiv" style="position: absolute;visibility: hidden;left: 0;top: 0;height: 0;width: 0;background-color: #000000;z-index: 5000;filter: alpha(opacity=50);-moz-opacity:0.5;">
  &nbsp;
</div>

<script language="JavaScript" src="<%=request.getContextPath()%>/visitorTools/js/main.js" type="text/javascript"></script>
<script language="javascript">
<%
    String showPageContentsRequest = request.getParameter(PortalVisitorConstants.SHOW_PAGE_CONTENTS);
    if (showPageContentsRequest == null )
    {
        showPageContentsRequest = (String)session.getAttribute(PortalVisitorConstants.SHOW_PAGE_CONTENTS);
    }
    if (showPageContentsRequest != null && showPageContentsRequest.equals("1") )
    {
%>
        showContentsElement = document.getElementById("showPageContentsCheckbox");
        showContentsElement.checked = "true";
        showPageContents();
<%
    }
%>
</script>

    <%-- close desktops and pathinfo are good --%>
    </es:notNull>
<%-- close user not logged in --%>
</es:notNull>
 

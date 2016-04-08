<%@ taglib uri="render.tld" prefix="render" %>

<%@ page import="java.util.*,
                 com.bea.jsptools.portal.util.VisitorToolsUtil,
                 com.bea.jsptools.portal.util.VisitorToolsHtmlUtil,
                 com.bea.jsptools.common.Utility" %>

<%@ page import="com.bea.netuix.servlets.controls.application.DesktopPresentationContext" %>
<%@ page import="com.bea.netuix.servlets.controls.PresentationContext" %>
<%@ page import="com.bea.netuix.servlets.controls.page.BookPresentationContext" %>
<%@ page import="com.bea.netuix.servlets.controls.page.PagePresentationContext" %>

<%@ page import="com.bea.netuix.application.view.BookView" %>
<%@ page import="com.bea.netuix.application.view.MenuView" %>
<%@ page import="com.bea.netuix.application.view.NavigableView" %>

<%@ page import="com.bea.netuix.application.identifier.BookInstanceId" %>
<%@ page import="com.bea.netuix.application.identifier.MenuDefinitionId" %>
<%@ page import="com.bea.netuix.application.identifier.NavigableInstanceId" %>
<%@ page import="com.bea.netuix.application.identifier.PageInstanceId" %>

<%@ page import="com.bea.netuix.application.definition.BookDefinition" %>
<%@ page import="com.bea.netuix.application.definition.LayoutDefinition" %>
<%@ page import="com.bea.netuix.application.definition.MenuDefinition" %>
<%@ page import="com.bea.netuix.application.definition.PageDefinition" %>

<%@ page import="com.bea.jsptools.portal.PortalVisitorConstants" %>
<%@ page import="com.bea.jsptools.portal.PortalVisitorManager" %>

<%@ page import="com.bea.jsptools.portal.placement.BookPlacement" %>
<%@ page import="com.bea.jsptools.portal.placement.NavigablePlacement" %>
<%@ page import="com.bea.jsptools.portal.placement.PagePlacement" %>

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
    String pathInfo = request.getPathInfo();
    String portalPath = pathInfo.substring(1, pathInfo.lastIndexOf("/"));
    String desktopPath = pathInfo.substring(pathInfo.lastIndexOf("/") + 1, pathInfo.length());

    // check to see if we set a new book id in the backing file, pointing to our possible new instance
    String bookId = (String) request.getAttribute(PortalVisitorConstants.EDIT_BOOK);
    if (bookId == null)
    {
        bookId = request.getParameter(PortalVisitorConstants.EDIT_BOOK);
        if (bookId == null)
        {
            bookId = "0";
        }
    }
    String bookName = "" + PortalVisitorManager.crossSiteScriptFix(request.getParameter(PortalVisitorConstants.EDIT_BOOK_NAME));
    bookName = VisitorToolsHtmlUtil.fixupQuotes( bookName );
    String fixedBookName = bookName;
    DesktopPresentationContext desktopPresentationContext = DesktopPresentationContext.getDesktopPresentationContext(request);
    BookPresentationContext bookPresentationContext = desktopPresentationContext.getBookPresentationContext();
    String theBook = bookPresentationContext.getLabel();
    String primaryBookId = bookPresentationContext.getInstanceId();
    BookPresentationContext theBookPC = primaryBookId.equals(bookId) ? bookPresentationContext : VisitorToolsUtil.findBookInBook(bookPresentationContext, bookId, request);
%>
<es:notNull item="<%=theBookPC%>" >
<div style="padding-left:6px;padding-right:6px;padding-bottom:6px;padding-top:0px;">
  <h2><i18n:getMessage messageName="edit.book.title" /></h2>
    <table cellpadding="3" cellspacing="0" border="0" width="1%" align="left">
        <tr>
            <td width="300" valign="top" align="left" nowrap>
               <p><i18n:getMessage messageName="edit.book.desc.move" /></p>
            </td>            
            <td width="1%" valign="top" align="left" nowrap>
                <div class="bea-portal-window">
                    <div class="bea-portal-window-titlebar"><i18n:getMessage messageName="edit.book.menutabs" /></div>
                    <div style="padding:6px;white-space:nowrap;">
                        <form method="post" id="UpdateMenuForm" name="UpdateMenuForm">
                        <i18n:getMessage messageName="edit.book.choosemenu" /><br>
                            <select name="<%=PortalVisitorConstants.MENU_ID%>" id="<%=PortalVisitorConstants.MENU_ID%>">
                                <option value="-1"><i18n:getMessage messageName="edit.book.nomenu" />
                                <%  int selectedMenuId = VisitorToolsHtmlUtil.getSelectedMenuId(  request, bookId, webAppName, portalPath, desktopPath ); %>
                                <es:forEachInArray array="<%=PortalVisitorManager.getMenuDefinitions(webAppName, request.getLocale(), request)%>"
                                                    id="tmpMenu"
                                                    type="com.bea.netuix.application.definition.MenuDefinition"  >
                                                    <%LocalizationResource lr = tmpMenu.getLocalizationResource();%>
                                                    <%int menuId = tmpMenu.getMenuDefinitionId().getId();%>
                                                    <option value="<%=menuId%>" <% if (menuId == selectedMenuId){%>selected<%}%>><%=lr.getTitle()%>
                                </es:forEachInArray>
                            </select>&nbsp;<input type="submit" value="<i18n:getMessage messageName="edit.book.button.applymenu" />">
                            <input type="hidden" name="<%=PortalVisitorConstants.EDIT_BOOK%>" value="<%=bookId%>"/>
                            <input type="hidden" name="<%=PortalVisitorConstants.EDIT_BOOK_NAME%>" value="<%=fixedBookName%>"/>
                            <input type="hidden" name="<%=PortalVisitorConstants.WEB_APP_NAME%>" value="<%=webAppName%>"/>
                            <input type="hidden" name="<%=PortalVisitorConstants.PORTAL_PATH%>" value="<%=portalPath%>"/>
                            <input type="hidden" name="<%=PortalVisitorConstants.DESKTOP_PATH%>" value="<%=desktopPath%>"/>
                            <input type="hidden" name="<%=PortalVisitorConstants.TARGET_PAGE_ID%>" value="<%=PortalVisitorConstants.VISITOR_TOOLS_EDIT_BOOK%>"/>
                            <input type="hidden" name="<%=PortalVisitorConstants.MAIN_BOOK%>" value="<%=theBook%>"/>
                        </form>
                    </div>
                </div>
            </td>
		</tr>		
		<tr>
		    <td width="300" valign="top" align="left" nowrap>
		       <p><i18n:getMessage messageName="edit.book.desc.order" /></p>
               <p><i18n:getMessage messageName="edit.book.desc.choose" /></p>
			</td>
            <td width="1%" valign="top" align="left" nowrap>
                <div class="bea-portal-window">
                    <div class="bea-portal-window-titlebar"><i18n:getMessage messageName="edit.book.items" /> <%=bookName%></div>
                    <div style="padding:20px">
                        <div class="bea-portal-window">
                            <table width="100%" class="portlet-section-alternate">
                                <tr>
                                    <td width="99%" valign="top" align="center" nowrap>
                                        <select name="allNavs" id="allNavs" size="6" style="width:100%;">
                                          <es:forEachInArray array="<%=VisitorToolsHtmlUtil.getBookItemOptions( theBookPC )%>"
                                                              id="option"
                                                              type="java.lang.String"  >
                                               <%=option%>
                                          </es:forEachInArray>
                                        </select>
                                    </td>
                                    <td width="1%" valign="middle" align="center" nowrap>
                                        <a href="javascript:moveNavUp()"><img border="0" src='/<%=webAppName%>/visitorTools/images/up.gif' alt="<i18n:getMessage messageName="edit.book.moveup" />"></a><br>
                                        <a href="javascript:moveNavDown()"><img border="0" src='/<%=webAppName%>/visitorTools/images/down.gif' alt="<i18n:getMessage messageName="edit.book.movedown" />"></a>
                                    </td>
                                </tr>
                                <tr>
                                    <td width="99%" valign="top" align="center" nowrap><i18n:getMessage messageName="no.selected.item.remove" id="alertTxt"/>
                                        <input type="button" value="<i18n:getMessage messageName="edit.book.remove.item.value" />" title="<i18n:getMessage messageName="edit.book.remove.item.title" />" onClick="removeNav('<%=Utility.fixQuotes(alertTxt)%>')">
                                        <br><i18n:getMessage messageName="edit.book.available.resources" id="txt1"/>
                                        <input type="button" value="<i18n:getMessage messageName="edit.book.add.item.value" />" title="<i18n:getMessage messageName="edit.book.add.item.title" />" onClick="addContentToBook('<%=Utility.fixQuotes(txt1)%>')">
                                        <br>&nbsp;<br><i18n:getMessage messageName="edit.book.available.resources" id="txt2"/>
                                        <input type="button" value="<i18n:getMessage messageName="edit.book.add.book.value" />" title="<i18n:getMessage messageName="edit.book.add.book.value" />" onClick="addNewBookToBook('<%=Utility.fixQuotes(txt2)%>')">
                                        <br><i18n:getMessage messageName="edit.book.available.resources" id="txt3"/>
                                        <input type="button" value="<i18n:getMessage messageName="edit.book.add.page.value" />" title="<i18n:getMessage messageName="edit.book.add.page.value" />" onClick="addNewPageToBook('<%=Utility.fixQuotes(txt3)%>')">
                                    </td>
                                    <td width="1%" valign="middle" align="center" nowrap>&nbsp;

                                    </td>
                                </tr>
                            </table>
                        </div>
                        <div align="center">
                            <i18n:getMessage messageName="book.has.not.changed" id="alertTxt"/>
                            <%String save = "saveNavChanges('" + bookId + "','" + fixedBookName + "','" + Utility.fixQuotes( alertTxt )+ "')";%>
                            <input type="button" value="<i18n:getMessage messageName='edit.book.button.save' />" onClick="<%=save%>" >
                            &nbsp;&nbsp;
                            <input type="button" value="<i18n:getMessage messageName='edit.book.button.back' />" onClick="cancelNavChanges()">
                        </div>
                    </div>
                </div>
            </td>
        </tr>
    </table>
</div>

<div id="AddContentToBookDialog" align="center" class="bea-portal-window" style="position:absolute;visibility:hidden;left:0;top:0;height:0;width:0;z-index:5001">
  <table width='400' height='250' cellpadding="0" cellspacing="12">
    <tr>
      <td valign="top" align="left" nowrap class="bea-portal-window" width="50%">
        <div class="bea-portal-window-titlebar"><i18n:getMessage messageName="edit.book.pages" /></div>
        <div id="pageSelectList" class="portlet-section-alternate" align="center" style="height:100%;">
            <select MULTIPLE name="allPages" id="allPages" size="10" style="width:80%;">
             <es:forEachInArray array="<%=VisitorToolsHtmlUtil.getPageDefinitionOptions( request, webAppName, portalPath, desktopPath )%>"
                                                              id="option"
                                                              type="java.lang.String"  >
                   <%=option%>
              </es:forEachInArray>
            </select>
            <br>
            <i18n:getMessage messageName="no.selected.item.add" id="alertTxt"/>
            <input type="button" value="<i18n:getMessage messageName='edit.book.button.addpage' />" onClick="addPageToBook('<%=Utility.fixQuotes(alertTxt)%>')">
        </div>
      </td>
      <td valign="top" align="left" nowrap class="bea-portal-window" width="50%">
        <div class="bea-portal-window-titlebar"><i18n:getMessage messageName="edit.book.books" /></div>
        <div id="bookSelectList" class="portlet-section-alternate" align="center" style="height:100%;">
            <select MULTIPLE name="allBookBooks" id="allBookBooks" size="10" style="width:80%;">
             <es:forEachInArray array="<%=VisitorToolsHtmlUtil.getBookDefinitionOptions( request, webAppName, portalPath, desktopPath )%>"
                                                              id="option"
                                                              type="java.lang.String"  >
                  <%=option%>
              </es:forEachInArray>
            </select>
            <br>
            <i18n:getMessage messageName="no.selected.item.add" id="alertTxt" />
            <input type="button" value="<i18n:getMessage messageName='edit.book.button.addbook' />" onClick="addBookToBook('<%=Utility.fixQuotes(alertTxt)%>')"><br>
        </div>
      </td>
    </tr>
    <tr>
      <td colspan="2" valign="middle" align="center">
          <input type="button" value="<i18n:getMessage messageName='edit.book.button.cancel' />" onClick="toggleDialogBox('AddContentToBookDialog')">
      </td>
    </tr>
  </table>
</div><%-- end Add content to book dialog div --%>

<div id="AddNewBookToBookDialog" align="center" class="bea-portal-window" style="position:absolute;visibility:hidden;left:0;top:0;height:0;width:0;z-index:5002">
  <table width="100%" cellpadding="0" cellspacing="12">
    <tr>
      <td valign="top" align="left" nowrap class="bea-portal-window" width="100%">
            <div class="bea-portal-window-titlebar"><i18n:getMessage messageName="edit.book.menutabs" /></div>
            <div style="padding:6px;white-space:nowrap;">
                <i18n:getMessage messageName="edit.page.choose.menu" />
                <select name="newBookMenuId" id="newBookMenuId">
                    <option value="-1"><i18n:getMessage messageName="edit.book.nomenu" />
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
        <div class="bea-portal-window-titlebar"><i18n:getMessage messageName="edit.book.book.properties" /></div>
        <div style="padding:6px;white-space:nowrap;">
            <i18n:getMessage messageName="edit.book.book.name" /> <input type="text" size="20" name="newBookName" id="newBookName">
        </div>
      </td>
    </tr>
    <tr>
      <td valign="middle" align="center"><i18n:getMessage messageName='must.specify.book.name' id="alertTxt66" />
          <input type="button" value="<i18n:getMessage messageName='edit.book.button.ok' />" onClick="saveNewBookInBook('<%=Utility.fixQuotes(alertTxt66)%>')">
          <input type="button" value="<i18n:getMessage messageName='edit.book.button.cancel' />" onClick="toggleDialogBox('AddNewBookToBookDialog')">
      </td>
    </tr>
  </table>
</div><%-- end Add New Book dialog div --%>

<div id="AddNewPageToBookDialog" align="center" class="bea-portal-window" style="position:absolute;visibility:hidden;left:0;top:0;height:0;width:0;z-index:5002">
  <table width="100%" cellpadding="0" cellspacing="12">
    <tr>
      <td valign="top" align="left" nowrap class="bea-portal-window" width="100%">
            <div class="bea-portal-window-titlebar"><i18n:getMessage messageName="edit.book.layout" /></div>
            <div style="padding:6px;white-space:nowrap;">
                <i18n:getMessage messageName="edit.book.chooselayout" />
                <select name="newPageLayoutId" id="newPageLayoutId">
                        <es:forEachInArray array="<%=PortalVisitorManager.getLayoutDefinitions(webAppName, request.getLocale(), request)%>"
                                id="tmpLayout"
                                type="com.bea.netuix.application.definition.LayoutDefinition"  >
                                <%LocalizationResource lr = tmpLayout.getLocalizationResource();%>
                                <%int layoutId = tmpLayout.getLayoutDefinitionId().getId();%>
                                <option value="<%=layoutId%>"><%=lr.getTitle()%></OPTION>
                        </es:forEachInArray>
               </select>
            </div>
      </td>
    </tr>
    <tr>
      <td valign="top" align="left" nowrap class="bea-portal-window" width="100%">
        <div class="bea-portal-window-titlebar"><i18n:getMessage messageName="edit.book.page.properties" /></div>
        <div style="padding:6px;white-space:nowrap;">
            <i18n:getMessage messageName="edit.book.page.name" /> <input type="text" size="20" name="newPageName" id="newPageName">
        </div>
      </td>
    </tr>
    <tr>
      <td valign="middle" align="center">
          <i18n:getMessage messageName="must.specify.page.name" id="alertTxt"/>
          <input type="button" value="<i18n:getMessage messageName='edit.page.button.ok' />" onClick="saveNewPageInBook('<%=Utility.fixQuotes(alertTxt)%>')">
          <input type="button" value="<i18n:getMessage messageName='edit.page.button.cancel' />" onClick="toggleDialogBox('AddNewPageToBookDialog')">
      </td>
    </tr>
  </table>
</div><%-- end Add New Page dialog div --%>

<form method="post" name="CancelNavChangesForm" id="CancelNavChangesForm">
    <input type="hidden" name="cancel_book" value="1" />
    <input type="hidden" name="<%=PortalVisitorConstants.TARGET_PAGE_ID%>" value="<%=PortalVisitorConstants.VISITOR_TOOLS_MAIN_PAGE%>"/>
</form>

<form method="post" name="SaveNavigablesForm" id="SaveNavigablesForm">
    <input type="hidden" name="<%=PortalVisitorConstants.SAVE_BOOK%>" value="1" />
    <input type="hidden" name="<%=PortalVisitorConstants.EDIT_BOOK%>" value="" />
    <input type="hidden" name="<%=PortalVisitorConstants.EDIT_BOOK_NAME%>" value="" />
    <input type="hidden" name="<%=PortalVisitorConstants.MOVE_NAVIGABLE_IDS%>" value="" />
    <input type="hidden" name="<%=PortalVisitorConstants.MOVE_NAVIGABLE_POSITIONS%>" value="" />
    <input type="hidden" name="<%=PortalVisitorConstants.DELETE_NAVIGABLE_IDS%>" value="" />
    <input type="hidden" name="<%=PortalVisitorConstants.ADD_NAVIGABLE_IDS%>" value="" />
    <input type="hidden" name="<%=PortalVisitorConstants.ADD_NAVIGABLE_POSITIONS%>" value="" />
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
</es:notNull>
<!-- script declaration here so allnavs element is defined-->
<script language="JavaScript" src="<%=request.getContextPath()%>/visitorTools/js/book.js" type="text/javascript"></script>

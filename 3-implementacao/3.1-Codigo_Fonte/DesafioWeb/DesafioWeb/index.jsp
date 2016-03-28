<%@ taglib uri="netui-tags-html.tld" prefix="netui"%>
<%@ taglib uri="netui-tags-databinding.tld" prefix="netui-data"%>

<% 
  if (request.getUserPrincipal()==null){
    %>
    <jsp:include page="resources/jsp/login.jsp" />
    <%} else{
      ResourceBundle msgs;
      Locale locale = (Locale)request.getSession().getAttribute(org.apache.struts.Globals.LOCALE_KEY);
      if (locale == null)
        locale = new Locale("pt","BR");  
      msgs = ResourceBundle.getBundle("msgs", locale);
      %>
      <html>
          <head>
              <title>Itaipu Binacional</title>
          </head>
          
          <frameset id="frmMain" frameborder="0" border="0" framespacing="0">
              <frame name="frmDrawing" id="frmDrawing" frameborder="0" bordercolor="#999999" scrolling="yes" marginheight="0" marginwidth="0" SRC="<%=msgs.getString("HOME_Portal")+ "?" + request.getQueryString()%>"/>

<!--             
             <frame id="frmFooter" name="frmFooter" scrolling="no" noresize  marginwidth="0" marginheight="0" SRC="<%=request.getContextPath()%>/resources/jsp/FrameFooter.jsp?pathSkin=/framework/skins/itaipuFrameMain"/>
-->
          </frameset>
      </html>

    <%}
%>

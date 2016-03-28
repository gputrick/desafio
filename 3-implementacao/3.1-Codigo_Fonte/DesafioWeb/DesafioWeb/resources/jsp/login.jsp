<%//if (!request.isUserInRole("GSEQSistema")  {   
  if (request.getUserPrincipal()==null){

    ResourceBundle msgs;
    Locale localeInicial =  new Locale("pt","BR");
    msgs = ResourceBundle.getBundle("msgs", localeInicial);

    String serverName = request.getServerName();
    String serverPort = "" + request.getServerPort();
    String httpLogin = "http://" + serverName + ":" + serverPort + "/LoginWeb/login.portal";
    
    //******alterado pelo nova estrutura.... precisa ser arrumado nome no properties
    String redirectLogin = msgs.getString("HOME_RedirectLogin");
    String sistema = "sistema=http://" + serverName + ":" + serverPort + request.getContextPath() + "/" + redirectLogin;
    httpLogin= httpLogin + "?" + sistema;
    %>
<script>
  parent.location.href="<%=httpLogin%>"
</script>

<%}%>


<%
  String language = "";
  String country = "";
  Locale locale = new Locale("pt","BR");
  com.bea.wlw.netui.pageflow.scoping.internal.ScopedRequestImpl sri = null;
  
    if (request.getQueryString() != null && request.getParameter("language") != null && request.getParameter("country") != null){
      language = request.getParameter("language");
      country = request.getParameter("country");
      locale = new Locale(language,country);
      if (session.getAttribute("country") != country)
        session.setAttribute("country", country);
      if (session.getAttribute("language") != language)
        session.setAttribute("language", language);
    }else{
      if (session.getAttribute("country") == null) {
        session.setAttribute("country", "BR");
      }
      if (session.getAttribute("language") == null) {
        session.setAttribute("language", "pt");
      }
      language = (String)session.getAttribute("language");
      country = (String)session.getAttribute("country");

      locale = new Locale(language,country);
    }

    session.setAttribute(org.apache.struts.Globals.LOCALE_KEY,locale);

%>


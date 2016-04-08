<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ page import="com.bea.netuix.servlets.controls.portlet.PortletPresentationContext"%>
<%@ taglib uri="netui-tags-template.tld" prefix="netui-template"%>
<%@ taglib uri="netui-tags-databinding.tld" prefix="netui-data"%>
<%@ taglib uri="netui-tags-html.tld" prefix="netui"%>

<%
  response.setHeader( "Pragma", "No-cache" );
  response.setHeader( "Cache-Control", "no-cache" );
  response.setHeader( "Expires", "1" );  
  response.setHeader( "Expires", "1" );    
  
  //efetua a verificacao se a tela esta em popUp (fora de um portlet)  
  boolean isPortlet = false;
  if (PortletPresentationContext.getPortletPresentationContext(request) != null) 
    isPortlet = true;  
%>  
<%if (!isPortlet) {%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%}%>

<!--Template.jsp-->

<%if (!isPortlet) {%>
<html>
  <head>  
<%}%>

    <!-- css principal -->        
    <link href="<%=request.getContextPath()%>/resources/css/bodyApp.css" type="text/css" rel="stylesheet">    
                
    <!-- CSS da tree do sistema PAMHO -->       
    <link href="<%=request.getContextPath()%>/resources/css/pam.css" type="text/css" rel="stylesheet"> 
                
    <!-- java script com funções gerais -->
    <script charset="iso-8859-1" language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/resources/js/geral.js"></script>


    <!-- java script para Data -->        
    <script charset="iso-8859-1" language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/resources/js/validaData.js"></script>
    
    <!-- Componente Pop Up -->
    <%if (!isPortlet) {%>
        <link  rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/componentes/popup/css/popup.css">
    <%}%>
    <link  rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/componentes/popup/css/popupExterno.css">
    <script charset="iso-8859-1" language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/resources/componentes/popup/javascript/popup.js"></script>
            
    <!-- Componente Botao Calendario -->
    <link href="<%=request.getContextPath()%>/resources/componentes/btCalendario/css/calendario.css" type="text/css" rel="stylesheet">
    <script charset="iso-8859-1" language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/resources/componentes/btCalendario/js/calendar.js"></script>
    <script charset="iso-8859-1" language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/resources/componentes/btCalendario/js/calendar-es.js"></script>
    <script charset="iso-8859-1" language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/resources/componentes/btCalendario/js/calendar-pt.js"></script>
    <script charset="iso-8859-1" language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/resources/componentes/btCalendario/js/calendar-setup.js"></script>
    
    <!-- Componente Hint -->
    <link href="<%=request.getContextPath()%>/resources/componentes/hint/css/hint.css" rel="stylesheet" type="text/css">
    <script charset="iso-8859-1" language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/resources/componentes/hint/javascript/cb.js"></script>                      
    
    <!-- Componente jquery -->
    <script charset="iso-8859-1" language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/resources/componentes/jquery/javascript/jquery.js"></script>
<%if (!isPortlet) {%>    
  </head>
  <body>
<%}%>        
    <!-- pop up -->
    <div id="divPopup" class="divPopup" align="left">                
    </div>
    <!-- fundo popup -->
    <div id="divPopupBackground" class="divPopupBackground">&nbsp;</div>

    <netui-template:includeSection name="bodySection"></netui-template:includeSection>
    
  <!-- trecho de codigo usado para formatar os campos double que usam virgula  
  
    o que resolve: problema na submissão de campos double que usam virgula, gerando 
    logs de erro no netui.log. 
    
    Ele simplesmente substitui a virgula pelo ponto antes de submiter o jsp.        
    
    Para que funcione corretamente deve ser colocado no styleclass a classe double
    
    Exemplo:
    
    styleClass="campoDisable double"
  -->
    
  <script>
  
  function newsubmit(event) {            
    var lista = $('.double');
    for (i = 0; i <lista.length; i++) {
      converterParaFloat(lista[i]);                    
    }                        
      
    // call real submit function
    this._submit();
  }

  // capture the onsubmit event on all forms
  window.addEventListener('submit', newsubmit, true);

  // If a script calls someForm.submit(), the onsubmit event does not fire,
  // so we need to redefine the submit method of the HTMLFormElement class.
  HTMLFormElement.prototype._submit = HTMLFormElement.prototype.submit;
  HTMLFormElement.prototype.submit = newsubmit;
  
  /*
    $(window).unload (function () {
      var lista = $('.double');
      for (i = 0; i <lista.length; i++) {
        converterParaFloat(lista[i]);                    
      }                                      
    });
  
  
  $(window).mousedown (function(event)
  {
    alert(event.type);        
    return true;
  } );
  */
  
  // limpa campos do tipo long com valor 0
    var lista = $('.long');
    for (i = 0; i <lista.length; i++) {
      if(lista[i].value=="0"){
        lista[i].value = "";     
      }             
    }                        
  
</script>
        
  
<%if (!isPortlet) {%>
  </body>
</html>
<%}%>

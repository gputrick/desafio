<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ page import="desafio.ProdutoVO"%>

<%@ page import="resources.src.PopupUtils"%>
<%@ taglib uri="netui-tags-databinding.tld" prefix="netui-data"%>
<%@ taglib uri="netui-tags-html.tld" prefix="netui"%>
<%@ taglib uri="netui-tags-template.tld" prefix="netui-template"%>

<%  
  ProdutoVO produtoVO = (ProdutoVO) request.getAttribute(PopupUtils.OBJ_SELECT_KEY);    
%>
<script>
function selecionaLocal() {
    <%if (produtoVO != null) {%>
      var id = "<%=produtoVO.getId_produto()%>"; 
      var nome= "<%=produtoVO.getNome_produto()%>";            
      parent.getParentPopupIframe().setValuesLocal(id, nome); 
    <%}%>
    parent.closePopup();
}
</script>
<netui:html>
    <head>
    </head>
    <body onload="javascript:selecionaLocal();">
    </body>
</netui:html>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ page import="resources.src.PopupUtils"%>
<%@ taglib uri="netui-tags-databinding.tld" prefix="netui-data"%>
<%@ taglib uri="netui-tags-html.tld" prefix="netui"%>
<%@ taglib uri="netui-tags-template.tld" prefix="netui-template"%>
<netui:html>
    <head>
        <title>
            Desafio
        </title>
        <link rel="stylesheet" type="text/css" href="/DesafioWeb/resources/css/style.css">
        <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css">
    </head>
    <body>
        <div class="container">
            <h2 class="subtitle">Consultar</h2>
            <h1 class="title">Categoria Produto</h1>
            
            <netui:form action="acObterListaCategoriaProduto">
                <h3 class="subtitle">Nome Categoria Produto</h3>
                <netui:textBox dataSource="{actionForm.nomeCategoriaProdutoFiltro}"/>
                <netui:anchor formSubmit="true">
                    <i class="fa fa-search"></i>
                </netui:anchor>
    
                <netui:anchor action="acCadastrarCategoriaProduto">
                    <button class="right-button">
                        <i class="fa fa-plus">Cadastrar</i>
                    </button>
                </netui:anchor>
            </netui:form>
            
            <netui:form tagId="formEliminarCategoriaProduto" action="acEliminarCategoriaProduto">
                <netui:hidden tagId="codigo" dataSource="{pageFlow.categoriaProdutoFormBean.categoriaProdutoVO.id_categoria_produto}" />
            </netui:form>
            
            <netui-data:grid dataSource="{pageFlow.listaCategoriaProduto}" name="{pageFlow.gridListaCategoriaProduto}">
                <netui-data:gridStyle styleClassPrefix="grid"/>
                <netui-data:pager renderInHeader="false" action="acPaginacaoCategoriaProduto" renderInFooter="true"/>
                <netui-data:columns filterAction="acFiltroListaCategoriaProduto" sortAction="acOrdenaListaCategoriaProduto">
                    <netui-data:anchorColumn action="acSelecionaCategoriaProduto" styleClassPrefix="left" addRowId="true" title="Nome Categoria" name="NOME_CATEGORIA_PRODUTO"/>
                    <netui-data:anchorColumn action="acSelecionaCategoriaProduto" styleClassPrefix="right" addRowId="true" title="&nbsp;" src="/DesafioWeb/resources/images/eye-icon.png" width="16"/>
                    <netui-data:anchorColumn action="acIrParaAlterarCategoriaProduto" styleClassPrefix="right" addRowId="true" title="&nbsp;" src="/DesafioWeb/resources/images/edit-icon.png" width="16"/>
                    <netui-data:expressionColumn value="<a href='javascript:confirmaExclusao(\"{container.item.id_categoria_produto}\");'><img src='/DesafioWeb/resources/images/trash-icon.png' width='16'/></a>" title="&nbsp;" styleClassPrefix="right"/>
                </netui-data:columns>
            </netui-data:grid>
            
            <script type="text/javascript">
                //confirma a exclusao de um registro  
                function confirmaExclusao(codigo) {
                    var forme = document.forms[getNetuiTagName("formEliminarCategoriaProduto",this)];
              
                    if (confirm("Isto irá excluir todos os vinculos com outros objetos, esta ação não poderá ser revertida. Confirma a exclusão do registro?")) {
                        forme[getNetuiTagName("codigo",this)].value = codigo;
                        forme.submit();
                    }
                }
            </script>
        </div>
    </body>
</netui:html>
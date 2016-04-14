<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="netui-tags-databinding.tld" prefix="netui-data"%>
<%@ taglib uri="netui-tags-html.tld" prefix="netui"%>
<%@ taglib uri="netui-tags-template.tld" prefix="netui-template"%>
<netui:html>
    <head>
        <title>
            Desafio
        </title>
        <link rel="stylesheet" href="">
        <link rel="stylesheet" type="text/css" href="/DesafioWeb/resources/css/style.css">
        <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css">
    </head>
    <body>
        <div class="container">
            <h2 class="subtitle">Visualizar</h2>
            <h1 class="title">Categoria Produto</h1>
            
            <h3 class="subtitle">Nome Categoria Produto</h3>
            <netui:textBox tagId="nome_categoria_produto" dataSource="{pageFlow.categoriaProdutoFormBean.categoriaProdutoVO.nome_categoria_produto}" readonly="true"/>
            
            <netui:form action="acObterListaSubCategoria">
                 <h3 class="subtitle">Nome Sub-categoria</h3>
                <netui:textBox dataSource="{actionForm.nomeCategoriaProdutoFiltro}"/>
                <netui:anchor formSubmit="true">
                    <i class="fa fa-search"></i>
                </netui:anchor>
            </netui:form>
            
            <netui-data:grid dataSource="{pageFlow.listaSubCategoria}" name="{pageFlow.gridListaSubCategoria}">
                <netui-data:gridStyle styleClassPrefix="grid"/>
                <netui-data:pager renderInHeader="false" action="acPaginacaoSubCategoriaProduto" renderInFooter="true"/>
                <netui-data:columns filterAction="acFiltroListaSubCategoriaProduto" sortAction="acOrdenaListaSubCategoriaProduto">
                    <netui-data:basicColumn styleClassPrefix="left" title="Nome Sub-categoria" name="NOME_CATEGORIA_PRODUTO"/>
                </netui-data:columns>
            </netui-data:grid>
            
            <netui:anchor href="javascript:confirmaExclusao();">
                <button class="right-button" >
                    <i class="fa fa-trash">Excluir</i>
                </button>
            </netui:anchor>
            
            
            <netui:anchor action="acIrParaAlterarCategoriaProduto">
                <button class="right-button">
                    <i class="fa fa-edit">Alterar</i>
                </button>
            </netui:anchor>
            
            <netui:anchor action="acIrParaConsultarCategoriaProduto">
                <button class="right-button">
                    <i class="fa fa-arrow-left">Voltar</i>
                </button>
            </netui:anchor>
            
            
            <netui:form tagId="formEliminarCategoriaProduto" action="acEliminarCategoriaProduto">
                <netui:hidden tagId="codigo" dataSource="{pageFlow.categoriaProdutoFormBean.categoriaProdutoVO.id_categoria_produto}" />
            </netui:form>
            <script type="text/javascript">
                //confirma a exclusao de um registro  
                function confirmaExclusao() {
                    var forme = document.forms[getNetuiTagName("formEliminarCategoriaProduto",this)];
              
                    if (confirm("Isto irá excluir todos os vinculos com outros objetos, esta ação não poderá ser revertida. Confirma a exclusão do registro?")) {
                        forme.submit();
                    }
                }
            </script>
        </div>
    </body>
</netui:html>
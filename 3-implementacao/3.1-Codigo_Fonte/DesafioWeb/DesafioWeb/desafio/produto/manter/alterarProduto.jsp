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
            <h2 class="subtitle">Alterar</h2>
            <h1 class="title">Produto</h1>
            
            <h3 class="subtitle">Nome</h3>
            <netui:textBox tagId="nome_produto" dataSource="{pageFlow.produtoFormBean.produtoVO.nome_produto}"/>
            
            
            <netui:anchor href="javascript:confirmaExclusao();">
                <button class="right-button">
                    <i class="fa fa-plus">Vincular</i>
                </button>                
            </netui:anchor>
            
            <netui-data:grid dataSource="{pageFlow.listaCategoriaProduto}" name="{pageFlow.gridListaCategoriaProduto}">
                <netui-data:gridStyle styleClassPrefix="grid"/>
                <netui-data:pager renderInHeader="false" action="acPaginacaoCategoriaProduto" renderInFooter="true"/>
                <netui-data:columns filterAction="acFiltroListaCategoriaProduto" sortAction="acOrdenaListaCategoriaProduto">
                    <netui-data:anchorColumn action="acSelecionaCategoriaProduto" styleClassPrefix="left" addRowId="true" title="Nome Categoria" name="NOME_CATEGORIA_PRODUTO"/>
                    <netui-data:anchorColumn action="acSelecionaCategoriaProduto" styleClassPrefix="right" addRowId="true" title="&nbsp;" src="/DesafioWeb/resources/images/eye-icon.png" width="16"/>
                    <netui-data:expressionColumn value="<a href='javascript:confirmaExclusao(\"{container.item.id_categoria_produto}\");'><img src='/DesafioWeb/resources/images/trash-icon.png' width='16'/></a>" title="&nbsp;" styleClassPrefix="right"/>
                </netui-data:columns>
            </netui-data:grid>
            
            <netui:form tagId="formEliminarProduto" action="acEliminarProduto">
                <netui:hidden tagId="codigo" dataSource="{pageFlow.produtoFormBean.produtoVO.id_produto}" />
            </netui:form>
                        
            <netui:anchor href="javascript:confirmaExclusao();" >
                <button class="right-button">
                    <i class="fa fa-check">Confirmar</i>
                </button>
            </netui:anchor>

            <netui:anchor href="javascript:confirmaExclusao();" >
                <button class="right-button">
                    <i class="fa fa-close">Cancelar</i>
                </button>
            </netui:anchor>
            
        </div>
    </body>
</netui:html>
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
            
            <netui-data:repeater dataSource="{pageFlow.listaCategoriaProdutoVO}">
                <netui-data:repeaterHeader>
                    <table class="grid-table">
                    <tr>
                        <td>
                            Nome Categoria
                        </td>
                    <tr>
                </netui-data:repeaterHeader>
                <netui-data:repeaterItem>
                    <tr>
                        <td>
                            <netui:label value="{container.item.nome_categoria_produto}" />    
                        </td>
                    <tr>
                </netui-data:repeaterItem>
                    </table>
            </netui-data:repeater>
            
            <netui:form tagId="formEliminarProduto" action="acEliminarProduto">
                <netui:hidden tagId="codigo" dataSource="{pageFlow.produtoFormBean.produtoVO.id_produto}" />
            </netui:form>
                        
            <netui:anchor href="javascript:confirmaExclusao();" >
                <button class="right-button">
                    <i class="fa fa-check">Confirmar</i>
                </button>
            </netui:anchor>

            <netui:anchor action="acVoltarAPaginaAnterior" >
                <button class="right-button">
                    <i class="fa fa-close">Cancelar</i>
                </button>
            </netui:anchor>
            
        </div>
    </body>
</netui:html>
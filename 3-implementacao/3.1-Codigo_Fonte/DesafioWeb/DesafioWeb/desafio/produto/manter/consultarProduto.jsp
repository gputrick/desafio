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
    <body class="container">
        
        <h2 class="subtitle">Consultar</h2>
        <h1 class="title">Produto</h1>

        <input type="text" class="input"/><i class="fa fa-search"></i>
        
        <netui:anchor action="cadastrarProduto"><button class="right-button"><i class="fa fa-plus"></i>Cadastrar</button></netui:anchor>
        
        <script language="javascript" src='<%=request.getContextPath() +
        "/resources/grid/_grid.js"%>' type="text/javascript"></script>
        <netui-data:grid dataSource="{pageFlow.listaProduto}" name="{pageFlow.gridListaProduto}">
            <netui-data:pager renderInFooter="true" action="obterListaProduto"></netui-data:pager>
            <netui-data:columns>
                <netui-data:anchorColumn title="Nome Categoria" action="visualizarProduto" name="nome"></netui-data:anchorColumn>
            </netui-data:columns>
        </netui-data:grid>
        
    </body>
</netui:html>
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
        <%String email = (String)request.getSession().getAttribute("email");%>
        <div align="right">
            <netui:label value="<%=email%>"/> <i class="fa fa-unlock"></i>
        </div>
        
        <h2 class="subtitle">Consultar</h2>
        <h1 class="title">Produto</h1>

        <input type="text" class="input"/><i class="fa fa-search"></i>
        
        <netui:anchor action="cadastrarProduto"><button class="right-button"><i class="fa fa-plus"></i>Cadastrar</button></netui:anchor>
        
        <table class="table">
            <tr>
                <th>Nome Produto</th>
                <th></th>
            </tr>
            <tr>
                <td>Celular e Smartphone</td>
                <td class="table-button">
                    <netui:anchor action="visualizarProduto"><i class="fa fa-eye"></i></netui:anchor>
                    <netui:anchor action="alterarProduto"><i class="fa fa-edit"></i></netui:anchor>
                    <i class="fa fa-trash"></i>
                </td>
            </tr>
            <tr>
                <td>Televisão</td>
                <td class="table-button">
                    <i class="fa fa-eye"></i>
                    <i class="fa fa-edit"></i>
                    <i class="fa fa-trash"></i>
                </td>
            </tr>
            <tr>
                <td>Notebook</td>
                <td class="table-button">
                    <i class="fa fa-eye"></i>
                    <i class="fa fa-edit"></i>
                    <i class="fa fa-trash"></i>
                </td>
            </tr>
        </table>
    </body>
</netui:html>
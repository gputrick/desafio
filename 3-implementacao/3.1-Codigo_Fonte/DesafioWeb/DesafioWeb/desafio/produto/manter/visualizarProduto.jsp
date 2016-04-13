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
        <h2 class="subtitle">Visualizar</h2>
        <h1 class="title">Produto</h1>
        
        <h3 class="subtitle">Nome</h3>
        <netui:textBox tagId="nome_local" dataSource="{pageFlow.produtoFormBean.produtoVO.nome_produto}" readonly="true" styleClass="campoDisable"/>
        
        
        <button id="deleteButton" class="right-button"><i class="fa fa-trash"></i> Excluir</button>
        <netui:anchor action="alterarProduto"> <button class="right-button"><i class="fa fa-edit"></i> Alterar</button></netui:anchor>
        
        <div id="deleteModal" class="modal">
            <div class="modal-content">
                <span class="close fa fa-close"></span>
                <br>
                <div align="center">
                    <h2>Atenção</h2>
                    <h3>Você confirma a exclusão?</h3>
                    <br>
                    <button><i class="fa fa-check"></i> Confirmar</button>
                    <button id="closeButton"><i class="fa fa-close"></i> Cancelar</button>
                </div>
                
                
            </div>
        </div>
        <script src="/DesafioWeb/resources/js/modalConfirmacao.js"></script>
    </body>
</netui:html>
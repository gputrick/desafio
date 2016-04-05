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
        <link rel="stylesheet" type="text/css" href="../../css/style.css">
        <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css">
    </head>
    <body class="container">
        <%String email = (String)request.getSession().getAttribute("email");%>
        <div align="right">
            <netui:label value="<%=email%>"/> <i class="fa fa-unlock"></i>
        </div>
        
        <h2 class="subtitle">Alterar</h2>
        <h1 class="title">Produto</h1>
        
        <h3 class="subtitle">Nome</h3>
        <input type="text" class="input"/>
        <br>
        
        <input type="text" class="input"/><i class="fa fa-search"></i>
        
        <button id="vincularCategoriaButton" class="right-button"><i class="fa fa-plus"></i> Vincular Categoria</button>
        
        <table class="table">
            <tr>
                <th>Nome Categoria</th>
                <th></th>
            </tr>
            <tr>
                <td>Celular e Smartphone</td>
                <td class="table-button">
                    <i class="fa fa-ban"></i>
                </td>
            </tr>
            <tr>
                <td>Televisão</td>
                <td class="table-button">
                    <i class="fa fa-ban"></i>
                </td>
            </tr>
            <tr>
                <td>Notebook</td>
                <td class="table-button">
                    <i class="fa fa-ban"></i>
                </td>
            </tr>
        </table>
        <br>
        
        <button class="right-button"><i class="fa fa-check"></i> Confirmar</button>
        <button class="right-button"><i class="fa fa-close"></i> Cancelar</button>
        
        <div id="vinculaCategoriaModal" class="modal">
            <div class="modal-content">
                <span class="close">x</span>
                <br>
                <div align="center">
                    <h2>Escolha as categorias</h2>
                    
                    <input type="text" class="input"/><i class="fa fa-search"></i>
                </div>
                <table class="table">
                    <tr>
                        <th>Nome Categoria</th>
                        <th></th>
                    </tr>
                    <tr>
                        <td>Celular e Smartphone</td>
                        <td class="table-button">
                            <i class="fa fa-eye"></i>
                        </td>
                    </tr>
                    <tr>
                        <td>Televisão</td>
                        <td class="table-button">
                            <i class="fa fa-eye"></i>
                        </td>
                    </tr>
                    <tr>
                        <td>Notebook</td>
                        <td class="table-button">
                            <i class="fa fa-eye"></i>
                        </td>
                    </tr>
                </table>
                
                <button><i class="fa fa-check"></i> Vincular</button>
                <button id="closeButton"><i class="fa fa-close"></i> Cancelar</button>
            </div>
        </div>
    </body>
    <script src="/DesafioWeb/resources/js/modalVincularCategoria.js"></script>
    </body>
</netui:html>
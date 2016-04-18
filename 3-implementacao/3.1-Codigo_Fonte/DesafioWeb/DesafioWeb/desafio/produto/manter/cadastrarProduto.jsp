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
            <h2 class="subtitle">Cadastrar</h2>
            <h1 class="title">Produto</h1>
            <netui:form tagId="formAlterarProduto" action="acCadastrarProduto">
                <h3 class="subtitle">Nome Produto</h3>
                <netui:textBox tagId="nome_produto" dataSource="{pageFlow.produtoFormBean.produtoVO.nome_produto}" maxlength="144"/>
                
                <netui:anchor formSubmit="true" action="acAbrirPopupVincularCategoria" id="vinculaCategoriaButton">
                    <button class="right-button">
                        <i class="fa fa-plus">Vincular</i>
                    </button>                
                </netui:anchor>
            </netui:form>
            <netui:form action="acObterListaCategoriaProdutoVO">
                 <h3 class="subtitle">Nome Categoria</h3>
                <netui:textBox dataSource="{actionForm.nomeCategoriaProdutoFiltro}" maxlength="144"/>
                <netui:anchor formSubmit="true">
                    <i class="fa fa-search"></i>
                </netui:anchor>
            </netui:form>
        
            <netui:form tagId="formDesvincularCategoriaProduto" action="acDesvincularCategoriaProduto">
                <netui:hidden tagId="codigo" dataSource="{pageFlow.categoriaProdutoFormBean.categoriaProdutoVO.id_categoria_produto}" />
            </netui:form>
            <netui:form tagId="formVincularCategoriaProduto" action="acApagarMesagem">
                <netui:hidden tagId="displayPopup" dataSource="{pageFlow.produtoFormBean.displayPopup}" />
                <netui:hidden tagId="mensagem" dataSource="{pageFlow.produtoFormBean.mensagem}" />
            </netui:form>
            
            <netui-data:repeater dataSource="{pageFlow.listaCategoriaProdutoVOFiltrada}" defaultText="Nenhum Resultado Encontrado" ignoreNulls="true">
                <netui-data:repeaterHeader>
                    <table class="grid-table">
                        <tr class="grid-tr-header">
                            <td class="left-td-header">
                                Nome Categoria
                            </td>
                            <td class="right-td-header">
                            </td>
                        </tr>
                </netui-data:repeaterHeader>
                <netui-data:repeaterItem>
                        <tr class="grid-tr-data">
                            <td class="left-td-data">
                                <netui:label value="{container.item.nome_categoria_produto}" />    
                            </td>
                            <td class="right-td-data">
                                <netui:anchor href="javascript:desvinculaCategoriaProduto({container.item.id_categoria_produto});">
                                    <i class="fa fa-close"></i>
                                </netui:anchor>
                            </td>
                        </tr>
                </netui-data:repeaterItem>
                <netui-data:repeaterFooter>
                    </table>
                </netui-data:repeaterFooter>
            </netui-data:repeater>
                        
            <button id="confirma-button" class="right-button">
                <i class="fa fa-check">Confirmar</i>
            </button>

            <netui:anchor action="acVoltarAPaginaAnterior" >
                <button class="right-button">
                    <i class="fa fa-close">Cancelar</i>
                </button>
            </netui:anchor>
            
            <div id="vinculaCategoriaModal" class="modal">
                <div class="modal-content">
                    <netui:anchor action="acFechaPopup">
                        <span class="close fa fa-close"></span>
                    </netui:anchor>
                    <br>
                    <div align="center">
                         <netui:form action="acObterListaCategoriaProdutoPopup">
                            <h2 class="title-modal">Escolha a categoria</h2>
                            <netui:textBox dataSource="{actionForm.nomeCategoriaProdutoFiltroPopup}" maxlength="144"/>
                            <netui:anchor formSubmit="true">
                                <i class="fa fa-search"></i>
                            </netui:anchor>    
                        </netui:form>
                    </div>
                    
                    <netui-data:grid dataSource="{pageFlow.listaCategoriaProduto}" name="{pageFlow.gridListaCategoriaProduto}">
                        <netui-data:gridStyle styleClassPrefix="grid"/>
                        <netui-data:pager renderInHeader="false" action="acPaginacaoCategoriaProduto" renderInFooter="true" pageSize="5"/>
                        <netui-data:columns filterAction="acFiltroListaCategoriaProduto" sortAction="acOrdenaListaCategoriaProduto">
                            <netui-data:anchorColumn action="acVinculaCategoriaProduto" addRowId="true" title="Nome Categoria" name="NOME_CATEGORIA_PRODUTO"/>
                        </netui-data:columns>
                    </netui-data:grid>
                    
                    <netui:anchor action="acFechaPopup">
                        <button id="closeButton" class="right-button">
                            <i class="fa fa-close"></i> Cancelar
                        </button>
                    </netui:anchor>
                </div>
            </div>
        </div>
        <script type="text/javascript">
            window.onload = abrirPopup;
            
            function desvinculaCategoriaProduto(codigo){
                forme = document.forms[getNetuiTagName("formDesvincularCategoriaProduto", this)];
                forme[getNetuiTagName("codigo",this)].value = codigo;
                forme.submit();
            }
            
            function abrirPopup(){
                forme = document.forms[getNetuiTagName("formVincularCategoriaProduto", this)];
                displayPopup = forme[getNetuiTagName("displayPopup",this)].value;
                var modal = document.getElementById('vinculaCategoriaModal');
                modal.style.display = displayPopup;
                
                mensagem = forme[getNetuiTagName("mensagem",this)].value;
                if(mensagem.localeCompare("") != 0){
                    alert(mensagem);
                    forme.submit();
                }
            }
            
            btnConfirma = document.getElementById("confirma-button");
            btnConfirma.onclick = function(){
                document.forms[getNetuiTagName("formAlterarProduto", this)].submit();
            }
            
        </script>
    </body>
</netui:html>
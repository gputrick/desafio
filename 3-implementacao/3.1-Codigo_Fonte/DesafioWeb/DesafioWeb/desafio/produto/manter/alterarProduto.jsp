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
            
            <h3 class="subtitle">Nome Produto</h3>
            <netui:textBox tagId="nome_produto" dataSource="{pageFlow.produtoFormBean.produtoVO.nome_produto}"/>
            
            <netui:form action="acObterListaCategoriaProdutoVO">
                 <h3 class="subtitle">Nome Categoria</h3>
                <netui:textBox dataSource="{actionForm.nomeCategoriaProdutoFiltro}"/>
                <netui:anchor formSubmit="true">
                    <i class="fa fa-search"></i>
                </netui:anchor>
                
                <netui:anchor action="acIrParaVincularCategoria">
                    <button class="right-button">
                        <i class="fa fa-plus">Vincular</i>
                    </button>                
                </netui:anchor>
            </netui:form>
            
            <netui:form tagId="formDesvincularCategoriaProduto" action="acDesvincularCategoriaProduto">
                <netui:hidden tagId="codigo" dataSource="{pageFlow.categoriaProdutoFormBean.categoriaProdutoVO.id_categoria_produto}" />
            </netui:form>
            
            <netui-data:repeater dataSource="{pageFlow.listaCategoriaProdutoVOFiltrada}">
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
            
            
            
            <script type="text/javascript">
                function desvinculaCategoriaProduto(codigo){
                    forme = document.forms[getNetuiTagName("formDesvincularCategoriaProduto", this)];
                    forme[getNetuiTagName("codigo",this)].value = codigo;
                    forme.submit();
                }
            </script>
        </div>
    </body>
</netui:html>
package desafio.jcs; 

import com.bea.control.Control;

public interface JCSProduto extends Control
{ 

    javax.sql.RowSet obterListaProduto(java.lang.String nomeProduto, com.bea.control.DatabaseFilter filter) throws java.lang.Exception;

    void eliminarProduto(desafio.ProdutoVO produtoVO) throws java.lang.Exception;

    void atualizaProduto(desafio.ProdutoVO produtoVO) throws java.lang.Exception;

    desafio.ProdutoVO obterProduto(desafio.ProdutoVO produtoVO) throws java.lang.Exception;
} 

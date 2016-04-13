package desafio.jcs; 

import com.bea.control.Control;

public interface JCSCategoriaProduto extends Control
{ 

    void atualizarCategoriaProduto(desafio.CategoriaProdutoVO categoriaProdutoVO) throws java.lang.Exception;

    desafio.CategoriaProdutoVO obterCategoriaProduto(desafio.CategoriaProdutoVO categoriaProdutoVO) throws java.lang.Exception;

    void eliminarCategoriaProduto(desafio.CategoriaProdutoVO categoriaProdutoVO) throws java.lang.Exception;

    javax.sql.RowSet obterListaCategoriaProduto(desafio.ProdutoVO produtoVOFiltro, java.lang.String nomeCategoriaProduto, com.bea.control.DatabaseFilter filter) throws java.lang.Exception;
} 

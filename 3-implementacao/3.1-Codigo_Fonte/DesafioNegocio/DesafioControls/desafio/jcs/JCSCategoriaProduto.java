package desafio.jcs; 

import com.bea.control.Control;
import desafio.CategoriaProdutoVO;
import desafio.ProdutoVO;

public interface JCSCategoriaProduto extends Control
{ 

    void eliminarCategoriaProduto(desafio.CategoriaProdutoVO categoriaProdutoVO) throws java.lang.Exception;

    javax.sql.RowSet obterListaCategoriaProduto(desafio.ProdutoVO produtoVOFiltro, java.lang.String nomeCategoriaProduto, com.bea.control.DatabaseFilter filter) throws java.lang.Exception;

    desafio.CategoriaProdutoVO[] obterListaCategoriaProdutoPorProduto(desafio.ProdutoVO produtoVOFiltro, java.lang.String nomeCategoriaProdutoFiltro) throws java.lang.Exception;

    desafio.CategoriaProdutoVO[] obterListaCategoriaProdutoPorCategoriaPai(desafio.CategoriaProdutoVO categoriaPaiVO);

    javax.sql.RowSet obterListaSubCategoria(desafio.CategoriaProdutoVO categoriaProdutoVOFiltro, java.lang.String nomeCategoriaProdutoFiltro, com.bea.control.DatabaseFilter filter) throws java.lang.Exception;

    desafio.CategoriaProdutoVO obterCategoriaProduto(desafio.CategoriaProdutoVO categoriaProdutoVO) throws java.lang.Exception;

    desafio.CategoriaProdutoVO atualizarCategoriaProduto(desafio.CategoriaProdutoVO categoriaProdutoVO, desafio.CategoriaProdutoVO[] listaSubCategoriaVOAtualizada) throws java.lang.Exception;
} 

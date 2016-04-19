package desafio.jcs;

import com.bea.control.Control;
import desafio.CategoriaProdutoVO;
import desafio.ProdutoVO;

public interface JCSCategoriaProduto extends Control {

	/**
	 * Método obtém a lista de categorias filtradas pela categoriaPai
	 */
	desafio.CategoriaProdutoVO[] obterListaCategoriaProdutoPorCategoriaPai(desafio.CategoriaProdutoVO categoriaPaiVO);

	/**
	 * Método obtém a lista de subCategorias filtradas pela categoriaPai
	 */
	javax.sql.RowSet obterListaSubCategoria(desafio.CategoriaProdutoVO categoriaProdutoVOFiltro,
			java.lang.String nomeCategoriaProdutoFiltro, com.bea.control.DatabaseFilter filter)
			throws java.lang.Exception;

	/**
	 * Método além de atualizar os dados primitivos de categoriaProduto atualiza
	 * a lista de sub-categorias associadas a sua primary key
	 */
	desafio.CategoriaProdutoVO atualizarCategoriaProduto(desafio.CategoriaProdutoVO categoriaProdutoVO,
			desafio.CategoriaProdutoVO[] listaSubCategoriaVOAtualizada) throws java.lang.Exception;

	/**
	 * Método elimina todas as ocorrencias de categoria produto na tabela
	 * associativa produto_categoria_produto e depois exclui categoriaProduto da
	 * tabela categoria_produto
	 */
	void eliminarCategoriaProduto(desafio.CategoriaProdutoVO categoriaProdutoVO) throws java.lang.Exception;

	/**
	 * Método obtém lista de categoriaProduto caso haja o filtro produto faz o
	 * join com a tabela associativa produto_categoria_produto
	 */
	javax.sql.RowSet obterListaCategoriaProduto(desafio.ProdutoVO produtoVOFiltro,
			java.lang.String nomeCategoriaProduto, com.bea.control.DatabaseFilter filter) throws java.lang.Exception;

	/**
	 * Método obtem os dados primitivos de categoriaProduto e a lista de
	 * sub-categorias
	 */
	desafio.CategoriaProdutoVO obterCategoriaProduto(desafio.CategoriaProdutoVO categoriaProdutoVO)
			throws java.lang.Exception;

	/**
	 * Método obtém lista de categoriaProduto no formato VO[] caso haja o filtro
	 * produto faz o join com a tabela associativa produto_categoria_produto
	 */
	desafio.CategoriaProdutoVO[] obterListaCategoriaProdutoPorProduto(desafio.ProdutoVO produtoVOFiltro,
			java.lang.String nomeCategoriaProdutoFiltro) throws java.lang.Exception;
}

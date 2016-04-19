package desafio.jcs;

import com.bea.control.Control;
import com.bea.control.DatabaseFilter;
import desafio.ProdutoVO;
import javax.sql.RowSet;

public interface JCSProduto extends Control {

	/**
	 * Método obtém a lista de produtos, caso houver categoriaVOFiltro realiza o
	 * join com a tabela associativa produto_categoria_produto
	 */
	javax.sql.RowSet obterListaProduto(desafio.CategoriaProdutoVO categoriaProdutoVOFiltro,
			java.lang.String nomeProduto, com.bea.control.DatabaseFilter filter) throws java.lang.Exception;

	/**
	 * Método elimina todas as ocorrências do produto na tabela associativa
	 * produto_categoria_produto e depois exclui produto
	 */
	void eliminarProduto(desafio.ProdutoVO produtoVO) throws java.lang.Exception;

	/**
	 * Método verifica todas as ocorrencias de produto na tabela associativa
	 * produto_categoria_produto, compara com a lista atualizada, exclui quem
	 * foi excluido e insere os registros novos na tabela. Além de atualizar os
	 * dados primitivos
	 */
	void atualizarProduto(desafio.ProdutoVO produtoVO,
			desafio.ProdutoCategoriaProdutoVO[] listaProdutoCategoriaProdutoVOAtualizada) throws java.lang.Exception;

	/**
	 * Método insere todas os registros da lista de produto_categoria_produto
	 * depois insere o produtoVO na tabela produto
	 */
	desafio.ProdutoVO cadastrarProduto(desafio.ProdutoVO produtoVO,
			desafio.CategoriaProdutoVO[] listaCategoriaProdutoVO) throws java.lang.Exception;

	/**
	 * Método obtém além dos dados primitivos do produto a lista de
	 * categoria_produto de acordo com suas ocorrencias na tabela
	 * produto_categoria_produto
	 */
	desafio.ProdutoVO obterProduto(desafio.ProdutoVO produtoVO) throws java.lang.Exception;
}

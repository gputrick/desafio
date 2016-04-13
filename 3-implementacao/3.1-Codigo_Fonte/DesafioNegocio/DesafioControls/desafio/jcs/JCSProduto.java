package desafio.jcs; 

import com.bea.control.Control;
import com.bea.control.DatabaseFilter;
import desafio.ProdutoVO;
import javax.sql.RowSet;

public interface JCSProduto extends Control
{ 
    
    desafio.ProdutoVO obterProduto(desafio.ProdutoVO produtoVO) throws java.lang.Exception;
    
    void eliminarProduto(desafio.ProdutoVO produtoVO) throws java.lang.Exception;
    
    void atualizarProduto(desafio.ProdutoVO produtoVO) throws java.lang.Exception;

    javax.sql.RowSet obterListaProduto(desafio.CategoriaProdutoVO categoriaProdutoVOFiltro, java.lang.String nomeProduto, com.bea.control.DatabaseFilter filter) throws java.lang.Exception;
} 

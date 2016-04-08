package desafio.jcs; 

import com.bea.control.Control;

public interface JCSProduto extends Control
{ 

    javax.sql.RowSet obterListaProduto(java.lang.String nomeProduto, com.bea.control.DatabaseFilter filter) throws java.lang.Exception;
} 

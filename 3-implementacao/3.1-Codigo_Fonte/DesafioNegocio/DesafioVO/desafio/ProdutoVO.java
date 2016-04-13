package desafio;


import java.io.Serializable;
import java.util.ArrayList;

public class ProdutoVO implements Serializable
{ 
    private static final long serialVersionUID = 1L;
    
    private long id_produto;
    private String nome_produto;
    
    private ProdutoCategoriaProdutoVO[] listaProdutoCategoriaProduto;

    public long getId_produto(){
        return this.id_produto;
    }
    
    public void setId_produto(long id_produto){
        this.id_produto = id_produto;
    }
    
    public String getNome_produto(){
        return this.nome_produto;
    }
    
    public void setNome_produto(String nome_produto){
        this.nome_produto = nome_produto;
    }
    
    public ProdutoCategoriaProdutoVO[] getListaProdutoCategoriaProduto(){
        return this.listaProdutoCategoriaProduto;
    }
    
    public void setListaProdutoCategoriaProduto(ProdutoCategoriaProdutoVO[] listaProdutoCategoriaProduto){
        this.listaProdutoCategoriaProduto = listaProdutoCategoriaProduto;
    }
} 

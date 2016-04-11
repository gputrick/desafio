package desafio;


import java.io.Serializable;
import java.util.ArrayList;

public class ProdutoVO implements Serializable
{ 
    private long id_produto;
    private String nome_produto;
    
    private ProdutoCategoriaProdutoVO[] listaProdutoCategoriaProduto;
    
    public long getIdProduto(){
        return this.id_produto;
    }
    
    public void setIdProduto(long id_produto){
        this.id_produto = id_produto;
    }
    
    public String getNomeProduto(){
        return this.nome_produto;
    }
    
    public void setNomeProduto(String nome_produto){
        this.nome_produto = nome_produto;
    }
    
    public ProdutoCategoriaProdutoVO[] getListaProdutoCategoriaProduto(){
        return this.listaProdutoCategoriaProduto;
    }
    
    public void setListaProdutoCategoriaProduto(ProdutoCategoriaProdutoVO[] listaProdutoCategoriaProduto){
        this.listaProdutoCategoriaProduto = listaProdutoCategoriaProduto;
    }
} 

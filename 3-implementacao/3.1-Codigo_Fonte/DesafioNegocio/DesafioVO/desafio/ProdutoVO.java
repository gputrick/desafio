package desafio;


import java.io.Serializable;
import java.util.ArrayList;

public class ProdutoVO implements Serializable
{ 
    private long idProduto;
    private String nomeProduto;
    private ProdutoCategoriaProdutoVO[] listaProdutoCategoriaProduto;
    
    public long getIdProduto(){
        return this.idProduto;
    }
    
    public void setIdProduto(long idProduto){
        this.idProduto = idProduto;
    }
    
    public String getNomeProduto(){
        return this.nomeProduto;
    }
    
    public void setNomeProduto(String nomeProduto){
        this.nomeProduto = nomeProduto;
    }
    
    public ProdutoCategoriaProdutoVO[] getListaProdutoCategoriaProduto(){
        return this.listaProdutoCategoriaProduto;
    }
    
    public void setListaProdutoCategoriaProduto(ProdutoCategoriaProdutoVO[] listaProdutoCategoriaProduto){
        this.listaProdutoCategoriaProduto = listaProdutoCategoriaProduto;
    }
} 

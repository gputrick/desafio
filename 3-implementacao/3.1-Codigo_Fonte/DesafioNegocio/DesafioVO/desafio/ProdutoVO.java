package desafio;


import java.io.Serializable;
import java.util.ArrayList;

public class ProdutoVO implements Serializable
{ 
    private long idProduto;
    private String nome;
    private ArrayList listaProdutoCategoriaProduto = new ArrayList();
    
    public long getIdProduto(){
        return this.idProduto;
    }
    
    public void setIdProduto(long idProduto){
        this.idProduto = idProduto;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public ArrayList getListaProdutoCategoriaProduto(){
        return this.listaProdutoCategoriaProduto;
    }
    
    public void setListaProdutoCategoriaProduto(ArrayList listaProdutoCategoriaProduto){
        this.listaProdutoCategoriaProduto = listaProdutoCategoriaProduto;
    }
} 

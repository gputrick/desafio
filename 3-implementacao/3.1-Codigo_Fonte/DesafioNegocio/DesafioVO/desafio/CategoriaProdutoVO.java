package desafio; 

import java.util.ArrayList;
import java.io.Serializable;

public class CategoriaProdutoVO implements Serializable
{ 
    private long idCategoriaProduto;
    private String nome;
    private ArrayList listaProdutoCategoriaProduto = new ArrayList(); //ProdutoCategoriaProduto Class
    
    public long getIdCategoriaProduto(){
        return this.idCategoriaProduto;
    }
    
    public void setIdCategoriaProduto(long idCategoriaProduto){
        this.idCategoriaProduto = idCategoriaProduto;
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

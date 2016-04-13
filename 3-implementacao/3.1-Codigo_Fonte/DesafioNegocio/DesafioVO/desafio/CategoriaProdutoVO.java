package desafio; 

import java.util.ArrayList;
import java.io.Serializable;

public class CategoriaProdutoVO implements Serializable
{ 
    private static final long serialVersionUID = 1L;
    
    private long id_categoria_produto;
    private String nome_categoria_produto;
    private long id_categoria_pai;
    
    private CategoriaProdutoVO categoriaPaiVO;
    private ProdutoCategoriaProdutoVO[] listaProdutoCategoriaProduto;
    
    public long getId_categoria_produto(){
        return this.id_categoria_produto;
    }
    
    public void setId_categoria_produto(long id_categoria_produto){
        this.id_categoria_produto = id_categoria_produto;
    }
    
    public long getId_categoria_pai(){
        return this.id_categoria_pai;
    }
    
    public void setId_categoria_pai(long id_categoria_pai){
        this.id_categoria_pai = id_categoria_pai;
    }
    
    
    public CategoriaProdutoVO getCategoriaPaiVO(){
        return this.categoriaPaiVO;
    }
    
    public void setCategoriaPaiVO(CategoriaProdutoVO categoriaPai){
        this.categoriaPaiVO = categoriaPaiVO;
    }
    
    public String getNome_categoria_produto(){
        return this.nome_categoria_produto;
    }
    
    public void setNome_categoria_produto(String nome_categoria_produto){
        this.nome_categoria_produto = nome_categoria_produto;
    }
    
    public ProdutoCategoriaProdutoVO[] getListaProdutoCategoriaProduto(){
        return this.listaProdutoCategoriaProduto;
    }
    
    public void setListaProdutoCategoriaProduto(ProdutoCategoriaProdutoVO[] listaProdutoCategoriaProduto){
        this.listaProdutoCategoriaProduto = listaProdutoCategoriaProduto;
    }
} 

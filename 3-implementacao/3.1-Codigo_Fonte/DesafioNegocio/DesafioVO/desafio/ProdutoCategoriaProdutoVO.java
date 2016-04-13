package desafio; 

import desafio.CategoriaProdutoVO;
import desafio.ProdutoVO;
import java.io.Serializable;

public class ProdutoCategoriaProdutoVO implements Serializable
{   
    private static final long serialVersionUID = 1L;
    
    private long id_produto;
    private long id_categoria_produto;
    
    private ProdutoVO produto;
    private CategoriaProdutoVO categoriaProduto;
    
    public long getId_produto(){
        return this.id_produto;
    }
    
    public void setId_produto(long id_produto){
        this.id_produto = id_produto;
    }
    
    public long getId_categoria_produto(){
        return this.id_categoria_produto;
    }
    
    public void setId_categoria_produto(long id_categoria_produto){
        this.id_categoria_produto = id_categoria_produto;
    }
    
    public ProdutoVO getProduto(){
        return this.produto;
    }
    
    public void setProduto(ProdutoVO produto){
        this.produto = produto;
    }
    
    public CategoriaProdutoVO getCategoriaProduto(){
        return this.categoriaProduto;
    }
    
    public void setCategoriaProduto(CategoriaProdutoVO categoriaProduto){
        this.categoriaProduto = categoriaProduto;
    }
} 

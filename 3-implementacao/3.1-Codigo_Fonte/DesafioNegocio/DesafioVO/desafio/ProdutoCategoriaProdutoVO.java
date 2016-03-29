package desafio; 

import desafio.CategoriaProdutoVO;
import desafio.ProdutoVO;
import java.io.Serializable;

public class ProdutoCategoriaProdutoVO implements Serializable
{ 
    private ProdutoVO produto;
    private CategoriaProdutoVO categoriaProduto;
    
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

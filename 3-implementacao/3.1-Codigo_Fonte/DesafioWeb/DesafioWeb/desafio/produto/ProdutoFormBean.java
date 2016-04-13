package desafio.produto; 

import desafio.ProdutoCategoriaProdutoVO;
import desafio.ProdutoVO;
import org.apache.struts.action.ActionForm;

public class ProdutoFormBean extends ActionForm
{ 
    private ProdutoVO produtoVO;
    private long idProdutoFiltro;
    private String nomeProdutoFiltro;
    private ProdutoCategoriaProdutoVO[] listaProdutoCategoriaProduto;
    
    public long getIdProdutoFiltro(){
        return this.idProdutoFiltro;
    }
    
    public void setIdProdutoFiltro(long idProdutoFiltro){
        this.idProdutoFiltro = idProdutoFiltro;
    }
    
    public String getNomeProdutoFiltro(){
        return this.nomeProdutoFiltro;
    }
    
    public void setNomeProdutoFiltro(String nomeProdutoFiltro){
        this.nomeProdutoFiltro = nomeProdutoFiltro;
    }
    
    public ProdutoCategoriaProdutoVO[] getListaProdutoCategoriaProduto(){
        return this.listaProdutoCategoriaProduto;
    }
    
    public void setListaProdutoCategoriaProduto(ProdutoCategoriaProdutoVO[] listaProdutoCategoriaProduto){
        this.listaProdutoCategoriaProduto = listaProdutoCategoriaProduto;
    }
    public ProdutoVO getProdutoVO(){
        if(this.produtoVO == null){
            this.produtoVO = new ProdutoVO();
        }
        return this.produtoVO;
    }
    
    public void setProdutoVO(ProdutoVO produtoVO){
        this.produtoVO = produtoVO;
    }
} 


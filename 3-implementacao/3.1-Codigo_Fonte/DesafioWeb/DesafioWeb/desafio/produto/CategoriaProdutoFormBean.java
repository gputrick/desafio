package desafio.produto; 

import desafio.CategoriaProdutoVO;
import desafio.ProdutoCategoriaProdutoVO;
import org.apache.struts.action.ActionForm;

public class CategoriaProdutoFormBean extends ActionForm
{ 
    private CategoriaProdutoVO categoriaProdutoVO;
    private long idCategoriaProdutoFiltro;
    private String nomeCategoriaProdutoFiltro;
    private ProdutoCategoriaProdutoVO[] listaProdutoCategoriaProduto;
    
    public long getIdCategoriaProdutoFiltro(){
        return this.idCategoriaProdutoFiltro;
    }
    
    public void setIdCategoriaProdutoFiltro(long idCategoriaProdutoFiltro){
        this.idCategoriaProdutoFiltro = idCategoriaProdutoFiltro;
    }
    
    public String getNomeCategoriaProdutoFiltro(){
        return this.nomeCategoriaProdutoFiltro;
    }
    
    public void setNomeCategoriaProdutoFiltro(String nomeCategoriaProdutoFiltro){
        this.nomeCategoriaProdutoFiltro = nomeCategoriaProdutoFiltro;
    }
    
    public ProdutoCategoriaProdutoVO[] getListaProdutoCategoriaProduto(){
        return this.listaProdutoCategoriaProduto;
    }
    
    public void setListaProdutoCategoriaProduto(ProdutoCategoriaProdutoVO[] listaProdutoCategoriaProduto){
        this.listaProdutoCategoriaProduto = listaProdutoCategoriaProduto;
    }
    public CategoriaProdutoVO getCategoriaProdutoVO(){
        if(this.categoriaProdutoVO == null){
            this.categoriaProdutoVO = new CategoriaProdutoVO();
        }
        return this.categoriaProdutoVO;
    }
    
    public void setCategoriaProdutoVO(CategoriaProdutoVO categoriaProdutoVO){
        this.categoriaProdutoVO = categoriaProdutoVO;
    }
} 


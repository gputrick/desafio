package desafio.categoriaProduto; 

import desafio.CategoriaProdutoVO;
import desafio.ProdutoCategoriaProdutoVO;
import org.apache.struts.action.ActionForm;

public class CategoriaProdutoFormBean extends ActionForm
{ 
    private CategoriaProdutoVO categoriaProdutoVO;
    private long idCategoriaProdutoFiltro;
    private String nomeCategoriaProdutoFiltro;
    private String nomeCategoriaProdutoFiltroPopup;
    private ProdutoCategoriaProdutoVO[] listaProdutoCategoriaProduto;
    private String displayPopup;
    private String mensagem;
    
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
    
        
    public String getNomeCategoriaProdutoFiltroPopup(){
        return this.nomeCategoriaProdutoFiltroPopup;
    }
    
    public void setNomeCategoriaProdutoFiltroPopup(String nomeCategoriaProdutoFiltroPopup){
        this.nomeCategoriaProdutoFiltroPopup = nomeCategoriaProdutoFiltroPopup;
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
    
    public String getDisplayPopup(){
        return this.displayPopup;
    }
    
    public void setDisplayPopup(String displayPopup){
        this.displayPopup = displayPopup;
    }
    
    public String getMensagem(){
        return this.mensagem;
    }
    
    public void setMensagem(String mensagem){
        this.mensagem = mensagem;
    }
} 


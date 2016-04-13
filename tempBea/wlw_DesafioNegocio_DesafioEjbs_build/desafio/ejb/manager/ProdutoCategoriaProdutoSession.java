package desafio.ejb.manager;

import desafio.CategoriaProdutoVO;
import desafio.ProdutoCategoriaProdutoVO;
import desafio.ProdutoVO;
import desafio.ejb.geral.CategoriaProduto;
import desafio.ejb.geral.CategoriaProdutoBean;
import desafio.ejb.geral.CategoriaProdutoHome;
import desafio.ejb.geral.Produto;
import desafio.ejb.geral.ProdutoBean;
import desafio.ejb.geral.ProdutoCategoriaProduto;
import desafio.ejb.geral.ProdutoCategoriaProdutoBean;
import desafio.ejb.geral.ProdutoCategoriaProdutoBeanPK;
import desafio.ejb.geral.ProdutoCategoriaProdutoHome;
import desafio.ejb.geral.ProdutoHome;
import desafio.infra.DesafioException;
import itaipu.util.ServiceLocator;
import javax.ejb.*;
import javax.naming.NamingException;
import weblogic.ejb.*;

/**
 * @ejbgen:session enable-call-by-reference="true" type="Stateless" default-transaction="Required"
 *   ejb-name = "ProdutoCategoriaProdutoSession"
 *
 * @ejbgen:jndi-name
 *   remote = "ejb.DesafioEjbs.ProdutoCategoriaProdutoSessionRemoteHome"
 *
 * @ejbgen:file-generation remote-class = "true" remote-class-name = "ProdutoCategoriaProdutoSessionRemote" remote-home = "true" remote-home-name = "ProdutoCategoriaProdutoSessionHome" local-class = "false" local-class-name = "ProdutoCategoriaProdutoSessionLocal" local-home = "false" local-home-name = "ProdutoCategoriaProdutoSessionLocalHome"
 */
public class ProdutoCategoriaProdutoSession
  extends GenericSessionBean
  implements SessionBean
{
    private ProdutoCategoriaProduto produtoCategoriaProduto;
    private ProdutoCategoriaProdutoHome produtoCategoriaProdutoHome;
    
    public void ejbCreate() 
    {}
  
    /**
     * M�todo respons�vel pelo carregamento do ProdutoCategoriaProdutoBean
     * 
     * @param produtoCategoriaProdutoVO
     * @return Bean - produtoCategoriaProdutoVO
     * @throws DesafioException
     */
     private void inicializa(ProdutoCategoriaProdutoVO produtoCategoriaProdutoVO) throws DesafioException, EJBException {
		this.produtoCategoriaProduto = null;
		this.produtoCategoriaProdutoHome = null;
        
		try {
                if((produtoCategoriaProdutoVO != null) &&
                (produtoCategoriaProdutoVO.getId_produto() > 0)&&
                (produtoCategoriaProdutoVO.getId_categoria_produto() > 0)){
                    this.produtoCategoriaProdutoHome = ProdutoCategoriaProdutoBean.getHome();
                    
                    //Chave Composta
                    ProdutoCategoriaProdutoBeanPK produtoCategoriaProdutoPK = new ProdutoCategoriaProdutoBeanPK(new Long(produtoCategoriaProdutoVO.getId_categoria_produto()),
                                                                                                                new Long(produtoCategoriaProdutoVO.getId_produto()));
                        
                    this.produtoCategoriaProduto = produtoCategoriaProdutoHome.findByPrimaryKey(produtoCategoriaProdutoPK);
			} else
				throw new ObjectNotFoundException();
		} catch (ObjectNotFoundException e) {
			throw new DesafioException("Desafio018 - ProdutoCategoriaProduto: ProdutoCategoriaProduto não encontrato");
		} catch (Exception e) {
			throw new EJBException(e);
		}
	}
    
    /**
    * @param produtoVO
    * @throws DesafioException
    */
    private Produto inicializaProduto(ProdutoCategoriaProdutoVO produtoCategoriaProdutoVO) throws DesafioException {
        
        Produto produto = null;
        ProdutoHome produtoHome = null;     
                
        try {
            produtoHome = ProdutoBean.getHome();
            
            if((produtoCategoriaProdutoVO != null) &&
            (produtoCategoriaProdutoVO.getId_produto() > 0)){
                
                produto = produtoHome.findByPrimaryKey(new Long(produtoCategoriaProdutoVO.getId_produto()));
                
            }else{
                
                throw new ObjectNotFoundException();
            }            
        } catch (ObjectNotFoundException e) {
            throw new DesafioException("Desafio022 - Produto: Produto não encontrado ou não existente");
        } catch (Exception e) {
            throw new EJBException(e);
        }
        return produto;
    }
    
    /* 
    * @param categoriaProdutoVO
    * @throws DesafioException
    */
    private CategoriaProduto inicializaCategoriaProduto(ProdutoCategoriaProdutoVO produtoCategoriaProdutoVO) throws DesafioException {
        
        CategoriaProduto categoriaProduto = null;
        CategoriaProdutoHome categoriaProdutoHome = null;     
                
        try {
            categoriaProdutoHome = CategoriaProdutoBean.getHome();
            
            if((produtoCategoriaProdutoVO != null) &&
            (produtoCategoriaProdutoVO.getId_categoria_produto() > 0)){
                
                categoriaProduto = categoriaProdutoHome.findByPrimaryKey(new Long(produtoCategoriaProdutoVO.getId_categoria_produto()));
                
            }else{
                
                throw new ObjectNotFoundException();
            }            
        } catch (ObjectNotFoundException e) {
            throw new DesafioException("Desafio021 - ProdutoCategoriaProduto: CategoriaProduto não encontrado ou não existente");
        } catch (Exception e) {
            throw new EJBException(e);
        }
        return categoriaProduto;
    }
    
    
    
     /**
    * @ejbgen:remote-method transaction-attribute="Required"
    */
    public void eliminarProdutoCategoriaProduto( ProdutoCategoriaProdutoVO produtoCategoriaProdutoVO ) 	throws DesafioException
    {
        try{
            
            this.inicializa( produtoCategoriaProdutoVO );
            this.produtoCategoriaProduto.remove();
            
        }catch( RemoveException e){
            throw new DesafioException("Desafio019 - ProdutoCategoriaProduto: Impossível excluir registro");
        }
    }
    
     /**
    * @ejbgen:remote-method transaction-attribute="Required"
    */
     public ProdutoCategoriaProdutoVO obterProdutoCategoriaProduto(ProdutoCategoriaProdutoVO produtoCategoriaProdutoVO) throws DesafioException
    {
        this.inicializa( produtoCategoriaProdutoVO );
        return produtoCategoriaProduto.getData();
    }
    
        /**
     * Método retorna o nome jndi para lookup
     *
     * @return String
     */
    public static String getRemoteJndiName() {
        return "ejb.DesafioEjbs.ProdutoCategoriaProdutoSessionRemoteHome";
    }
    
    /**
     * M�todo retorna a classe Home do Bean
     * 
     * @return ProdutoCategoriaProdutoSessionHome
     * @throws NamingException
     */
    public static ProdutoCategoriaProdutoSessionHome getRemoteHome() throws NamingException {
        return (ProdutoCategoriaProdutoSessionHome) ServiceLocator.getInstance().getRemoteHome(getRemoteJndiName(), ProdutoCategoriaProdutoSessionHome.class);
    }
    
}
package desafio.ejb.geral;

import desafio.CategoriaProdutoVO;
import desafio.ProdutoCategoriaProdutoVO;
import desafio.infra.DesafioException;
import itaipu.util.ServiceLocator;
import java.util.Collection;
import javax.ejb.CreateException;
import javax.naming.NamingException;

import weblogic.ejb.GenericEntityBean;

/**
 * @ejbgen:entity enable-call-by-reference="true" default-transaction="Supports"
 *   ejb-name = "CategoriaProdutoBean"
 *   data-source-name = "dsDesafio"
 *   table-name = "CATEGORIA_PRODUTO"
 *   prim-key-class = "java.lang.Long"
 *
 * @ejbgen:jndi-name
 *   local = "ejb.DesafioEjbs.CategoriaProdutoBeanHome"
 *
 * @ejbgen:file-generation local-class = "true" local-class-name = "CategoriaProduto" local-home = "true" local-home-name = "CategoriaProdutoHome" remote-class = "false" remote-class-name = "CategoriaProdutoRemote" remote-home = "false" remote-home-name = "CategoriaProdutoRemoteHome" value-class = "false" value-class-name = "CategoriaProdutoValue" pk-class = "true"
 * @ejbgen:relation role-name="CategoriaProdutoBean-has-ProdutoCategoriaProdutoBeans" target-ejb="ProdutoCategoriaProdutoBean" multiplicity="One" name="ProdutoCategoriaProdutoBean-CategoriaProdutoBean"
 * @ejbgen:relation role-name="CategoriaProdutoBeans-have-CategoriaProdutoBean" fk-column="ID_CATEGORIA_PAI" cmr-field="categoriaPai" target-ejb="CategoriaProdutoBean" multiplicity="Many" name="CategoriaProdutoBean-CategoriaProdutoBean"
 * @ejbgen:relation role-name="CategoriaProdutoBean-has-CategoriaProdutoBeans" target-ejb="CategoriaProdutoBean" multiplicity="One" name="CategoriaProdutoBean-CategoriaProdutoBean"
 * @ejbgen:automatic-key-generation cache-size="1" name="CATEGORIA_PRODUTO_SEQ" type="Oracle"
 */

public abstract class CategoriaProdutoBean 
  extends GenericEntityBean
{

  public java.lang.Long ejbCreate(CategoriaProdutoVO categoriaProdutoVO, CategoriaProduto categoriaPai)
    throws CreateException, DesafioException
    {
        this.validaCategoriaProduto(categoriaProdutoVO);
        this.setData(categoriaProdutoVO);
        return null;
    }
  
  public void ejbPostCreate(CategoriaProdutoVO categoriaProdutoVO, CategoriaProduto categoriaPai) 
    throws CreateException
  { 
    this.setCategoriaPai(categoriaPai);
  }


  /**
   * @ejbgen:cmp-field ordering-number="10" column = "ID_CATEGORIA_PRODUTO"
   *  primkey-field="true"
   * @ejbgen:local-method
   */
  public abstract Long getId_categoria_produto();
  /**
   * @ejbgen:local-method
   */
  public abstract void setId_categoria_produto(Long val);
  
  /**
   * @ejbgen:cmp-field column = "ID_CATEGORIA_PAI"
   * @ejbgen:local-method
   */
  public abstract Long getId_categoria_pai();
  /**
   * @ejbgen:local-method
   */
  public abstract void setId_categoria_pai(Long val);
  
  /**
   * @ejbgen:cmp-field column = "NOME_CATEGORIA_PRODUTO"
   * @ejbgen:local-method
   */
  public abstract String getNome_categoria_produto();
  /**
   * @ejbgen:local-method
   */
  public abstract void setNome_categoria_produto(String val);
  

    /**
     * @ejbgen:cmr-field
     * @ejbgen:local-method
     */
    public abstract CategoriaProduto getCategoriaPai();

    /**
     * @ejbgen:local-method
     */
    public abstract void setCategoriaPai(CategoriaProduto arg);
    
        /**
    * Método obtem os dados do Bean para o VO
    *
    * @return CategoriaProdutoVO
    * @throws DesafioException
    * @ejbgen:local-method transaction-attribute="Supports"
    */
    public void setData(CategoriaProdutoVO categoriaProdutoVO) throws DesafioException{
      this.setNome_categoria_produto(categoriaProdutoVO.getNome_categoria_produto() == null ? null : categoriaProdutoVO.getNome_categoria_produto().trim());
    }
    /**
    * Método obtem os dados do Bean para o VO
    *
    * @return CategoriaProdutoVO
    * @throws DesafioException
    * @ejbgen:local-method transaction-attribute="Supports"
    */
    public CategoriaProdutoVO getData() throws DesafioException {
      CategoriaProdutoVO categoriaProdutoVO = new CategoriaProdutoVO();
      
      categoriaProdutoVO.setId_categoria_produto(this.getId_categoria_produto() == null ? 0 : this.getId_categoria_produto().longValue());
      categoriaProdutoVO.setId_categoria_pai(this.getId_categoria_pai() == null ? 0 : this.getId_categoria_pai().longValue());
      categoriaProdutoVO.setNome_categoria_produto(this.getNome_categoria_produto());
      
      return categoriaProdutoVO;
    }
    
    
    /**
    * Método valida os dados do Value Object
    *
    * @param CategoriaProduto com os dados a serem validados
    * @throws DesafioException
    * @ejbgen:local-method transaction-attribute="Supports"
    */
    
    public void validaCategoriaProduto(CategoriaProdutoVO categoriaProdutoVO) throws DesafioException{
      if ((categoriaProdutoVO == null) ||
      (categoriaProdutoVO.getNome_categoria_produto() == null) ||
      (categoriaProdutoVO.getNome_categoria_produto().trim().equals(""))){
        throw new DesafioException("Desafio001 - CategoriaProduto: Dados incompletos");
      }
    }

    
     /**
     * Método retorna o nome jndi para lookup
     *
     * @return String
     */
    public static String getLocalJndiName() {
        return "ejb.DesafioEjbs.CategoriaProdutoBeanHome";
    }
    
     /**
     * Método retorna a classe home do bean
     *
     * @return CategoriaProdutoHome
     * @throws NamingException
     */
    public static CategoriaProdutoHome getHome() throws NamingException {
        return (CategoriaProdutoHome) ServiceLocator.getInstance().getLocalHome(getLocalJndiName());
    }
}


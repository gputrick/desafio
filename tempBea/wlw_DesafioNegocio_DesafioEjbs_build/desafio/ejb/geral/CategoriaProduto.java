package desafio.ejb.geral;


/*
  ** This file was automatically generated by EJBGen 2.16
  ** Build: 20050706-1110
*/


import javax.ejb.EJBLocalObject;

// BEGIN imports from bean class
import desafio.CategoriaProdutoVO;
import desafio.ProdutoCategoriaProdutoVO;
import desafio.infra.DesafioException;
import itaipu.util.ServiceLocator;
import java.util.Collection;
import javax.ejb.CreateException;
import javax.naming.NamingException;
import weblogic.ejb.GenericEntityBean;
// END imports from bean class


public interface CategoriaProduto extends EJBLocalObject {

  public desafio.ejb.geral.CategoriaProduto getCategoriaPai() ;
  /**
   * Método obtem os dados do Bean para o VO
   * @return CategoriaProdutoVO
   * @throws DesafioException
   */
  public desafio.CategoriaProdutoVO getData()  throws desafio.infra.DesafioException;  public Long getId_categoria_pai() ;  public Long getId_categoria_produto() ;  public String getNome_categoria_produto() ;  public void setCategoriaPai(desafio.ejb.geral.CategoriaProduto arg) ;
  /**
   * Método obtem os dados do Bean para o VO
   * @return CategoriaProdutoVO
   * @throws DesafioException
   */
  public void setData(desafio.CategoriaProdutoVO categoriaProdutoVO)  throws desafio.infra.DesafioException;  public void setId_categoria_pai(Long val) ;  public void setId_categoria_produto(Long val) ;  public void setNome_categoria_produto(String val) ;
  /**
   * Método valida os dados do Value Object
   * @param CategoriaProduto
            com os dados a serem validados
   * @throws DesafioException
   */
  public void validaCategoriaProduto(desafio.CategoriaProdutoVO categoriaProdutoVO)  throws desafio.infra.DesafioException;
}

/**
* This code was automatically generated at 16:43:59 on 12/04/2016
* by weblogic.ejb20.ejbc.Ejb2Rmi -- do not edit.
*
* @version WebLogic Server 8.1 SP6  Wed Jun 21 08:18:55 PDT 2006 781680 
* @author Copyright (c) 2016 by BEA Systems, Inc. All Rights Reserved.
*/

package desafio.ejb.geral;
import weblogic.ejb20.interfaces.WLEnterpriseBean;
public final class ProdutoBean_jhfb8g_LocalHomeImpl
extends    weblogic.ejb20.internal.EntityEJBLocalHome
implements desafio.ejb.geral.ProdutoHome, weblogic.utils.PlatformConstants 

, weblogic.ejb.QueryLocalHome
{
  public weblogic.ejb20.internal.MethodDescriptor md_eo_getId_produto;
  public weblogic.ejb20.internal.MethodDescriptor md_eo_setId_produto_L;
  public weblogic.ejb20.internal.MethodDescriptor md_eo_getData;
  public weblogic.ejb20.internal.MethodDescriptor md_eo_setData_desafio_ProdutoVO;
  public weblogic.ejb20.internal.MethodDescriptor md_eo_setNome_produto_S;
  public weblogic.ejb20.internal.MethodDescriptor md_eo_getNome_produto;
  public weblogic.ejb20.internal.MethodDescriptor md_eo_validaProduto_desafio_ProdutoVO;
  
  
  public weblogic.ejb20.internal.MethodDescriptor md_ejbCreate_desafio_ProdutoVO;
  
  
  public weblogic.ejb20.internal.MethodDescriptor md_ejbFindByPrimaryKey_L;
  
  
  private static java.lang.reflect.Method mth_ejbCreate_desafio_ProdutoVO;
  private static java.lang.reflect.Method mth_postejbCreate_desafio_ProdutoVO;
  
  
  
  
  public weblogic.ejb20.internal.MethodDescriptor md_eo_remove;
  
  public weblogic.ejb20.internal.MethodDescriptor md_ejbRemove_O;
  
  static {
    
    try {
      
      
      mth_ejbCreate_desafio_ProdutoVO = ProdutoBean_jhfb8g_Intf.class.getMethod(
      "ejbCreate", new Class [] {desafio.ProdutoVO.class});
      
      if (true) {
        mth_postejbCreate_desafio_ProdutoVO = ProdutoBean_jhfb8g_Intf.class.getMethod(
        "ejbPostCreate", new Class [] {desafio.ProdutoVO.class}); 
      }
      
      
      
      
      
    } catch (Exception e) {
      throw new AssertionError("Unable to find expected "+
      "methods.  Please check your classpath for stale versions of "+
      "your ejb classes and re-run weblogic.ejbc");
    }
  }
  
  
  public ProdutoBean_jhfb8g_LocalHomeImpl() {
    super(ProdutoBean_jhfb8g_ELOImpl.class
    , java.lang.Long.class);
  }
  
  
  public desafio.ejb.geral.Produto create (desafio.ProdutoVO arg0)
  throws javax.ejb.CreateException, desafio.infra.DesafioException
  {
    try {
      return (desafio.ejb.geral.Produto) super.create(md_ejbCreate_desafio_ProdutoVO,
      mth_ejbCreate_desafio_ProdutoVO, mth_postejbCreate_desafio_ProdutoVO, 
      new Object [] {  arg0});
      
    } catch (java.lang.Exception e) {
      if (e instanceof javax.ejb.EJBException) {
        throw (javax.ejb.EJBException)e;
      }
      else if (e instanceof javax.ejb.CreateException) {
        throw (javax.ejb.CreateException) e;
      }else if (e instanceof desafio.infra.DesafioException) {
        throw (desafio.infra.DesafioException) e;
      }
      else {
        throw new javax.ejb.CreateException ("Error while creating bean: " + 
        e.toString());
      }
    }
  }
  
  
  
  
  public desafio.ejb.geral.Produto findByPrimaryKey(java.lang.Long arg0)
  throws javax.ejb.FinderException
  {
    try {
      return (desafio.ejb.geral.Produto)
      super.findByPrimaryKey(md_ejbFindByPrimaryKey_L,  arg0 );
    } catch (java.lang.Exception e) {
      if (e instanceof javax.ejb.EJBException) {
        throw (javax.ejb.EJBException)e;
      }
      else if (e instanceof javax.ejb.FinderException) {
        throw (javax.ejb.FinderException) e;
      }
      else {
        throw new javax.ejb.FinderException ("Error while finding bean: " + 
        e.toString());
      }
    }
  }
  
  
  
  
  
  
  public void remove(java.lang.Object pk) 
  throws javax.ejb.RemoveException
  {
    super.remove(md_ejbRemove_O, pk);
  }
  
}


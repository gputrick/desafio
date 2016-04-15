/**
* This code was automatically generated at 15:39:30 on 15/04/2016
* by weblogic.ejb20.ejbc.Ejb2Rmi -- do not edit.
*
* @version WebLogic Server 8.1 SP6  Wed Jun 21 08:18:55 PDT 2006 781680 
* @author Copyright (c) 2016 by BEA Systems, Inc. All Rights Reserved.
*/

package desafio.ejb.geral;
import weblogic.ejb20.interfaces.WLEnterpriseBean;
public final class ProdutoCategoriaProdutoBean_vhvw4g_LocalHomeImpl
extends    weblogic.ejb20.internal.EntityEJBLocalHome
implements desafio.ejb.geral.ProdutoCategoriaProdutoHome, weblogic.utils.PlatformConstants 

, weblogic.ejb.QueryLocalHome
{
  public weblogic.ejb20.internal.MethodDescriptor md_eo_setCategoriaProduto_desafio_ejb_geral_CategoriaProduto;
  public weblogic.ejb20.internal.MethodDescriptor md_eo_getProduto;
  public weblogic.ejb20.internal.MethodDescriptor md_eo_validaProdutoCategoriaProduto_desafio_ProdutoCategoriaProdutoVO;
  public weblogic.ejb20.internal.MethodDescriptor md_eo_getId_produto;
  public weblogic.ejb20.internal.MethodDescriptor md_eo_getId_categoria_produto;
  public weblogic.ejb20.internal.MethodDescriptor md_eo_getData;
  public weblogic.ejb20.internal.MethodDescriptor md_eo_setProduto_desafio_ejb_geral_Produto;
  public weblogic.ejb20.internal.MethodDescriptor md_eo_setId_categoria_produto_L;
  public weblogic.ejb20.internal.MethodDescriptor md_eo_setData_desafio_ProdutoCategoriaProdutoVO;
  public weblogic.ejb20.internal.MethodDescriptor md_eo_getCategoriaProduto;
  public weblogic.ejb20.internal.MethodDescriptor md_eo_setId_produto_L;
  
  
  public weblogic.ejb20.internal.MethodDescriptor md_ejbCreate_desafio_ProdutoCategoriaProdutoVO;
  
  
  public weblogic.ejb20.internal.MethodDescriptor md_ejbFindByPrimaryKey_desafio_ejb_geral_ProdutoCategoriaProdutoBeanPK;
  
  
  private static java.lang.reflect.Method mth_ejbCreate_desafio_ProdutoCategoriaProdutoVO;
  private static java.lang.reflect.Method mth_postejbCreate_desafio_ProdutoCategoriaProdutoVO;
  
  
  
  
  public weblogic.ejb20.internal.MethodDescriptor md_eo_remove;
  
  public weblogic.ejb20.internal.MethodDescriptor md_ejbRemove_O;
  
  static {
    
    try {
      
      
      mth_ejbCreate_desafio_ProdutoCategoriaProdutoVO = ProdutoCategoriaProdutoBean_vhvw4g_Intf.class.getMethod(
      "ejbCreate", new Class [] {desafio.ProdutoCategoriaProdutoVO.class});
      
      if (true) {
        mth_postejbCreate_desafio_ProdutoCategoriaProdutoVO = ProdutoCategoriaProdutoBean_vhvw4g_Intf.class.getMethod(
        "ejbPostCreate", new Class [] {desafio.ProdutoCategoriaProdutoVO.class}); 
      }
      
      
      
      
      
    } catch (Exception e) {
      throw new AssertionError("Unable to find expected "+
      "methods.  Please check your classpath for stale versions of "+
      "your ejb classes and re-run weblogic.ejbc");
    }
  }
  
  
  public ProdutoCategoriaProdutoBean_vhvw4g_LocalHomeImpl() {
    super(ProdutoCategoriaProdutoBean_vhvw4g_ELOImpl.class
    , desafio.ejb.geral.ProdutoCategoriaProdutoBeanPK.class);
  }
  
  
  public desafio.ejb.geral.ProdutoCategoriaProduto create (desafio.ProdutoCategoriaProdutoVO arg0)
  throws javax.ejb.CreateException, desafio.infra.DesafioException
  {
    try {
      return (desafio.ejb.geral.ProdutoCategoriaProduto) super.create(md_ejbCreate_desafio_ProdutoCategoriaProdutoVO,
      mth_ejbCreate_desafio_ProdutoCategoriaProdutoVO, mth_postejbCreate_desafio_ProdutoCategoriaProdutoVO, 
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
  
  
  
  
  public desafio.ejb.geral.ProdutoCategoriaProduto findByPrimaryKey(desafio.ejb.geral.ProdutoCategoriaProdutoBeanPK arg0)
  throws javax.ejb.FinderException
  {
    try {
      return (desafio.ejb.geral.ProdutoCategoriaProduto)
      super.findByPrimaryKey(md_ejbFindByPrimaryKey_desafio_ejb_geral_ProdutoCategoriaProdutoBeanPK,  arg0 );
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


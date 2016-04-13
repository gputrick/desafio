/**
* This code was automatically generated at 16:43:59 on 12/04/2016
* by weblogic.ejb20.ejbc.Ejb2Rmi -- do not edit.
*
* @version WebLogic Server 8.1 SP6  Wed Jun 21 08:18:55 PDT 2006 781680 
* @author Copyright (c) 2016 by BEA Systems, Inc. All Rights Reserved.
*/

package desafio.ejb.geral;
import weblogic.ejb20.interfaces.WLEnterpriseBean;
public final class CategoriaProdutoBean_3k3wj0_LocalHomeImpl
extends    weblogic.ejb20.internal.EntityEJBLocalHome
implements desafio.ejb.geral.CategoriaProdutoHome, weblogic.utils.PlatformConstants 

, weblogic.ejb.QueryLocalHome
{
  public weblogic.ejb20.internal.MethodDescriptor md_eo_getId_categoria_pai;
  public weblogic.ejb20.internal.MethodDescriptor md_eo_setId_categoria_produto_L;
  public weblogic.ejb20.internal.MethodDescriptor md_eo_setId_categoria_pai_L;
  public weblogic.ejb20.internal.MethodDescriptor md_eo_getId_categoria_produto;
  public weblogic.ejb20.internal.MethodDescriptor md_eo_getData;
  public weblogic.ejb20.internal.MethodDescriptor md_eo_getCategoriaPai;
  public weblogic.ejb20.internal.MethodDescriptor md_eo_setData_desafio_CategoriaProdutoVO;
  public weblogic.ejb20.internal.MethodDescriptor md_eo_setNome_categoria_produto_S;
  public weblogic.ejb20.internal.MethodDescriptor md_eo_setCategoriaPai_desafio_ejb_geral_CategoriaProduto;
  public weblogic.ejb20.internal.MethodDescriptor md_eo_getNome_categoria_produto;
  public weblogic.ejb20.internal.MethodDescriptor md_eo_validaCategoriaProduto_desafio_CategoriaProdutoVO;
  
  
  public weblogic.ejb20.internal.MethodDescriptor md_ejbCreate_desafio_CategoriaProdutoVOdesafio_ejb_geral_CategoriaProduto;
  
  
  public weblogic.ejb20.internal.MethodDescriptor md_ejbFindByPrimaryKey_L;
  
  
  private static java.lang.reflect.Method mth_ejbCreate_desafio_CategoriaProdutoVOdesafio_ejb_geral_CategoriaProduto;
  private static java.lang.reflect.Method mth_postejbCreate_desafio_CategoriaProdutoVOdesafio_ejb_geral_CategoriaProduto;
  
  
  
  
  public weblogic.ejb20.internal.MethodDescriptor md_eo_remove;
  
  public weblogic.ejb20.internal.MethodDescriptor md_ejbRemove_O;
  
  static {
    
    try {
      
      
      mth_ejbCreate_desafio_CategoriaProdutoVOdesafio_ejb_geral_CategoriaProduto = CategoriaProdutoBean_3k3wj0_Intf.class.getMethod(
      "ejbCreate", new Class [] {desafio.CategoriaProdutoVO.class, desafio.ejb.geral.CategoriaProduto.class});
      
      if (true) {
        mth_postejbCreate_desafio_CategoriaProdutoVOdesafio_ejb_geral_CategoriaProduto = CategoriaProdutoBean_3k3wj0_Intf.class.getMethod(
        "ejbPostCreate", new Class [] {desafio.CategoriaProdutoVO.class, desafio.ejb.geral.CategoriaProduto.class}); 
      }
      
      
      
      
      
    } catch (Exception e) {
      throw new AssertionError("Unable to find expected "+
      "methods.  Please check your classpath for stale versions of "+
      "your ejb classes and re-run weblogic.ejbc");
    }
  }
  
  
  public CategoriaProdutoBean_3k3wj0_LocalHomeImpl() {
    super(CategoriaProdutoBean_3k3wj0_ELOImpl.class
    , java.lang.Long.class);
  }
  
  
  public desafio.ejb.geral.CategoriaProduto create (desafio.CategoriaProdutoVO arg0,desafio.ejb.geral.CategoriaProduto arg1)
  throws javax.ejb.CreateException, desafio.infra.DesafioException
  {
    try {
      return (desafio.ejb.geral.CategoriaProduto) super.create(md_ejbCreate_desafio_CategoriaProdutoVOdesafio_ejb_geral_CategoriaProduto,
      mth_ejbCreate_desafio_CategoriaProdutoVOdesafio_ejb_geral_CategoriaProduto, mth_postejbCreate_desafio_CategoriaProdutoVOdesafio_ejb_geral_CategoriaProduto, 
      new Object [] {  arg0, arg1});
      
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
  
  
  
  
  public desafio.ejb.geral.CategoriaProduto findByPrimaryKey(java.lang.Long arg0)
  throws javax.ejb.FinderException
  {
    try {
      return (desafio.ejb.geral.CategoriaProduto)
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


/**
* This code was automatically generated at 16:43:59 on 12/04/2016
* by weblogic.ejb20.ejbc.Ejb2Rmi -- do not edit.
*
* @version WebLogic Server 8.1 SP6  Wed Jun 21 08:18:55 PDT 2006 781680 
* @author Copyright (c) 2016 by BEA Systems, Inc. All Rights Reserved.
*/

package desafio.ejb.manager;
import weblogic.ejb20.interfaces.WLEnterpriseBean;
public final class CategoriaProdutoSession_snmn7k_HomeImpl
extends    weblogic.ejb20.internal.StatelessEJBHome
implements desafio.ejb.manager.CategoriaProdutoSessionHome, weblogic.utils.PlatformConstants

{
  public weblogic.ejb20.internal.MethodDescriptor md_eo_delProdutoCategoriaProduto_desafio_ProdutoCategoriaProdutoVOdesafio_CategoriaProdutoVO;
  public weblogic.ejb20.internal.MethodDescriptor md_eo_addProdutoCategoriaProduto_desafio_ProdutoCategoriaProdutoVOdesafio_CategoriaProdutoVO;
  public weblogic.ejb20.internal.MethodDescriptor md_eo_obterCategoriaProduto_desafio_CategoriaProdutoVO;
  public weblogic.ejb20.internal.MethodDescriptor md_eo_eliminarCategoriaProduto_desafio_CategoriaProdutoVO;
  public weblogic.ejb20.internal.MethodDescriptor md_eo_atualizarCategoriaProduto_desafio_CategoriaProdutoVO;
  
  
  public weblogic.ejb20.internal.MethodDescriptor md_ejbCreate;
  
  
  
  
  
  private static java.lang.reflect.Method mth_ejbCreate;
  private static java.lang.reflect.Method mth_postejbCreate;
  
  
  
  
  
  public weblogic.ejb20.internal.MethodDescriptor md_eo_remove;
  
  public weblogic.ejb20.internal.MethodDescriptor md_ejbRemove_javax_ejb_Handle;
  public weblogic.ejb20.internal.MethodDescriptor md_ejbRemove_O;
  
  static {
    
    try {
      
      
      mth_ejbCreate = CategoriaProdutoSession_snmn7k_Intf.class.getMethod(
      "ejbCreate", null);
      
      if (false) {
        mth_postejbCreate = CategoriaProdutoSession_snmn7k_Intf.class.getMethod(
        "ejbPostCreate", null); 
      }
      
      
      
      
      
    } catch (Exception e) {
      throw new AssertionError("Unable to find expected "+
      "methods.  Please check your classpath for stale versions of "+
      "your ejb classes and re-run weblogic.ejbc");
    }
  }
  
  
  public CategoriaProdutoSession_snmn7k_HomeImpl() {
    super(CategoriaProdutoSession_snmn7k_EOImpl.class
    );
  }
  
  
  public desafio.ejb.manager.CategoriaProdutoSessionRemote create ()
  throws javax.ejb.CreateException, java.rmi.RemoteException
  {
    try {
      return (desafio.ejb.manager.CategoriaProdutoSessionRemote) super.create(md_ejbCreate);
    } catch (java.lang.Exception e) {
      if (e instanceof java.rmi.RemoteException) {
        throw (java.rmi.RemoteException)e;
      }
      else if (e instanceof javax.ejb.CreateException) {
        throw (javax.ejb.CreateException) e;
      }
      else {
        throw new javax.ejb.CreateException ("Error while creating bean: " + 
        e.toString());
      }
    }
  }
  
  
  
  
  
  
  
  public void remove(java.lang.Object pk) 
  throws java.rmi.RemoteException, javax.ejb.RemoveException
  {
    super.remove(md_ejbRemove_O, pk);
  }
  
  public void remove(javax.ejb.Handle h)
  throws java.rmi.RemoteException, javax.ejb.RemoveException
  {
    super.remove(md_ejbRemove_javax_ejb_Handle, h);
  }
  
  
}


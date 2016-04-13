/**
* This code was automatically generated at 16:43:59 on 12/04/2016
* by weblogic.ejb20.ejbc.Ejb2Rmi -- do not edit.
*
* @version WebLogic Server 8.1 SP6  Wed Jun 21 08:18:55 PDT 2006 781680 
* @author Copyright (c) 2016 by BEA Systems, Inc. All Rights Reserved.
*/

package desafio.ejb.manager;

import weblogic.ejb20.interfaces.WLEnterpriseBean;

public final class ProdutoCategoriaProdutoSession_ceaum_EOImpl
extends weblogic.ejb20.internal.StatelessEJBObject
implements desafio.ejb.manager.ProdutoCategoriaProdutoSessionRemote, weblogic.utils.PlatformConstants
{
  
  public ProdutoCategoriaProdutoSession_ceaum_EOImpl() {}
  
  public desafio.ProdutoCategoriaProdutoVO obterProdutoCategoriaProduto(desafio.ProdutoCategoriaProdutoVO arg0)
  throws java.rmi.RemoteException, desafio.infra.DesafioException
  {
    java.lang.Throwable __ee = null;
    
    weblogic.ejb20.internal.InvocationWrapper __wrap;
    weblogic.ejb20.internal.MethodDescriptor __md = 
    ((ProdutoCategoriaProdutoSession_ceaum_HomeImpl)getEJBHome()).md_eo_obterProdutoCategoriaProduto_desafio_ProdutoCategoriaProdutoVO;
    try {
      __wrap = super.preInvoke(
      __md, weblogic.ejb20.internal.DummyContextHandler.THE_ONE);
    } catch (weblogic.ejb20.internal.NeedRealContextHandlerError e) {
      __wrap = super.preInvoke(
      __md, new weblogic.ejb20.internal.EJBContextHandler(
      __md, new Object [] {  arg0}));          
    }
    
    ProdutoCategoriaProdutoSession_ceaum_Intf __bean = (ProdutoCategoriaProdutoSession_ceaum_Intf) __wrap.getBean();
    
    desafio.ProdutoCategoriaProdutoVO result = null;
    
    int __oldState = __bean.__WL_getMethodState();
    
    try {
      __bean.__WL_setMethodState(WLEnterpriseBean.STATE_BUSINESS_METHOD);
      
      result =  __bean.obterProdutoCategoriaProduto( arg0);
      
    } catch (java.lang.Throwable t) {
      __ee = t;
    }
    finally {
      __bean.__WL_setMethodState(__oldState);
    }
    
    try {
      super.postInvoke(__wrap, __ee);
      
    } catch (java.lang.Exception e) {
      if (e instanceof java.rmi.RemoteException) {
        throw (java.rmi.RemoteException)e;
      } 
      else if (e instanceof desafio.infra.DesafioException) {
        throw (desafio.infra.DesafioException) e;
      }
      else {
        throw new java.rmi.UnexpectedException("Unexpected exception in " +
        "desafio.ejb.manager.ProdutoCategoriaProdutoSession.obterProdutoCategoriaProduto():" + EOL +	
        weblogic.utils.StackTraceUtils.throwable2StackTrace(e), e);
      } 
    }
    return result;
  }
  
  public void eliminarProdutoCategoriaProduto(desafio.ProdutoCategoriaProdutoVO arg0)
  throws java.rmi.RemoteException, desafio.infra.DesafioException
  {
    java.lang.Throwable __ee = null;
    
    weblogic.ejb20.internal.InvocationWrapper __wrap;
    weblogic.ejb20.internal.MethodDescriptor __md = 
    ((ProdutoCategoriaProdutoSession_ceaum_HomeImpl)getEJBHome()).md_eo_eliminarProdutoCategoriaProduto_desafio_ProdutoCategoriaProdutoVO;
    try {
      __wrap = super.preInvoke(
      __md, weblogic.ejb20.internal.DummyContextHandler.THE_ONE);
    } catch (weblogic.ejb20.internal.NeedRealContextHandlerError e) {
      __wrap = super.preInvoke(
      __md, new weblogic.ejb20.internal.EJBContextHandler(
      __md, new Object [] {  arg0}));          
    }
    
    ProdutoCategoriaProdutoSession_ceaum_Intf __bean = (ProdutoCategoriaProdutoSession_ceaum_Intf) __wrap.getBean();
    
    // No return value
    
    int __oldState = __bean.__WL_getMethodState();
    
    try {
      __bean.__WL_setMethodState(WLEnterpriseBean.STATE_BUSINESS_METHOD);
      
      __bean.eliminarProdutoCategoriaProduto( arg0);
      
    } catch (java.lang.Throwable t) {
      __ee = t;
    }
    finally {
      __bean.__WL_setMethodState(__oldState);
    }
    
    try {
      super.postInvoke(__wrap, __ee);
      
    } catch (java.lang.Exception e) {
      if (e instanceof java.rmi.RemoteException) {
        throw (java.rmi.RemoteException)e;
      } 
      else if (e instanceof desafio.infra.DesafioException) {
        throw (desafio.infra.DesafioException) e;
      }
      else {
        throw new java.rmi.UnexpectedException("Unexpected exception in " +
        "desafio.ejb.manager.ProdutoCategoriaProdutoSession.eliminarProdutoCategoriaProduto():" + EOL +	
        weblogic.utils.StackTraceUtils.throwable2StackTrace(e), e);
      } 
    }
    // No return result
  }
  
  
  
  public void remove()
  throws javax.ejb.RemoveException, java.rmi.RemoteException
  {
    super.remove(((ProdutoCategoriaProdutoSession_ceaum_HomeImpl)getEJBHome()).md_eo_remove);
  }
  
}


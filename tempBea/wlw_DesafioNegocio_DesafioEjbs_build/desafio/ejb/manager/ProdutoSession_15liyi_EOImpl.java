/**
* This code was automatically generated at 15:39:30 on 15/04/2016
* by weblogic.ejb20.ejbc.Ejb2Rmi -- do not edit.
*
* @version WebLogic Server 8.1 SP6  Wed Jun 21 08:18:55 PDT 2006 781680 
* @author Copyright (c) 2016 by BEA Systems, Inc. All Rights Reserved.
*/

package desafio.ejb.manager;

import weblogic.ejb20.interfaces.WLEnterpriseBean;

public final class ProdutoSession_15liyi_EOImpl
extends weblogic.ejb20.internal.StatelessEJBObject
implements desafio.ejb.manager.ProdutoSessionRemote, weblogic.utils.PlatformConstants
{
  
  public ProdutoSession_15liyi_EOImpl() {}
  
  public desafio.ProdutoVO atualizarProduto(desafio.ProdutoVO arg0)
  throws java.rmi.RemoteException, desafio.infra.DesafioException
  {
    java.lang.Throwable __ee = null;
    
    weblogic.ejb20.internal.InvocationWrapper __wrap;
    weblogic.ejb20.internal.MethodDescriptor __md = 
    ((ProdutoSession_15liyi_HomeImpl)getEJBHome()).md_eo_atualizarProduto_desafio_ProdutoVO;
    try {
      __wrap = super.preInvoke(
      __md, weblogic.ejb20.internal.DummyContextHandler.THE_ONE);
    } catch (weblogic.ejb20.internal.NeedRealContextHandlerError e) {
      __wrap = super.preInvoke(
      __md, new weblogic.ejb20.internal.EJBContextHandler(
      __md, new Object [] {  arg0}));          
    }
    
    ProdutoSession_15liyi_Intf __bean = (ProdutoSession_15liyi_Intf) __wrap.getBean();
    
    desafio.ProdutoVO result = null;
    
    int __oldState = __bean.__WL_getMethodState();
    
    try {
      __bean.__WL_setMethodState(WLEnterpriseBean.STATE_BUSINESS_METHOD);
      
      result =  __bean.atualizarProduto( arg0);
      
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
        "desafio.ejb.manager.ProdutoSession.atualizarProduto():" + EOL +	
        weblogic.utils.StackTraceUtils.throwable2StackTrace(e), e);
      } 
    }
    return result;
  }
  
  public void delProdutoCategoriaProduto(desafio.ProdutoCategoriaProdutoVO arg0, desafio.ProdutoVO arg1)
  throws java.rmi.RemoteException, desafio.infra.DesafioException
  {
    java.lang.Throwable __ee = null;
    
    weblogic.ejb20.internal.InvocationWrapper __wrap;
    weblogic.ejb20.internal.MethodDescriptor __md = 
    ((ProdutoSession_15liyi_HomeImpl)getEJBHome()).md_eo_delProdutoCategoriaProduto_desafio_ProdutoCategoriaProdutoVOdesafio_ProdutoVO;
    try {
      __wrap = super.preInvoke(
      __md, weblogic.ejb20.internal.DummyContextHandler.THE_ONE);
    } catch (weblogic.ejb20.internal.NeedRealContextHandlerError e) {
      __wrap = super.preInvoke(
      __md, new weblogic.ejb20.internal.EJBContextHandler(
      __md, new Object [] {  arg0, arg1}));          
    }
    
    ProdutoSession_15liyi_Intf __bean = (ProdutoSession_15liyi_Intf) __wrap.getBean();
    
    // No return value
    
    int __oldState = __bean.__WL_getMethodState();
    
    try {
      __bean.__WL_setMethodState(WLEnterpriseBean.STATE_BUSINESS_METHOD);
      
      __bean.delProdutoCategoriaProduto( arg0, arg1);
      
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
        "desafio.ejb.manager.ProdutoSession.delProdutoCategoriaProduto():" + EOL +	
        weblogic.utils.StackTraceUtils.throwable2StackTrace(e), e);
      } 
    }
    // No return result
  }
  
  public void eliminarProduto(desafio.ProdutoVO arg0)
  throws java.rmi.RemoteException, desafio.infra.DesafioException
  {
    java.lang.Throwable __ee = null;
    
    weblogic.ejb20.internal.InvocationWrapper __wrap;
    weblogic.ejb20.internal.MethodDescriptor __md = 
    ((ProdutoSession_15liyi_HomeImpl)getEJBHome()).md_eo_eliminarProduto_desafio_ProdutoVO;
    try {
      __wrap = super.preInvoke(
      __md, weblogic.ejb20.internal.DummyContextHandler.THE_ONE);
    } catch (weblogic.ejb20.internal.NeedRealContextHandlerError e) {
      __wrap = super.preInvoke(
      __md, new weblogic.ejb20.internal.EJBContextHandler(
      __md, new Object [] {  arg0}));          
    }
    
    ProdutoSession_15liyi_Intf __bean = (ProdutoSession_15liyi_Intf) __wrap.getBean();
    
    // No return value
    
    int __oldState = __bean.__WL_getMethodState();
    
    try {
      __bean.__WL_setMethodState(WLEnterpriseBean.STATE_BUSINESS_METHOD);
      
      __bean.eliminarProduto( arg0);
      
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
        "desafio.ejb.manager.ProdutoSession.eliminarProduto():" + EOL +	
        weblogic.utils.StackTraceUtils.throwable2StackTrace(e), e);
      } 
    }
    // No return result
  }
  
  public desafio.ProdutoVO addProdutoCategoriaProduto(desafio.ProdutoCategoriaProdutoVO arg0, desafio.ProdutoVO arg1)
  throws java.rmi.RemoteException, desafio.infra.DesafioException
  {
    java.lang.Throwable __ee = null;
    
    weblogic.ejb20.internal.InvocationWrapper __wrap;
    weblogic.ejb20.internal.MethodDescriptor __md = 
    ((ProdutoSession_15liyi_HomeImpl)getEJBHome()).md_eo_addProdutoCategoriaProduto_desafio_ProdutoCategoriaProdutoVOdesafio_ProdutoVO;
    try {
      __wrap = super.preInvoke(
      __md, weblogic.ejb20.internal.DummyContextHandler.THE_ONE);
    } catch (weblogic.ejb20.internal.NeedRealContextHandlerError e) {
      __wrap = super.preInvoke(
      __md, new weblogic.ejb20.internal.EJBContextHandler(
      __md, new Object [] {  arg0, arg1}));          
    }
    
    ProdutoSession_15liyi_Intf __bean = (ProdutoSession_15liyi_Intf) __wrap.getBean();
    
    desafio.ProdutoVO result = null;
    
    int __oldState = __bean.__WL_getMethodState();
    
    try {
      __bean.__WL_setMethodState(WLEnterpriseBean.STATE_BUSINESS_METHOD);
      
      result =  __bean.addProdutoCategoriaProduto( arg0, arg1);
      
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
        "desafio.ejb.manager.ProdutoSession.addProdutoCategoriaProduto():" + EOL +	
        weblogic.utils.StackTraceUtils.throwable2StackTrace(e), e);
      } 
    }
    return result;
  }
  
  public desafio.ProdutoVO obterProduto(desafio.ProdutoVO arg0)
  throws java.rmi.RemoteException, desafio.infra.DesafioException
  {
    java.lang.Throwable __ee = null;
    
    weblogic.ejb20.internal.InvocationWrapper __wrap;
    weblogic.ejb20.internal.MethodDescriptor __md = 
    ((ProdutoSession_15liyi_HomeImpl)getEJBHome()).md_eo_obterProduto_desafio_ProdutoVO;
    try {
      __wrap = super.preInvoke(
      __md, weblogic.ejb20.internal.DummyContextHandler.THE_ONE);
    } catch (weblogic.ejb20.internal.NeedRealContextHandlerError e) {
      __wrap = super.preInvoke(
      __md, new weblogic.ejb20.internal.EJBContextHandler(
      __md, new Object [] {  arg0}));          
    }
    
    ProdutoSession_15liyi_Intf __bean = (ProdutoSession_15liyi_Intf) __wrap.getBean();
    
    desafio.ProdutoVO result = null;
    
    int __oldState = __bean.__WL_getMethodState();
    
    try {
      __bean.__WL_setMethodState(WLEnterpriseBean.STATE_BUSINESS_METHOD);
      
      result =  __bean.obterProduto( arg0);
      
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
        "desafio.ejb.manager.ProdutoSession.obterProduto():" + EOL +	
        weblogic.utils.StackTraceUtils.throwable2StackTrace(e), e);
      } 
    }
    return result;
  }
  
  
  
  public void remove()
  throws javax.ejb.RemoveException, java.rmi.RemoteException
  {
    super.remove(((ProdutoSession_15liyi_HomeImpl)getEJBHome()).md_eo_remove);
  }
  
}


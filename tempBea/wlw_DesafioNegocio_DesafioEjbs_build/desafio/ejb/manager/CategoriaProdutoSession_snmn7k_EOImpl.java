/**
* This code was automatically generated at 16:43:59 on 12/04/2016
* by weblogic.ejb20.ejbc.Ejb2Rmi -- do not edit.
*
* @version WebLogic Server 8.1 SP6  Wed Jun 21 08:18:55 PDT 2006 781680 
* @author Copyright (c) 2016 by BEA Systems, Inc. All Rights Reserved.
*/

package desafio.ejb.manager;

import weblogic.ejb20.interfaces.WLEnterpriseBean;

public final class CategoriaProdutoSession_snmn7k_EOImpl
extends weblogic.ejb20.internal.StatelessEJBObject
implements desafio.ejb.manager.CategoriaProdutoSessionRemote, weblogic.utils.PlatformConstants
{
  
  public CategoriaProdutoSession_snmn7k_EOImpl() {}
  
  public void delProdutoCategoriaProduto(desafio.ProdutoCategoriaProdutoVO arg0, desafio.CategoriaProdutoVO arg1)
  throws java.rmi.RemoteException, desafio.infra.DesafioException
  {
    java.lang.Throwable __ee = null;
    
    weblogic.ejb20.internal.InvocationWrapper __wrap;
    weblogic.ejb20.internal.MethodDescriptor __md = 
    ((CategoriaProdutoSession_snmn7k_HomeImpl)getEJBHome()).md_eo_delProdutoCategoriaProduto_desafio_ProdutoCategoriaProdutoVOdesafio_CategoriaProdutoVO;
    try {
      __wrap = super.preInvoke(
      __md, weblogic.ejb20.internal.DummyContextHandler.THE_ONE);
    } catch (weblogic.ejb20.internal.NeedRealContextHandlerError e) {
      __wrap = super.preInvoke(
      __md, new weblogic.ejb20.internal.EJBContextHandler(
      __md, new Object [] {  arg0, arg1}));          
    }
    
    CategoriaProdutoSession_snmn7k_Intf __bean = (CategoriaProdutoSession_snmn7k_Intf) __wrap.getBean();
    
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
        "desafio.ejb.manager.CategoriaProdutoSession.delProdutoCategoriaProduto():" + EOL +	
        weblogic.utils.StackTraceUtils.throwable2StackTrace(e), e);
      } 
    }
    // No return result
  }
  
  public desafio.CategoriaProdutoVO addProdutoCategoriaProduto(desafio.ProdutoCategoriaProdutoVO arg0, desafio.CategoriaProdutoVO arg1)
  throws java.rmi.RemoteException, desafio.infra.DesafioException
  {
    java.lang.Throwable __ee = null;
    
    weblogic.ejb20.internal.InvocationWrapper __wrap;
    weblogic.ejb20.internal.MethodDescriptor __md = 
    ((CategoriaProdutoSession_snmn7k_HomeImpl)getEJBHome()).md_eo_addProdutoCategoriaProduto_desafio_ProdutoCategoriaProdutoVOdesafio_CategoriaProdutoVO;
    try {
      __wrap = super.preInvoke(
      __md, weblogic.ejb20.internal.DummyContextHandler.THE_ONE);
    } catch (weblogic.ejb20.internal.NeedRealContextHandlerError e) {
      __wrap = super.preInvoke(
      __md, new weblogic.ejb20.internal.EJBContextHandler(
      __md, new Object [] {  arg0, arg1}));          
    }
    
    CategoriaProdutoSession_snmn7k_Intf __bean = (CategoriaProdutoSession_snmn7k_Intf) __wrap.getBean();
    
    desafio.CategoriaProdutoVO result = null;
    
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
        "desafio.ejb.manager.CategoriaProdutoSession.addProdutoCategoriaProduto():" + EOL +	
        weblogic.utils.StackTraceUtils.throwable2StackTrace(e), e);
      } 
    }
    return result;
  }
  
  public desafio.CategoriaProdutoVO obterCategoriaProduto(desafio.CategoriaProdutoVO arg0)
  throws java.rmi.RemoteException, desafio.infra.DesafioException
  {
    java.lang.Throwable __ee = null;
    
    weblogic.ejb20.internal.InvocationWrapper __wrap;
    weblogic.ejb20.internal.MethodDescriptor __md = 
    ((CategoriaProdutoSession_snmn7k_HomeImpl)getEJBHome()).md_eo_obterCategoriaProduto_desafio_CategoriaProdutoVO;
    try {
      __wrap = super.preInvoke(
      __md, weblogic.ejb20.internal.DummyContextHandler.THE_ONE);
    } catch (weblogic.ejb20.internal.NeedRealContextHandlerError e) {
      __wrap = super.preInvoke(
      __md, new weblogic.ejb20.internal.EJBContextHandler(
      __md, new Object [] {  arg0}));          
    }
    
    CategoriaProdutoSession_snmn7k_Intf __bean = (CategoriaProdutoSession_snmn7k_Intf) __wrap.getBean();
    
    desafio.CategoriaProdutoVO result = null;
    
    int __oldState = __bean.__WL_getMethodState();
    
    try {
      __bean.__WL_setMethodState(WLEnterpriseBean.STATE_BUSINESS_METHOD);
      
      result =  __bean.obterCategoriaProduto( arg0);
      
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
        "desafio.ejb.manager.CategoriaProdutoSession.obterCategoriaProduto():" + EOL +	
        weblogic.utils.StackTraceUtils.throwable2StackTrace(e), e);
      } 
    }
    return result;
  }
  
  public void eliminarCategoriaProduto(desafio.CategoriaProdutoVO arg0)
  throws java.rmi.RemoteException, desafio.infra.DesafioException
  {
    java.lang.Throwable __ee = null;
    
    weblogic.ejb20.internal.InvocationWrapper __wrap;
    weblogic.ejb20.internal.MethodDescriptor __md = 
    ((CategoriaProdutoSession_snmn7k_HomeImpl)getEJBHome()).md_eo_eliminarCategoriaProduto_desafio_CategoriaProdutoVO;
    try {
      __wrap = super.preInvoke(
      __md, weblogic.ejb20.internal.DummyContextHandler.THE_ONE);
    } catch (weblogic.ejb20.internal.NeedRealContextHandlerError e) {
      __wrap = super.preInvoke(
      __md, new weblogic.ejb20.internal.EJBContextHandler(
      __md, new Object [] {  arg0}));          
    }
    
    CategoriaProdutoSession_snmn7k_Intf __bean = (CategoriaProdutoSession_snmn7k_Intf) __wrap.getBean();
    
    // No return value
    
    int __oldState = __bean.__WL_getMethodState();
    
    try {
      __bean.__WL_setMethodState(WLEnterpriseBean.STATE_BUSINESS_METHOD);
      
      __bean.eliminarCategoriaProduto( arg0);
      
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
        "desafio.ejb.manager.CategoriaProdutoSession.eliminarCategoriaProduto():" + EOL +	
        weblogic.utils.StackTraceUtils.throwable2StackTrace(e), e);
      } 
    }
    // No return result
  }
  
  public desafio.CategoriaProdutoVO atualizarCategoriaProduto(desafio.CategoriaProdutoVO arg0)
  throws java.rmi.RemoteException, desafio.infra.DesafioException
  {
    java.lang.Throwable __ee = null;
    
    weblogic.ejb20.internal.InvocationWrapper __wrap;
    weblogic.ejb20.internal.MethodDescriptor __md = 
    ((CategoriaProdutoSession_snmn7k_HomeImpl)getEJBHome()).md_eo_atualizarCategoriaProduto_desafio_CategoriaProdutoVO;
    try {
      __wrap = super.preInvoke(
      __md, weblogic.ejb20.internal.DummyContextHandler.THE_ONE);
    } catch (weblogic.ejb20.internal.NeedRealContextHandlerError e) {
      __wrap = super.preInvoke(
      __md, new weblogic.ejb20.internal.EJBContextHandler(
      __md, new Object [] {  arg0}));          
    }
    
    CategoriaProdutoSession_snmn7k_Intf __bean = (CategoriaProdutoSession_snmn7k_Intf) __wrap.getBean();
    
    desafio.CategoriaProdutoVO result = null;
    
    int __oldState = __bean.__WL_getMethodState();
    
    try {
      __bean.__WL_setMethodState(WLEnterpriseBean.STATE_BUSINESS_METHOD);
      
      result =  __bean.atualizarCategoriaProduto( arg0);
      
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
        "desafio.ejb.manager.CategoriaProdutoSession.atualizarCategoriaProduto():" + EOL +	
        weblogic.utils.StackTraceUtils.throwable2StackTrace(e), e);
      } 
    }
    return result;
  }
  
  
  
  public void remove()
  throws javax.ejb.RemoveException, java.rmi.RemoteException
  {
    super.remove(((CategoriaProdutoSession_snmn7k_HomeImpl)getEJBHome()).md_eo_remove);
  }
  
}


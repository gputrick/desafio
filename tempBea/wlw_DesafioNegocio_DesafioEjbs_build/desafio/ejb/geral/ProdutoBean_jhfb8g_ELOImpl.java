/**
* This code was automatically generated at 16:43:59 on 12/04/2016
* by weblogic.ejb20.ejbc.Ejb2Rmi -- do not edit.
*
* @version WebLogic Server 8.1 SP6  Wed Jun 21 08:18:55 PDT 2006 781680 
* @author Copyright (c) 2016 by BEA Systems, Inc. All Rights Reserved.
*/

package desafio.ejb.geral;

import weblogic.ejb20.interfaces.WLEnterpriseBean;

public final class ProdutoBean_jhfb8g_ELOImpl
extends weblogic.ejb20.internal.EntityEJBLocalObject
implements desafio.ejb.geral.Produto, weblogic.utils.PlatformConstants, java.io.Serializable
{
  
  public ProdutoBean_jhfb8g_ELOImpl() {}
  
  public java.lang.Long getId_produto()
  {
    java.lang.Throwable __ee = null;
    
    weblogic.ejb20.internal.InvocationWrapper __wrap;
    weblogic.ejb20.internal.MethodDescriptor __md = 
    ((ProdutoBean_jhfb8g_LocalHomeImpl)getEJBLocalHome()).md_eo_getId_produto;
    try {
      __wrap = super.preInvokeLite(
      __md, weblogic.ejb20.internal.DummyContextHandler.THE_ONE);
    } catch (weblogic.ejb20.internal.NeedRealContextHandlerError e) {
      __wrap = super.preInvokeLite(
      __md, new weblogic.ejb20.internal.EJBContextHandler(
      __md, new Object [] { }));          
    }
    
    ProdutoBean_jhfb8g_Intf __bean = (ProdutoBean_jhfb8g_Intf) __wrap.getBean();
    
    java.lang.Long result = null;
    
    int __oldState = __bean.__WL_getMethodState();
    
    try {
      __bean.__WL_setMethodState(WLEnterpriseBean.STATE_BUSINESS_METHOD);
      
      result =  __bean.getId_produto(
      );
      ((weblogic.ejb20.persistence.spi.CMPBean) __bean).__WL_checkExistsOnMethod();
      
    } catch (java.lang.Throwable t) {
      __ee = t;
    }
    finally {
      __bean.__WL_setMethodState(__oldState);
    }
    
    try {
      super.postInvokeLite(__wrap, __ee);
      
    } catch (java.lang.Exception e) {
      if (e instanceof javax.ejb.EJBException) {
        throw (javax.ejb.EJBException) e;
      } 
      
      else {
        throw new javax.ejb.EJBException("Unexpected exception in " +
        "desafio.ejb.geral.ProdutoBean.getId_produto():" + EOL +	
        weblogic.utils.StackTraceUtils.throwable2StackTrace(e), e);
        
        
      } 
    }
    return result;
  }
  
  public void setId_produto(java.lang.Long arg0)
  {
    java.lang.Throwable __ee = null;
    
    weblogic.ejb20.internal.InvocationWrapper __wrap;
    weblogic.ejb20.internal.MethodDescriptor __md = 
    ((ProdutoBean_jhfb8g_LocalHomeImpl)getEJBLocalHome()).md_eo_setId_produto_L;
    try {
      __wrap = super.preInvokeLite(
      __md, weblogic.ejb20.internal.DummyContextHandler.THE_ONE);
    } catch (weblogic.ejb20.internal.NeedRealContextHandlerError e) {
      __wrap = super.preInvokeLite(
      __md, new weblogic.ejb20.internal.EJBContextHandler(
      __md, new Object [] {  arg0}));          
    }
    
    ProdutoBean_jhfb8g_Intf __bean = (ProdutoBean_jhfb8g_Intf) __wrap.getBean();
    
    // No return value
    
    int __oldState = __bean.__WL_getMethodState();
    
    try {
      __bean.__WL_setMethodState(WLEnterpriseBean.STATE_BUSINESS_METHOD);
      
      __bean.setId_produto(
      arg0);
      ((weblogic.ejb20.persistence.spi.CMPBean) __bean).__WL_checkExistsOnMethod();
      
    } catch (java.lang.Throwable t) {
      __ee = t;
    }
    finally {
      __bean.__WL_setMethodState(__oldState);
    }
    
    try {
      super.postInvokeLite(__wrap, __ee);
      
    } catch (java.lang.Exception e) {
      if (e instanceof javax.ejb.EJBException) {
        throw (javax.ejb.EJBException) e;
      } 
      
      else {
        throw new javax.ejb.EJBException("Unexpected exception in " +
        "desafio.ejb.geral.ProdutoBean.setId_produto():" + EOL +	
        weblogic.utils.StackTraceUtils.throwable2StackTrace(e), e);
        
        
      } 
    }
    // No return result
  }
  
  public desafio.ProdutoVO getData() throws desafio.infra.DesafioException
  {
    java.lang.Throwable __ee = null;
    
    weblogic.ejb20.internal.InvocationWrapper __wrap;
    weblogic.ejb20.internal.MethodDescriptor __md = 
    ((ProdutoBean_jhfb8g_LocalHomeImpl)getEJBLocalHome()).md_eo_getData;
    try {
      __wrap = super.preInvoke(
      __md, weblogic.ejb20.internal.DummyContextHandler.THE_ONE);
    } catch (weblogic.ejb20.internal.NeedRealContextHandlerError e) {
      __wrap = super.preInvoke(
      __md, new weblogic.ejb20.internal.EJBContextHandler(
      __md, new Object [] { }));          
    }
    
    ProdutoBean_jhfb8g_Intf __bean = (ProdutoBean_jhfb8g_Intf) __wrap.getBean();
    
    desafio.ProdutoVO result = null;
    
    int __oldState = __bean.__WL_getMethodState();
    
    try {
      __bean.__WL_setMethodState(WLEnterpriseBean.STATE_BUSINESS_METHOD);
      
      result =  __bean.getData(
      );
      ((weblogic.ejb20.persistence.spi.CMPBean) __bean).__WL_checkExistsOnMethod();
      
    } catch (java.lang.Throwable t) {
      __ee = t;
    }
    finally {
      __bean.__WL_setMethodState(__oldState);
    }
    
    try {
      super.postInvoke(__wrap, __ee);
      
    } catch (java.lang.Exception e) {
      if (e instanceof javax.ejb.EJBException) {
        throw (javax.ejb.EJBException) e;
      } 
      else if (e instanceof desafio.infra.DesafioException) {
        throw (desafio.infra.DesafioException) e;
      }
      else {
        throw new javax.ejb.EJBException("Unexpected exception in " +
        "desafio.ejb.geral.ProdutoBean.getData():" + EOL +	
        weblogic.utils.StackTraceUtils.throwable2StackTrace(e), e);
        
        
      } 
    }
    return result;
  }
  
  public void setData(desafio.ProdutoVO arg0)
  throws desafio.infra.DesafioException
  {
    java.lang.Throwable __ee = null;
    
    weblogic.ejb20.internal.InvocationWrapper __wrap;
    weblogic.ejb20.internal.MethodDescriptor __md = 
    ((ProdutoBean_jhfb8g_LocalHomeImpl)getEJBLocalHome()).md_eo_setData_desafio_ProdutoVO;
    try {
      __wrap = super.preInvoke(
      __md, weblogic.ejb20.internal.DummyContextHandler.THE_ONE);
    } catch (weblogic.ejb20.internal.NeedRealContextHandlerError e) {
      __wrap = super.preInvoke(
      __md, new weblogic.ejb20.internal.EJBContextHandler(
      __md, new Object [] {  arg0}));          
    }
    
    ProdutoBean_jhfb8g_Intf __bean = (ProdutoBean_jhfb8g_Intf) __wrap.getBean();
    
    // No return value
    
    int __oldState = __bean.__WL_getMethodState();
    
    try {
      __bean.__WL_setMethodState(WLEnterpriseBean.STATE_BUSINESS_METHOD);
      
      __bean.setData(
      arg0);
      ((weblogic.ejb20.persistence.spi.CMPBean) __bean).__WL_checkExistsOnMethod();
      
    } catch (java.lang.Throwable t) {
      __ee = t;
    }
    finally {
      __bean.__WL_setMethodState(__oldState);
    }
    
    try {
      super.postInvoke(__wrap, __ee);
      
    } catch (java.lang.Exception e) {
      if (e instanceof javax.ejb.EJBException) {
        throw (javax.ejb.EJBException) e;
      } 
      else if (e instanceof desafio.infra.DesafioException) {
        throw (desafio.infra.DesafioException) e;
      }
      else {
        throw new javax.ejb.EJBException("Unexpected exception in " +
        "desafio.ejb.geral.ProdutoBean.setData():" + EOL +	
        weblogic.utils.StackTraceUtils.throwable2StackTrace(e), e);
        
        
      } 
    }
    // No return result
  }
  
  public void setNome_produto(java.lang.String arg0)
  {
    java.lang.Throwable __ee = null;
    
    weblogic.ejb20.internal.InvocationWrapper __wrap;
    weblogic.ejb20.internal.MethodDescriptor __md = 
    ((ProdutoBean_jhfb8g_LocalHomeImpl)getEJBLocalHome()).md_eo_setNome_produto_S;
    try {
      __wrap = super.preInvokeLite(
      __md, weblogic.ejb20.internal.DummyContextHandler.THE_ONE);
    } catch (weblogic.ejb20.internal.NeedRealContextHandlerError e) {
      __wrap = super.preInvokeLite(
      __md, new weblogic.ejb20.internal.EJBContextHandler(
      __md, new Object [] {  arg0}));          
    }
    
    ProdutoBean_jhfb8g_Intf __bean = (ProdutoBean_jhfb8g_Intf) __wrap.getBean();
    
    // No return value
    
    int __oldState = __bean.__WL_getMethodState();
    
    try {
      __bean.__WL_setMethodState(WLEnterpriseBean.STATE_BUSINESS_METHOD);
      
      __bean.setNome_produto(
      arg0);
      ((weblogic.ejb20.persistence.spi.CMPBean) __bean).__WL_checkExistsOnMethod();
      
    } catch (java.lang.Throwable t) {
      __ee = t;
    }
    finally {
      __bean.__WL_setMethodState(__oldState);
    }
    
    try {
      super.postInvokeLite(__wrap, __ee);
      
    } catch (java.lang.Exception e) {
      if (e instanceof javax.ejb.EJBException) {
        throw (javax.ejb.EJBException) e;
      } 
      
      else {
        throw new javax.ejb.EJBException("Unexpected exception in " +
        "desafio.ejb.geral.ProdutoBean.setNome_produto():" + EOL +	
        weblogic.utils.StackTraceUtils.throwable2StackTrace(e), e);
        
        
      } 
    }
    // No return result
  }
  
  public java.lang.String getNome_produto()
  {
    java.lang.Throwable __ee = null;
    
    weblogic.ejb20.internal.InvocationWrapper __wrap;
    weblogic.ejb20.internal.MethodDescriptor __md = 
    ((ProdutoBean_jhfb8g_LocalHomeImpl)getEJBLocalHome()).md_eo_getNome_produto;
    try {
      __wrap = super.preInvokeLite(
      __md, weblogic.ejb20.internal.DummyContextHandler.THE_ONE);
    } catch (weblogic.ejb20.internal.NeedRealContextHandlerError e) {
      __wrap = super.preInvokeLite(
      __md, new weblogic.ejb20.internal.EJBContextHandler(
      __md, new Object [] { }));          
    }
    
    ProdutoBean_jhfb8g_Intf __bean = (ProdutoBean_jhfb8g_Intf) __wrap.getBean();
    
    java.lang.String result = null;
    
    int __oldState = __bean.__WL_getMethodState();
    
    try {
      __bean.__WL_setMethodState(WLEnterpriseBean.STATE_BUSINESS_METHOD);
      
      result =  __bean.getNome_produto(
      );
      ((weblogic.ejb20.persistence.spi.CMPBean) __bean).__WL_checkExistsOnMethod();
      
    } catch (java.lang.Throwable t) {
      __ee = t;
    }
    finally {
      __bean.__WL_setMethodState(__oldState);
    }
    
    try {
      super.postInvokeLite(__wrap, __ee);
      
    } catch (java.lang.Exception e) {
      if (e instanceof javax.ejb.EJBException) {
        throw (javax.ejb.EJBException) e;
      } 
      
      else {
        throw new javax.ejb.EJBException("Unexpected exception in " +
        "desafio.ejb.geral.ProdutoBean.getNome_produto():" + EOL +	
        weblogic.utils.StackTraceUtils.throwable2StackTrace(e), e);
        
        
      } 
    }
    return result;
  }
  
  public void validaProduto(desafio.ProdutoVO arg0)
  throws desafio.infra.DesafioException
  {
    java.lang.Throwable __ee = null;
    
    weblogic.ejb20.internal.InvocationWrapper __wrap;
    weblogic.ejb20.internal.MethodDescriptor __md = 
    ((ProdutoBean_jhfb8g_LocalHomeImpl)getEJBLocalHome()).md_eo_validaProduto_desafio_ProdutoVO;
    try {
      __wrap = super.preInvoke(
      __md, weblogic.ejb20.internal.DummyContextHandler.THE_ONE);
    } catch (weblogic.ejb20.internal.NeedRealContextHandlerError e) {
      __wrap = super.preInvoke(
      __md, new weblogic.ejb20.internal.EJBContextHandler(
      __md, new Object [] {  arg0}));          
    }
    
    ProdutoBean_jhfb8g_Intf __bean = (ProdutoBean_jhfb8g_Intf) __wrap.getBean();
    
    // No return value
    
    int __oldState = __bean.__WL_getMethodState();
    
    try {
      __bean.__WL_setMethodState(WLEnterpriseBean.STATE_BUSINESS_METHOD);
      
      __bean.validaProduto(
      arg0);
      ((weblogic.ejb20.persistence.spi.CMPBean) __bean).__WL_checkExistsOnMethod();
      
    } catch (java.lang.Throwable t) {
      __ee = t;
    }
    finally {
      __bean.__WL_setMethodState(__oldState);
    }
    
    try {
      super.postInvoke(__wrap, __ee);
      
    } catch (java.lang.Exception e) {
      if (e instanceof javax.ejb.EJBException) {
        throw (javax.ejb.EJBException) e;
      } 
      else if (e instanceof desafio.infra.DesafioException) {
        throw (desafio.infra.DesafioException) e;
      }
      else {
        throw new javax.ejb.EJBException("Unexpected exception in " +
        "desafio.ejb.geral.ProdutoBean.validaProduto():" + EOL +	
        weblogic.utils.StackTraceUtils.throwable2StackTrace(e), e);
        
        
      } 
    }
    // No return result
  }
  
  
  
  public void remove()
  throws javax.ejb.RemoveException
  {
    super.remove(((ProdutoBean_jhfb8g_LocalHomeImpl)getEJBLocalHome()).md_eo_remove);
  }
  
  private void writeObject(java.io.ObjectOutputStream out)
  throws java.io.IOException 
  {
    throw new javax.ejb.EJBException(
    "Attempt to pass a reference to an EJBLocalObject to a remote " +
    "client.  A local EJB component may only be accessed by clients " +
    "co-located in the same ear or standalone jar file.");
  }
  
  private void readObject(java.io.ObjectInputStream in)
  throws java.io.IOException, java.lang.ClassNotFoundException 
  {
    // this method is never called
    
    throw new javax.ejb.EJBException(
    "Attempt to pass a reference to an EJBLocalObject to a remote " +
    "client.  A local EJB component may only be accessed by clients " +
    "co-located in the same ear or standalone jar file.");
  }
}

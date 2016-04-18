/**
* This code was automatically generated at 11:20:45 on 18/04/2016
* by weblogic.ejb20.ejbc.Ejb2Rmi -- do not edit.
*
* @version WebLogic Server 8.1 SP6  Wed Jun 21 08:18:55 PDT 2006 781680 
* @author Copyright (c) 2016 by BEA Systems, Inc. All Rights Reserved.
*/

package desafio.ejb.geral;

import weblogic.ejb20.interfaces.WLEnterpriseBean;

public final class CategoriaProdutoBean_3k3wj0_ELOImpl
extends weblogic.ejb20.internal.EntityEJBLocalObject
implements desafio.ejb.geral.CategoriaProduto, weblogic.utils.PlatformConstants, java.io.Serializable
{
  
  public CategoriaProdutoBean_3k3wj0_ELOImpl() {}
  
  public java.lang.Long getId_categoria_pai()
  {
    java.lang.Throwable __ee = null;
    
    weblogic.ejb20.internal.InvocationWrapper __wrap;
    weblogic.ejb20.internal.MethodDescriptor __md = 
    ((CategoriaProdutoBean_3k3wj0_LocalHomeImpl)getEJBLocalHome()).md_eo_getId_categoria_pai;
    try {
      __wrap = super.preInvokeLite(
      __md, weblogic.ejb20.internal.DummyContextHandler.THE_ONE);
    } catch (weblogic.ejb20.internal.NeedRealContextHandlerError e) {
      __wrap = super.preInvokeLite(
      __md, new weblogic.ejb20.internal.EJBContextHandler(
      __md, new Object [] { }));          
    }
    
    CategoriaProdutoBean_3k3wj0_Intf __bean = (CategoriaProdutoBean_3k3wj0_Intf) __wrap.getBean();
    
    java.lang.Long result = null;
    
    int __oldState = __bean.__WL_getMethodState();
    
    try {
      __bean.__WL_setMethodState(WLEnterpriseBean.STATE_BUSINESS_METHOD);
      
      result =  __bean.getId_categoria_pai(
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
        "desafio.ejb.geral.CategoriaProdutoBean.getId_categoria_pai():" + EOL +	
        weblogic.utils.StackTraceUtils.throwable2StackTrace(e), e);
        
        
      } 
    }
    return result;
  }
  
  public java.lang.Long getId_categoria_produto()
  {
    java.lang.Throwable __ee = null;
    
    weblogic.ejb20.internal.InvocationWrapper __wrap;
    weblogic.ejb20.internal.MethodDescriptor __md = 
    ((CategoriaProdutoBean_3k3wj0_LocalHomeImpl)getEJBLocalHome()).md_eo_getId_categoria_produto;
    try {
      __wrap = super.preInvokeLite(
      __md, weblogic.ejb20.internal.DummyContextHandler.THE_ONE);
    } catch (weblogic.ejb20.internal.NeedRealContextHandlerError e) {
      __wrap = super.preInvokeLite(
      __md, new weblogic.ejb20.internal.EJBContextHandler(
      __md, new Object [] { }));          
    }
    
    CategoriaProdutoBean_3k3wj0_Intf __bean = (CategoriaProdutoBean_3k3wj0_Intf) __wrap.getBean();
    
    java.lang.Long result = null;
    
    int __oldState = __bean.__WL_getMethodState();
    
    try {
      __bean.__WL_setMethodState(WLEnterpriseBean.STATE_BUSINESS_METHOD);
      
      result =  __bean.getId_categoria_produto(
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
        "desafio.ejb.geral.CategoriaProdutoBean.getId_categoria_produto():" + EOL +	
        weblogic.utils.StackTraceUtils.throwable2StackTrace(e), e);
        
        
      } 
    }
    return result;
  }
  
  public void validaCategoriaProduto(desafio.CategoriaProdutoVO arg0)
  throws desafio.infra.DesafioException
  {
    java.lang.Throwable __ee = null;
    
    weblogic.ejb20.internal.InvocationWrapper __wrap;
    weblogic.ejb20.internal.MethodDescriptor __md = 
    ((CategoriaProdutoBean_3k3wj0_LocalHomeImpl)getEJBLocalHome()).md_eo_validaCategoriaProduto_desafio_CategoriaProdutoVO;
    try {
      __wrap = super.preInvoke(
      __md, weblogic.ejb20.internal.DummyContextHandler.THE_ONE);
    } catch (weblogic.ejb20.internal.NeedRealContextHandlerError e) {
      __wrap = super.preInvoke(
      __md, new weblogic.ejb20.internal.EJBContextHandler(
      __md, new Object [] {  arg0}));          
    }
    
    CategoriaProdutoBean_3k3wj0_Intf __bean = (CategoriaProdutoBean_3k3wj0_Intf) __wrap.getBean();
    
    // No return value
    
    int __oldState = __bean.__WL_getMethodState();
    
    try {
      __bean.__WL_setMethodState(WLEnterpriseBean.STATE_BUSINESS_METHOD);
      
      __bean.validaCategoriaProduto(
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
        "desafio.ejb.geral.CategoriaProdutoBean.validaCategoriaProduto():" + EOL +	
        weblogic.utils.StackTraceUtils.throwable2StackTrace(e), e);
        
        
      } 
    }
    // No return result
  }
  
  public void setId_categoria_produto(java.lang.Long arg0)
  {
    java.lang.Throwable __ee = null;
    
    weblogic.ejb20.internal.InvocationWrapper __wrap;
    weblogic.ejb20.internal.MethodDescriptor __md = 
    ((CategoriaProdutoBean_3k3wj0_LocalHomeImpl)getEJBLocalHome()).md_eo_setId_categoria_produto_L;
    try {
      __wrap = super.preInvokeLite(
      __md, weblogic.ejb20.internal.DummyContextHandler.THE_ONE);
    } catch (weblogic.ejb20.internal.NeedRealContextHandlerError e) {
      __wrap = super.preInvokeLite(
      __md, new weblogic.ejb20.internal.EJBContextHandler(
      __md, new Object [] {  arg0}));          
    }
    
    CategoriaProdutoBean_3k3wj0_Intf __bean = (CategoriaProdutoBean_3k3wj0_Intf) __wrap.getBean();
    
    // No return value
    
    int __oldState = __bean.__WL_getMethodState();
    
    try {
      __bean.__WL_setMethodState(WLEnterpriseBean.STATE_BUSINESS_METHOD);
      
      __bean.setId_categoria_produto(
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
        "desafio.ejb.geral.CategoriaProdutoBean.setId_categoria_produto():" + EOL +	
        weblogic.utils.StackTraceUtils.throwable2StackTrace(e), e);
        
        
      } 
    }
    // No return result
  }
  
  public desafio.CategoriaProdutoVO getData()
  throws desafio.infra.DesafioException
  {
    java.lang.Throwable __ee = null;
    
    weblogic.ejb20.internal.InvocationWrapper __wrap;
    weblogic.ejb20.internal.MethodDescriptor __md = 
    ((CategoriaProdutoBean_3k3wj0_LocalHomeImpl)getEJBLocalHome()).md_eo_getData;
    try {
      __wrap = super.preInvoke(
      __md, weblogic.ejb20.internal.DummyContextHandler.THE_ONE);
    } catch (weblogic.ejb20.internal.NeedRealContextHandlerError e) {
      __wrap = super.preInvoke(
      __md, new weblogic.ejb20.internal.EJBContextHandler(
      __md, new Object [] { }));          
    }
    
    CategoriaProdutoBean_3k3wj0_Intf __bean = (CategoriaProdutoBean_3k3wj0_Intf) __wrap.getBean();
    
    desafio.CategoriaProdutoVO result = null;
    
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
        "desafio.ejb.geral.CategoriaProdutoBean.getData():" + EOL +	
        weblogic.utils.StackTraceUtils.throwable2StackTrace(e), e);
        
        
      } 
    }
    return result;
  }
  
  public desafio.ejb.geral.CategoriaProduto getCategoriaPai()
  {
    java.lang.Throwable __ee = null;
    
    weblogic.ejb20.internal.InvocationWrapper __wrap;
    weblogic.ejb20.internal.MethodDescriptor __md = 
    ((CategoriaProdutoBean_3k3wj0_LocalHomeImpl)getEJBLocalHome()).md_eo_getCategoriaPai;
    try {
      __wrap = super.preInvoke(
      __md, weblogic.ejb20.internal.DummyContextHandler.THE_ONE);
    } catch (weblogic.ejb20.internal.NeedRealContextHandlerError e) {
      __wrap = super.preInvoke(
      __md, new weblogic.ejb20.internal.EJBContextHandler(
      __md, new Object [] { }));          
    }
    
    CategoriaProdutoBean_3k3wj0_Intf __bean = (CategoriaProdutoBean_3k3wj0_Intf) __wrap.getBean();
    
    desafio.ejb.geral.CategoriaProduto result = null;
    
    int __oldState = __bean.__WL_getMethodState();
    
    try {
      __bean.__WL_setMethodState(WLEnterpriseBean.STATE_BUSINESS_METHOD);
      
      result =  __bean.getCategoriaPai(
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
      
      else {
        throw new javax.ejb.EJBException("Unexpected exception in " +
        "desafio.ejb.geral.CategoriaProdutoBean.getCategoriaPai():" + EOL +	
        weblogic.utils.StackTraceUtils.throwable2StackTrace(e), e);
        
        
      } 
    }
    return result;
  }
  
  public void setId_categoria_pai(java.lang.Long arg0)
  {
    java.lang.Throwable __ee = null;
    
    weblogic.ejb20.internal.InvocationWrapper __wrap;
    weblogic.ejb20.internal.MethodDescriptor __md = 
    ((CategoriaProdutoBean_3k3wj0_LocalHomeImpl)getEJBLocalHome()).md_eo_setId_categoria_pai_L;
    try {
      __wrap = super.preInvokeLite(
      __md, weblogic.ejb20.internal.DummyContextHandler.THE_ONE);
    } catch (weblogic.ejb20.internal.NeedRealContextHandlerError e) {
      __wrap = super.preInvokeLite(
      __md, new weblogic.ejb20.internal.EJBContextHandler(
      __md, new Object [] {  arg0}));          
    }
    
    CategoriaProdutoBean_3k3wj0_Intf __bean = (CategoriaProdutoBean_3k3wj0_Intf) __wrap.getBean();
    
    // No return value
    
    int __oldState = __bean.__WL_getMethodState();
    
    try {
      __bean.__WL_setMethodState(WLEnterpriseBean.STATE_BUSINESS_METHOD);
      
      __bean.setId_categoria_pai(
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
        "desafio.ejb.geral.CategoriaProdutoBean.setId_categoria_pai():" + EOL +	
        weblogic.utils.StackTraceUtils.throwable2StackTrace(e), e);
        
        
      } 
    }
    // No return result
  }
  
  public void setCategoriaPai(desafio.ejb.geral.CategoriaProduto arg0)
  {
    java.lang.Throwable __ee = null;
    
    weblogic.ejb20.internal.InvocationWrapper __wrap;
    weblogic.ejb20.internal.MethodDescriptor __md = 
    ((CategoriaProdutoBean_3k3wj0_LocalHomeImpl)getEJBLocalHome()).md_eo_setCategoriaPai_desafio_ejb_geral_CategoriaProduto;
    try {
      __wrap = super.preInvoke(
      __md, weblogic.ejb20.internal.DummyContextHandler.THE_ONE);
    } catch (weblogic.ejb20.internal.NeedRealContextHandlerError e) {
      __wrap = super.preInvoke(
      __md, new weblogic.ejb20.internal.EJBContextHandler(
      __md, new Object [] {  arg0}));          
    }
    
    CategoriaProdutoBean_3k3wj0_Intf __bean = (CategoriaProdutoBean_3k3wj0_Intf) __wrap.getBean();
    
    // No return value
    
    int __oldState = __bean.__WL_getMethodState();
    
    try {
      __bean.__WL_setMethodState(WLEnterpriseBean.STATE_BUSINESS_METHOD);
      
      __bean.setCategoriaPai(
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
      
      else {
        throw new javax.ejb.EJBException("Unexpected exception in " +
        "desafio.ejb.geral.CategoriaProdutoBean.setCategoriaPai():" + EOL +	
        weblogic.utils.StackTraceUtils.throwable2StackTrace(e), e);
        
        
      } 
    }
    // No return result
  }
  
  public void setNome_categoria_produto(java.lang.String arg0)
  {
    java.lang.Throwable __ee = null;
    
    weblogic.ejb20.internal.InvocationWrapper __wrap;
    weblogic.ejb20.internal.MethodDescriptor __md = 
    ((CategoriaProdutoBean_3k3wj0_LocalHomeImpl)getEJBLocalHome()).md_eo_setNome_categoria_produto_S;
    try {
      __wrap = super.preInvokeLite(
      __md, weblogic.ejb20.internal.DummyContextHandler.THE_ONE);
    } catch (weblogic.ejb20.internal.NeedRealContextHandlerError e) {
      __wrap = super.preInvokeLite(
      __md, new weblogic.ejb20.internal.EJBContextHandler(
      __md, new Object [] {  arg0}));          
    }
    
    CategoriaProdutoBean_3k3wj0_Intf __bean = (CategoriaProdutoBean_3k3wj0_Intf) __wrap.getBean();
    
    // No return value
    
    int __oldState = __bean.__WL_getMethodState();
    
    try {
      __bean.__WL_setMethodState(WLEnterpriseBean.STATE_BUSINESS_METHOD);
      
      __bean.setNome_categoria_produto(
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
        "desafio.ejb.geral.CategoriaProdutoBean.setNome_categoria_produto():" + EOL +	
        weblogic.utils.StackTraceUtils.throwable2StackTrace(e), e);
        
        
      } 
    }
    // No return result
  }
  
  public java.lang.String getNome_categoria_produto()
  {
    java.lang.Throwable __ee = null;
    
    weblogic.ejb20.internal.InvocationWrapper __wrap;
    weblogic.ejb20.internal.MethodDescriptor __md = 
    ((CategoriaProdutoBean_3k3wj0_LocalHomeImpl)getEJBLocalHome()).md_eo_getNome_categoria_produto;
    try {
      __wrap = super.preInvokeLite(
      __md, weblogic.ejb20.internal.DummyContextHandler.THE_ONE);
    } catch (weblogic.ejb20.internal.NeedRealContextHandlerError e) {
      __wrap = super.preInvokeLite(
      __md, new weblogic.ejb20.internal.EJBContextHandler(
      __md, new Object [] { }));          
    }
    
    CategoriaProdutoBean_3k3wj0_Intf __bean = (CategoriaProdutoBean_3k3wj0_Intf) __wrap.getBean();
    
    java.lang.String result = null;
    
    int __oldState = __bean.__WL_getMethodState();
    
    try {
      __bean.__WL_setMethodState(WLEnterpriseBean.STATE_BUSINESS_METHOD);
      
      result =  __bean.getNome_categoria_produto(
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
        "desafio.ejb.geral.CategoriaProdutoBean.getNome_categoria_produto():" + EOL +	
        weblogic.utils.StackTraceUtils.throwable2StackTrace(e), e);
        
        
      } 
    }
    return result;
  }
  
  public void setData(desafio.CategoriaProdutoVO arg0)
  throws desafio.infra.DesafioException
  {
    java.lang.Throwable __ee = null;
    
    weblogic.ejb20.internal.InvocationWrapper __wrap;
    weblogic.ejb20.internal.MethodDescriptor __md = 
    ((CategoriaProdutoBean_3k3wj0_LocalHomeImpl)getEJBLocalHome()).md_eo_setData_desafio_CategoriaProdutoVO;
    try {
      __wrap = super.preInvoke(
      __md, weblogic.ejb20.internal.DummyContextHandler.THE_ONE);
    } catch (weblogic.ejb20.internal.NeedRealContextHandlerError e) {
      __wrap = super.preInvoke(
      __md, new weblogic.ejb20.internal.EJBContextHandler(
      __md, new Object [] {  arg0}));          
    }
    
    CategoriaProdutoBean_3k3wj0_Intf __bean = (CategoriaProdutoBean_3k3wj0_Intf) __wrap.getBean();
    
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
        "desafio.ejb.geral.CategoriaProdutoBean.setData():" + EOL +	
        weblogic.utils.StackTraceUtils.throwable2StackTrace(e), e);
        
        
      } 
    }
    // No return result
  }
  
  
  
  public void remove()
  throws javax.ejb.RemoveException
  {
    super.remove(((CategoriaProdutoBean_3k3wj0_LocalHomeImpl)getEJBLocalHome()).md_eo_remove);
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


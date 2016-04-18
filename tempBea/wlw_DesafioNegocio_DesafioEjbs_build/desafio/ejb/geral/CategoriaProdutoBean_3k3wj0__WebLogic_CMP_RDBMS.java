/**
 * This code was automatically generated at 11:20:45 on 18/04/2016
 * by weblogic.ejb20.cmp.rdbms.codegen.RDBMSCodeGenerator -- do not edit.
 *
 * @version WebLogic Server 8.1 SP6  Wed Jun 21 08:18:55 PDT 2006 781680 
 * @author Copyright (c) 2016 by BEA Systems, Inc. All Rights Reserved.
 */

package desafio.ejb.geral;

import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.io.IOException;

import javax.ejb.EntityContext;
import javax.ejb.EJBException;
import javax.ejb.EJBObject;
import javax.ejb.ObjectNotFoundException;
import javax.ejb.NoSuchEntityException;
import javax.ejb.Handle;
import javax.ejb.HomeHandle;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingEnumeration;
import javax.naming.NameClassPair;
import javax.rmi.PortableRemoteObject;
import javax.transaction.Transaction;
import javax.transaction.TransactionManager;

import weblogic.ejb.OptimisticConcurrencyException;
import weblogic.ejb20.InternalException;
import weblogic.ejb20.internal.EJBRuntimeUtils;
import weblogic.ejb20.internal.EntityEJBContextImpl;
import weblogic.ejb20.interfaces.WLEnterpriseBean;
import weblogic.ejb20.interfaces.CachingManager;
import weblogic.ejb20.persistence.RSInfoImpl;
import weblogic.ejb20.persistence.spi.CMPBean;
import weblogic.ejb20.persistence.spi.CMPBeanManager;
import weblogic.ejb20.persistence.spi.PersistenceManager;
import weblogic.ejb20.persistence.spi.PersistenceRuntimeException;
import weblogic.ejb20.persistence.spi.RSInfo;

import weblogic.ejb20.cmp.rdbms.RDBMSObjectInputStream;
import weblogic.ejb20.cmp.rdbms.RDBMSPersistenceManager;
import weblogic.ejb20.cmp.rdbms.RDBMSException;
import weblogic.ejb20.cmp.rdbms.RDBMSUtils;
import weblogic.ejb20.cmp.rdbms.RDBMSM2NSet;
import weblogic.ejb20.cmp.rdbms.RDBMSSet;

import weblogic.transaction.TransactionHelper;
import weblogic.ejb20.dd.DDConstants;

import weblogic.ejb20.EJBLogger;
import weblogic.logging.Loggable;

import weblogic.utils.Debug;

public final class CategoriaProdutoBean_3k3wj0__WebLogic_CMP_RDBMS extends desafio.ejb.geral.CategoriaProdutoBean
  implements CMPBean, CategoriaProdutoBean_3k3wj0_Intf
{
  // =================================================================
  // Class variable(s)
  private static final boolean __WL_debug =
    (System.getProperty(RDBMSUtils.RDBMS_CODEGEN_DEBUG_PROP) != null);
  private static final boolean __WL_verbose =
    (System.getProperty(RDBMSUtils.RDBMS_CODEGEN_VERBOSE_PROP) != null);

  private static String EOL = System.getProperty("line.separator");

  private static final java.lang.reflect.Method __WL_produtoCategoriaProdutoBean_categoriaProduto_finder_;
private static final java.lang.reflect.Method __WL_categoriaPai_finder_;
private static final java.lang.reflect.Method __WL_categoriaProdutoBean_categoriaPai_finder_;

static {
Method m = null;
try {
m = desafio.ejb.geral.ProdutoCategoriaProdutoBean_vhvw4g_Intf.class.getMethod("ejbFindByCategoriaProdutoBean_3k3wj0__WebLogic_CMP_RDBMS_produtoCategoriaProdutoBean_categoriaProduto__WL_", new Class[] {java.lang.Long.class });
} catch (NoSuchMethodException ignore) {
m = null;
}
__WL_produtoCategoriaProdutoBean_categoriaProduto_finder_ = m;
try {
m = desafio.ejb.geral.CategoriaProdutoBean_3k3wj0_Intf.class.getMethod("ejbFindByCategoriaProdutoBean_3k3wj0__WebLogic_CMP_RDBMS_categoriaPai__WL_", new Class[] {java.lang.Long.class });
} catch (NoSuchMethodException ignore) {
m = null;
}
__WL_categoriaPai_finder_ = m;
try {
m = desafio.ejb.geral.CategoriaProdutoBean_3k3wj0_Intf.class.getMethod("ejbFindByCategoriaProdutoBean_3k3wj0__WebLogic_CMP_RDBMS_categoriaProdutoBean_categoriaPai__WL_", new Class[] {java.lang.Long.class });
} catch (NoSuchMethodException ignore) {
m = null;
}
__WL_categoriaProdutoBean_categoriaPai_finder_ = m;
}


  

  // =================================================================
  // ejbSelect Methods Defined on CMR Beans
  


  // =================================================================
  // Instance variable(s)
   
  

  private javax.ejb.EJBContext __WL_EJBContext;

  private int __WL_method_state;

  private short __WL_bean_state;

  private boolean __WL_isRemoved = false;

  private boolean __WL_busy = false;
  
  private boolean __WL_isLocal = true;

  private boolean __WL_needsRemove;

  private Object __WL_loadUser;

  private boolean __WL_creatorOfTx;

  private boolean __WL_createAfterRemove = false;
  
  private EntityContext __WL_ctx;
  private RDBMSPersistenceManager __WL_pm;
private ClassLoader __WL_classLoader;
private CMPBeanManager __WL_produtoCategoriaProdutoBean_categoriaProduto_bm;
private CMPBeanManager __WL_categoriaPai_bm;
private CMPBeanManager __WL_categoriaProdutoBean_categoriaPai_bm;


  public java.lang.Long id_categoria_pai;
public java.lang.Long id_categoria_produto;
public java.lang.String nome_categoria_produto;


  
  public java.util.Collection __WL_produtoCategoriaProdutoBean_categoriaProduto_field_;
public desafio.ejb.geral.CategoriaProduto __WL_categoriaPai_field_;
public java.util.Collection __WL_categoriaProdutoBean_categoriaPai_field_;


  

  private boolean[] __WL_isModified = new boolean[3];
private boolean __WL_modifiedBeanIsRegistered= false;

  private boolean __WL_invalidatedBeanIsRegistered= false;

  private boolean[] __WL_isLoaded = new boolean[3];
private boolean __WL_beanIsLoaded= false;

  public boolean __WL_produtoCategoriaProdutoBean_categoriaProduto_isLoaded_ = false;
public boolean __WL_categoriaPai_isLoaded_ = false;
public boolean __WL_categoriaProdutoBean_categoriaPai_isLoaded_ = false;

  // for remote relationships
  
  
  

  // =================================================================
  // Constructor(s)
  public CategoriaProdutoBean_3k3wj0__WebLogic_CMP_RDBMS()  {
    super();

    __WL_initialize();

    
  }

  // This method is called by ejbLoad, ejbPassivate, and ejbRemove
  // to initialize the persistent state of the bean and its associated
  // variables.
  public void __WL_initialize()
  {
    __WL_initialize(true);
  }

  public void __WL_initialize(boolean __WL_initSnapshotVars)
  {
    __WL_initialize_persistent(__WL_initSnapshotVars);

    __WL_beanIsLoaded = false;
    
    __WL_modifiedBeanIsRegistered = false;

    
__WL_produtoCategoriaProdutoBean_categoriaProduto_isLoaded_ = false;
__WL_categoriaPai_isLoaded_ = false;
__WL_categoriaProdutoBean_categoriaPai_isLoaded_ = false;


    //cached relationship state
    
__WL_produtoCategoriaProdutoBean_categoriaProduto_field_ = null;
__WL_categoriaPai_field_ = null;
__WL_categoriaProdutoBean_categoriaPai_field_ = null;


  }

  private void __WL_initialize_persistent(boolean __WL_initSnapshotVars)
  {
    for (int __WL_i = 0; __WL_i < 3; __WL_i++) {
       __WL_isLoaded[__WL_i] = false;
       __WL_isModified[__WL_i] = false;

    }

    
nome_categoria_produto = null;
id_categoria_pai = null;
id_categoria_produto = null;

    if (__WL_initSnapshotVars) {
      
    }
  }
  
  // ================================================================
  // Method(s)

  public javax.transaction.Transaction __WL_getBeanManagedTransaction() {
    throw new AssertionError("Entity beans can't have"
        + " bean-managed transactions");
  }

  public void __WL_setBeanManagedTransaction(javax.transaction.Transaction tx) {
    throw new AssertionError("Entity beans can't have"
        + " bean-managed transactions");

  }

  public boolean __WL_isBusy() { return __WL_busy; }
  public void __WL_setBusy(boolean b) { __WL_busy = b; }

  public boolean __WL_getIsLocal() { return __WL_isLocal; }
  public void __WL_setIsLocal(boolean b) { __WL_isLocal = b; }

  public int __WL_getMethodState() { return __WL_method_state; }
  public void __WL_setMethodState(int state) { __WL_method_state = state; }

  public boolean __WL_needsRemove() { return __WL_needsRemove; }
  public void __WL_setNeedsRemove(boolean b) { __WL_needsRemove = b; }

  public void __WL_setCreatorOfTx ( boolean b) { __WL_creatorOfTx = b; }
  public boolean __WL_isCreatorOfTx() { return __WL_creatorOfTx; }
  
  public javax.ejb.EJBContext __WL_getEJBContext() { return __WL_EJBContext; }
  public void __WL_setEJBContext(javax.ejb.EJBContext ctx) {
    __WL_EJBContext = ctx;
  }

  public void __WL_setLoadUser(Object o) { __WL_loadUser = o;}
  public Object __WL_getLoadUser() { return __WL_loadUser; } 

  public void setEntityContext(javax.ejb.EntityContext arg0) {
    int __WL_oldState = __WL_method_state;
    try {
      __WL_method_state = STATE_SET_CONTEXT;
      super.setEntityContext(arg0);
      this.__WL_ctx = arg0;
    } finally {
      __WL_method_state = __WL_oldState;
    }
  }

  public void unsetEntityContext()
    
  {
    int __WL_oldState = __WL_method_state;
    try {
      __WL_method_state = STATE_UNSET_CONTEXT;
      super.unsetEntityContext();
    } finally {
      __WL_method_state = __WL_oldState;
    }
  }

  public void ejbActivate()
    
  {
    int __WL_oldState = __WL_method_state;
    try {
      __WL_method_state = STATE_EJB_ACTIVATE;
      super.ejbActivate();
    } finally {
      __WL_method_state = __WL_oldState;
    }
  }


  // ================================================================
  // Getter and Setter methods.
    public java.lang.Long getId_categoria_pai()
  {
    try {
            if (!(__WL_isLoaded[0] || __WL_isModified[0])) {
        __WL_loadGroup0();
      }

      return id_categoria_pai;
        } catch (RuntimeException re) {
      if (__WL_verbose) {
        Debug.say("rethrowing RuntimeException.");
        re.printStackTrace();
      }
      throw re;
    } catch (Exception ex) {
      if (__WL_verbose) {
        Debug.say("wrapping Exception in PersistenceRuntimeException.");
        ex.printStackTrace();
      }
      throw new PersistenceRuntimeException(ex);
    }

  }
  public void setId_categoria_pai(
    java.lang.Long id_categoria_pai)
  {
    Loggable l = EJBLogger.logcannotCallSetOnCmpCmrFieldLoggable();throw new EJBException(l.getMessage());


  }

  public java.lang.Long getId_categoria_produto()
  {
    try {
            if (!(__WL_isLoaded[1] || __WL_isModified[1])) {
        __WL_loadGroup0();
      }

      return id_categoria_produto;
        } catch (RuntimeException re) {
      if (__WL_verbose) {
        Debug.say("rethrowing RuntimeException.");
        re.printStackTrace();
      }
      throw re;
    } catch (Exception ex) {
      if (__WL_verbose) {
        Debug.say("wrapping Exception in PersistenceRuntimeException.");
        ex.printStackTrace();
      }
      throw new PersistenceRuntimeException(ex);
    }

  }
  public void setId_categoria_produto(
    java.lang.Long id_categoria_produto)
  {
    if (__WL_method_state!=STATE_EJB_CREATE) {
Loggable l = EJBLogger.logcannotCallSetOnPkLoggable();throw new IllegalStateException(l.getMessage());}
    
    this.id_categoria_produto = id_categoria_produto;
    __WL_isModified[1] = true;
    
        if (! __WL_modifiedBeanIsRegistered) {
      __WL_pm.registerModifiedBean(__WL_ctx.getPrimaryKey());
      __WL_modifiedBeanIsRegistered = true;
    }


  }

  public java.lang.String getNome_categoria_produto()
  {
    try {
            if (!(__WL_isLoaded[2] || __WL_isModified[2])) {
        __WL_loadGroup0();
      }

      return nome_categoria_produto;
        } catch (RuntimeException re) {
      if (__WL_verbose) {
        Debug.say("rethrowing RuntimeException.");
        re.printStackTrace();
      }
      throw re;
    } catch (Exception ex) {
      if (__WL_verbose) {
        Debug.say("wrapping Exception in PersistenceRuntimeException.");
        ex.printStackTrace();
      }
      throw new PersistenceRuntimeException(ex);
    }

  }
  public void setNome_categoria_produto(
    java.lang.String nome_categoria_produto)
  {
        if ((this.nome_categoria_produto == nome_categoria_produto || (this.nome_categoria_produto!=null && this.nome_categoria_produto.equals(nome_categoria_produto))) && __WL_isLoaded[2]) return;

    this.nome_categoria_produto = nome_categoria_produto;
    __WL_isModified[2] = true;
    
        if (! __WL_modifiedBeanIsRegistered) {
      __WL_pm.registerModifiedBean(__WL_ctx.getPrimaryKey());
      __WL_modifiedBeanIsRegistered = true;
    }


  }


  public java.util.Collection getProdutoCategoriaProdutoBean_categoriaProduto() {
    try {
      if (__WL_produtoCategoriaProdutoBean_categoriaProduto_field_==null) {
         if (__WL_verbose) {
            Debug.say("\t__WL_produtoCategoriaProdutoBean_categoriaProduto_field_ was null.");
         }

         __WL_produtoCategoriaProdutoBean_categoriaProduto_field_ = new CategoriaProdutoBean_3k3wj0__WebLogic_CMP_RDBMS_produtoCategoriaProdutoBean_categoriaProduto_Set(this, __WL_produtoCategoriaProdutoBean_categoriaProduto_bm, __WL_produtoCategoriaProdutoBean_categoriaProduto_finder_);

      }
      Transaction currentTx =
        TransactionHelper.getTransactionHelper().getTransaction();
      if(currentTx != null && ((RDBMSSet)__WL_produtoCategoriaProdutoBean_categoriaProduto_field_)
                         .checkIfCurrentTxEqualsCreateTx(currentTx)) {
        return __WL_produtoCategoriaProdutoBean_categoriaProduto_field_;
      } else {
        __WL_produtoCategoriaProdutoBean_categoriaProduto_field_ = (Set)(((CategoriaProdutoBean_3k3wj0__WebLogic_CMP_RDBMS_produtoCategoriaProdutoBean_categoriaProduto_Set)
                 __WL_produtoCategoriaProdutoBean_categoriaProduto_field_).clone());
        ((RDBMSSet)__WL_produtoCategoriaProdutoBean_categoriaProduto_field_).setTransaction(currentTx);
	((RDBMSSet)__WL_produtoCategoriaProdutoBean_categoriaProduto_field_).setIsCreatorBeanInvalidated(false);
        return __WL_produtoCategoriaProdutoBean_categoriaProduto_field_;
      }
       
        } catch (RuntimeException re) {
      if (__WL_verbose) {
        Debug.say("rethrowing RuntimeException.");
        re.printStackTrace();
      }
      throw re;
    } catch (Exception ex) {
      if (__WL_verbose) {
        Debug.say("wrapping Exception in PersistenceRuntimeException.");
        ex.printStackTrace();
      }
      throw new PersistenceRuntimeException(ex);
    }

}
public void setProdutoCategoriaProdutoBean_categoriaProduto(java.util.Collection produtoCategoriaProdutoBean_categoriaProduto) {
Loggable l = EJBLogger.logsetCheckForCmrFieldAsPkLoggable();throw new EJBException(l.getMessage());

}

public void __WL_add__WL_produtoCategoriaProdutoBean_categoriaProduto_field_(Object produtoCategoriaProdutoBean_categoriaProduto) {
if (__WL_produtoCategoriaProdutoBean_categoriaProduto_field_ == null) {
__WL_produtoCategoriaProdutoBean_categoriaProduto_field_ = new CategoriaProdutoBean_3k3wj0__WebLogic_CMP_RDBMS_produtoCategoriaProdutoBean_categoriaProduto_Set(this, __WL_produtoCategoriaProdutoBean_categoriaProduto_bm, __WL_produtoCategoriaProdutoBean_categoriaProduto_finder_);

}
((RDBMSSet)__WL_produtoCategoriaProdutoBean_categoriaProduto_field_).doAddToCache(produtoCategoriaProdutoBean_categoriaProduto);
__WL_produtoCategoriaProdutoBean_categoriaProduto_isLoaded_ = true;
}

public desafio.ejb.geral.CategoriaProduto getCategoriaPai() {
    try {
      if (!__WL_isLoaded[0]) __WL_loadGroup0();


      if (__WL_categoriaPai_field_==null) {
        
        
        
        if (!(id_categoria_pai==null)) {
          Transaction orgTx = 
            TransactionHelper.getTransactionHelper().getTransaction();
          try {
            __WL_categoriaPai_field_ = (desafio.ejb.geral.CategoriaProduto)__WL_categoriaPai_bm.localFindByPrimaryKey( 
__WL_categoriaPai_finder_, this.id_categoria_pai);

          } finally {
            
          }       
        }
      }

      return __WL_categoriaPai_field_;
        } catch (RuntimeException re) {
      if (__WL_verbose) {
        Debug.say("rethrowing RuntimeException.");
        re.printStackTrace();
      }
      throw re;
    } catch (Exception ex) {
      if (__WL_verbose) {
        Debug.say("wrapping Exception in PersistenceRuntimeException.");
        ex.printStackTrace();
      }
      throw new PersistenceRuntimeException(ex);
    }

}
public void setCategoriaPai(desafio.ejb.geral.CategoriaProduto categoriaPai) {
if (__WL_method_state==STATE_EJB_CREATE) {
Loggable l = EJBLogger.logsetCheckForCmrFieldDuringEjbCreateLoggable();throw new IllegalStateException(l.getMessage());
}
__WL_setCategoriaPai(categoriaPai, false);
}
public void __WL_setCategoriaPai(desafio.ejb.geral.CategoriaProduto categoriaPai, boolean ejbStore) {
__WL_setCategoriaPai(categoriaPai, ejbStore, true);
}

// The flag 'remove' controls whether the Relationship's
// underlying __WL_cache does a remove() operation.
// If an Iterator of the __WL_cache is used to effect a remove()
// then we must be sure to not to do a__WL_cache.remove()
//   that is the intended use of the 'remove' flag.

public void __WL_setCategoriaPai(desafio.ejb.geral.CategoriaProduto categoriaPai, boolean ejbStore, boolean remove) {
    try {
          if (!__WL_isLoaded[0]) __WL_loadGroup0();


    if (!(id_categoria_pai==null)) {
      
      
      

      desafio.ejb.geral.CategoriaProdutoBean_3k3wj0_Intf __WL_bean =
        (desafio.ejb.geral.CategoriaProdutoBean_3k3wj0_Intf)__WL_categoriaPai_bm.lookup(this.id_categoria_pai);
      int __WL_oldState = __WL_bean.__WL_getMethodState();
      try {
        __WL_bean.__WL_setMethodState(WLEnterpriseBean.STATE_BUSINESS_METHOD);
        RDBMSSet __WL_collection = (RDBMSSet)
          __WL_bean.getCategoriaProdutoBean_categoriaPai();
        __WL_collection.doRemove(__WL_ctx.getEJBLocalObject(), remove);
      } finally {
        __WL_bean.__WL_setMethodState(__WL_oldState);
      }
    }


      __WL_doSetCategoriaPai(categoriaPai);

      __WL_postSetCategoriaPai();


      if (ejbStore) ejbStore();
        } catch (RuntimeException re) {
      if (__WL_verbose) {
        Debug.say("rethrowing RuntimeException.");
        re.printStackTrace();
      }
      throw re;
    } catch (Exception ex) {
      if (__WL_verbose) {
        Debug.say("wrapping Exception in PersistenceRuntimeException.");
        ex.printStackTrace();
      }
      throw new PersistenceRuntimeException(ex);
    }

}

private void __WL_postSetCategoriaPai() throws java.lang.Exception {
    if (!(id_categoria_pai==null)) {
      
      
      
      desafio.ejb.geral.CategoriaProdutoBean_3k3wj0_Intf __WL_bean = (desafio.ejb.geral.CategoriaProdutoBean_3k3wj0_Intf)
        __WL_categoriaPai_bm.lookup(this.id_categoria_pai);

      int __WL_oldState = __WL_bean.__WL_getMethodState();
      try {
        __WL_bean.__WL_setMethodState(WLEnterpriseBean.STATE_BUSINESS_METHOD);
	      
            if ((__WL_bean.__WL_beanIsLoaded() && __WL_bean.__WL_getIsRemoved()) ||
        (!__WL_bean.__WL_beanIsLoaded() && !__WL_bean.__WL_exists(this.id_categoria_pai))) {
      Loggable l = EJBLogger.logillegalAttemptToAssignRemovedBeanToCMRFieldLoggable(
        this.id_categoria_pai.toString());
      throw new IllegalArgumentException(l.getMessage());
    }


        RDBMSSet __WL_collection = (RDBMSSet)
          __WL_bean.getCategoriaProdutoBean_categoriaPai();
        __WL_collection.doAdd(__WL_ctx.getEJBLocalObject());
      } finally {
        __WL_bean.__WL_setMethodState(__WL_oldState);
      }
    }
}

public void __WL_doSetCategoriaPai(desafio.ejb.geral.CategoriaProduto categoriaPai) {
    try {
      if (!__WL_isLoaded[0]) __WL_loadGroup0();

      if (__WL_verbose) {
        Debug.say("[" + __WL_ctx.getPrimaryKey() +
                  "]called __WL_doSetCategoriaPai...");
      }
      __WL_categoriaPai_field_ = categoriaPai;
      if (__WL_categoriaPai_field_ == null) {
        if (__WL_verbose) {
          Debug.say("setting field variable to null.");
        }
        id_categoria_pai = null;
__WL_isModified[0] = true;

      }
      else {
        if (__WL_verbose) {
          Debug.say("setting field variable to new value.");
        }
        id_categoria_pai = (java.lang.Long)__WL_categoriaPai_field_.getPrimaryKey();
__WL_isModified[0] = true;

      }
          if (! __WL_modifiedBeanIsRegistered) {
      __WL_pm.registerModifiedBean(__WL_ctx.getPrimaryKey());
      __WL_modifiedBeanIsRegistered = true;
    }

        } catch (RuntimeException re) {
      if (__WL_verbose) {
        Debug.say("rethrowing RuntimeException.");
        re.printStackTrace();
      }
      throw re;
    } catch (Exception ex) {
      if (__WL_verbose) {
        Debug.say("wrapping Exception in PersistenceRuntimeException.");
        ex.printStackTrace();
      }
      throw new PersistenceRuntimeException(ex);
    }

}

public void __WL_add__WL_categoriaPai_field_(Object categoriaPai) {
if (categoriaPai != null) {
__WL_categoriaPai_field_ = (desafio.ejb.geral.CategoriaProduto) categoriaPai;
}
__WL_categoriaPai_isLoaded_ = true;
}

public java.util.Collection getCategoriaProdutoBean_categoriaPai() {
    try {
      if (__WL_categoriaProdutoBean_categoriaPai_field_==null) {
         if (__WL_verbose) {
            Debug.say("\t__WL_categoriaProdutoBean_categoriaPai_field_ was null.");
         }

         __WL_categoriaProdutoBean_categoriaPai_field_ = new CategoriaProdutoBean_3k3wj0__WebLogic_CMP_RDBMS_categoriaProdutoBean_categoriaPai_Set(this, __WL_categoriaProdutoBean_categoriaPai_bm, __WL_categoriaProdutoBean_categoriaPai_finder_);

      }
      Transaction currentTx =
        TransactionHelper.getTransactionHelper().getTransaction();
      if(currentTx != null && ((RDBMSSet)__WL_categoriaProdutoBean_categoriaPai_field_)
                         .checkIfCurrentTxEqualsCreateTx(currentTx)) {
        return __WL_categoriaProdutoBean_categoriaPai_field_;
      } else {
        __WL_categoriaProdutoBean_categoriaPai_field_ = (Set)(((CategoriaProdutoBean_3k3wj0__WebLogic_CMP_RDBMS_categoriaProdutoBean_categoriaPai_Set)
                 __WL_categoriaProdutoBean_categoriaPai_field_).clone());
        ((RDBMSSet)__WL_categoriaProdutoBean_categoriaPai_field_).setTransaction(currentTx);
	((RDBMSSet)__WL_categoriaProdutoBean_categoriaPai_field_).setIsCreatorBeanInvalidated(false);
        return __WL_categoriaProdutoBean_categoriaPai_field_;
      }
       
        } catch (RuntimeException re) {
      if (__WL_verbose) {
        Debug.say("rethrowing RuntimeException.");
        re.printStackTrace();
      }
      throw re;
    } catch (Exception ex) {
      if (__WL_verbose) {
        Debug.say("wrapping Exception in PersistenceRuntimeException.");
        ex.printStackTrace();
      }
      throw new PersistenceRuntimeException(ex);
    }

}
public void setCategoriaProdutoBean_categoriaPai(java.util.Collection categoriaProdutoBean_categoriaPai) {
if (__WL_method_state==STATE_EJB_CREATE) {
Loggable l = EJBLogger.logsetCheckForCmrFieldDuringEjbCreateLoggable();throw new IllegalStateException(l.getMessage());
}
    if (categoriaProdutoBean_categoriaPai==null) {
      Loggable l = EJBLogger.lognullAssignedToCmrFieldLoggable();
      throw new IllegalArgumentException(l.getMessage());
   
    }

    try {
      getCategoriaProdutoBean_categoriaPai();

      if (categoriaProdutoBean_categoriaPai==__WL_categoriaProdutoBean_categoriaPai_field_)
        return;

      __WL_categoriaProdutoBean_categoriaPai_field_.clear();
      __WL_categoriaProdutoBean_categoriaPai_field_.addAll(categoriaProdutoBean_categoriaPai);
        } catch (RuntimeException re) {
      if (__WL_verbose) {
        Debug.say("rethrowing RuntimeException.");
        re.printStackTrace();
      }
      throw re;
    } catch (Exception ex) {
      if (__WL_verbose) {
        Debug.say("wrapping Exception in PersistenceRuntimeException.");
        ex.printStackTrace();
      }
      throw new PersistenceRuntimeException(ex);
    }

}

public void __WL_add__WL_categoriaProdutoBean_categoriaPai_field_(Object categoriaProdutoBean_categoriaPai) {
if (__WL_categoriaProdutoBean_categoriaPai_field_ == null) {
__WL_categoriaProdutoBean_categoriaPai_field_ = new CategoriaProdutoBean_3k3wj0__WebLogic_CMP_RDBMS_categoriaProdutoBean_categoriaPai_Set(this, __WL_categoriaProdutoBean_categoriaPai_bm, __WL_categoriaProdutoBean_categoriaPai_finder_);

}
((RDBMSSet)__WL_categoriaProdutoBean_categoriaPai_field_).doAddToCache(categoriaProdutoBean_categoriaPai);
__WL_categoriaProdutoBean_categoriaPai_isLoaded_ = true;
}


  

  //=================================================================
  //Finder methods.
  public java.lang.Object ejbFindByPrimaryKey(java.lang.Long param0) throws javax.ejb.FinderException
    {
    if(__WL_verbose) {
      Debug.say("called findByPrimaryKey.");
    }

    java.sql.Connection __WL_con = null;
    java.sql.PreparedStatement __WL_stmt = null;
    java.sql.ResultSet __WL_rs = null;
    int __WL_offset = 0;
    desafio.ejb.geral.CategoriaProdutoBean_3k3wj0__WebLogic_CMP_RDBMS __WL_bean = null;
Object __WL_eo = null;
Object __WL_eo_rc = null;

    

    

    int selectForUpdateVal = __WL_pm.getSelectForUpdateValue();

    java.lang.String __WL_query = null;

    switch(selectForUpdateVal) {
      case DDConstants.SELECT_FOR_UPDATE_DISABLED:
	__WL_query = "SELECT WL0.ID_CATEGORIA_PRODUTO, WL0.ID_CATEGORIA_PAI, WL0.NOME_CATEGORIA_PRODUTO  FROM CATEGORIA_PRODUTO WL0 WHERE ( WL0.ID_CATEGORIA_PRODUTO = ? )";
        break;

      case DDConstants.SELECT_FOR_UPDATE:
        __WL_query = "SELECT WL0.ID_CATEGORIA_PRODUTO, WL0.ID_CATEGORIA_PAI, WL0.NOME_CATEGORIA_PRODUTO  FROM CATEGORIA_PRODUTO WL0 WHERE ( WL0.ID_CATEGORIA_PRODUTO = ? ) FOR UPDATE ";
        break;

      case DDConstants.SELECT_FOR_UPDATE_NO_WAIT:
        __WL_query = "SELECT WL0.ID_CATEGORIA_PRODUTO, WL0.ID_CATEGORIA_PAI, WL0.NOME_CATEGORIA_PRODUTO  FROM CATEGORIA_PRODUTO WL0 WHERE ( WL0.ID_CATEGORIA_PRODUTO = ? ) FOR UPDATE NOWAIT ";
        break;

      default:
        throw new AssertionError(
        "Unknown selectForUpdate type: '"+selectForUpdateVal+"'");
    }

    if(__WL_verbose) {
      Debug.say("Finder produced statement string " + __WL_query);
    }

    

    try {
      __WL_con = __WL_pm.getConnection();
    } 
    catch (java.lang.Exception e) {
      __WL_pm.releaseResources(__WL_con, __WL_stmt, __WL_rs);
      throw new javax.ejb.FinderException("Couldn't get connection: " + EOL +
        e.toString() + EOL +
        RDBMSUtils.throwable2StackTrace(e));
    }

    

    try {

      __WL_stmt = __WL_con.prepareStatement(__WL_query);
      // preparedStatementParamIndex reset.
      
if (param0 == null) {
__WL_stmt.setNull(1,java.sql.Types.INTEGER);
} else {
__WL_stmt.setLong(1, param0.longValue());
if (__WL_verbose) {
Debug.say("paramIdx :"+1+" binded with value :"+param0);
}
}

      __WL_rs = __WL_stmt.executeQuery();

      
      
Map __WL_pkMap = new HashMap();

      boolean __WL_isMulti = false;
      while (__WL_rs.next()) {
        
Integer __WL_offsetIntObj = new Integer(0);
Object __WL_pk = __WL_getPKFromRS(__WL_rs, __WL_offsetIntObj, __WL_classLoader);
__WL_eo = null;
if (__WL_pk != null) { 
RSInfo __WL_rsInfo = new RSInfoImpl(__WL_rs, 0, 0, __WL_pk);
__WL_bean = (desafio.ejb.geral.CategoriaProdutoBean_3k3wj0__WebLogic_CMP_RDBMS)__WL_pm.getBeanFromRS(__WL_pk, __WL_rsInfo);

__WL_eo = __WL_pm.finderGetEoFromBeanOrPk(__WL_bean, __WL_pk, __WL_getIsLocal());
if (__WL_verbose) Debug.say("bean after finder load: " + __WL_bean);
Object __WL_retVal = __WL_pkMap.put(__WL_pk, __WL_bean);
if (__WL_retVal!=null) __WL_isMulti=true;
}


      }

      if (__WL_pkMap.size() == 0) {
        if(__WL_verbose) {
          Debug.say("Throwing FinderException because bean wasn't found.");
        }
        throw new javax.ejb.ObjectNotFoundException("Bean with primary key '" + param0.toString() + "' was not found by 'findByPrimaryKey'.");
      }
      if (__WL_isMulti || __WL_pkMap.size() > 1) {
        Loggable l = EJBLogger.logfinderReturnedMultipleValuesLoggable("findByPrimaryKey");
        throw new javax.ejb.FinderException(l.getMessage());
      }
      return __WL_eo;
  } catch (javax.ejb.FinderException fe) {
    throw fe;
  } catch (java.sql.SQLException sqle) {
    throw new javax.ejb.FinderException(
      "Problem in findByPrimaryKey while preparing or executing " +
      "statement: '" +
      __WL_stmt + "': " + EOL +
      sqle.toString() + EOL +
      RDBMSUtils.throwable2StackTrace(sqle));
  } catch (Exception e) {
    throw new javax.ejb.FinderException(
      "Exception raised in findByPrimaryKey " + EOL +
      e.toString() + EOL +
      RDBMSUtils.throwable2StackTrace(e));
  } finally {
    __WL_pm.releaseResources(__WL_con, __WL_stmt, __WL_rs);
    
  }

}

public java.lang.Object ejbFindByProdutoCategoriaProdutoBean_vhvw4g__WebLogic_CMP_RDBMS_categoriaProduto__WL_
    (java.lang.Long param0
    ) throws java.lang.Exception
    {
    if(__WL_verbose) {
      Debug.say("called findByProdutoCategoriaProdutoBean_vhvw4g__WebLogic_CMP_RDBMS_categoriaProduto__WL_.");
    }

    java.sql.Connection __WL_con = null;
    java.sql.PreparedStatement __WL_stmt = null;
    java.sql.ResultSet __WL_rs = null;
    int __WL_offset = 0;
    desafio.ejb.geral.CategoriaProdutoBean_3k3wj0__WebLogic_CMP_RDBMS __WL_bean = null;
Object __WL_eo = null;
Object __WL_eo_rc = null;

    

    

    int selectForUpdateVal = __WL_pm.getSelectForUpdateValue();

    java.lang.String __WL_query = null;

    switch(selectForUpdateVal) {
      case DDConstants.SELECT_FOR_UPDATE_DISABLED:
	__WL_query = "SELECT WL0.ID_CATEGORIA_PRODUTO, WL0.ID_CATEGORIA_PAI, WL0.NOME_CATEGORIA_PRODUTO  FROM CATEGORIA_PRODUTO WL0 WHERE ( WL0.ID_CATEGORIA_PRODUTO = ? )";
        break;

      case DDConstants.SELECT_FOR_UPDATE:
        __WL_query = "SELECT WL0.ID_CATEGORIA_PRODUTO, WL0.ID_CATEGORIA_PAI, WL0.NOME_CATEGORIA_PRODUTO  FROM CATEGORIA_PRODUTO WL0 WHERE ( WL0.ID_CATEGORIA_PRODUTO = ? ) FOR UPDATE ";
        break;

      case DDConstants.SELECT_FOR_UPDATE_NO_WAIT:
        __WL_query = "SELECT WL0.ID_CATEGORIA_PRODUTO, WL0.ID_CATEGORIA_PAI, WL0.NOME_CATEGORIA_PRODUTO  FROM CATEGORIA_PRODUTO WL0 WHERE ( WL0.ID_CATEGORIA_PRODUTO = ? ) FOR UPDATE NOWAIT ";
        break;

      default:
        throw new AssertionError(
        "Unknown selectForUpdate type: '"+selectForUpdateVal+"'");
    }

    if(__WL_verbose) {
      Debug.say("Finder produced statement string " + __WL_query);
    }

    

    try {
      __WL_con = __WL_pm.getConnection();
    } 
    catch (java.lang.Exception e) {
      __WL_pm.releaseResources(__WL_con, __WL_stmt, __WL_rs);
      throw new javax.ejb.FinderException("Couldn't get connection: " + EOL +
        e.toString() + EOL +
        RDBMSUtils.throwable2StackTrace(e));
    }

    

    try {

      __WL_stmt = __WL_con.prepareStatement(__WL_query);
      // preparedStatementParamIndex reset.
      
if (param0 == null) {
__WL_stmt.setNull(1,java.sql.Types.INTEGER);
} else {
__WL_stmt.setLong(1, param0.longValue());
if (__WL_verbose) {
Debug.say("paramIdx :"+1+" binded with value :"+param0);
}
}

      __WL_rs = __WL_stmt.executeQuery();

      
      
Map __WL_pkMap = new HashMap();

      boolean __WL_isMulti = false;
      while (__WL_rs.next()) {
        
Integer __WL_offsetIntObj = new Integer(0);
Object __WL_pk = __WL_getPKFromRS(__WL_rs, __WL_offsetIntObj, __WL_classLoader);
__WL_eo = null;
if (__WL_pk != null) { 
RSInfo __WL_rsInfo = new RSInfoImpl(__WL_rs, 0, 0, __WL_pk);
__WL_bean = (desafio.ejb.geral.CategoriaProdutoBean_3k3wj0__WebLogic_CMP_RDBMS)__WL_pm.getBeanFromRS(__WL_pk, __WL_rsInfo);

__WL_eo = __WL_pm.finderGetEoFromBeanOrPk(__WL_bean, __WL_pk, __WL_getIsLocal());
if (__WL_verbose) Debug.say("bean after finder load: " + __WL_bean);
Object __WL_retVal = __WL_pkMap.put(__WL_pk, __WL_bean);
if (__WL_retVal!=null) __WL_isMulti=true;
}


      }

      if (__WL_pkMap.size() == 0) {
        if(__WL_verbose) {
          Debug.say("Throwing FinderException because bean wasn't found.");
        }
        throw new javax.ejb.ObjectNotFoundException("Bean not found in 'findByProdutoCategoriaProdutoBean_vhvw4g__WebLogic_CMP_RDBMS_categoriaProduto__WL_'.");
      }
      if (__WL_isMulti || __WL_pkMap.size() > 1) {
        Loggable l = EJBLogger.logfinderReturnedMultipleValuesLoggable("findByProdutoCategoriaProdutoBean_vhvw4g__WebLogic_CMP_RDBMS_categoriaProduto__WL_");
        throw new javax.ejb.FinderException(l.getMessage());
      }
      return __WL_eo;
  } catch (javax.ejb.FinderException fe) {
    throw fe;
  } catch (java.sql.SQLException sqle) {
    throw new javax.ejb.FinderException(
      "Problem in findByProdutoCategoriaProdutoBean_vhvw4g__WebLogic_CMP_RDBMS_categoriaProduto__WL_ while preparing or executing " +
      "statement: '" +
      __WL_stmt + "': " + EOL +
      sqle.toString() + EOL +
      RDBMSUtils.throwable2StackTrace(sqle));
  } catch (Exception e) {
    throw new javax.ejb.FinderException(
      "Exception raised in findByProdutoCategoriaProdutoBean_vhvw4g__WebLogic_CMP_RDBMS_categoriaProduto__WL_ " + EOL +
      e.toString() + EOL +
      RDBMSUtils.throwable2StackTrace(e));
  } finally {
    __WL_pm.releaseResources(__WL_con, __WL_stmt, __WL_rs);
    
  }

}

public java.util.Collection ejbFindByCategoriaProdutoBean_3k3wj0__WebLogic_CMP_RDBMS_categoriaProdutoBean_categoriaPai__WL_
    (java.lang.Long param0
    ) throws java.lang.Exception
    {
    if(__WL_verbose) {
      Debug.say("called findByCategoriaProdutoBean_3k3wj0__WebLogic_CMP_RDBMS_categoriaProdutoBean_categoriaPai__WL_");
    }

    java.sql.Connection __WL_con = null;
    java.sql.PreparedStatement __WL_stmt = null;
    java.sql.ResultSet __WL_rs = null;
    int __WL_offset = 0;
    

    

    int selectForUpdateVal = __WL_pm.getSelectForUpdateValue();

    java.lang.String __WL_query = null;
    switch(selectForUpdateVal) {
      case DDConstants.SELECT_FOR_UPDATE_DISABLED:
	__WL_query = "SELECT WL0.ID_CATEGORIA_PRODUTO, WL0.ID_CATEGORIA_PAI, WL0.NOME_CATEGORIA_PRODUTO  FROM CATEGORIA_PRODUTO WL0 WHERE ( WL0.ID_CATEGORIA_PAI = ? )";
        break;

      case DDConstants.SELECT_FOR_UPDATE:
        __WL_query = "SELECT WL0.ID_CATEGORIA_PRODUTO, WL0.ID_CATEGORIA_PAI, WL0.NOME_CATEGORIA_PRODUTO  FROM CATEGORIA_PRODUTO WL0 WHERE ( WL0.ID_CATEGORIA_PAI = ? ) FOR UPDATE ";
        break;

      case DDConstants.SELECT_FOR_UPDATE_NO_WAIT:
        __WL_query = "SELECT WL0.ID_CATEGORIA_PRODUTO, WL0.ID_CATEGORIA_PAI, WL0.NOME_CATEGORIA_PRODUTO  FROM CATEGORIA_PRODUTO WL0 WHERE ( WL0.ID_CATEGORIA_PAI = ? ) FOR UPDATE NOWAIT ";
        break;

      default:
        throw new AssertionError(
        "Unknown selectForUpdate type: '"+selectForUpdateVal+"'");
    }
    if(__WL_verbose) {
      Debug.say("Finder produced statement string " + __WL_query);
    }


    

    try {
      __WL_con = __WL_pm.getConnection();
    } 
    catch (java.lang.Exception e) {
      __WL_pm.releaseResources(__WL_con, __WL_stmt, __WL_rs);
      throw new javax.ejb.FinderException("Couldn't get connection: " + EOL +
        e.toString() + EOL +
        RDBMSUtils.throwable2StackTrace(e));
    }

    

    try {

      __WL_stmt = __WL_con.prepareStatement(__WL_query);

      
      // preparedStatementParamIndex reset.
      
if (param0 == null) {
__WL_stmt.setNull(1,java.sql.Types.INTEGER);
} else {
__WL_stmt.setLong(1, param0.longValue());
if (__WL_verbose) {
Debug.say("paramIdx :"+1+" binded with value :"+param0);
}
}


      __WL_rs = __WL_stmt.executeQuery();
    } 
    catch (java.lang.Exception e) {
      __WL_pm.releaseResources(__WL_con, __WL_stmt, __WL_rs);
      throw new javax.ejb.FinderException(
        "Exception in findByCategoriaProdutoBean_3k3wj0__WebLogic_CMP_RDBMS_categoriaProdutoBean_categoriaPai__WL_ while preparing or executing " +
        "statement: '" + __WL_stmt + "'" + EOL +
        e.toString() + EOL +
        RDBMSUtils.throwable2StackTrace(e));
    }

    try {
      java.util.Collection __WL_collection = new java.util.ArrayList();
desafio.ejb.geral.CategoriaProdutoBean_3k3wj0__WebLogic_CMP_RDBMS __WL_bean = null;
Object __WL_eo = null;
Object __WL_eo_rc = null;

      
      
Map __WL_pkMap = new HashMap();

      while (__WL_rs.next()) {
        
Integer __WL_offsetIntObj = new Integer(0);
Object __WL_pk = __WL_getPKFromRS(__WL_rs, __WL_offsetIntObj, __WL_classLoader);
__WL_eo = null;
if (__WL_pk != null) { 
RSInfo __WL_rsInfo = new RSInfoImpl(__WL_rs, 0, 0, __WL_pk);
__WL_bean = (desafio.ejb.geral.CategoriaProdutoBean_3k3wj0__WebLogic_CMP_RDBMS)__WL_pm.getBeanFromRS(__WL_pk, __WL_rsInfo);

__WL_eo = __WL_pm.finderGetEoFromBeanOrPk(__WL_bean, __WL_pk, __WL_getIsLocal());
if (__WL_verbose) Debug.say("bean after finder load: " + __WL_bean);
if( __WL_bean == null || ( __WL_bean != null && !__WL_bean.__WL_getIsRemoved()))
{
__WL_collection.add(__WL_eo);
}
Object __WL_retVal = __WL_pkMap.put(__WL_pk, __WL_bean);
}


      }
      return __WL_collection;

    } catch (java.sql.SQLException sqle) {
      throw new javax.ejb.FinderException(
        "Exception in 'findByCategoriaProdutoBean_3k3wj0__WebLogic_CMP_RDBMS_categoriaProdutoBean_categoriaPai__WL_' while using " +
        "result set: '" + __WL_rs + "'" + EOL +
        sqle.toString() + EOL +
        RDBMSUtils.throwable2StackTrace(sqle));
    } catch (java.lang.Exception e) {
      throw new javax.ejb.FinderException(
        "Exception executing finder 'findByCategoriaProdutoBean_3k3wj0__WebLogic_CMP_RDBMS_categoriaProdutoBean_categoriaPai__WL_': " + EOL +
        e.toString() + EOL +
        RDBMSUtils.throwable2StackTrace(e));
    } finally {
      
      __WL_pm.releaseResources(__WL_con, __WL_stmt, __WL_rs);
    }

}

public java.lang.Object ejbFindByCategoriaProdutoBean_3k3wj0__WebLogic_CMP_RDBMS_categoriaPai__WL_
    (java.lang.Long param0
    ) throws java.lang.Exception
    {
    if(__WL_verbose) {
      Debug.say("called findByCategoriaProdutoBean_3k3wj0__WebLogic_CMP_RDBMS_categoriaPai__WL_.");
    }

    java.sql.Connection __WL_con = null;
    java.sql.PreparedStatement __WL_stmt = null;
    java.sql.ResultSet __WL_rs = null;
    int __WL_offset = 0;
    desafio.ejb.geral.CategoriaProdutoBean_3k3wj0__WebLogic_CMP_RDBMS __WL_bean = null;
Object __WL_eo = null;
Object __WL_eo_rc = null;

    

    

    int selectForUpdateVal = __WL_pm.getSelectForUpdateValue();

    java.lang.String __WL_query = null;

    switch(selectForUpdateVal) {
      case DDConstants.SELECT_FOR_UPDATE_DISABLED:
	__WL_query = "SELECT WL0.ID_CATEGORIA_PRODUTO, WL0.ID_CATEGORIA_PAI, WL0.NOME_CATEGORIA_PRODUTO  FROM CATEGORIA_PRODUTO WL0 WHERE ( WL0.ID_CATEGORIA_PRODUTO = ? )";
        break;

      case DDConstants.SELECT_FOR_UPDATE:
        __WL_query = "SELECT WL0.ID_CATEGORIA_PRODUTO, WL0.ID_CATEGORIA_PAI, WL0.NOME_CATEGORIA_PRODUTO  FROM CATEGORIA_PRODUTO WL0 WHERE ( WL0.ID_CATEGORIA_PRODUTO = ? ) FOR UPDATE ";
        break;

      case DDConstants.SELECT_FOR_UPDATE_NO_WAIT:
        __WL_query = "SELECT WL0.ID_CATEGORIA_PRODUTO, WL0.ID_CATEGORIA_PAI, WL0.NOME_CATEGORIA_PRODUTO  FROM CATEGORIA_PRODUTO WL0 WHERE ( WL0.ID_CATEGORIA_PRODUTO = ? ) FOR UPDATE NOWAIT ";
        break;

      default:
        throw new AssertionError(
        "Unknown selectForUpdate type: '"+selectForUpdateVal+"'");
    }

    if(__WL_verbose) {
      Debug.say("Finder produced statement string " + __WL_query);
    }

    

    try {
      __WL_con = __WL_pm.getConnection();
    } 
    catch (java.lang.Exception e) {
      __WL_pm.releaseResources(__WL_con, __WL_stmt, __WL_rs);
      throw new javax.ejb.FinderException("Couldn't get connection: " + EOL +
        e.toString() + EOL +
        RDBMSUtils.throwable2StackTrace(e));
    }

    

    try {

      __WL_stmt = __WL_con.prepareStatement(__WL_query);
      // preparedStatementParamIndex reset.
      
if (param0 == null) {
__WL_stmt.setNull(1,java.sql.Types.INTEGER);
} else {
__WL_stmt.setLong(1, param0.longValue());
if (__WL_verbose) {
Debug.say("paramIdx :"+1+" binded with value :"+param0);
}
}

      __WL_rs = __WL_stmt.executeQuery();

      
      
Map __WL_pkMap = new HashMap();

      boolean __WL_isMulti = false;
      while (__WL_rs.next()) {
        
Integer __WL_offsetIntObj = new Integer(0);
Object __WL_pk = __WL_getPKFromRS(__WL_rs, __WL_offsetIntObj, __WL_classLoader);
__WL_eo = null;
if (__WL_pk != null) { 
RSInfo __WL_rsInfo = new RSInfoImpl(__WL_rs, 0, 0, __WL_pk);
__WL_bean = (desafio.ejb.geral.CategoriaProdutoBean_3k3wj0__WebLogic_CMP_RDBMS)__WL_pm.getBeanFromRS(__WL_pk, __WL_rsInfo);

__WL_eo = __WL_pm.finderGetEoFromBeanOrPk(__WL_bean, __WL_pk, __WL_getIsLocal());
if (__WL_verbose) Debug.say("bean after finder load: " + __WL_bean);
Object __WL_retVal = __WL_pkMap.put(__WL_pk, __WL_bean);
if (__WL_retVal!=null) __WL_isMulti=true;
}


      }

      if (__WL_pkMap.size() == 0) {
        if(__WL_verbose) {
          Debug.say("Throwing FinderException because bean wasn't found.");
        }
        throw new javax.ejb.ObjectNotFoundException("Bean not found in 'findByCategoriaProdutoBean_3k3wj0__WebLogic_CMP_RDBMS_categoriaPai__WL_'.");
      }
      if (__WL_isMulti || __WL_pkMap.size() > 1) {
        Loggable l = EJBLogger.logfinderReturnedMultipleValuesLoggable("findByCategoriaProdutoBean_3k3wj0__WebLogic_CMP_RDBMS_categoriaPai__WL_");
        throw new javax.ejb.FinderException(l.getMessage());
      }
      return __WL_eo;
  } catch (javax.ejb.FinderException fe) {
    throw fe;
  } catch (java.sql.SQLException sqle) {
    throw new javax.ejb.FinderException(
      "Problem in findByCategoriaProdutoBean_3k3wj0__WebLogic_CMP_RDBMS_categoriaPai__WL_ while preparing or executing " +
      "statement: '" +
      __WL_stmt + "': " + EOL +
      sqle.toString() + EOL +
      RDBMSUtils.throwable2StackTrace(sqle));
  } catch (Exception e) {
    throw new javax.ejb.FinderException(
      "Exception raised in findByCategoriaProdutoBean_3k3wj0__WebLogic_CMP_RDBMS_categoriaPai__WL_ " + EOL +
      e.toString() + EOL +
      RDBMSUtils.throwable2StackTrace(e));
  } finally {
    __WL_pm.releaseResources(__WL_con, __WL_stmt, __WL_rs);
    
  }

}



  
// loadGroup method for the 'defaultGroup' group.
public void __WL_loadGroup0() throws Exception {
    java.sql.Connection __WL_con = null;
    java.sql.PreparedStatement __WL_stmt = null;
    java.sql.ResultSet __WL_rs = null;
    int __WL_offset = 0;

    int selectForUpdateVal = __WL_pm.getSelectForUpdateValue();

    java.lang.String __WL_query;

    // http://bugs.beasys.com/CRView?CR=CR070260
    //
    //  optimization.

    switch(selectForUpdateVal) {
      case DDConstants.SELECT_FOR_UPDATE_DISABLED:
        __WL_query = "SELECT WL0.ID_CATEGORIA_PAI, WL0.ID_CATEGORIA_PRODUTO, WL0.NOME_CATEGORIA_PRODUTO  FROM CATEGORIA_PRODUTO WL0  WHERE WL0.ID_CATEGORIA_PRODUTO = ? ";
        break;

      case DDConstants.SELECT_FOR_UPDATE:
        __WL_query = "SELECT WL0.ID_CATEGORIA_PAI, WL0.ID_CATEGORIA_PRODUTO, WL0.NOME_CATEGORIA_PRODUTO  FROM CATEGORIA_PRODUTO WL0  WHERE WL0.ID_CATEGORIA_PRODUTO = ?  FOR UPDATE ";
        break;

      case DDConstants.SELECT_FOR_UPDATE_NO_WAIT:
        __WL_query = "SELECT WL0.ID_CATEGORIA_PAI, WL0.ID_CATEGORIA_PRODUTO, WL0.NOME_CATEGORIA_PRODUTO  FROM CATEGORIA_PRODUTO WL0  WHERE WL0.ID_CATEGORIA_PRODUTO = ?  FOR UPDATE NOWAIT ";
        break;

      default:
        throw new AssertionError(
        "Unknown selectForUpdate type: '"+selectForUpdateVal+"'");
    }

    

    try {
      if (__WL_verbose) {
        Debug.say("__WL_loadGroup0 for pk=" + __WL_ctx.getPrimaryKey());
      }

      java.lang.Long __WL_pk = (java.lang.Long) __WL_ctx.getPrimaryKey();

      __WL_con = __WL_pm.getConnection();


      __WL_stmt = __WL_con.prepareStatement(__WL_query);

      // preparedStatementParamIndex reset.
      
if(!__WL_pm.setParamNull(__WL_stmt, 1, __WL_pk, "id_categoria_produto")) {
__WL_stmt.setLong(1, __WL_pk.longValue());
if (__WL_verbose) {
Debug.say("paramIdx :"+1+" binded with value :"+__WL_pk);
}
}


      if (__WL_verbose) {
        Debug.say("__WL_loadGroup0 for pk=" + __WL_ctx.getPrimaryKey() + 
                  ", executeQuery: "+__WL_query);
      }

      __WL_rs = __WL_stmt.executeQuery();
      if (__WL_rs.next()) {

        if (__WL_verbose) {
          Debug.say("__WL_loadGroup0 for pk=" + __WL_ctx.getPrimaryKey() + 
                    " now read columns from Results.");
        }
     
        
        if (!(this.__WL_isLoaded[0] || this.__WL_isModified[0])) {
this.id_categoria_pai = new Long(__WL_rs.getLong(1+__WL_offset));
if (__WL_rs.wasNull()) { 
this.id_categoria_pai = null;
}
}
else {
__WL_rs.getLong(1+__WL_offset);
}
if (!(this.__WL_isLoaded[1] || this.__WL_isModified[1])) {
this.id_categoria_produto = new Long(__WL_rs.getLong(2+__WL_offset));
if (__WL_rs.wasNull()) { 
this.id_categoria_produto = null;
}
}
else {
__WL_rs.getLong(2+__WL_offset);
}
if (!(this.__WL_isLoaded[2] || this.__WL_isModified[2])) {
this.nome_categoria_produto = (java.lang.String)__WL_rs.getString(3+__WL_offset);
if (__WL_rs.wasNull()) { 
this.nome_categoria_produto = null;
}
}
else {
__WL_rs.getString(3+__WL_offset);
}
this.__WL_isLoaded[0] = true;
this.__WL_isLoaded[1] = true;
this.__WL_isLoaded[2] = true;
this.__WL_beanIsLoaded = true;
        

        __WL_beanIsLoaded = true;
        
      } else {
        if(__WL_verbose) {
          Debug.say("__WL_loadGroup0 could not find primary key " +
                    __WL_pk);
        }
        Loggable l = EJBLogger.lognoSuchEntityExceptionLoggable(__WL_pk.toString());
        throw new NoSuchEntityException(l.getMessage());
              
      }
    } finally {
      __WL_pm.releaseResources(__WL_con, __WL_stmt, __WL_rs);
    }

    
}

  
// loadGroup from ResultSet to bean method for the 'defaultGroup' group.
public void __WL_loadGroup0FromRS
(java.sql.ResultSet __WL_rs, 
java.lang.Integer __WL_offsetIntObj, 
Object __WL_pk,
desafio.ejb.geral.CategoriaProdutoBean_3k3wj0_Intf beanIntf)
throws java.sql.SQLException, java.lang.Exception
{
desafio.ejb.geral.CategoriaProdutoBean_3k3wj0__WebLogic_CMP_RDBMS __WL_bean = (desafio.ejb.geral.CategoriaProdutoBean_3k3wj0__WebLogic_CMP_RDBMS)beanIntf;
if (__WL_verbose) {
Debug.say("__WL_loadGroup0FromRS");
}

int __WL_offset = __WL_offsetIntObj.intValue();

if (__WL_pk == null) {
if (!(__WL_bean.__WL_isLoaded[1] || __WL_bean.__WL_isModified[1])) {
__WL_bean.id_categoria_produto = new Long(__WL_rs.getLong(1+__WL_offset));
if (__WL_rs.wasNull()) { 
__WL_bean.id_categoria_produto = null;
}
}
else {
__WL_rs.getLong(1+__WL_offset);
}
} else {
__WL_bean.__WL_setPrimaryKey((java.lang.Long) __WL_pk);
}
if (!(__WL_bean.__WL_isLoaded[0] || __WL_bean.__WL_isModified[0])) {
__WL_bean.id_categoria_pai = new Long(__WL_rs.getLong(2+__WL_offset));
if (__WL_rs.wasNull()) { 
__WL_bean.id_categoria_pai = null;
}
}
else {
__WL_rs.getLong(2+__WL_offset);
}
if (!(__WL_bean.__WL_isLoaded[2] || __WL_bean.__WL_isModified[2])) {
__WL_bean.nome_categoria_produto = (java.lang.String)__WL_rs.getString(3+__WL_offset);
if (__WL_rs.wasNull()) { 
__WL_bean.nome_categoria_produto = null;
}
}
else {
__WL_rs.getString(3+__WL_offset);
}
__WL_bean.__WL_isLoaded[0] = true;
__WL_bean.__WL_isLoaded[1] = true;
__WL_bean.__WL_isLoaded[2] = true;
__WL_bean.__WL_beanIsLoaded = true;
__WL_beanIsLoaded = true;
}

  
public void __WL_loadCMRFieldFromRS_categoriaPai
(java.sql.ResultSet __WL_rs, 
java.lang.Integer __WL_offsetIntObj, 
desafio.ejb.geral.CategoriaProdutoBean_3k3wj0_Intf beanIntf) 
throws java.sql.SQLException, java.lang.Exception
{
desafio.ejb.geral.CategoriaProdutoBean_3k3wj0__WebLogic_CMP_RDBMS __WL_bean = (desafio.ejb.geral.CategoriaProdutoBean_3k3wj0__WebLogic_CMP_RDBMS)beanIntf;
if (__WL_verbose) {
Debug.say("__WL_loadCMRFieldFromRS_categoriaPai");
}

int __WL_offset = __WL_offsetIntObj.intValue();

if (!(__WL_bean.__WL_isLoaded[0] || __WL_bean.__WL_isModified[0])) {
__WL_bean.id_categoria_pai = new Long(__WL_rs.getLong(1+__WL_offset));
if (__WL_rs.wasNull()) { 
__WL_bean.id_categoria_pai = null;
}
}
else {
__WL_rs.getLong(1+__WL_offset);
}
__WL_bean.__WL_isLoaded[0] = true;

}

public void __WL_loadCMRFieldFromRS_produtoCategoriaProdutoBean_categoriaProduto
(java.sql.ResultSet __WL_rs, 
java.lang.Integer __WL_offsetIntObj, 
desafio.ejb.geral.CategoriaProdutoBean_3k3wj0_Intf beanIntf) 
throws java.sql.SQLException, java.lang.Exception
{
desafio.ejb.geral.CategoriaProdutoBean_3k3wj0__WebLogic_CMP_RDBMS __WL_bean = (desafio.ejb.geral.CategoriaProdutoBean_3k3wj0__WebLogic_CMP_RDBMS)beanIntf;
if (__WL_verbose) {
Debug.say("__WL_loadCMRFieldFromRS_produtoCategoriaProdutoBean_categoriaProduto");
}

int __WL_offset = __WL_offsetIntObj.intValue();

if (!(__WL_bean.__WL_isLoaded[1] || __WL_bean.__WL_isModified[1])) {
__WL_bean.id_categoria_produto = new Long(__WL_rs.getLong(1+__WL_offset));
if (__WL_rs.wasNull()) { 
__WL_bean.id_categoria_produto = null;
}
}
else {
__WL_rs.getLong(1+__WL_offset);
}
__WL_bean.__WL_isLoaded[1] = true;

}

public void __WL_loadCMRFieldFromRS_categoriaProdutoBean_categoriaPai
(java.sql.ResultSet __WL_rs, 
java.lang.Integer __WL_offsetIntObj, 
desafio.ejb.geral.CategoriaProdutoBean_3k3wj0_Intf beanIntf) 
throws java.sql.SQLException, java.lang.Exception
{
desafio.ejb.geral.CategoriaProdutoBean_3k3wj0__WebLogic_CMP_RDBMS __WL_bean = (desafio.ejb.geral.CategoriaProdutoBean_3k3wj0__WebLogic_CMP_RDBMS)beanIntf;
if (__WL_verbose) {
Debug.say("__WL_loadCMRFieldFromRS_categoriaProdutoBean_categoriaPai");
}

int __WL_offset = __WL_offsetIntObj.intValue();

if (!(__WL_bean.__WL_isLoaded[1] || __WL_bean.__WL_isModified[1])) {
__WL_bean.id_categoria_produto = new Long(__WL_rs.getLong(1+__WL_offset));
if (__WL_rs.wasNull()) { 
__WL_bean.id_categoria_produto = null;
}
}
else {
__WL_rs.getLong(1+__WL_offset);
}
__WL_bean.__WL_isLoaded[1] = true;

}


  // methods to load related beans - for Dynamic Finders
  
  public void __WL_loadBeansRelatedToCachingName(String cachingName, java.sql.ResultSet rs, CMPBean bean, int groupColumnCount)
throws Exception {
}


  public static Object __WL_getPKFromRS(java.sql.ResultSet __WL_rs, java.lang.Integer __WL_offsetIntObj, ClassLoader __WL_classLoader)
    throws java.sql.SQLException, java.lang.Exception
  {
    if (__WL_verbose) {
      Debug.say("__WL_getPKFromRS");
    }

    int __WL_offset = __WL_offsetIntObj.intValue();

    java.lang.Long __WL_pk = null;
    
    __WL_pk = new Long(__WL_rs.getLong(1+__WL_offset));
if (__WL_rs.wasNull()) { 
__WL_pk = null;
}

    
    return __WL_pk;
  }

  public Object __WL_getPKFromRSInstance(java.sql.ResultSet __WL_rs, java.lang.Integer __WL_offsetIntObj, ClassLoader __WL_classLoader)
    throws java.sql.SQLException, java.lang.Exception
  {
    return __WL_getPKFromRS(__WL_rs, __WL_offsetIntObj, __WL_classLoader);
  }

  //End finder methods.
  //=================================================================

  //=================================================================
  //Home methods.
  

  //End home methods.
  //=================================================================

  //=================================================================
  // ejbSelect methods defined in this Bean's abstract class

  


  //=================================================================
  // ejbSelectInternal methods that are to run in this Bean

  



  //=================================================================

  // ================================================================
  // Implementation of CMPBean
  public void __WL_setup(java.util.Map bmMap, PersistenceManager __WL_pm) {
    if (__WL_verbose) {
      Debug.say("CategoriaProdutoBean_3k3wj0__WebLogic_CMP_RDBMS.setup called.");
    }
    if (__WL_debug) {
      Debug.assertion(bmMap!=null);
      Debug.assertion(__WL_pm !=null);
    }
    this.__WL_pm = (RDBMSPersistenceManager)__WL_pm; 
    this.__WL_classLoader = this.__WL_pm.getClassLoader();
    if (__WL_debug) {
      Debug.assertion(this.__WL_classLoader != null);
    }
    try {__WL_categoriaPai_bm = (CMPBeanManager)bmMap.get("CategoriaProdutoBean");
if (__WL_debug) Debug.assertion(bmMap.get("CategoriaProdutoBean")!=null);

__WL_produtoCategoriaProdutoBean_categoriaProduto_bm = (CMPBeanManager)bmMap.get("ProdutoCategoriaProdutoBean");
if (__WL_debug) Debug.assertion(bmMap.get("ProdutoCategoriaProdutoBean")!=null);

__WL_categoriaProdutoBean_categoriaPai_bm = (CMPBeanManager)bmMap.get("CategoriaProdutoBean");
if (__WL_debug) Debug.assertion(bmMap.get("CategoriaProdutoBean")!=null);

    } catch (RuntimeException re) {
      if (__WL_verbose) {
        Debug.say("rethrowing RuntimeException.");
        re.printStackTrace();
      }
      throw re;
    } catch (Exception ex) {
      if (__WL_verbose) {
        Debug.say("wrapping Exception in PersistenceRuntimeException.");
        ex.printStackTrace();
      }
      throw new PersistenceRuntimeException(ex);
    }

    
  }

  public EntityContext __WL_getEntityContext() {
    return __WL_ctx;
  }

  public Object __WL_getPrimaryKey() {
    java.lang.Long __WL_pk = null;

__WL_pk = this.id_categoria_produto;
return __WL_pk;

  }

  public void __WL_setPrimaryKey(java.lang.Long __WL_pk) {
    this.id_categoria_produto = __WL_pk;

  }

  public void __WL_superEjbLoad()  {
    int __WL_oldState = __WL_method_state;

    try {
      __WL_method_state = STATE_EJBLOAD;
      super.ejbLoad();
    } finally {
      __WL_method_state = __WL_oldState;
    }
  }

  public void __WL_superEjbStore()  {
    int __WL_oldState = __WL_method_state;

    try {
      __WL_method_state = STATE_EJBSTORE;
      if (__WL_verbose) {
        Debug.say("__WL_superEjbStore "+ __WL_ctx.getPrimaryKey());
      }
      super.ejbStore();
    } finally {
      __WL_method_state = __WL_oldState;
    }
  }

  public void __WL_superEjbRemove(boolean initialize)  {
        int __WL_oldState = __WL_method_state;

    try {
      __WL_method_state = STATE_EJB_REMOVE;
      if (__WL_verbose) {
        Debug.say("__WL_superEjbRemove " + __WL_ctx.getPrimaryKey());
      }
      super.ejbRemove();

      
getProdutoCategoriaProdutoBean_categoriaProduto();
((CategoriaProdutoBean_3k3wj0__WebLogic_CMP_RDBMS_produtoCategoriaProdutoBean_categoriaProduto_Set)__WL_produtoCategoriaProdutoBean_categoriaProduto_field_).clear(false);
__WL_setCategoriaPai(null, false);
getCategoriaProdutoBean_categoriaPai();
((CategoriaProdutoBean_3k3wj0__WebLogic_CMP_RDBMS_categoriaProdutoBean_categoriaPai_Set)__WL_categoriaProdutoBean_categoriaPai_field_).clear(true);

      
      
      if(initialize)
      {
        // initialize state before this instance goes back into the pool
        if (!__WL_getIsRemoved()) __WL_initialize();
      }

    } finally {
      __WL_method_state = __WL_oldState;
    }

  }

  public void __WL_copyFrom(CMPBean otherBean, boolean __WL_initSnapshotVars) {
    CategoriaProdutoBean_3k3wj0__WebLogic_CMP_RDBMS __WL_bean = null;
try {
__WL_bean = (CategoriaProdutoBean_3k3wj0__WebLogic_CMP_RDBMS)otherBean;
    } catch (RuntimeException re) {
      if (__WL_verbose) {
        Debug.say("rethrowing RuntimeException.");
        re.printStackTrace();
      }
      throw re;
    } catch (Exception ex) {
      if (__WL_verbose) {
        Debug.say("wrapping Exception in PersistenceRuntimeException.");
        ex.printStackTrace();
      }
      throw new PersistenceRuntimeException(ex);
    }
if (!(this.__WL_isLoaded[0] || this.__WL_isModified[0])) {
if (__WL_bean.__WL_isLoaded[0]) {
if (__WL_verbose) {
Debug.say("copying field 'id_categoria_pai' to bean '" +
__WL_bean.__WL_getPrimaryKey() + "'.");
}
this.id_categoria_pai = __WL_bean.id_categoria_pai;
this.__WL_isLoaded[0] = true;
if (!__WL_initSnapshotVars) this.__WL_isModified[0] = true;
}
}

if (!(this.__WL_isLoaded[1] || this.__WL_isModified[1])) {
if (__WL_bean.__WL_isLoaded[1]) {
if (__WL_verbose) {
Debug.say("copying field 'id_categoria_produto' to bean '" +
__WL_bean.__WL_getPrimaryKey() + "'.");
}
this.id_categoria_produto = __WL_bean.id_categoria_produto;
this.__WL_isLoaded[1] = true;
if (!__WL_initSnapshotVars) this.__WL_isModified[1] = true;
}
}

if (!(this.__WL_isLoaded[2] || this.__WL_isModified[2])) {
if (__WL_bean.__WL_isLoaded[2]) {
if (__WL_verbose) {
Debug.say("copying field 'nome_categoria_produto' to bean '" +
__WL_bean.__WL_getPrimaryKey() + "'.");
}
this.nome_categoria_produto = __WL_bean.nome_categoria_produto;
this.__WL_isLoaded[2] = true;
if (!__WL_initSnapshotVars) this.__WL_isModified[2] = true;
}
}

this.__WL_modifiedBeanIsRegistered = __WL_bean.__WL_modifiedBeanIsRegistered;
this.__WL_beanIsLoaded = __WL_bean.__WL_beanIsLoaded;

if (!this.__WL_categoriaPai_isLoaded_) {
if (__WL_bean.__WL_categoriaPai_isLoaded_==true) {
if (__WL_verbose) {
Debug.say("copying cmr field 'categoriaPai' to bean '" +
__WL_bean.__WL_getPrimaryKey() + "'.");
}
this.__WL_categoriaPai_field_ = __WL_bean.__WL_categoriaPai_field_;
this.__WL_categoriaPai_isLoaded_ = true;
}
}

if (!this.__WL_produtoCategoriaProdutoBean_categoriaProduto_isLoaded_) {
if (__WL_bean.__WL_produtoCategoriaProdutoBean_categoriaProduto_isLoaded_==true) {
if (__WL_verbose) {
Debug.say("copying cmr field 'produtoCategoriaProdutoBean_categoriaProduto' to bean '" +
__WL_bean.__WL_getPrimaryKey() + "'.");
}
this.__WL_produtoCategoriaProdutoBean_categoriaProduto_field_ = __WL_bean.__WL_produtoCategoriaProdutoBean_categoriaProduto_field_;
this.__WL_produtoCategoriaProdutoBean_categoriaProduto_isLoaded_ = true;
}
}

if (!this.__WL_categoriaProdutoBean_categoriaPai_isLoaded_) {
if (__WL_bean.__WL_categoriaProdutoBean_categoriaPai_isLoaded_==true) {
if (__WL_verbose) {
Debug.say("copying cmr field 'categoriaProdutoBean_categoriaPai' to bean '" +
__WL_bean.__WL_getPrimaryKey() + "'.");
}
this.__WL_categoriaProdutoBean_categoriaPai_field_ = __WL_bean.__WL_categoriaProdutoBean_categoriaPai_field_;
this.__WL_categoriaProdutoBean_categoriaPai_isLoaded_ = true;
}
}


  }

  public void __WL_loadGroupByIndex(int index, java.sql.ResultSet rs,
    Integer offset, Object __WL_pk, javax.ejb.EntityBean eb) throws Exception
  {
    switch(index) {
      case 0: __WL_loadGroup0FromRS(rs, offset, __WL_pk, (desafio.ejb.geral.CategoriaProdutoBean_3k3wj0__WebLogic_CMP_RDBMS)eb); break;
default: throw new AssertionError("Bad Group index: "+index);

    }
  }

  public void __WL_loadCMRFieldByCmrField(String cmrField, java.sql.ResultSet rs,
    Integer offset, javax.ejb.EntityBean eb) throws Exception
  {
    if ("categoriaPai".equalsIgnoreCase(cmrField)) __WL_loadCMRFieldFromRS_categoriaPai(rs, offset,(desafio.ejb.geral.CategoriaProdutoBean_3k3wj0__WebLogic_CMP_RDBMS)eb);
if ("produtoCategoriaProdutoBean_categoriaProduto".equalsIgnoreCase(cmrField)) __WL_loadCMRFieldFromRS_produtoCategoriaProdutoBean_categoriaProduto(rs, offset,(desafio.ejb.geral.CategoriaProdutoBean_3k3wj0__WebLogic_CMP_RDBMS)eb);
if ("categoriaProdutoBean_categoriaPai".equalsIgnoreCase(cmrField)) __WL_loadCMRFieldFromRS_categoriaProdutoBean_categoriaPai(rs, offset,(desafio.ejb.geral.CategoriaProdutoBean_3k3wj0__WebLogic_CMP_RDBMS)eb);

  }

  public PersistenceManager __WL_getPersistenceManager() {
    return __WL_pm;
  }

  public void __WL_makeCascadeDelList(java.util.Map mapCascadeDelBeans,
                                 java.util.List listCascadeDelBeans,
                                 java.util.List listCascadeDelBeansWithoutDBUpdate,
                                 boolean withoutDBUpdate)
    throws java.lang.Exception
  {
    
    int __WL_oldState = __WL_method_state;
    __WL_method_state = STATE_EJB_REMOVE;

    // create a unique mapKey to map beans to mapCascadeDelBeans
    // re-use weblogic.ejb20.cache.CacheKey class since it take two
    // objects to create the key
    Object pk = __WL_ctx.getPrimaryKey();
    Object beanManager = __WL_pm.getBeanManager();
    weblogic.ejb20.cache.CacheKey mapKey =
      new weblogic.ejb20.cache.CacheKey(pk, (CachingManager)beanManager);

    // step 1:
    // keep track of all of the beans been visited is the map to detect the circular case
    if (mapCascadeDelBeans.get(mapKey) == null) {
      mapCascadeDelBeans.put(mapKey, this);
    }
    else {
      if (__WL_verbose) {
        Debug.say("Trying to add " + mapKey + " to list during cascade delete, " +
          "but it already exists in the list, a possible circular detect, ignored.");
      }
      return;
    }

    // step 2:
    // This is the place every bean bean added to the list.
    // true  if don't need a database update, db-cascade-delete is specified
    // false if do need a database update, db-cascade-detelet isn't specified
    if (withoutDBUpdate) {
      listCascadeDelBeansWithoutDBUpdate.add(this);
    } else {
      listCascadeDelBeans.add(this);
    }

    __WL_method_state = __WL_oldState;

  }

  public void __WL_setBeanParamsForCreateArray(
    java.sql.PreparedStatement[] __WL_stmt_array)
    throws Exception
  {
    
    // preparedStatementParamIndex reset.
if(!__WL_pm.setParamNull(__WL_stmt_array[0], 1, this.id_categoria_pai, "id_categoria_pai")) {
__WL_stmt_array[0].setLong(1, this.id_categoria_pai.longValue());
if (__WL_verbose) {
Debug.say("paramIdx :"+1+" binded with value :"+this.id_categoria_pai);
}
}

if(!__WL_pm.setParamNull(__WL_stmt_array[0], 2, this.id_categoria_produto, "id_categoria_produto")) {
__WL_stmt_array[0].setLong(2, this.id_categoria_produto.longValue());
if (__WL_verbose) {
Debug.say("paramIdx :"+2+" binded with value :"+this.id_categoria_produto);
}
}

if(!__WL_pm.setParamNull(__WL_stmt_array[0], 3, this.nome_categoria_produto, "nome_categoria_produto")) {
__WL_stmt_array[0].setString(3, this.nome_categoria_produto);
if (__WL_verbose) {
Debug.say("paramIdx :"+3+" binded with value :"+this.nome_categoria_produto);
}
}


  }

  public void __WL_setBeanParamsForUpdateArray(
    java.sql.PreparedStatement[] __WL_stmt_array,
    boolean[] __WL_isModified,
    java.lang.Long __WL_pk,
    int curTableIndex)
    throws Exception
  {
    // set all __WL_stmt_array when curTableIndex == -1
      if ((__WL_stmt_array[0] != null) && ((curTableIndex == 0) || (curTableIndex == -1))) {
    int __WL_num = 1;
    if (__WL_isModified[0]) {
if(__WL_verbose) Debug.say("setting("+this+") 'id_categoria_pai' using column " +__WL_num + ". Value is " + this.id_categoria_pai);
if(!__WL_pm.setParamNull(__WL_stmt_array[0], __WL_num, this.id_categoria_pai, "id_categoria_pai")) {
__WL_stmt_array[0].setLong(__WL_num, this.id_categoria_pai.longValue());
if (__WL_verbose) {
Debug.say("paramIdx :"+__WL_num+" binded with value :"+this.id_categoria_pai);
}
}
__WL_num++;
};

if (__WL_isModified[2]) {
if(__WL_verbose) Debug.say("setting("+this+") 'nome_categoria_produto' using column " +__WL_num + ". Value is " + this.nome_categoria_produto);
if(!__WL_pm.setParamNull(__WL_stmt_array[0], __WL_num, this.nome_categoria_produto, "nome_categoria_produto")) {
__WL_stmt_array[0].setString(__WL_num, this.nome_categoria_produto);
if (__WL_verbose) {
Debug.say("paramIdx :"+__WL_num+" binded with value :"+this.nome_categoria_produto);
}
}
__WL_num++;
};


    
    
if(!__WL_pm.setParamNull(__WL_stmt_array[0], __WL_num, __WL_pk, "id_categoria_produto")) {
__WL_stmt_array[0].setLong(__WL_num, __WL_pk.longValue());
if (__WL_verbose) {
Debug.say("paramIdx :"+__WL_num+" binded with value :"+__WL_pk);
}
}
__WL_num++;

    
  }


  }

  public void __WL_setBeanParamsForDeleteArray(
    java.sql.PreparedStatement[] __WL_stmt_array,
    boolean[] __WL_isModified,
    java.lang.Long __WL_pk)
    throws Exception
  {
    int __WL_num = 0;
__WL_num = 1;

if(!__WL_pm.setParamNull(__WL_stmt_array[0], __WL_num, __WL_pk, "id_categoria_produto")) {
__WL_stmt_array[0].setLong(__WL_num, __WL_pk.longValue());
if (__WL_verbose) {
Debug.say("paramIdx :"+__WL_num+" binded with value :"+__WL_pk);
}
}
__WL_num++;

  }

  public java.sql.PreparedStatement[] __WL_getStmtArray(
    java.sql.Connection __WL_con,
    boolean[] __WL_isModified,
    int operation)
    throws SQLException
  {
        if (__WL_verbose) {
      Debug.say("called __WL_getStmtArray.");
    }

    
java.sql.PreparedStatement[] __WL_stmt_array = new java.sql.PreparedStatement[1];

java.sql.PreparedStatement __WL_stmt_CATEGORIA_PRODUTO_0 = null;
__WL_stmt_array[0] = __WL_stmt_CATEGORIA_PRODUTO_0;


    
String[] __WL_query_array = new String[1];


    if (operation == DDConstants.INSERT) {
      __WL_query_array[0] = "INSERT INTO CATEGORIA_PRODUTO (ID_CATEGORIA_PAI, ID_CATEGORIA_PRODUTO, NOME_CATEGORIA_PRODUTO) VALUES (?, ?, ?)";

    } else if (operation == DDConstants.UPDATE) {
      int __WL_count        = 0;
      
      StringBuffer sb      = new StringBuffer();
      

      
__WL_count = 0;
sb.setLength(0);
if (__WL_isModified[0])  {
if (__WL_count > 0) sb.append(", ");
sb.append("ID_CATEGORIA_PAI = ? ");
__WL_count++;
}

if (__WL_isModified[2])  {
if (__WL_count > 0) sb.append(", ");
sb.append("NOME_CATEGORIA_PRODUTO = ? ");
__WL_count++;
}

if (__WL_count != 0) {
if (sb.length() != 0) {
__WL_query_array[0] = "UPDATE CATEGORIA_PRODUTO SET " + sb.toString() + " WHERE ID_CATEGORIA_PRODUTO = ?";
}
}

    } else if (operation == DDConstants.DELETE) {
      

      __WL_query_array[0] = "DELETE FROM CATEGORIA_PRODUTO WHERE ID_CATEGORIA_PRODUTO = ?" ;

    }

    if(__WL_verbose) {
      for (int i = 0 ; i < 1 ; i++) {
        Debug.say("__WL_getStmtArray() for " + operation + " produced sqlString: " + __WL_query_array[i]);
      }
    }

    
if (__WL_query_array[0] != null) __WL_stmt_array[0] = __WL_con.prepareStatement(__WL_query_array[0]);


    return __WL_stmt_array;

  }

  public void __WL_setBeanParamsForStmtArray(
    java.sql.PreparedStatement[] __WL_stmt_array,
    boolean[] __WL_isModified,
    int operation)
    throws Exception
  {
        if (operation == DDConstants.INSERT) {
      __WL_setBeanParamsForCreateArray(__WL_stmt_array);
    } else if (operation == DDConstants.UPDATE) {
      __WL_setBeanParamsForBulkUpdateArray(__WL_stmt_array, __WL_isModified);
    } else if (operation == DDConstants.DELETE) {
      __WL_setBeanParamsForBulkDeleteArray(__WL_stmt_array, __WL_isModified);
    }

  }

  public void __WL_setBeanParamsForBulkUpdateArray(
    java.sql.PreparedStatement[] __WL_stmt_array,
    boolean[] __WL_isModified)
    throws Exception
  {
      int __WL_oldState = __WL_method_state;

  try {
    __WL_method_state = STATE_EJBSTORE;

    java.lang.Long __WL_pk = (java.lang.Long) __WL_ctx.getPrimaryKey();

    __WL_setBeanParamsForUpdateArray(__WL_stmt_array, __WL_isModified, __WL_pk, -1);
  } finally {
    __WL_method_state = __WL_oldState;
  }

  }

  public void __WL_setBeanParamsForBulkDeleteArray(
    java.sql.PreparedStatement[] __WL_stmt_array,
    boolean[] __WL_isModified)
    throws Exception
  {
      int __WL_oldState = __WL_method_state;

  try {
    __WL_method_state = STATE_EJB_REMOVE;

    java.lang.Long __WL_pk = (java.lang.Long) __WL_ctx.getPrimaryKey();

    __WL_setBeanParamsForDeleteArray(__WL_stmt_array, __WL_isModified, __WL_pk);
  } finally {
    __WL_method_state = __WL_oldState;
  }

  }

  public boolean[] __WL_getIsModifiedUnion(boolean[] __WL_isModifiedUnion) 
  {
    if (__WL_isModifiedUnion == null) {
      __WL_isModifiedUnion = new boolean[3];

    }

    boolean __WL_isModifiedUnionBoolean = false;
  
        for (int i=0; i<__WL_isModified.length; i++) {
      __WL_isModifiedUnion[i] |= __WL_isModified[i];
      __WL_isModifiedUnionBoolean |= __WL_isModified[i];
    }


    if (__WL_isModifiedUnionBoolean) {
      
    }
    
    return __WL_isModifiedUnion;
  }

  public void __WL_setIsModifiedVars(boolean __WL_isModifiedFlag,
                                     java.sql.Connection __WL_con)
    throws Exception
  {
      int __WL_oldState = __WL_method_state;

  try {
    __WL_method_state = STATE_EJBSTORE;

    int __WL_num = 1;
    java.lang.Long __WL_pk = (java.lang.Long) __WL_ctx.getPrimaryKey();
    

    for (int __WL_i = 0; __WL_i < __WL_isModified.length; __WL_i++) {
      __WL_isModified[__WL_i] = __WL_isModifiedFlag;
    }
    __WL_modifiedBeanIsRegistered = __WL_isModifiedFlag;
    
  } finally {
    __WL_method_state = __WL_oldState;
  }

  }

  public void __WL_setIsModifiedVars(int operation,boolean __WL_isModifiedFlag,
                                     java.sql.Connection __WL_con)
    throws java.sql.SQLException, Exception
  {
      int __WL_oldState = __WL_method_state;
  
  try {
    __WL_method_state = STATE_EJBSTORE;

    int __WL_num = 1;
    java.lang.Long __WL_pk = (java.lang.Long) __WL_ctx.getPrimaryKey();
    // No blob/clob field is defined for this cmp bean ;

    for (int __WL_i = 0; __WL_i < __WL_isModified.length; __WL_i++) {
      __WL_isModified[__WL_i] = __WL_isModifiedFlag;
    }
    __WL_modifiedBeanIsRegistered = __WL_isModifiedFlag;
    
  } finally {
    __WL_method_state = __WL_oldState;
  
  }

  }

  public void __WL_perhapsTakeSnapshot() {
    
    
  }

  public Collection __WL_getNullSnapshotVariables() {
    return null;
  }

  public boolean __WL_exists(Object __WL_key) {
        if (__WL_verbose) {
      Debug.say("exists: " + __WL_key);
    }

    java.sql.Connection __WL_con = null;
    java.sql.PreparedStatement __WL_stmt = null;
    java.sql.ResultSet __WL_rs = null;
    try {
      java.lang.Long __WL_pk = (java.lang.Long) __WL_key;
      __WL_con = __WL_pm.getConnection();

      java.lang.String __WL_query =
        "select ID_CATEGORIA_PRODUTO from CATEGORIA_PRODUTO where ID_CATEGORIA_PRODUTO = ?";

      __WL_stmt = __WL_con.prepareStatement(__WL_query);

      // preparedStatementParamIndex reset.
      
if(!__WL_pm.setParamNull(__WL_stmt, 1, __WL_pk, "id_categoria_produto")) {
__WL_stmt.setLong(1, __WL_pk.longValue());
if (__WL_verbose) {
Debug.say("paramIdx :"+1+" binded with value :"+__WL_pk);
}
}


      __WL_rs = __WL_stmt.executeQuery();
      if (__WL_rs.next()) {
        return true;
      }
      else {
        return false;
      }
        } catch (RuntimeException re) {
      if (__WL_verbose) {
        Debug.say("rethrowing RuntimeException.");
        re.printStackTrace();
      }
      throw re;
    } catch (Exception ex) {
      if (__WL_verbose) {
        Debug.say("wrapping Exception in PersistenceRuntimeException.");
        ex.printStackTrace();
      }
      throw new PersistenceRuntimeException(ex);
    }

    finally {
      __WL_pm.releaseResources(__WL_con, __WL_stmt, __WL_rs);
    }

  }

  public void __WL_checkExistsOnMethod() throws NoSuchEntityException
  {
      if (__WL_getIsRemoved()) {
    Loggable l = EJBLogger.lognoSuchEntityExceptionLoggable(
      ((EntityEJBContextImpl)__WL_ctx).__WL_getPrimaryKey().toString());
    NoSuchEntityException nsee = new NoSuchEntityException(l.getMessage());
    if (__WL_verbose) {
      Debug.say("throwing RuntimeException.");
      nsee.printStackTrace();
    }
    throw nsee;
  }

  if (__WL_beanIsLoaded()) return;

  int __WL_oldState = __WL_method_state;
  
  try {
    __WL_method_state = WLEnterpriseBean.STATE_BUSINESS_METHOD;
    __WL_pm.disableTransactionStatusCheck();

    __WL_loadGroup0();
      } catch (RuntimeException re) {
      if (__WL_verbose) {
        Debug.say("rethrowing RuntimeException.");
        re.printStackTrace();
      }
      throw re;
    } catch (Exception ex) {
      if (__WL_verbose) {
        Debug.say("wrapping Exception in PersistenceRuntimeException.");
        ex.printStackTrace();
      }
      throw new PersistenceRuntimeException(ex);
    }

  finally {
    __WL_method_state = __WL_oldState;
    __WL_pm.enableTransactionStatusCheck();
  }

  }

  public short __WL_getBeanState() 
  {
    return __WL_bean_state;
  } 

  public void __WL_setBeanState(short value)
  {
    __WL_bean_state = value;
  }

  public boolean __WL_getIsRemoved() { return __WL_isRemoved; }
  public void __WL_setIsRemoved(boolean b) { __WL_isRemoved = b; }

  public void __WL_setCreateAfterRemove(boolean createAfterRemove) {
    __WL_createAfterRemove = createAfterRemove;
  }
  public void __WL_setInvalidatedBeanIsRegistered(boolean invalidationFlag) {
    __WL_invalidatedBeanIsRegistered = invalidationFlag;
  }

  public int __WL_appendVerifySqlForBatch(java.util.List verifyPk, 
                                          StringBuffer[] verifySql, 
                                          int[] verifyCount,
                                          int verifyMax)
  {
    int __WL_oldState = __WL_method_state;

    try {
      __WL_method_state = STATE_EJBSTORE;

      
    }
    finally {
      __WL_method_state = __WL_oldState;
    }

    return verifyMax;
  }

  public void __WL_setVerifyParamsForBatch(java.sql.Connection con,
                                           java.sql.PreparedStatement[] __WL_stmt_array, 
                                           int[] verifyCount)
    throws SQLException 
  {
    
  }

  public int __WL_appendVerifySql(java.util.List verifyPk, 
                             StringBuffer[] verifySql, 
                             int[] verifyCount,
                             int verifyMax)
  {
    int __WL_oldState = __WL_method_state;

    try {
      __WL_method_state = STATE_EJBSTORE;
      
      
    }
    finally {
      __WL_method_state = __WL_oldState;
    }

    return verifyMax;
  }

  public void __WL_setVerifyParams(java.sql.Connection con,
                              java.sql.PreparedStatement[] __WL_stmt_array, 
                              int[] verifyCount)
    throws SQLException 
  {
    
  }


  public String __WL_getM2NSQL(String cmrf, int operation)
  {
    throw new AssertionError(" in __WL_getM2NSQL: unknown Many To Many cmr-field "+cmrf+".");

  }

  public Collection __WL_getCmrBeansForCmrField(String cmrf)
  {
    throw new AssertionError(" in __WL_getCmrBeansForCmrField: unknown Many To Many cmr-field "+cmrf+".");

  }


  // end of CMPBean
  // ================================================================


  //=================================================================
  // implementation of javax.ejb.EntityBean

  public boolean __WL_beanIsLoaded() { 
    return __WL_beanIsLoaded; 
  }

  

  public java.lang.Long ejbCreate(desafio.CategoriaProdutoVO arg0, desafio.ejb.geral.CategoriaProduto arg1)throws javax.ejb.CreateException,desafio.infra.DesafioException{
    int __WL_oldState = __WL_method_state;
    try {
      __WL_method_state = STATE_EJB_CREATE;

      for (int __WL_i = 0; __WL_i < 3; __WL_i++) {
        __WL_isLoaded[__WL_i] = true;
        __WL_isModified[__WL_i] = false;
      }

      __WL_beanIsLoaded = true;
      

      // set true, this prevents us from registering the bean until after the
      // database insert
      __WL_modifiedBeanIsRegistered = true;
      
__WL_produtoCategoriaProdutoBean_categoriaProduto_isLoaded_ = false;
__WL_categoriaPai_isLoaded_ = false;
__WL_categoriaProdutoBean_categoriaPai_isLoaded_ = false;


      // initialize persistent and cached relationship variables, this
      // is done here purely to ensure robustness as the CMP variables
      // are also initialized whenever the bean enters the pooled state
      
nome_categoria_produto = null;
id_categoria_pai = null;
id_categoria_produto = null;

      
__WL_produtoCategoriaProdutoBean_categoriaProduto_field_ = null;
__WL_categoriaPai_field_ = null;
__WL_categoriaProdutoBean_categoriaPai_field_ = null;



      super.ejbCreate( arg0, arg1);

      

      
java.lang.Long __WL_genKey = (java.lang.Long) __WL_pm.getNextGenKeyForSequence();

setId_categoria_produto(__WL_genKey);



      
java.lang.Long __WL_pk = null;
__WL_pk = (java.lang.Long) __WL_getPrimaryKey();
return __WL_pk;
} catch (javax.ejb.CreateException ce) {
throw ce;
}


    finally {
      __WL_method_state = __WL_oldState;
    }
}


  public void ejbPostCreate(desafio.CategoriaProdutoVO arg0, desafio.ejb.geral.CategoriaProduto arg1)throws javax.ejb.CreateException{
    int __WL_oldState = __WL_method_state;
    try {
      __WL_method_state = STATE_EJB_POSTCREATE;

      


      super.ejbPostCreate( arg0, arg1);

      if (!__WL_pm.getOrderDatabaseOperations())
__WL_create();


      

      } catch (javax.ejb.CreateException ce) {
throw ce;


          } catch (RuntimeException re) {
      if (__WL_verbose) {
        Debug.say("rethrowing RuntimeException.");
        re.printStackTrace();
      }
      throw re;
    } catch (Exception ex) {
      if (__WL_verbose) {
        Debug.say("wrapping Exception in PersistenceRuntimeException.");
        ex.printStackTrace();
      }
      throw new PersistenceRuntimeException(ex);
    }

    finally {
      __WL_method_state = __WL_oldState;
    }
}


    private Object __WL_create() throws Exception {
    if (__WL_verbose) {
      Debug.say("called __WL_create.");
    }

        
    java.sql.Connection __WL_con = null;
    
java.sql.PreparedStatement[] __WL_stmt_array = new java.sql.PreparedStatement[1];

java.sql.PreparedStatement __WL_stmt_CATEGORIA_PRODUTO_0 = null;
__WL_stmt_array[0] = __WL_stmt_CATEGORIA_PRODUTO_0;


    
String[] __WL_query_array = new String[1];

    java.sql.ResultSet __WL_rs = null;

    java.lang.Long __WL_pk = null;
    boolean __WL_beanInserted = false;
    try {
      
      
__WL_pk = this.id_categoria_produto;


      __WL_con = __WL_pm.getConnection();
      if(__WL_verbose) {
        Debug.say("__WL_create() got connection.");
      }

      __WL_query_array[0] = "INSERT INTO CATEGORIA_PRODUTO (ID_CATEGORIA_PAI, ID_CATEGORIA_PRODUTO, NOME_CATEGORIA_PRODUTO) VALUES (?, ?, ?)";


      if (__WL_verbose) {
        for (int i = 0 ; i < 1 ; i++) {
          Debug.say("__WL_create() produced sqlString " + __WL_query_array[i]);
        }
      }

      
if (__WL_query_array[0] != null) __WL_stmt_array[0] = __WL_con.prepareStatement(__WL_query_array[0]);


      __WL_setBeanParamsForCreateArray(__WL_stmt_array);

      if(__WL_verbose) {
        Debug.say("__WL_create() about to execute sql.");
      }

      if (__WL_stmt_array[0].executeUpdate() != 1)
throw new java.lang.Exception("Failed to CREATE Bean.  Primary Key Value: '" + __WL_pk + "'");
      __WL_beanInserted = true;
      

      for (int __WL_i = 0; __WL_i < __WL_isModified.length; __WL_i++) {
        __WL_isModified[__WL_i] = false;
      }
      __WL_modifiedBeanIsRegistered = false;

      return __WL_pk;
    } catch (java.sql.SQLException se) {
            //ejb wants a duplicate key exception if that was what happened
      if(__WL_beanInserted) throw se;
      if(__WL_verbose) {
        Debug.say("__WL_create() "+
           "checking for duplicate key " + __WL_pk);
      }
      boolean exists = false;
      try {
        exists = __WL_exists(__WL_pk);
      }
      catch (Exception e) {
        throw se;
      }
      if (exists) {
        Loggable l = EJBLogger.logduplicateKeyFoundLoggable(__WL_pk.toString());
        throw new javax.ejb.DuplicateKeyException(
             l.getMessage());
       }
      else {
        throw se;
      }

    } finally {
      __WL_pm.releaseResultSet(__WL_rs);
      __WL_pm.releaseArrayResources(__WL_con, __WL_stmt_array, null);
   }

  }


  public void ejbRemove() {
    java.sql.Connection __WL_con = null;
    
java.sql.PreparedStatement[] __WL_stmt_array = new java.sql.PreparedStatement[1];

java.sql.PreparedStatement __WL_stmt_CATEGORIA_PRODUTO_0 = null;
__WL_stmt_array[0] = __WL_stmt_CATEGORIA_PRODUTO_0;


    
String[] __WL_query_array = new String[1];

    
    java.sql.PreparedStatement __WL_stmt = null;

    int __WL_oldState = __WL_method_state;

    try {
      __WL_method_state = STATE_EJB_REMOVE;
      int __WL_num = 0;
      if (__WL_verbose) {
        Debug.say("ejbRemove " + __WL_ctx.getPrimaryKey());
      }
      super.ejbRemove();

      try {
        
getProdutoCategoriaProdutoBean_categoriaProduto();
((CategoriaProdutoBean_3k3wj0__WebLogic_CMP_RDBMS_produtoCategoriaProdutoBean_categoriaProduto_Set)__WL_produtoCategoriaProdutoBean_categoriaProduto_field_).clear(false);
__WL_setCategoriaPai(null, false);
getCategoriaProdutoBean_categoriaPai();
((CategoriaProdutoBean_3k3wj0__WebLogic_CMP_RDBMS_categoriaProdutoBean_categoriaPai_Set)__WL_categoriaProdutoBean_categoriaPai_field_).clear(true);


        java.lang.Long __WL_pk = (java.lang.Long) __WL_ctx.getPrimaryKey();
        
        
        __WL_con = __WL_pm.getConnection();

        __WL_query_array[0] = "DELETE FROM CATEGORIA_PRODUTO WHERE ID_CATEGORIA_PRODUTO = ?" ;


        
if (__WL_query_array[0] != null) __WL_stmt_array[0] = __WL_con.prepareStatement(__WL_query_array[0]);


        __WL_setBeanParamsForDeleteArray(__WL_stmt_array, __WL_isModified, __WL_pk);

        for (int i = 0 ; i < 1 ; i++) {
          int j = __WL_stmt_array[i].executeUpdate();
          if (j == 0) {
             Loggable l = EJBLogger.logbeanDoesNotExistLoggable("CategoriaProdutoBean",__WL_pk.toString()); 
throw new NoSuchEntityException(l.getMessage()); 
          }
        }

        // initialize state before this instance goes back into the pool
        __WL_initialize();

          } catch (RuntimeException re) {
      if (__WL_verbose) {
        Debug.say("rethrowing RuntimeException.");
        re.printStackTrace();
      }
      throw re;
    } catch (Exception ex) {
      if (__WL_verbose) {
        Debug.say("wrapping Exception in PersistenceRuntimeException.");
        ex.printStackTrace();
      }
      throw new PersistenceRuntimeException(ex);
    }

    } finally {
      __WL_method_state = __WL_oldState;
      __WL_pm.releaseArrayResources(__WL_con, __WL_stmt_array, null);
    }
}

  

  public void ejbLoad()
  {
    int __WL_oldState = __WL_method_state;
    try {
      __WL_method_state = STATE_EJBLOAD;

      __WL_initialize();

      super.ejbLoad();

    } finally {
      __WL_method_state = __WL_oldState;
    }
  }

  
public void ejbStore() {
    __WL_store(true);
}

  public void __WL_store(boolean unregister) 
  {
         
    java.sql.Connection __WL_con = null;
    
java.sql.PreparedStatement[] __WL_stmt_array = new java.sql.PreparedStatement[1];

java.sql.PreparedStatement __WL_stmt_CATEGORIA_PRODUTO_0 = null;
__WL_stmt_array[0] = __WL_stmt_CATEGORIA_PRODUTO_0;


    int __WL_oldState = __WL_method_state;


    try {
      __WL_method_state = STATE_EJBSTORE;
      if (__WL_verbose) {
        Debug.say("ejbStore "+ __WL_ctx.getPrimaryKey());
      }
      super.ejbStore();

      try {
        int __WL_num          = 0;
        int __WL_count        = 0;
        int __WL_total       = 0;
        
        java.lang.Long __WL_pk     = (java.lang.Long) __WL_ctx.getPrimaryKey();
        String __WL_query     = null;
        StringBuffer sb      = new StringBuffer();
        

        
        
        __WL_count = 0;

        
sb.setLength(0);
if (__WL_isModified[0])  {
if (__WL_count > 0) sb.append(", ");
sb.append("ID_CATEGORIA_PAI = ? ");
__WL_count++;
}

if (__WL_isModified[2])  {
if (__WL_count > 0) sb.append(", ");
sb.append("NOME_CATEGORIA_PRODUTO = ? ");
__WL_count++;
}



        __WL_total = __WL_total + __WL_count + 0;

        if ( (__WL_count > 0) || (0 > 0) ) {

          if(__WL_con == null) __WL_con  = __WL_pm.getConnection();

          if (__WL_count > 0 || false) {
            // we have modified non-Blob/Clob Columns

            
            

            if (sb.length() > 0) {          
              __WL_query = "UPDATE CATEGORIA_PRODUTO SET " +
                          sb.toString() +
                          " WHERE ID_CATEGORIA_PRODUTO = ?" 
                          ;
              if(__WL_verbose) {
                Debug.say("WL_store sql: " + __WL_query);
              }

              __WL_stmt_array[0] = __WL_con.prepareStatement(__WL_query);

              __WL_setBeanParamsForUpdateArray(__WL_stmt_array, __WL_isModified, __WL_pk, 0);

              int __WL_i = __WL_stmt_array[0].executeUpdate();
              if (__WL_i == 0) {
                 Loggable l = EJBLogger.logbeanDoesNotExistLoggable("CategoriaProdutoBean",__WL_pk.toString()); 
throw new NoSuchEntityException(l.getMessage()); 
              }
            }
          }

          if (0 > 0) {
            // we have modified Blob/Clob Columns
            
          }
        }


        if (__WL_total == 0) {
          if (__WL_verbose) {
            Debug.say("ejbStore: avoided a store.  ejbStore: complete");
          }
          return;
        }

        
        for (int __WL_i = 0; __WL_i < __WL_isModified.length; __WL_i++) {
          if (__WL_isModified[__WL_i]) {
            __WL_isModified[__WL_i] = false;
            __WL_isLoaded[__WL_i] = true;
          }
        }
        if (unregister) {
              __WL_pm.unregisterModifiedBean(__WL_ctx.getPrimaryKey());

        }
        __WL_modifiedBeanIsRegistered = false;
        

        if (__WL_verbose) {
          Debug.say("ejbStore: complete");
        }
          } catch (RuntimeException re) {
      if (__WL_verbose) {
        Debug.say("rethrowing RuntimeException.");
        re.printStackTrace();
      }
      throw re;
    } catch (Exception ex) {
      if (__WL_verbose) {
        Debug.say("wrapping Exception in PersistenceRuntimeException.");
        ex.printStackTrace();
      }
      throw new PersistenceRuntimeException(ex);
    }

    } 
    finally {
      __WL_method_state = __WL_oldState;
      __WL_pm.releaseArrayResources(__WL_con, __WL_stmt_array, null);
    }

  }


  public void ejbPassivate()
  {
    int __WL_oldState = __WL_method_state;
    try {
      __WL_method_state = STATE_EJB_PASSIVATE;
      super.ejbPassivate();

      __WL_initialize();
    } finally {
      __WL_method_state = __WL_oldState;
    }
  }

  // Blob/Clob methods
  

  // end javax.ejb.EntityBean
  //=================================================================
}


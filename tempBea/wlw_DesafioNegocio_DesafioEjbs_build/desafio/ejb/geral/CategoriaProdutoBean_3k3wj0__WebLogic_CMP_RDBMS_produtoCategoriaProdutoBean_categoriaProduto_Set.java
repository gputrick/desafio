/**
 * This code was automatically generated at 16:43:59 on 12/04/2016
 * by weblogic.ejb20.cmp.rdbms.codegen.OneToManyGenerator -- do not edit.
 *
 * @version WebLogic Server 8.1 SP6  Wed Jun 21 08:18:55 PDT 2006 781680 
 * @author Copyright (c) 2016 by BEA Systems, Inc. All Rights Reserved.
 */

package desafio.ejb.geral;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.lang.reflect.Array;
import java.io.Serializable;
import java.io.IOException;

import javax.ejb.EJBObject;
import javax.ejb.EJBLocalObject;
import javax.ejb.EntityContext;
import javax.ejb.EJBException;
import javax.ejb.NoSuchEntityException;

import javax.transaction.Transaction;

import weblogic.ejb20.internal.EntityEJBContextImpl;
import weblogic.ejb20.interfaces.WLEnterpriseBean;
import weblogic.ejb20.persistence.spi.CMPBeanManager;
import weblogic.ejb20.persistence.spi.EoWrapper;
import weblogic.ejb20.persistence.spi.EloWrapper;
import weblogic.ejb20.persistence.spi.PersistenceRuntimeException;

  
import weblogic.ejb20.cmp.rdbms.RDBMSException;
import weblogic.ejb20.cmp.rdbms.RDBMSSet;
import weblogic.ejb20.cmp.rdbms.RDBMSUtils;
import weblogic.ejb20.cmp.rdbms.RDBMSPersistenceManager;
import javax.transaction.TransactionManager;
import weblogic.transaction.TransactionHelper;


import weblogic.ejb20.EJBLogger;
import weblogic.logging.Loggable;
import weblogic.utils.Debug;
import weblogic.utils.collections.ArraySet;

public final class CategoriaProdutoBean_3k3wj0__WebLogic_CMP_RDBMS_produtoCategoriaProdutoBean_categoriaProduto_Set implements RDBMSSet, Set, Serializable,Cloneable
{
  // =================================================================
  // Class  variable(s)
  private static final boolean __WL_debug =
    (System.getProperty(RDBMSUtils.RDBMS_CODEGEN_DEBUG_PROP) != null);
  private static final boolean __WL_verbose =
    (System.getProperty(RDBMSUtils.RDBMS_CODEGEN_VERBOSE_PROP) != null);

  private CMPBeanManager __WL_bm;
  private Method __WL_finder;
  private Object __WL_createPk;
  private EJBLocalObject __WL_createEo;
  private Set __WL_cache;
  
  private Set __WL_add;
private Set __WL_rem;
private RDBMSPersistenceManager __WL_pm;


  private boolean isCreatorBeanInvalidated = false;
  private Transaction __WL_createTx;
  private desafio.ejb.geral.CategoriaProdutoBean_3k3wj0_Intf __WL_creator;



  public CategoriaProdutoBean_3k3wj0__WebLogic_CMP_RDBMS_produtoCategoriaProdutoBean_categoriaProduto_Set(desafio.ejb.geral.CategoriaProdutoBean_3k3wj0_Intf __WL_creator,
                              CMPBeanManager __WL_bm,
                              Method __WL_finder
                             ) {
    try {
      this.__WL_creator = __WL_creator;
      this.__WL_bm = __WL_bm;
      this.__WL_finder = __WL_finder;
      EntityEJBContextImpl __WL_ctx = (EntityEJBContextImpl) __WL_creator.__WL_getEntityContext();
      __WL_createPk = __WL_ctx.__WL_getPrimaryKey();
      __WL_createEo = __WL_ctx.__WL_getEJBLocalObject();

      __WL_add = new ArraySet(10);
__WL_rem = new ArraySet(10);
__WL_pm = (RDBMSPersistenceManager)__WL_creator.__WL_getPersistenceManager();


      __WL_createTx = TransactionHelper.getTransactionHelper().getTransaction();

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


  private void populateCache() {
    try {
      if (__WL_debug) {
        Debug.assertion(__WL_createPk !=null);
      }
      
            if (__WL_creator.__WL_getMethodState() == WLEnterpriseBean.STATE_EJB_POSTCREATE) {
		if (__WL_cache == null) __WL_cache = new HashSet();
      }

 else { 
__WL_cache = __WL_bm.localWrapperSetFinder(__WL_finder, new Object[] {__WL_createPk});
 } 

      

      	  Iterator __WL_additer = __WL_add.iterator();
	  while (__WL_additer.hasNext()) {
	    EloWrapper __WL_wrapper = (EloWrapper)__WL_additer.next();
	    if (!__WL_cache.contains(__WL_wrapper)) {
	      __WL_cache.add(__WL_wrapper);
	    }
	  }
	  Iterator __WL_remiter = __WL_rem.iterator();
	  while (__WL_remiter.hasNext()) {
	    EloWrapper __WL_wrapper = (EloWrapper)__WL_remiter.next();
	
	    if (__WL_cache.contains(__WL_wrapper)) {
	      __WL_cache.remove(__WL_wrapper);
	    }
	  }
	  __WL_add = null;
	  __WL_rem = null;

     
      isCreatorBeanInvalidated = false;
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


  //======================================================================
  //implementation of RDBMSSet
  public void doAdd(Object o)
  {
         if (__WL_verbose) Debug.say("doAdd() called.");

    EJBLocalObject eo = (EJBLocalObject)o;

    checkTransaction();

    EloWrapper wrap = new EloWrapper(eo);
    if (__WL_cache==null) {
      if (__WL_rem.contains(wrap)) {
        __WL_rem.remove(wrap);
      }
      if (__WL_debug) {
        Debug.assertion(!__WL_add.contains(wrap));
      }
      __WL_add.add(wrap);
    }
    else {
      if (__WL_debug) {
        Debug.assertion(!__WL_cache.contains(wrap));
      }
      __WL_cache.add(wrap);
    }
    
    if (!isCreatorBeanInvalidated) {
     __WL_pm.registerInvalidatedBean(__WL_createPk);
     isCreatorBeanInvalidated = true;
    }

  }

  public void doRemove(Object o) {
    doRemove(o, true);
  }

  public void doRemove(Object o, boolean remove)
  {
        checkTransaction();

    EJBLocalObject eo = (EJBLocalObject)o;

    EloWrapper wrap = new EloWrapper(eo);
    if (__WL_cache==null) {
      if (__WL_add.contains(wrap)) {
        __WL_add.remove(wrap);
      }

      if (__WL_debug) {
        Debug.assertion(!__WL_rem.contains(wrap));
      }
      __WL_rem.add(wrap);
    }
    else {
      if (remove) {
        if (__WL_debug) {
          Debug.assertion(__WL_cache.contains(wrap));
        }
        __WL_cache.remove(wrap);
      }
    }
    if(!isCreatorBeanInvalidated) {
      __WL_pm.registerInvalidatedBean(__WL_createPk);
      isCreatorBeanInvalidated = true;
    }

  }

  public void doAddToCache(Object o)
  {
    if (__WL_verbose) Debug.say("doAddToCache() called.");

    if (__WL_cache==null) {
      __WL_cache = new HashSet(10);
    }

    if (o == null) return;

    EJBLocalObject eo = (EJBLocalObject)o;

    EloWrapper wrap = new EloWrapper(eo);

    if (__WL_debug) {
      Debug.assertion(!__WL_cache.contains(wrap));
    }
    __WL_cache.add(wrap);
  }


  //======================================================================
  //implementation of java.util.Collection
  public Iterator iterator() {

    checkTransaction();

    if (__WL_cache==null) {
      populateCache();
    }

    return new CategoriaProdutoBean_3k3wj0__WebLogic_CMP_RDBMS_produtoCategoriaProdutoBean_categoriaProduto_Iterator(__WL_cache.iterator(), this);
  }

  public Transaction getTransaction() { return __WL_createTx; }

  public void setTransaction(Transaction newCreateTx) {
    __WL_createTx = newCreateTx; 
   }

  public void setIsCreatorBeanInvalidated(boolean value) {
   isCreatorBeanInvalidated = value;
  }

  public boolean add(Object o) {

    checkTransaction();

    if (o==null)
      throw new IllegalArgumentException();

    if (!(o instanceof desafio.ejb.geral.ProdutoCategoriaProduto))
      throw new IllegalArgumentException(
        "Attempted to add an object of type '" +
        o.getClass().getName() +
        "' to collection, but the type must be '" +
        "desafio.ejb.geral.ProdutoCategoriaProduto' instead.");

    try {
      EJBLocalObject eo = (EJBLocalObject)o;
      desafio.ejb.geral.ProdutoCategoriaProdutoBean_vhvw4g_Intf __WL_bean = (desafio.ejb.geral.ProdutoCategoriaProdutoBean_vhvw4g_Intf)
        __WL_bm.lookup(eo.getPrimaryKey());
      int __WL_oldState = __WL_bean.__WL_getMethodState();
      try {
        __WL_bean.__WL_setMethodState(WLEnterpriseBean.STATE_BUSINESS_METHOD);
        
        

        try {
          __WL_bean.__WL_checkExistsOnMethod();
        }
        catch (NoSuchEntityException nsee) {
          Loggable l = EJBLogger.logbeanDoesNotExistLoggable("ProdutoCategoriaProdutoBean",eo.getPrimaryKey().toString());
          throw new IllegalArgumentException(l.getMessage());  
        }
        if (__WL_createPk.equals(__WL_bean.getId_categoria_produto())) {
          return false;
        }
        else {
          __WL_bean.setCategoriaProduto(
            (desafio.ejb.geral.CategoriaProduto)__WL_createEo);
          return true;
        }
      } finally {
        __WL_bean.__WL_setMethodState(__WL_oldState);
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


  public boolean addAll(Collection __WL_collection) {
    checkTransaction();

    if (__WL_collection==null) return false;

    Collection temp = new ArrayList();
    temp.addAll(__WL_collection);
    Iterator __WL_iter = temp.iterator();

    boolean changed = false;
    while (__WL_iter.hasNext()) {
      changed |= add(__WL_iter.next());
    }
    return changed;
  }


  public void clear() {
    clear(false);
  }


  public void clear(boolean ejbStore) {
    checkTransaction();

    if (__WL_cache==null) {
      populateCache();
    }

    Collection cln = (Collection)((HashSet)__WL_cache).clone();
    Iterator __WL_iter = cln.iterator();
    while (__WL_iter.hasNext()) {
      EloWrapper __WL_wrapper = (EloWrapper)__WL_iter.next();
      remove(__WL_wrapper.getEJBLocalObject(), ejbStore);
    }
  }


  public boolean contains(Object o) {
    checkTransaction();

    if (o==null)
      return false;

    if (!(o instanceof desafio.ejb.geral.ProdutoCategoriaProduto))
      return false;

    try {
      EJBLocalObject eo = (EJBLocalObject)o;
      if (__WL_cache !=null) {
        EloWrapper wrap = new EloWrapper(eo);
        return __WL_cache.contains(wrap);
      }
      else {
        desafio.ejb.geral.ProdutoCategoriaProdutoBean_vhvw4g_Intf __WL_bean = (desafio.ejb.geral.ProdutoCategoriaProdutoBean_vhvw4g_Intf)
          __WL_bm.lookup(eo.getPrimaryKey());

        try {
          __WL_bean.__WL_checkExistsOnMethod();
        }
        catch (NoSuchEntityException nsee) {
          Loggable l = EJBLogger.logbeanDoesNotExistLoggable("ProdutoCategoriaProdutoBean",eo.getPrimaryKey().toString());
          throw new IllegalArgumentException(l.getMessage());  
        }

        int __WL_oldState = __WL_bean.__WL_getMethodState();
        try {
          __WL_bean.__WL_setMethodState(WLEnterpriseBean.STATE_BUSINESS_METHOD);
          
          
          if (__WL_createPk.equals(__WL_bean.getId_categoria_produto())) {
            return true;
          }
          else {
            return false;
          }
        } finally {
          __WL_bean.__WL_setMethodState(__WL_oldState);
        }
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

  public boolean containsAll(Collection eos) {
    checkTransaction();

    if (eos==null)
      return true;

    Iterator iter = eos.iterator();
    while (iter.hasNext()) {
      if (!contains(iter.next())) {
        return false;
      }
    }

    return true;
  }


  public boolean equals(Object o) {
    checkTransaction();

    if (!(o instanceof CategoriaProdutoBean_3k3wj0__WebLogic_CMP_RDBMS_produtoCategoriaProdutoBean_categoriaProduto_Set))
      return false;

    CategoriaProdutoBean_3k3wj0__WebLogic_CMP_RDBMS_produtoCategoriaProdutoBean_categoriaProduto_Set other = (CategoriaProdutoBean_3k3wj0__WebLogic_CMP_RDBMS_produtoCategoriaProdutoBean_categoriaProduto_Set)o;

    if (__WL_cache==null)
      populateCache();
    if (other.__WL_cache==null)
      other.populateCache();

    return __WL_cache.equals(other.__WL_cache);
  }


  public int hashCode() {
    checkTransaction();

    if (__WL_cache==null)
      populateCache();
    return __WL_cache.hashCode();
  }


  public boolean isEmpty() {
    checkTransaction();

    if (__WL_cache==null)
      populateCache();

    return __WL_cache.isEmpty();
  }


  public boolean remove(Object o)
  {
    return remove(o, false);
  }

  public boolean remove(Object o, boolean ejbStore)
  {
    return remove(o, ejbStore, true);
  }


  // The flag 'remove' controls whether the Relationship's
  // underlying __WL_cache does a remove() operation.
  // If an Iterator of the __WL_cache is used to effect a remove()
  // then we must be sure to not do a __WL_cache.remove()
  //   that is the intended use of the 'remove' flag.

  public boolean remove(Object o, boolean ejbStore, boolean remove)

  {
    checkTransaction();

    if (o==null)
      throw new IllegalArgumentException();

    if (!(o instanceof desafio.ejb.geral.ProdutoCategoriaProduto))
      throw new IllegalArgumentException(
        "Attempted to add an object of type '" +
        o.getClass().getName() +
        "' to collection, but the type must be '" +
        "desafio.ejb.geral.ProdutoCategoriaProduto' instead.");

    try {
      EJBLocalObject eo = (EJBLocalObject)o;
      desafio.ejb.geral.ProdutoCategoriaProdutoBean_vhvw4g_Intf __WL_bean = (desafio.ejb.geral.ProdutoCategoriaProdutoBean_vhvw4g_Intf)
        __WL_bm.lookup(eo.getPrimaryKey());

      try {
        __WL_bean.__WL_checkExistsOnMethod();
      }
      catch (NoSuchEntityException nsee) {
          Loggable l = EJBLogger.logbeanDoesNotExistLoggable("ProdutoCategoriaProdutoBean",eo.getPrimaryKey().toString());
          throw new IllegalArgumentException(l.getMessage());  
      }

      int __WL_oldState = __WL_bean.__WL_getMethodState();
      try {
        __WL_bean.__WL_setMethodState(WLEnterpriseBean.STATE_BUSINESS_METHOD);
        
        
        if (!__WL_createPk.equals(__WL_bean.getId_categoria_produto())) {
          return false;
        }
        else {
          __WL_bean.__WL_setCategoriaProduto(null, ejbStore, remove);
          return true;
        }
      } finally {
        __WL_bean.__WL_setMethodState(__WL_oldState);
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


  public boolean removeAll(Collection col) {
    checkTransaction();

    if (col==null)
      return false;

    boolean changed = false;
    Iterator iter = col.iterator();
    while (iter.hasNext()) {
      changed |= remove(iter.next(), false);
    }

    return changed;
  }


  public boolean retainAll(Collection c) {
    checkTransaction();

    Iterator iter = iterator();
    List toRemove = new ArrayList();

    while (iter.hasNext()) {
      EJBLocalObject eo = (EJBLocalObject)iter.next();

      if (c != null && !c.contains(eo)) {
        toRemove.add(eo);
      }
    }

    Iterator remIter = toRemove.iterator();
    boolean changed = false;
    while (remIter.hasNext()) {
      EJBLocalObject eo = (EJBLocalObject)remIter.next();
      changed |= this.remove(eo);
    }

    return changed;
  }


  public int size() {
    checkTransaction();

    if (__WL_cache==null)
      populateCache();

    return __WL_cache.size();
  }


  public Object[] toArray()
  {
    if (__WL_verbose) Debug.say("toArray() called.");

    checkTransaction();

    if (__WL_cache==null) populateCache();

    int i = 0;
    Object[] arry = new Object[__WL_cache.size()];
    Iterator iter = __WL_cache.iterator();
    while (iter.hasNext()) {
      EloWrapper wrap = (EloWrapper)iter.next();
      arry[i++] = wrap.getEJBLocalObject();
    }

    return arry;
  }


  public Object[] toArray(Object[] a)
  {
    if (__WL_verbose) Debug.say("toArray() called.");

    checkTransaction();

    if (a==null)
      throw new ArrayStoreException(
        "Null argument passed to CategoriaProdutoBean_3k3wj0__WebLogic_CMP_RDBMS_produtoCategoriaProdutoBean_categoriaProduto_Set.toArray");

    try {
      Class toClass = a.getClass().getComponentType();

      if (__WL_cache==null) populateCache();

      if (a.length<__WL_cache.size())
        a = (Object[])Array.newInstance(toClass, __WL_cache.size());

      int i = 0;
      Iterator iter = __WL_cache.iterator();
      while (iter.hasNext()) {
        EloWrapper wrap = (EloWrapper)iter.next();
        desafio.ejb.geral.ProdutoCategoriaProduto elem = 
          (desafio.ejb.geral.ProdutoCategoriaProduto)wrap.getEJBLocalObject();

        if (i==0) {
          Class colClass = elem.getClass();
          if (!toClass.isAssignableFrom(colClass)) {
            throw new ArrayStoreException(
              "Argument type '" +
              toClass.getName() +
              "' passed to CategoriaProdutoBean_3k3wj0__WebLogic_CMP_RDBMS_produtoCategoriaProdutoBean_categoriaProduto_Set.toArray " +
              "is not a superclass of the element type of the collection '" +
              colClass.getName() +
              "'.");
          }
        }

        a[i++] = elem;
      }

      while (i<a.length) {
        a[i++] = null;
      }

      return a;
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

  private void checkTransaction()
  {
    Transaction tx = TransactionHelper.getTransactionHelper().getTransaction();

    if (tx==null) {
      Loggable l = EJBLogger.logaccessedCmrCollectionOutsideTransactionLoggable("CategoriaProdutoBean", "produtoCategoriaProdutoBean_categoriaProduto");
      throw new IllegalStateException(
        l.getMessage());
    }
    if (!tx.equals(__WL_createTx) && ! false ) {

      Loggable l1 = EJBLogger.logaccessedCmrCollectionInDifferentTransactionLoggable("CategoriaProdutoBean", "produtoCategoriaProdutoBean_categoriaProduto");
      throw new IllegalStateException(
        l1.getMessage());
    }
  }
  
   public boolean checkIfCurrentTxEqualsCreateTx(javax.transaction.Transaction currentTx) {

     if(currentTx != null && currentTx.equals(__WL_createTx))
       return true;
     else
       return false;
  }
 
  public Object clone()  throws CloneNotSupportedException {
     return super.clone();
  }
 
  private void writeObject(java.io.ObjectOutputStream out)
    throws IOException
  {
    throw new EJBException(
      "Attempt to serialize a collection that implements a cmr-field.  " +
      "Collections managed by the CMP RDBMS persistence manager may not " +
      "be passed directly to a remote client.");
  }

  private void readObject(java.io.ObjectInputStream in)
    throws IOException, ClassNotFoundException
  {
    // this method is never called

    throw new EJBException(
      "Attempt to serialize a collection that implements a cmr-field.  " +
      "Collections managed by the CMP RDBMS persistence manager may not " +
      "be passed directly to a remote client.");
  }
}

/**
 * This code was automatically generated at 16:43:59 on 12/04/2016
 * by weblogic.ejb20.cmp.rdbms.codegen.OneToManyGenerator -- do not edit.
 *
 * @version WebLogic Server 8.1 SP6  Wed Jun 21 08:18:55 PDT 2006 781680 
 * @author Copyright (c) 2016 by BEA Systems, Inc. All Rights Reserved.
 */

package desafio.ejb.geral;

import java.util.Iterator;
import java.util.Set;

import javax.transaction.Transaction;

import weblogic.ejb20.persistence.spi.EoWrapper;
import weblogic.ejb20.persistence.spi.EloWrapper;
import weblogic.ejb20.EJBTextTextFormatter;
import weblogic.ejb20.EJBLogger;
import weblogic.logging.Loggable;
import weblogic.transaction.TransactionHelper;
import weblogic.utils.Debug;


public class CategoriaProdutoBean_3k3wj0__WebLogic_CMP_RDBMS_produtoCategoriaProdutoBean_categoriaProduto_Iterator implements Iterator {

  private EloWrapper currWrapper = null;
  private Iterator __WL_iter;
  private CategoriaProdutoBean_3k3wj0__WebLogic_CMP_RDBMS_produtoCategoriaProdutoBean_categoriaProduto_Set __WL_creator;
  private Transaction __WL_createTx;

  public CategoriaProdutoBean_3k3wj0__WebLogic_CMP_RDBMS_produtoCategoriaProdutoBean_categoriaProduto_Iterator(Iterator __WL_iter,
                            CategoriaProdutoBean_3k3wj0__WebLogic_CMP_RDBMS_produtoCategoriaProdutoBean_categoriaProduto_Set __WL_creator) 
  {
    this.__WL_iter = __WL_iter;
    this.__WL_creator = __WL_creator;
    this.__WL_createTx = __WL_creator.getTransaction();
  }

  public boolean hasNext() 
  {
    checkTransaction();

    return __WL_iter.hasNext();
  }

  // Note: IllegalStateException checking for illegal
  //       calls to next() and remove() are deferred to
  //       the underlying Iterator.

  public Object next() 
  {
    checkTransaction();

    currWrapper = (EloWrapper)__WL_iter.next();
    return currWrapper.getEJBLocalObject();
  }

  public void remove() 
  {
    checkTransaction();

    __WL_iter.remove();
    if (null == currWrapper) {
      return;
    }
    __WL_creator.remove(currWrapper.getEJBLocalObject(),
                       false,      // do ejbStore()
                       false);     // do Collection.remove()
  }

  private void checkTransaction()
  {
    Transaction tx = TransactionHelper.getTransactionHelper().getTransaction();

    if (tx==null) {
      Loggable l = EJBLogger.logaccessedCmrIteratorOutsideTransactionLoggable("CategoriaProdutoBean", "produtoCategoriaProdutoBean_categoriaProduto");
      throw new IllegalStateException(
        l.getMessage());
    }

    if (!tx.equals(__WL_createTx) && ! false ) {
      Loggable l1 = EJBLogger.logaccessedCmrIteratorInDifferentTransactionLoggable("CategoriaProdutoBean", "produtoCategoriaProdutoBean_categoriaProduto");
      throw new IllegalStateException(l1.getMessage());
    }
  }
}

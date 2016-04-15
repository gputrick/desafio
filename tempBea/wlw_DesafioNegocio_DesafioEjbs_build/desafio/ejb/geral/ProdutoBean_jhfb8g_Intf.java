/**
 * This code was automatically generated at 15:39:30 on 15/04/2016
 * by weblogic.ejb20.cmp.rdbms.codegen.RDBMSCodeGenerator -- do not edit.
 *
 * @version WebLogic Server 8.1 SP6  Wed Jun 21 08:18:55 PDT 2006 781680 
 * @author Copyright (c) 2016 by BEA Systems, Inc. All Rights Reserved.
 */

package desafio.ejb.geral;

import weblogic.ejb20.interfaces.WLEnterpriseBean;

public interface ProdutoBean_jhfb8g_Intf 
  extends WLEnterpriseBean, weblogic.ejb20.persistence.spi.CMPBean
{

public void ejbActivate();
public java.lang.Long ejbCreate(desafio.ProdutoVO arg0)
     throws javax.ejb.CreateException, desafio.infra.DesafioException;
public void ejbLoad();
public void ejbPassivate();
public void ejbPostCreate(desafio.ProdutoVO arg0)
     throws javax.ejb.CreateException;
public void ejbRemove();
public void ejbStore();
public desafio.ProdutoVO getData() throws desafio.infra.DesafioException;
public abstract java.lang.Long getId_produto();
public abstract java.lang.String getNome_produto();
public void setData(desafio.ProdutoVO arg0)
     throws desafio.infra.DesafioException;
public void setEntityContext(javax.ejb.EntityContext arg0);
public abstract void setId_produto(java.lang.Long arg0);
public abstract void setNome_produto(java.lang.String arg0);
public void unsetEntityContext();
public void validaProduto(desafio.ProdutoVO arg0)
     throws desafio.infra.DesafioException;
public java.util.Collection getProdutoCategoriaProdutoBean_produto();
public void __WL_add__WL_produtoCategoriaProdutoBean_produto_field_(Object obj);public void setProdutoCategoriaProdutoBean_produto(java.util.Collection produtoCategoriaProdutoBean_produto);
public java.lang.Object ejbFindByProdutoCategoriaProdutoBean_vhvw4g__WebLogic_CMP_RDBMS_produto__WL_
    (java.lang.Long param0
    ) throws java.lang.Exception
    ;
public Object __WL_getPKFromRSInstance(java.sql.ResultSet rs, java.lang.Integer offset, ClassLoader cl)
throws java.sql.SQLException, java.lang.Exception;
public void __WL_loadGroup0FromRS
(java.sql.ResultSet rs, java.lang.Integer offset, Object __WL_pk, desafio.ejb.geral.ProdutoBean_jhfb8g_Intf var) 
throws java.sql.SQLException, java.lang.Exception;
public void __WL_loadCMRFieldFromRS_produtoCategoriaProdutoBean_produto
(java.sql.ResultSet rs, java.lang.Integer offset, desafio.ejb.geral.ProdutoBean_jhfb8g_Intf var) 
throws java.sql.SQLException, java.lang.Exception;
public boolean __WL_exists(Object key);
public boolean __WL_beanIsLoaded();
public java.lang.Object ejbFindByPrimaryKey(java.lang.Long param0) throws javax.ejb.FinderException
    ;


}

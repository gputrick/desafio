/**
 * This code was automatically generated at 15:39:30 on 15/04/2016
 * by weblogic.ejb20.cmp.rdbms.codegen.RDBMSCodeGenerator -- do not edit.
 *
 * @version WebLogic Server 8.1 SP6  Wed Jun 21 08:18:55 PDT 2006 781680 
 * @author Copyright (c) 2016 by BEA Systems, Inc. All Rights Reserved.
 */

package desafio.ejb.geral;

import weblogic.ejb20.interfaces.WLEnterpriseBean;

public interface ProdutoCategoriaProdutoBean_vhvw4g_Intf 
  extends WLEnterpriseBean, weblogic.ejb20.persistence.spi.CMPBean
{

public void ejbActivate();
public desafio.ejb.geral.ProdutoCategoriaProdutoBeanPK ejbCreate(desafio.ProdutoCategoriaProdutoVO arg0)
     throws javax.ejb.CreateException, desafio.infra.DesafioException;
public void ejbLoad();
public void ejbPassivate();
public void ejbPostCreate(desafio.ProdutoCategoriaProdutoVO arg0)
     throws javax.ejb.CreateException;
public void ejbRemove();
public void ejbStore();
public abstract desafio.ejb.geral.CategoriaProduto getCategoriaProduto();
public desafio.ProdutoCategoriaProdutoVO getData()
     throws desafio.infra.DesafioException;
public abstract java.lang.Long getId_categoria_produto();
public abstract java.lang.Long getId_produto();
public abstract desafio.ejb.geral.Produto getProduto();
public abstract void setCategoriaProduto(desafio.ejb.geral.CategoriaProduto arg0);
public void setData(desafio.ProdutoCategoriaProdutoVO arg0)
     throws desafio.infra.DesafioException;
public void setEntityContext(javax.ejb.EntityContext arg0);
public abstract void setId_categoria_produto(java.lang.Long arg0);
public abstract void setId_produto(java.lang.Long arg0);
public abstract void setProduto(desafio.ejb.geral.Produto arg0);
public void unsetEntityContext();
public void validaProdutoCategoriaProduto(desafio.ProdutoCategoriaProdutoVO arg0)
     throws desafio.infra.DesafioException;
public void __WL_add__WL_categoriaProduto_field_(Object obj);public void __WL_setCategoriaProduto(desafio.ejb.geral.CategoriaProduto categoriaProduto, boolean ejbStore, boolean remove);
public void __WL_add__WL_produto_field_(Object obj);public void __WL_setProduto(desafio.ejb.geral.Produto produto, boolean ejbStore, boolean remove);
public java.util.Collection ejbFindByCategoriaProdutoBean_3k3wj0__WebLogic_CMP_RDBMS_produtoCategoriaProdutoBean_categoriaProduto__WL_
    (java.lang.Long param0
    ) throws java.lang.Exception
    ;
public java.util.Collection ejbFindByProdutoBean_jhfb8g__WebLogic_CMP_RDBMS_produtoCategoriaProdutoBean_produto__WL_
    (java.lang.Long param0
    ) throws java.lang.Exception
    ;
public Object __WL_getPKFromRSInstance(java.sql.ResultSet rs, java.lang.Integer offset, ClassLoader cl)
throws java.sql.SQLException, java.lang.Exception;
public void __WL_loadGroup0FromRS
(java.sql.ResultSet rs, java.lang.Integer offset, Object __WL_pk, desafio.ejb.geral.ProdutoCategoriaProdutoBean_vhvw4g_Intf var) 
throws java.sql.SQLException, java.lang.Exception;
public void __WL_loadCMRFieldFromRS_categoriaProduto
(java.sql.ResultSet rs, java.lang.Integer offset, desafio.ejb.geral.ProdutoCategoriaProdutoBean_vhvw4g_Intf var) 
throws java.sql.SQLException, java.lang.Exception;
public void __WL_loadCMRFieldFromRS_produto
(java.sql.ResultSet rs, java.lang.Integer offset, desafio.ejb.geral.ProdutoCategoriaProdutoBean_vhvw4g_Intf var) 
throws java.sql.SQLException, java.lang.Exception;
public boolean __WL_exists(Object key);
public boolean __WL_beanIsLoaded();
public java.lang.Object ejbFindByPrimaryKey(desafio.ejb.geral.ProdutoCategoriaProdutoBeanPK param0
    ) throws javax.ejb.FinderException
    ;


}

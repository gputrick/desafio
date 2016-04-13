/**
 * This code was automatically generated at 16:43:59 on 12/04/2016
 * by weblogic.ejb20.cmp.rdbms.codegen.RDBMSCodeGenerator -- do not edit.
 *
 * @version WebLogic Server 8.1 SP6  Wed Jun 21 08:18:55 PDT 2006 781680 
 * @author Copyright (c) 2016 by BEA Systems, Inc. All Rights Reserved.
 */

package desafio.ejb.geral;

import weblogic.ejb20.interfaces.WLEnterpriseBean;

public interface CategoriaProdutoBean_3k3wj0_Intf 
  extends WLEnterpriseBean, weblogic.ejb20.persistence.spi.CMPBean
{

public void ejbActivate();
public java.lang.Long ejbCreate(desafio.CategoriaProdutoVO arg0, desafio.ejb.geral.CategoriaProduto arg1)
     throws javax.ejb.CreateException, desafio.infra.DesafioException;
public void ejbLoad();
public void ejbPassivate();
public void ejbPostCreate(desafio.CategoriaProdutoVO arg0, desafio.ejb.geral.CategoriaProduto arg1)
     throws javax.ejb.CreateException;
public void ejbRemove();
public void ejbStore();
public abstract desafio.ejb.geral.CategoriaProduto getCategoriaPai();
public desafio.CategoriaProdutoVO getData()
     throws desafio.infra.DesafioException;
public abstract java.lang.Long getId_categoria_pai();
public abstract java.lang.Long getId_categoria_produto();
public abstract java.lang.String getNome_categoria_produto();
public abstract void setCategoriaPai(desafio.ejb.geral.CategoriaProduto arg0);
public void setData(desafio.CategoriaProdutoVO arg0)
     throws desafio.infra.DesafioException;
public void setEntityContext(javax.ejb.EntityContext arg0);
public abstract void setId_categoria_pai(java.lang.Long arg0);
public abstract void setId_categoria_produto(java.lang.Long arg0);
public abstract void setNome_categoria_produto(java.lang.String arg0);
public void unsetEntityContext();
public void validaCategoriaProduto(desafio.CategoriaProdutoVO arg0)
     throws desafio.infra.DesafioException;
public java.util.Collection getProdutoCategoriaProdutoBean_categoriaProduto();
public java.util.Collection getCategoriaProdutoBean_categoriaPai();
public void __WL_add__WL_produtoCategoriaProdutoBean_categoriaProduto_field_(Object obj);public void setProdutoCategoriaProdutoBean_categoriaProduto(java.util.Collection produtoCategoriaProdutoBean_categoriaProduto);
public void __WL_add__WL_categoriaPai_field_(Object obj);public void __WL_setCategoriaPai(desafio.ejb.geral.CategoriaProduto categoriaPai, boolean ejbStore, boolean remove);
public void __WL_add__WL_categoriaProdutoBean_categoriaPai_field_(Object obj);public void setCategoriaProdutoBean_categoriaPai(java.util.Collection categoriaProdutoBean_categoriaPai);
public java.lang.Object ejbFindByProdutoCategoriaProdutoBean_vhvw4g__WebLogic_CMP_RDBMS_categoriaProduto__WL_
    (java.lang.Long param0
    ) throws java.lang.Exception
    ;
public java.util.Collection ejbFindByCategoriaProdutoBean_3k3wj0__WebLogic_CMP_RDBMS_categoriaProdutoBean_categoriaPai__WL_
    (java.lang.Long param0
    ) throws java.lang.Exception
    ;
public java.lang.Object ejbFindByCategoriaProdutoBean_3k3wj0__WebLogic_CMP_RDBMS_categoriaPai__WL_
    (java.lang.Long param0
    ) throws java.lang.Exception
    ;
public Object __WL_getPKFromRSInstance(java.sql.ResultSet rs, java.lang.Integer offset, ClassLoader cl)
throws java.sql.SQLException, java.lang.Exception;
public void __WL_loadGroup0FromRS
(java.sql.ResultSet rs, java.lang.Integer offset, Object __WL_pk, desafio.ejb.geral.CategoriaProdutoBean_3k3wj0_Intf var) 
throws java.sql.SQLException, java.lang.Exception;
public void __WL_loadCMRFieldFromRS_categoriaPai
(java.sql.ResultSet rs, java.lang.Integer offset, desafio.ejb.geral.CategoriaProdutoBean_3k3wj0_Intf var) 
throws java.sql.SQLException, java.lang.Exception;
public void __WL_loadCMRFieldFromRS_produtoCategoriaProdutoBean_categoriaProduto
(java.sql.ResultSet rs, java.lang.Integer offset, desafio.ejb.geral.CategoriaProdutoBean_3k3wj0_Intf var) 
throws java.sql.SQLException, java.lang.Exception;
public void __WL_loadCMRFieldFromRS_categoriaProdutoBean_categoriaPai
(java.sql.ResultSet rs, java.lang.Integer offset, desafio.ejb.geral.CategoriaProdutoBean_3k3wj0_Intf var) 
throws java.sql.SQLException, java.lang.Exception;
public boolean __WL_exists(Object key);
public boolean __WL_beanIsLoaded();
public java.lang.Object ejbFindByPrimaryKey(java.lang.Long param0) throws javax.ejb.FinderException
    ;


}

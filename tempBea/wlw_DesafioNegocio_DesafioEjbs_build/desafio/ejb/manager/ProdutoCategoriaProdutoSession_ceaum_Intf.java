/**
* This code was automatically generated at 11:20:45 on 18/04/2016
* by weblogic.ejb20.ejbc.Ejb2Rmi -- do not edit.
*
* @version WebLogic Server 8.1 SP6  Wed Jun 21 08:18:55 PDT 2006 781680 
* @author Copyright (c) 2016 by BEA Systems, Inc. All Rights Reserved.
*/

package desafio.ejb.manager;

import weblogic.ejb20.interfaces.WLEnterpriseBean;

public interface ProdutoCategoriaProdutoSession_ceaum_Intf 
extends WLEnterpriseBean
{
  
  public desafio.ProdutoCategoriaProdutoVO atualizarProdutoCategoriaProduto(desafio.ProdutoCategoriaProdutoVO arg0)
  throws desafio.infra.DesafioException, javax.naming.NamingException;
  public void ejbActivate();
  public void ejbCreate();
  public void ejbPassivate();
  public void ejbRemove();
  public void eliminarProdutoCategoriaProduto(desafio.ProdutoCategoriaProdutoVO arg0)
  throws desafio.infra.DesafioException;
  public desafio.ProdutoCategoriaProdutoVO obterProdutoCategoriaProduto(desafio.ProdutoCategoriaProdutoVO arg0)
  throws desafio.infra.DesafioException;
  public void setSessionContext(javax.ejb.SessionContext arg0);
  
  
}

/**
* This code was automatically generated at 15:39:30 on 15/04/2016
* by weblogic.ejb20.ejbc.Ejb2Rmi -- do not edit.
*
* @version WebLogic Server 8.1 SP6  Wed Jun 21 08:18:55 PDT 2006 781680 
* @author Copyright (c) 2016 by BEA Systems, Inc. All Rights Reserved.
*/

package desafio.ejb.manager;

import weblogic.ejb20.interfaces.WLEnterpriseBean;

public interface ProdutoSession_15liyi_Intf 
extends WLEnterpriseBean
{
  
  public desafio.ProdutoVO addProdutoCategoriaProduto(desafio.ProdutoCategoriaProdutoVO arg0, desafio.ProdutoVO arg1)
  throws desafio.infra.DesafioException;
  public desafio.ProdutoVO atualizarProduto(desafio.ProdutoVO arg0)
  throws desafio.infra.DesafioException;
  public void delProdutoCategoriaProduto(desafio.ProdutoCategoriaProdutoVO arg0, desafio.ProdutoVO arg1)
  throws desafio.infra.DesafioException;
  public void ejbActivate();
  public void ejbCreate();
  public void ejbPassivate();
  public void ejbRemove();
  public void eliminarProduto(desafio.ProdutoVO arg0)
  throws desafio.infra.DesafioException;
  public desafio.ProdutoVO obterProduto(desafio.ProdutoVO arg0)
  throws desafio.infra.DesafioException;
  public void setSessionContext(javax.ejb.SessionContext arg0);
  
  
}

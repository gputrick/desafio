/**
* This code was automatically generated at 15:39:30 on 15/04/2016
* by weblogic.ejb20.ejbc.Ejb2Rmi -- do not edit.
*
* @version WebLogic Server 8.1 SP6  Wed Jun 21 08:18:55 PDT 2006 781680 
* @author Copyright (c) 2016 by BEA Systems, Inc. All Rights Reserved.
*/

package desafio.ejb.manager;

import weblogic.ejb20.interfaces.WLEnterpriseBean;

public interface CategoriaProdutoSession_snmn7k_Intf 
extends WLEnterpriseBean
{
  
  public desafio.CategoriaProdutoVO addProdutoCategoriaProduto(desafio.ProdutoCategoriaProdutoVO arg0, desafio.CategoriaProdutoVO arg1)
  throws desafio.infra.DesafioException;
  public desafio.CategoriaProdutoVO atualizarCategoriaProduto(desafio.CategoriaProdutoVO arg0)
  throws desafio.infra.DesafioException;
  public void delProdutoCategoriaProduto(desafio.ProdutoCategoriaProdutoVO arg0, desafio.CategoriaProdutoVO arg1)
  throws desafio.infra.DesafioException;
  public void ejbActivate();
  public void ejbCreate();
  public void ejbPassivate();
  public void ejbRemove();
  public void eliminarCategoriaProduto(desafio.CategoriaProdutoVO arg0)
  throws desafio.infra.DesafioException;
  public desafio.CategoriaProdutoVO obterCategoriaProduto(desafio.CategoriaProdutoVO arg0)
  throws desafio.infra.DesafioException;
  public void setSessionContext(javax.ejb.SessionContext arg0);
  
  
}

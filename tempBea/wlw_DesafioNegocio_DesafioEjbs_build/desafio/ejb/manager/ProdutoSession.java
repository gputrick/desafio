package desafio.ejb.manager;

import desafio.ProdutoCategoriaProdutoVO;
import desafio.ProdutoVO;
import desafio.ejb.geral.Produto;
import desafio.ejb.geral.ProdutoBean;
import desafio.ejb.geral.ProdutoCategoriaProduto;
import desafio.ejb.geral.ProdutoCategoriaProdutoBean;
import desafio.ejb.geral.ProdutoCategoriaProdutoBeanPK;
import desafio.ejb.geral.ProdutoCategoriaProdutoHome;
import desafio.ejb.geral.ProdutoHome;
import desafio.infra.DesafioException;
import itaipu.util.ServiceLocator;
import javax.ejb.*;
import javax.naming.NamingException;
import weblogic.ejb.*;

/**
 * @ejbgen:session enable-call-by-reference="true" type="Stateless"
 *                 default-transaction="Required" ejb-name = "ProdutoSession"
 *
 * @ejbgen:jndi-name remote = "ejb.DesafioEjbs.ProdutoSessionRemoteHome"
 *
 * @ejbgen:file-generation remote-class = "true" remote-class-name =
 *                         "ProdutoSessionRemote" remote-home = "true"
 *                         remote-home-name = "ProdutoSessionHome" local-class =
 *                         "false" local-class-name = "ProdutoSessionLocal"
 *                         local-home = "false" local-home-name =
 *                         "ProdutoSessionLocalHome"
 */
public class ProdutoSession extends GenericSessionBean implements SessionBean {
	private Produto produto;
	private ProdutoHome produtoHome;

	public void ejbCreate() {
	}

	/**
	 * M�todo responsável pelo carregamento do Bean principal (master) em
	 * vari�veis globais
	 * 
	 * @param produtoVO
	 * @throws DesafioException
	 */
	private void inicializa(ProdutoVO produtoVO) throws DesafioException {

		this.produto = null;
		this.produtoHome = null;

		try {
			this.produtoHome = ProdutoBean.getHome();

			if ((produtoVO != null) && (produtoVO.getId_produto() > 0)) {

				this.produto = this.produtoHome.findByPrimaryKey(new Long(produtoVO.getId_produto()));

			} else {

				throw new ObjectNotFoundException();
			}
		} catch (ObjectNotFoundException e) {
			throw new DesafioException("Desafio020 - Produto: Produto não encontrado ou não existente");
		} catch (Exception e) {
			throw new EJBException(e);
		}
	}

	/**
	 * Método exclui o objeto da persistência
	 * 
	 * @ejbgen:remote-method transaction-attribute="Required"
	 */
	public void eliminarProduto(ProdutoVO produtoVO) throws DesafioException {
		try {
			this.inicializa(produtoVO);
			this.produto.remove();

		} catch (RemoveException e) {
			throw new DesafioException("Desafio021 - Produto: Impossível excluir registro");
		}
	}

	/**
	 * Método obtém os dados primitivos do objeto
	 * 
	 * @ejbgen:remote-method transaction-attribute="Required"
	 */
	public ProdutoVO obterProduto(ProdutoVO produtoVO) throws DesafioException {
		this.inicializa(produtoVO);
		return produto.getData();
	}

	/**
	 * Método atualiza os dados primitivos do objeto
	 * 
	 * @param produtoVO
	 * @return ProdutoVO
	 * @throws DesafioException
	 * @ejbgen:remote-method transaction-attribute="Required"
	 */
	public ProdutoVO atualizarProduto(ProdutoVO produtoVO) throws DesafioException {
		try {
			this.inicializa(produtoVO);

		} catch (DesafioException e) {
		} catch (Exception e) {
			throw new DesafioException(e);
		}

		try {
			if (this.produto == null) {
				this.produto = this.produtoHome.create(produtoVO);
			} else {
				this.produto.validaProduto(produtoVO);
				this.produto.setData(produtoVO);
			}
		} catch (CreateException e) {
			throw new EJBException(e);
		}

		return this.produto.getData();
	}

	/**
	 * M�todo respons�vel pelo carregamento do ProdutoCategoriaProdutoBean
	 * 
	 * @param produtoCategoriaProdutoVO
	 * @return Bean - produtoCategoriaProdutoVO
	 * @throws DesafioException
	 */
	private ProdutoCategoriaProduto inicializaProdutoCategoriaProduto(
			ProdutoCategoriaProdutoVO produtoCategoriaProdutoVO) throws DesafioException, EJBException {
		ProdutoCategoriaProduto produtoCategoriaProduto = null;
		ProdutoCategoriaProdutoHome produtoCategoriaProdutoHome = null;

		try {
			if ((produtoCategoriaProdutoVO != null) && (produtoCategoriaProdutoVO.getProduto() != null)
					&& (produtoCategoriaProdutoVO.getProduto().getId_produto() > 0)
					&& (produtoCategoriaProdutoVO.getCategoriaProduto() != null)
					&& (produtoCategoriaProdutoVO.getCategoriaProduto().getId_categoria_produto() > 0)) {
				produtoCategoriaProdutoHome = ProdutoCategoriaProdutoBean.getHome();

				// Chave Composta
				ProdutoCategoriaProdutoBeanPK produtoCategoriaProdutoPK = new ProdutoCategoriaProdutoBeanPK(
						new Long(produtoCategoriaProdutoVO.getCategoriaProduto().getId_categoria_produto()),
						new Long(produtoCategoriaProdutoVO.getProduto().getId_produto()));

				produtoCategoriaProduto = produtoCategoriaProdutoHome.findByPrimaryKey(produtoCategoriaProdutoPK);
			} else
				throw new ObjectNotFoundException();
		} catch (ObjectNotFoundException e) {
			throw new DesafioException("Desafio023 - Produto: ProdutoCategoriaProduto não encontrato");
		} catch (Exception e) {
			throw new EJBException(e);
		}

		return produtoCategoriaProduto;
	}

	/**
	 * Método responsável por inserir na lista de Produto
	 * 
	 * @param produtoCategoriaProdutoVO
	 *            - produtoVO
	 * @return ProdutoVO
	 * @throws DesafioException
	 * @ejbgen:remote-method transaction-attribute="Required"
	 */
	public ProdutoVO addProdutoCategoriaProduto(ProdutoCategoriaProdutoVO produtoCategoriaProdutoVO,
			ProdutoVO produtoVO) throws DesafioException {
		ProdutoCategoriaProduto produtoCategoriaProduto = null;
		ProdutoCategoriaProdutoHome produtoCategoriaProdutoHome = null;

		try {
			produtoVO = this.atualizarProduto(produtoVO);

			if (produtoCategoriaProdutoVO != null) {
				produtoCategoriaProdutoHome = ProdutoCategoriaProdutoBean.getHome();

				produtoCategoriaProduto = produtoCategoriaProdutoHome.create(produtoCategoriaProdutoVO);
			}
		} catch (Exception e) {
			throw new EJBException(e);
		}
		return produtoVO;
	}

	/**
	 * M�todo responsável por excluir da lista de Produto
	 * 
	 * @param produtoCategoriaProdutoVO
	 *            - produtoVO
	 * @return ProdutoVO
	 * @throws DesafioException
	 * @ejbgen:remote-method transaction-attribute="Required"
	 */
	public void delProdutoCategoriaProduto(ProdutoCategoriaProdutoVO produtoCategoriaProdutoVO, ProdutoVO produtoVO)
			throws DesafioException {
		try {
			/*
			 * busca o produto
			 */
			inicializa(produtoVO);

			/*
			 * recupera o produtoCategoriaProduto
			 */
			ProdutoCategoriaProduto produtoCategoriaProduto = this
					.inicializaProdutoCategoriaProduto(produtoCategoriaProdutoVO);

			/*
			 * remove o bean da lista do produto
			 */
			produtoCategoriaProduto.remove();

		} catch (EJBException e) {
			throw new EJBException(e);
		} catch (Exception e) {
			throw new DesafioException("Desafio024 Produto - Não é possível excluir ProdutoCategoriaProduto");
		}
	}

	/**
	 * Método retorna o nome jndi para lookup
	 *
	 * @return String
	 */
	public static String getRemoteJndiName() {
		return "ejb.DesafioEjbs.ProdutoSessionRemoteHome";
	}

	/**
	 * M�todo retorna a classe Home do Bean
	 * 
	 * @return ProdutoSessionHome
	 * @throws NamingException
	 */
	public static ProdutoSessionHome getRemoteHome() throws NamingException {
		return (ProdutoSessionHome) ServiceLocator.getInstance().getRemoteHome(getRemoteJndiName(),
				ProdutoSessionHome.class);
	}
}

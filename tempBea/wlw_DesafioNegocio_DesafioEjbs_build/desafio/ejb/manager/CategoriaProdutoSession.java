package desafio.ejb.manager;

import desafio.ProdutoCategoriaProdutoVO;
import desafio.CategoriaProdutoVO;
import desafio.ejb.geral.CategoriaProduto;
import desafio.ejb.geral.CategoriaProdutoBean;
import desafio.ejb.geral.ProdutoCategoriaProduto;
import desafio.ejb.geral.ProdutoCategoriaProdutoBean;
import desafio.ejb.geral.ProdutoCategoriaProdutoBeanPK;
import desafio.ejb.geral.ProdutoCategoriaProdutoHome;
import desafio.ejb.geral.CategoriaProdutoHome;
import desafio.infra.DesafioException;
import itaipu.util.ServiceLocator;
import javax.ejb.*;
import javax.naming.NamingException;
import weblogic.ejb.*;

/**
 * @ejbgen:session enable-call-by-reference="true" type="Stateless"
 *                 default-transaction="Required" ejb-name =
 *                 "CategoriaProdutoSession"
 *
 * @ejbgen:jndi-name remote =
 *                   "ejb.DesafioEjbs.CategoriaProdutoSessionRemoteHome"
 *
 * @ejbgen:file-generation remote-class = "true" remote-class-name =
 *                         "CategoriaProdutoSessionRemote" remote-home = "true"
 *                         remote-home-name = "CategoriaProdutoSessionHome"
 *                         local-class = "false" local-class-name =
 *                         "CategoriaProdutoSessionLocal" local-home = "false"
 *                         local-home-name = "CategoriaProdutoSessionLocalHome"
 */
public class CategoriaProdutoSession extends GenericSessionBean implements SessionBean {
	private CategoriaProduto categoriaProduto;
	private CategoriaProdutoHome categoriaProdutoHome;

	public void ejbCreate() {
	}

	/**
	 * Método responsável pelo carregamento do Bean principal (master) em
	 * variáveis globais
	 * 
	 * @param solicitacaoEquipamentoVO
	 *            - SolicitacaoEquipamentoVO
	 * @throws GSMException
	 */
	private void inicializa(CategoriaProdutoVO categoriaProdutoVO) throws DesafioException {

		this.categoriaProduto = null;
		this.categoriaProdutoHome = null;

		try {
			this.categoriaProdutoHome = CategoriaProdutoBean.getHome();

			if ((categoriaProdutoVO != null) && (categoriaProdutoVO.getId_categoria_produto() > 0)) {

				this.categoriaProduto = this.categoriaProdutoHome
						.findByPrimaryKey(new Long(categoriaProdutoVO.getId_categoria_produto()));

			} else {

				throw new ObjectNotFoundException();
			}
		} catch (ObjectNotFoundException e) {
			throw new DesafioException(
					"Desafio010 - CategoriaProduto: CategoriaProduto não encontrado ou não existente");
		} catch (Exception e) {
			throw new EJBException(e);
		}
	}

	/**
	 * Método obtem os dados de categoriaProdutoPai a partir da primary key
	 * 
	 * @param categoriaProdutoVO
	 * @return CategoriaProduto //Categoria Pai
	 * @throws DesafioException
	 */
	private CategoriaProduto inicializaCategoriaPai(CategoriaProdutoVO categoriaProdutoVO)
			throws DesafioException, EJBException {

		CategoriaProdutoVO categoriaPaiVO = null;
		CategoriaProduto categoriaPai = null;
		CategoriaProdutoHome categoriaPaiHome = null;

		try {
			if ((categoriaProdutoVO != null) && (categoriaProdutoVO.getId_categoria_pai() > 0)) {
				categoriaPaiHome = CategoriaProdutoBean.getHome();
				categoriaPai = categoriaPaiHome.findByPrimaryKey(new Long(categoriaProdutoVO.getId_categoria_pai()));
				categoriaPaiVO = categoriaPai.getData();
			}
		} catch (ObjectNotFoundException e) {
			throw new DesafioException("Desafio015 - CategoriaProduto: CategoriaPai não existente");
		} catch (Exception e) {
			throw new EJBException(e);
		}
		return categoriaPai;
	}

	/**
	 * Método que exclui categoriaProduto da persistência
	 * 
	 * @param categoriaProdutoVO
	 * @throws DesafioException
	 * @ejbgen:remote-method transaction-attribute="Required"
	 */
	public void eliminarCategoriaProduto(CategoriaProdutoVO categoriaProdutoVO) throws DesafioException {
		try {

			this.inicializa(categoriaProdutoVO);
			this.categoriaProduto.remove();

		} catch (RemoveException e) {
			throw new DesafioException("Desafio011 - CategoriaProduto: Impossível excluir registro");
		}
	}

	/**
	 * Metodo responsavel por obter os dados do objeto
	 * 
	 * @param categoriaProdutoVO
	 * @throws DesafioException
	 * @ejbgen:remote-method transaction-attribute="Required"
	 */
	public CategoriaProdutoVO obterCategoriaProduto(CategoriaProdutoVO categoriaProdutoVO) throws DesafioException {
		this.inicializa(categoriaProdutoVO);
		return categoriaProduto.getData();
	}

	/**
	 * Método responsável por atualizar os dados primitivos do objeto
	 * 
	 * @param categoriaProdutoVO
	 * @return CategoriaProdutoVO
	 * @throws DesafioException
	 * @ejbgen:remote-method transaction-attribute="Required"
	 */
	public CategoriaProdutoVO atualizarCategoriaProduto(CategoriaProdutoVO categoriaProdutoVO) throws DesafioException {
		try {

			this.inicializa(categoriaProdutoVO);

		} catch (DesafioException e) {
		} catch (Exception e) {
			throw new DesafioException(e);
		}

		try {
			CategoriaProduto categoriaPai = this.inicializaCategoriaPai(categoriaProdutoVO);

			if (this.categoriaProduto == null) {
				this.categoriaProduto = categoriaProdutoHome.create(categoriaProdutoVO, null);
			} else {
				this.categoriaProduto.validaCategoriaProduto(categoriaProdutoVO);
				this.categoriaProduto.setData(categoriaProdutoVO);
				this.categoriaProduto.setCategoriaPai(categoriaPai);
			}
		} catch (CreateException e) {
			throw new EJBException(e);
		}
		return this.categoriaProduto.getData();
	}

	/**
	 * Método responsável pelo carregamento do ProdutoCategoriaProdutoBean
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
			throw new DesafioException("Desafio013 - Produto: ProdutoCategoriaProduto não encontrato");
		} catch (Exception e) {
			throw new EJBException(e);
		}

		return produtoCategoriaProduto;
	}

	/**
	 * Método responsável por inserir na lista de CategoriaProduto
	 * 
	 * @param produtoCategoriaProdutoVO
	 *            - categoriaProdutoVO
	 * @return CategoriaProdutoVO
	 * @throws DesafioException
	 * @ejbgen:remote-method transaction-attribute="Required"
	 */
	public CategoriaProdutoVO addProdutoCategoriaProduto(ProdutoCategoriaProdutoVO produtoCategoriaProdutoVO,
			CategoriaProdutoVO categoriaProdutoVO) throws DesafioException {
		ProdutoCategoriaProduto produtoCategoriaProduto = null;
		ProdutoCategoriaProdutoHome produtoCategoriaProdutoHome = null;

		try {
			categoriaProdutoVO = this.atualizarCategoriaProduto(categoriaProdutoVO);

			if (produtoCategoriaProdutoVO != null) {
				produtoCategoriaProdutoHome = ProdutoCategoriaProdutoBean.getHome();

				produtoCategoriaProduto = produtoCategoriaProdutoHome.create(produtoCategoriaProdutoVO);
			}
		} catch (Exception e) {
			throw new EJBException(e);
		}
		return categoriaProdutoVO;
	}

	/**
	 * M�todo responsável por excluir da lista de CategoriaProduto
	 * 
	 * @param produtoCategoriaProdutoVO
	 *            - categoriaProdutoVO
	 * @return CategoriaProdutoVO
	 * @throws DesafioException
	 * @ejbgen:remote-method transaction-attribute="Required"
	 */
	public void delProdutoCategoriaProduto(ProdutoCategoriaProdutoVO produtoCategoriaProdutoVO,
			CategoriaProdutoVO categoriaProdutoVO) throws DesafioException {
		try {
			/*
			 * busca o categoriaProduto
			 */
			inicializa(categoriaProdutoVO);

			/*
			 * recupera o produtoCategoriaProduto
			 */
			ProdutoCategoriaProduto produtoCategoriaProduto = this
					.inicializaProdutoCategoriaProduto(produtoCategoriaProdutoVO);

			/*
			 * remove o bean da lista do categoriaProduto
			 */
			produtoCategoriaProduto.remove();

		} catch (EJBException e) {
			throw new EJBException(e);
		} catch (Exception e) {
			throw new DesafioException("Desafio014 CategoriaProduto - Não é possível excluir ProdutoCategoriaProduto");
		}
	}

	/**
	 * Método retorna o nome jndi para lookup
	 *
	 * @return String
	 */
	public static String getRemoteJndiName() {
		return "ejb.DesafioEjbs.CategoriaProdutoSessionRemoteHome";
	}

	/**
	 * M�todo retorna a classe Home do Bean
	 * 
	 * @return CategoriaProdutoSessionHome
	 * @throws NamingException
	 */
	public static CategoriaProdutoSessionHome getRemoteHome() throws NamingException {
		return (CategoriaProdutoSessionHome) ServiceLocator.getInstance().getRemoteHome(getRemoteJndiName(),
				CategoriaProdutoSessionHome.class);
	}
}

package desafio.infra;

import itaipu.util.exceptions.AppException;
import java.io.Serializable;

public class DesafioException extends AppException implements Serializable {

	public DesafioException(String erro, Exception ee) {
		super(DesafioLogger.getInstance(DesafioLogger.CAMADA_NEGOCIO), "Desafio", erro, ee);
	}

	public DesafioException(Exception ee) {
		super(DesafioLogger.getInstance(DesafioLogger.CAMADA_NEGOCIO), "Desafio", ee);
	}

	public DesafioException(String erro) {
		super(DesafioLogger.getInstance(DesafioLogger.CAMADA_NEGOCIO), "Desafio", erro);
	}

}

package desafio.infra;

import itaipu.util.log.AppLogger;
import java.io.Serializable;

public class DesafioLogger extends AppLogger implements Serializable {

	public DesafioLogger(String camada) {
		super("Desafio", camada);
	}

	public static DesafioLogger getInstance(String camada) {
		DesafioLogger instance = null;
		DesafioLogger instanceWeb = null;

		if (camada.equals(DesafioLogger.CAMADA_WEB)) {
			if (instanceWeb == null) {
				instanceWeb = new DesafioLogger(DesafioLogger.CAMADA_WEB);
				instanceWeb.getLogFile().setLevel(org.apache.log4j.Level.ALL);
				return instanceWeb;
			}
		} else {
			if (instance == null) {
				instance = new DesafioLogger(DesafioLogger.CAMADA_NEGOCIO);
			}
		}
		instance.getLogFile().setLevel(org.apache.log4j.Level.ALL);
		return instance;
	}
}

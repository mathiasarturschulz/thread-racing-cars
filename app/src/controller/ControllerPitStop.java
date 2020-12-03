package src.controller;

import src.model.ModelCarro;

/**
 * Classe que controla as operações com o pit stop
 * 
 * @author Mathias Artur Schulz
 * @since 02/12/2020
 */
public class ControllerPitStop {

	private final static float QTD_PARA_REABASTECER = 60;

	/**
	 * Método responsável por realizar o pit stop do carro atual
	 * O pit stop só pode ser realizado um carro por vez
	 *  
	 * @param modelCarro
	 * @param combustivelCarro
	 * @return
	 * @throws InterruptedException
	 */
	public static synchronized float pitStop(ModelCarro modelCarro, float combustivelCarro) throws InterruptedException {
		System.out.println("\n[ENTRADA PIT STOP] " + modelCarro.getPiloto() + " (" + modelCarro.getNome() + ") ENTROU no pit stop! ");

		// realizar o reabastecimento do carro
		combustivelCarro += QTD_PARA_REABASTECER;
		// realiza uma pausa na thread do carro para simular o tanque sendo enchido
		Thread.sleep(300);

		System.out.println("[SAIDA PIT STOP] " + modelCarro.getPiloto() + " (" + modelCarro.getNome() + ") SAIU do pit stop! ");
		return combustivelCarro;
	}
}

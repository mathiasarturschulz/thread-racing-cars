package src.controller;

import src.model.ModelCarro;

public class ControllerPiStop {

	public static synchronized float pitStop(ModelCarro modelCarro, float combustivelCarro) throws InterruptedException {
		System.out.println("-> Entrou: " + modelCarro.getPiloto());
		// acrescenta 50 litros
		combustivelCarro += 50;

		Thread.sleep(500);

		System.out.println("-> Saiu: " + modelCarro.getPiloto());
		return combustivelCarro;
	}
}

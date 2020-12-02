package src;

import java.util.ArrayList;
import java.util.List;
import src.model.ModelCarro;

/**
 * Classe principal do projeto
 * 
 * @author Mathias Artur Schulz
 * @since 13/11/2020
 */
public class Main {

	/**
	 * Método main do projeto
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			int comprimentoPista = 150;

			// cria o arraylist
			List<ModelCarro> carros = new ArrayList<ModelCarro>();
			carros.add(new ModelCarro(1, "Mustang Fastback 1965", "João Barion", "Preto", "Monster;WD-40;Drift HQ;", (float) 99.9));
			carros.add(new ModelCarro(2, "BMW E36", "Marcio Kabeça", "Branco/Preto", "Pneu Store;InjePro;", (float) 99.9));
			carros.add(new ModelCarro(2, "Nissan 350z", "Bruno Bar", "Camaleão", "WD-40;Pneu Store;InjePro;", (float) 99.9));
			carros.add(new ModelCarro(2, "Mazda RX-7", "Mad Mike", "Preto", "Red Bull;", (float) 99.9));
			carros.add(new ModelCarro(2, "Mustang RTR", "Vaughn Gittin Jr.", "Preto", "Ford;Monster;", (float) 99.9));

			System.out.println("\n=> Iniciando a corrida Super Drift Brasil 2020 ");
			System.out.println("\nA pista possui um comprimento de " + comprimentoPista + " metros ");
			Thread.sleep(2000);

			// apresenta os carros
			System.out.println("\n=> Os competidores são: ");
			for (ModelCarro carro: carros) {
				System.out.println(carro.toString());
			}
			Thread.sleep(2000);

			// inicia uma thread para cada carro da corrida
			List<ThreadCarro> carrosThread = new ArrayList<ThreadCarro>();
			for (int i = 0; i < carros.size(); i++) {
				carrosThread.add(new ThreadCarro(comprimentoPista, carros.get(i)));
				carrosThread.get(i).start();
			}

			// realiza um join com o objetivo de sincronizar as threads
			for (ThreadCarro thread: carrosThread) {
				thread.join();
			}

			System.out.println("\n=> Corrida finalizada! ");
			apresentaColocacoes(carrosThread);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Método responsável por mostrar as colocações dos carros
	 * Utiliza como base a quantidade de repetições utilizadas para atravessar a chegada
	 * Quanto menor a quantidade, antes chegou
	 * 
	 * @param carrosThread
	 */
	private static void apresentaColocacoes(List<ThreadCarro> carrosThread) {
		// realiza uma ordenação pela quantidade de repetições
		ThreadCarro temp = null;
		for (int i = 0; i < carrosThread.size(); i++) {
			for (int j = i+1; j < carrosThread.size(); j++) {
				if (carrosThread.get(i).getQtdRepeticoes() > carrosThread.get(j).getQtdRepeticoes()) {
					temp = carrosThread.get(i);
					carrosThread.set(i, carrosThread.get(j));
					carrosThread.set(j, temp);
				}
			}
		}

		// apresenta as colocações
		System.out.println("\n=> COLOCAÇÕES: ");
		for (int i = 0; i < carrosThread.size(); i++) {
			System.out.println(
					(i + 1) + "º colocado: " + carrosThread.get(i).getModelCarro().getPiloto() 
					+ " (" + carrosThread.get(i).getModelCarro().getNome() + ") "
			);
		}
	}
}

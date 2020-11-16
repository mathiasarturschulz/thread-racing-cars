package src;

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
			int quantidadeCarros = 3;
			
			// cria o array
			ModelCarro[] carros = new ModelCarro[quantidadeCarros];
			carros[0] = new ModelCarro(1, "350z-Barion", "João Barion", "Preto", "Monster,NANDO,WD-40,Drift-HQ");
			carros[1] = new ModelCarro(2, "BMW-Kabeca", "Marcio Kabeça", "Branco/Preto", "Pneu-Store,Inje-Pro");
			carros[2] = new ModelCarro(2, "350z-Bar", "Bruno Bar", "Preto", "WD-40,Pneu-Store,Inje-Pro");

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
			ThreadCarro[] carrosThread = new ThreadCarro[quantidadeCarros];
			for (int i = 0; i < carrosThread.length; i++) {
				carrosThread[i] = new ThreadCarro(comprimentoPista, carros[i]);
				carrosThread[i].start();
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
	public static void apresentaColocacoes(ThreadCarro[] carrosThread) {
		// realiza uma ordenação pela quantidade de repetições
		ThreadCarro temp = null;
		for (int i = 0; i < carrosThread.length; i++) {
			for (int j = i+1; j < carrosThread.length; j++) {
				if (carrosThread[i].getQtdRepeticoes() > carrosThread[j].getQtdRepeticoes()) {
					temp = carrosThread[i];
					carrosThread[i] = carrosThread[j];
					carrosThread[j] = temp;
				}
			}
		}

		// apresenta as colocações
		System.out.println("\n=> COLOCAÇÕES: ");
		for (int i = 0; i < carrosThread.length; i++) {
			System.out.println((i + 1) + "º colocado: " + carrosThread[i].getModelCarro().getNome());
		}
	}
}

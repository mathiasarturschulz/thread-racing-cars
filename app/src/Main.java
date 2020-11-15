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
			int comprimentoPista = 200;

			ModelCarro carroA = new ModelCarro(1, "CarroA", "João Barion", "Preto", "Monster,NANDO,WD-40,Drift-HQ");
			ModelCarro carroB = new ModelCarro(2, "CarroB", "Marcio Kabeça", "Branco/Preto", "Pneu-Store,Inje-Pro");
		
			System.out.println("\n=> Iniciando a corrida Super Drift Brasil 2020 ");
			System.out.println("\nA pista possui um comprimento de " + comprimentoPista + " metros ");
			Thread.sleep(2000);

			System.out.println("\n=> Os competidores são: ");
			System.out.println(carroA.toString());
			System.out.println(carroB.toString());
			Thread.sleep(2000);

			ThreadCarro threadCarroA = new ThreadCarro(comprimentoPista, carroA);
			threadCarroA.start();

			ThreadCarro threadCarroB = new ThreadCarro(comprimentoPista, carroB);
			threadCarroB.start();

			// realiza um join com o objetivo de sincronizar as thread, onde a thread atual espera as outras
			threadCarroA.join();
			threadCarroB.join();

			System.out.println("\n=> Corrida finalizada! ");
			System.out.println(threadCarroA.getQtdRepeticoes());
			System.out.println(threadCarroB.getQtdRepeticoes());
			
//			if (threadCarroA.getQtdRepeticoes() > threadCarroB.getQtdRepeticoes()) {
//				System.out.println();
//			}
			

			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void apresentaColocacoes(int qtdRepeticoesCarroA, int qtdRepeticoesCarroB) {
		String primeiroLugar = "";
		String segundoLugar = "";
		if (qtdRepeticoesCarroA > qtdRepeticoesCarroB) {
			
		}
	}
}

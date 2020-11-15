package src;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import src.model.ModelCarro;
import src.model.ModelCorrida;

/**
 * Classe principal do projeto
 * 
 * @author Mathias Artur Schulz
 * @since 13/11/2020
 */
public class Main {

	static int i;

	/**
	 * Método main do projeto
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Random gerador = new Random();

		int comprimentoPista = 200;
		ModelCarro carroA = new ModelCarro(1, "CarroA", "João Barion", "Preto", "Monster,NANDO,WD-40,Drift-HQ");
		ModelCarro carroB = new ModelCarro(2, "CarroB", "Marcio Kabeça", "Branco/Preto", "Pneu-Store,Inje-Pro");
		ModelCorrida corrida = new ModelCorrida(1, "Super Drift Brasil 2020", comprimentoPista, carroA, carroB);

		System.out.println("Iniciando a corrida " + corrida.getNome());
		System.out.println(carroA.toString());
		System.out.println(carroB.toString());

		System.out.println("\n=> Pista: ");
		System.out.println("=".repeat(comprimentoPista));
		System.out.println("A \nB");
		System.out.println("=".repeat(comprimentoPista));

		while (corrida.getComprimentoCarroA() < comprimentoPista) {

			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("\n=> Pista: ");
			System.out.println("=".repeat(comprimentoPista));

			// carroA
			corrida.setComprimentoCarroA(corrida.getComprimentoCarroA() + gerador.nextInt(4));
			System.out.println("-".repeat(corrida.getComprimentoCarroA()) + "A");

			// carroB
			corrida.setComprimentoCarroB(corrida.getComprimentoCarroB() + gerador.nextInt(4));
			System.out.println("-".repeat(corrida.getComprimentoCarroB()) + "B");

			System.out.println("=".repeat(comprimentoPista));
		}
	}
}

package src;

import java.util.Random;
import src.model.ModelCarro;

/**
 * Classe que representa as operações com da entidade corrida
 * 
 * @author Mathias Artur Schulz
 * @since 15/11/2020
 */
public class ThreadCarro extends Thread {

	private int comprimentoPista;
	private ModelCarro modelCarro;
	private Random gerador;

	/**
	 * Construtor
	 * 
	 * @param comprimentoPista
	 * @param modelCarro
	 */
	public ThreadCarro(int comprimentoPista, ModelCarro modelCarro) {
		this.gerador = new Random();
		this.comprimentoPista = comprimentoPista;
		this.modelCarro = modelCarro;
	}

	/**
	 * Método chamado no start da thread
	 */
	public void run() {
		this.iniciaCorridaCarroAtual();
	}

	/**
	 * Método que realiza a corrida na pista de um determinado carro e apresenta a distancia do carro
	 */
	public void iniciaCorridaCarroAtual() {
		int distanciaCarro = 0;
		// o carro continua correndo na pista enquanto não atravessou a chegada
		while (distanciaCarro < comprimentoPista) {
			distanciaCarro += gerador.nextInt(4);
			System.out.println("-".repeat(distanciaCarro) + this.modelCarro.getNome());
		}
	}
}

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

	public ThreadCarro(int comprimentoPista, ModelCarro modelCarro) {
		this.gerador = new Random();
		this.comprimentoPista = comprimentoPista;
		this.modelCarro = modelCarro;
	}

	@Override
	public void run() {
		this.iniciaCorridaCarroAtual();
	}

	public void iniciaCorridaCarroAtual() {
		int distanciaCarro = 0;
		while (distanciaCarro < comprimentoPista) {
			distanciaCarro += gerador.nextInt(4);
			System.out.println("-".repeat(distanciaCarro) + this.modelCarro.getNome());
		}
	}
}

package src;

import java.util.Random;
import src.controller.ControllerPitStop;
import src.model.ModelCarro;

/**
 * Classe que representa as operações com a thread do carro
 * 
 * @author Mathias Artur Schulz
 * @since 15/11/2020
 */
public class ThreadCarro extends Thread {

	private int comprimentoPista;
	private ModelCarro modelCarro;
	private Random gerador;
	private int qtdRepeticoes;

	/**
	 * Construtor
	 * 
	 * @param comprimentoPista
	 * @param modelCarro
	 */
	public ThreadCarro(int comprimentoPista, ModelCarro modelCarro) {
		this.comprimentoPista = comprimentoPista;
		this.modelCarro = modelCarro;
		this.gerador = new Random();
		this.qtdRepeticoes = 0;
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
		try {
			int distanciaCarro = 0;
			// inicia a corrida com o tanque do carro cheio
			float combustivelCarro = this.modelCarro.getCombustivel();

			// o carro continua correndo na pista enquanto não atravessou a chegada
			while (distanciaCarro < comprimentoPista) {
				// gera um número aleatório entre 0 e 4 para simular que o carro está percorrendo na pista
				distanciaCarro += gerador.nextInt(4);
				if (distanciaCarro > comprimentoPista) {
					distanciaCarro = comprimentoPista;
				}
				System.out.println("-".repeat(distanciaCarro) + this.modelCarro.getNome() + " (" + distanciaCarro + "m)" + "Com.: " + combustivelCarro + "LT");
				this.qtdRepeticoes++;

				// atualiza o combustivel e valida se necessita de pit stop
				combustivelCarro = atualizaCombustivel(combustivelCarro);

				Thread.sleep(200);
			}
			System.out.println("[CHEGADA] Carro " + this.modelCarro.getNome() + " atravessou a chegada! ");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Método responsável por atualizar a quantidade de combustível no carro
	 * Se necessário, chama a operação de pit stop
	 * 
	 * @param combustivelCarro
	 * @return
	 * @throws InterruptedException
	 */
	private float atualizaCombustivel(float combustivelCarro) throws InterruptedException {
		// gera um valor aleatório simulando o gasto de combustível
		combustivelCarro -= gerador.nextInt(10);

		// se o carro possui menos de 10 litros de combustível espera para entrar no pit stop
		if (combustivelCarro <= 10) {
			System.out.println("+ " + modelCarro.getPiloto() + " (" + modelCarro.getNome() + ") está tentanto entrar no pit stop... ");
			combustivelCarro = ControllerPitStop.pitStop(modelCarro, combustivelCarro);
		}

		return combustivelCarro;
	}

	public int getQtdRepeticoes() {
		return qtdRepeticoes;
	}
	
	public ModelCarro getModelCarro() {
		return modelCarro;
	}
}

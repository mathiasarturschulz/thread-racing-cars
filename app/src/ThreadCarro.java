package src;

import java.util.Random;

import src.controller.ControllerPiStop;
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
		this.gerador = new Random();
		this.comprimentoPista = comprimentoPista;
		this.modelCarro = modelCarro;
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

				// atualiza o combustivel e valida se necessita de pitstop
				combustivelCarro = atualizaCombustivel(combustivelCarro);

				Thread.sleep(200);
			}
			System.out.println("Carro " + this.modelCarro.getNome() + " atravessou a chegada! ");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private float atualizaCombustivel(float combustivelCarro) throws InterruptedException {
		// gera um valor aleatório simulando o gasto de combustível
		int combustivelGasto = gerador.nextInt(10);

		combustivelCarro -= combustivelGasto;

		if (combustivelCarro <= 10) {
			System.out.println("Entrando no pitstop... ");
			combustivelCarro = ControllerPiStop.pitStop(modelCarro, combustivelCarro);
//			combustivelCarro = pitStop(combustivelCarro);
		}

		// quando o combustível atual do carro é menor ou igual a 10 entra no pitstop
		
		return combustivelCarro;
	}

	public int getQtdRepeticoes() {
		return qtdRepeticoes;
	}
	
	public ModelCarro getModelCarro() {
		return modelCarro;
	}
}

package src;

import src.model.Carro;

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

		Carro carroA = new Carro(1, "Carro A", "Azul");
		Carro carroB = new Carro(2, "Carro B", "Vermelho");

		System.out.println("Main inicial! ");
		System.out.println(carroA.toString());
		System.out.println(carroB.toString());
	}

}

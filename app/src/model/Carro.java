package src.model;

/**
 * Classe que representa a entidade Carro
 * 
 * @author Mathias Artur Schulz
 * @since 13/11/2020
 */
public class Carro {

	private int codigo;
	private String nome;
	private String cor;

	public Carro(int codigo, String nome, String cor) {
		this.codigo = codigo;
		this.nome = nome;
		this.cor = cor;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	@Override
	public String toString() {
		return "Carro [codigo=" + codigo + ", nome=" + nome + ", cor=" + cor + "]";
	}
}

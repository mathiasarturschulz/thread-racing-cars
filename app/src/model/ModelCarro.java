package src.model;

/**
 * Classe que representa a entidade Carro
 * 
 * @author Mathias Artur Schulz
 * @since 13/11/2020
 */
public class ModelCarro {

	private int codigo;
	private String nome;
	private String piloto;
	private String cor;
	private String patrocinadores;
	private float combustivel;

	/**
	 * Construtor
	 * 
	 * @param codigo
	 * @param nome
	 * @param piloto
	 * @param cor
	 * @param patrocinadores
	 * @param combustivel
	 */
	public ModelCarro(
		int codigo, 
		String nome, 
		String piloto,
		String cor, 
		String patrocinadores,
		float combustivel
	) {
		this.codigo = codigo;
		this.nome = nome;
		this.piloto = piloto;
		this.cor = cor;
		this.patrocinadores = patrocinadores;
		this.combustivel = combustivel;
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

	public String getPiloto() {
		return piloto;
	}

	public void setPiloto(String piloto) {
		this.piloto = piloto;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getPatrocinadores() {
		return patrocinadores;
	}

	public void setPatrocinadores(String patrocinadores) {
		this.patrocinadores = patrocinadores;
	}

	public float getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(float combustivel) {
		this.combustivel = combustivel;
	}

	@Override
	public String toString() {
		return "Carro [codigo=" + codigo 
			+ ", nome=" + nome 
			+ ", piloto=" + piloto 
			+ ", cor=" + cor 
			+ ", patrocinadores=" + patrocinadores
			+ ", combustivel=" + combustivel
		+ "]";
	}	
}

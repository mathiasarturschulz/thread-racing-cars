package src.model;

/**
 * Classe que representa a entidade Corrida
 * 
 * @author Mathias Artur Schulz
 * @since 15/11/2020
 */
public class ModelCorrida {

	private int codigo;
	private String nome;
	private int comprimento;
	private int comprimentoCarroA;
	private int comprimentoCarroB;
	private ModelCarro CarroA;
	private ModelCarro CarroB;	
	
	public ModelCorrida(
		int codigo, 
		String nome,
		int comprimento, 
		ModelCarro carroA,
		ModelCarro carroB
	) {
		this.codigo = codigo;
		this.nome = nome;
		this.comprimento = comprimento;
		this.comprimentoCarroA = 0;
		this.comprimentoCarroB = 0;
		this.CarroA = carroA;
		this.CarroB = carroB;
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

	public int getComprimento() {
		return comprimento;
	}

	public void setComprimento(int comprimento) {
		this.comprimento = comprimento;
	}

	public int getComprimentoCarroA() {
		return comprimentoCarroA;
	}

	public void setComprimentoCarroA(int comprimentoCarroA) {
		this.comprimentoCarroA = comprimentoCarroA;
	}

	public int getComprimentoCarroB() {
		return comprimentoCarroB;
	}

	public void setComprimentoCarroB(int comprimentoCarroB) {
		this.comprimentoCarroB = comprimentoCarroB;
	}

	public ModelCarro getCarroA() {
		return CarroA;
	}

	public void setCarroA(ModelCarro carroA) {
		CarroA = carroA;
	}

	public ModelCarro getCarroB() {
		return CarroB;
	}

	public void setCarroB(ModelCarro carroB) {
		CarroB = carroB;
	}

	@Override
	public String toString() {
		return "Corrida [codigo=" + codigo 
			+ ", nome=" + nome 
			+ ", comprimento=" + comprimento 
			+ ", comprimentoCarroA=" + comprimentoCarroA
			+ ", comprimentoCarroB=" + comprimentoCarroB 
			+ ", CarroA=" + CarroA 
			+ ", CarroB=" + CarroB 
		+ "]";
	}
}

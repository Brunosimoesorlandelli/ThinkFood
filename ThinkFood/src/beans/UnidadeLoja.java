package beans;

public class UnidadeLoja {

	private String telefone;
	private Endereco endereco;
	private int qtdFunc;
	private int seq;

	public UnidadeLoja(String telefone, Endereco endereco, int qtdFunc, int seq) {
		this.telefone = telefone;
		this.endereco = endereco;
		this.qtdFunc = qtdFunc;
		this.seq = seq;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public int getQtdFunc() {
		return qtdFunc;
	}

	public void setQtdFunc(int qtdFunc) {
		this.qtdFunc = qtdFunc;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

}

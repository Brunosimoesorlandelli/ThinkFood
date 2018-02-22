package beans;

public class UnidadeLoja {

	private String telefone;
	private String cep;
	private int qtdFunc;
	private int seq;

	public UnidadeLoja(String telefone, String cep, int qtdFunc, int seq) {
		this.telefone = telefone;
		this.cep = cep;
		this.qtdFunc = qtdFunc;
		this.seq = seq;
	}

	public UnidadeLoja() {

	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
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

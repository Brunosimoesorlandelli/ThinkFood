package beans;

public class Endereco {

	private String cep;
	private String cidade;
	private String estado;
	private String bairro;
	private String pontoRef;
	private String TipoLogradouro;

	public Endereco(String cep, String cidade, String estado, String bairro, String pRef, String tLog) {
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
		this.bairro = bairro;
		this.pontoRef = pRef;
		this.TipoLogradouro = tLog;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getPontoRef() {
		return pontoRef;
	}

	public void setPontoRef(String pontoRef) {
		this.pontoRef = pontoRef;
	}

	public String getTipoLogradouro() {
		return TipoLogradouro;
	}

	public void setTipoLogradouro(String tipoLogradouro) {
		TipoLogradouro = tipoLogradouro;
	}

}

package beans;

public class ClientePJ extends Cliente {

	private String nomeFantasia;
	private String razaoSocial;
	private String cnpj;

	public ClientePJ(int id, String cnpj, String rSocial, String nFanta) {
		super(id);
		this.nomeFantasia = nFanta;
		this.razaoSocial = rSocial;
		this.cnpj = cnpj;
	}

	public ClientePJ() {

	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

}

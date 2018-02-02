package beans;

public class Fornecedor {
	private String cnpj;
	private String email;
	private String razaoSocial;
	private Endereco endereco;
	private int fone;
	
	public Fornecedor(String cnpj, String email, String razaoSocial, Endereco endereco, int fone) {
		this.cnpj = cnpj;
		this.email = email;
		this.razaoSocial = razaoSocial;
		this.endereco = endereco;
		this.fone = fone;
	}

	
	public int getFone() {
		return fone;
	}



	public void setFone(int fone) {
		this.fone = fone;
	}



	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}

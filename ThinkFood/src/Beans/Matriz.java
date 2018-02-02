package Beans;

import java.util.ArrayList;

public class Matriz {

	private String telefone;
	private String cnpj;
	private String nomeFantasia;
	private String razaoSocial;
	private ArrayList<UnidadeLoja> unity;

	public Matriz(String telefone, String cnpj, String nFanta, String rSocial) {
		this.telefone = telefone;
		this.cnpj = cnpj;
		this.nomeFantasia = nFanta;
		this.razaoSocial = rSocial;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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

	public ArrayList<UnidadeLoja> getUnity() {
		return unity;
	}

	public void setUnity(ArrayList<UnidadeLoja> unity) {
		this.unity = unity;
	}

}

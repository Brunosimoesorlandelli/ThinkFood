package Negocio.beans;

import java.sql.Date;

public class ClientePF extends Cliente {

	private String nome;
	private String cpf;
	private Date dataDeNascimento;

	public ClientePF(String nome, String cpf, Date dtNas, int id) {
		super(id);
		this.nome = nome;
		this.cpf = cpf;
		this.dataDeNascimento = dtNas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

}

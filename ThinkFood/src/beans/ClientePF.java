package beans;

import java.sql.Date;

public class ClientePF extends Cliente {

	private String nome;
	private Date dataDeNascimento;

	public ClientePF(String nome, Date dtNas, int id) {
		super(id);
		this.nome = nome;
		this.dataDeNascimento = dtNas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

}

package beans;

import java.sql.Date;

public class Funcionario {

	private String nome;
	private String cpf;
	private Date dataNasc;
	private String CEP;
	private double salario;
	private String compl;
	private int numero;
	private int seq_loja;
	private String senha;

	public Funcionario(String nome, String cpf, Date dataNasc, String CEP, double salario, int numero, String compl,
			int seq_Loja, String senha) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNasc = dataNasc;
		this.CEP = CEP;
		this.salario = salario;
		this.numero = numero;
		this.compl = compl;
		this.seq_loja = seq_Loja;
		this.senha = senha;

	}
	
	public Funcionario() {
		
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

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String cEP) {
		CEP = cEP;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCompl() {
		return compl;
	}

	public void setCompl(String compl) {
		this.compl = compl;
	}

	public int getSeq_loja() {
		return seq_loja;
	}

	public void setSeq_loja(int seq_loja) {
		this.seq_loja = seq_loja;
	}

}

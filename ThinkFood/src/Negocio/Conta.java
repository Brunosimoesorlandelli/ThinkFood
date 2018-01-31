package Negocio;

import java.sql.Date;

public class Conta {

	private int seq;
	private Date dtEmissao;
	private double valorTotal;

	public Conta(int seq, Date dtEmissao, double valorTotal) {
		this.seq = seq;
		this.dtEmissao = dtEmissao;
		this.valorTotal = valorTotal;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public Date getDtEmissao() {
		return dtEmissao;
	}

	public void setDtEmissao(Date dtEmissao) {
		this.dtEmissao = dtEmissao;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	

}

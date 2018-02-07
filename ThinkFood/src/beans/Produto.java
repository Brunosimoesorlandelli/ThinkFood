package beans;

import java.sql.Date;

public class Produto {
	private int unidade;
	private int codigo;
	private String descr;
	private int qtdMinStk;
	private Date dt_inicio;
	private Date dt_fim;

	public Produto(int unidade, int codigo, String descr, int qtdMinStk, Date dt_inicio, Date dt_fim) {
		this.unidade = unidade;
		this.codigo = codigo;
		this.descr = descr;
		this.qtdMinStk = qtdMinStk;
		this.dt_inicio = dt_inicio;
		this.dt_fim = dt_fim;
	}

	public int getUnidade() {
		return unidade;
	}

	public void setUnidade(int unidade) {
		this.unidade = unidade;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public int getQtdMinStk() {
		return qtdMinStk;
	}

	public void setQtdMinStk(int qtdMinStk) {
		this.qtdMinStk = qtdMinStk;
	}

	public Date getDt_inicio() {
		return dt_inicio;
	}

	public void setDt_inicio(Date dt_inicio) {
		this.dt_inicio = dt_inicio;
	}

	public Date getDt_fim() {
		return dt_fim;
	}

	public void setDt_fim(Date dt_fim) {
		this.dt_fim = dt_fim;
	}

}

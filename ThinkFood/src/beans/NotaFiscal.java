package beans;

import java.sql.Date;

public class NotaFiscal {
	
	private String tipo;
	private int cod;
	private String descr;
	private Date dataExpedicao;
	private double valorUnitario;
	
	public NotaFiscal (String tipo, int cod, String descr, Date dataExpedicao, double valorUnitario) {
		this.tipo = tipo;
		this.cod = cod;
		this.descr = descr;
		this.dataExpedicao = dataExpedicao;
		this.valorUnitario = valorUnitario;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public Date getDataExpedicao() {
		return dataExpedicao;
	}

	public void setDataExpedicao(Date dataExpedicao) {
		this.dataExpedicao = dataExpedicao;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	

}

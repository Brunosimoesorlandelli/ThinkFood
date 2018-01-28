package Negocio;

import java.sql.Date;

public class Pagamento {
	private int cod;
	private Date data;
	private Status status;
	private double valorPago;
	private int codTipoPagamento;
	private int codNotaFiscal;

	public Pagamento(int cod, Date data, Status status, double valorPago, int codTipoPagamento, int codNotaFiscal) {

		this.cod = cod;
		this.data = data;
		this.status = status;
		this.valorPago = valorPago;
		this.codTipoPagamento = codTipoPagamento;
		this.codNotaFiscal = codNotaFiscal;

	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public double getValorPago() {
		return valorPago;
	}

	public void setValorPago(double valorPago) {
		this.valorPago = valorPago;
	}

	public int getCodTipoPagamento() {
		return codTipoPagamento;
	}

	public void setCodTipoPagamento(int codTipoPagamento) {
		this.codTipoPagamento = codTipoPagamento;
	}

	public int getCodNotaFiscal() {
		return codNotaFiscal;
	}

	public void setCodNotaFiscal(int codNotaFiscal) {
		this.codNotaFiscal = codNotaFiscal;
	}

}

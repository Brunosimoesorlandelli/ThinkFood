package beans;

import java.sql.Date;
import java.sql.Time;

public class PedidoDelivery {

	private int taxa;
	private StatusDelivery status;
	private String CEP;
	private Time horaSaida;
	private Date data;
	private int numero;
	private String complemento;
	private String cpfEntregador;

	public PedidoDelivery(int taxa, StatusDelivery status, String CEP, Time hSaida, Date data, int numero, String cmplt,
			String cpfEntregador) {
		this.taxa = taxa;
		this.status = status;
		this.CEP = CEP;
		this.horaSaida = hSaida;
		this.data = data;
		this.numero = numero;
		this.complemento = cmplt;
		this.cpfEntregador = cpfEntregador;
	}

	public int getTaxa() {
		return taxa;
	}

	public void setTaxa(int taxa) {
		this.taxa = taxa;
	}

	public StatusDelivery getStatus() {
		return status;
	}

	public void setStatus(StatusDelivery status) {
		this.status = status;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String cEP) {
		CEP = cEP;
	}

	public Time getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(Time horaSaida) {
		this.horaSaida = horaSaida;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCpfEntregador() {
		return cpfEntregador;
	}

	public void setCpfEntregador(String cpfEntregador) {
		this.cpfEntregador = cpfEntregador;
	}

}

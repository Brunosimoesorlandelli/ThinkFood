package beans;

import java.sql.Date;
import java.sql.Time;

public class PedidoDelivery {

	private int taxa;
	private StatusDelivery status;
	private Endereco endereco;
	private Time horaSaida;
	private Date data;
	private int numero;
	private String complemento;

	public PedidoDelivery(int taxa, StatusDelivery status, Endereco endereco, Time hSaida, Date data, int numero,
			String cmplt) {
		this.taxa = taxa;
		this.status = status;
		this.endereco = endereco;
		this.horaSaida = hSaida;
		this.data = data;
		this.numero = numero;
		this.complemento = cmplt;
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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

}

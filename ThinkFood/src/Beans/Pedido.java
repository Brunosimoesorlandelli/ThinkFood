package Beans;

import java.sql.Date;
import java.sql.Time;

public class Pedido {

	private int id;
	private Time hora;
	private Date data;
	private double valor;

	public Pedido(int id, Time hora, Date data, double valor) {

		this.id = id;
		this.hora = hora;
		this.data = data;
		this.valor = valor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}

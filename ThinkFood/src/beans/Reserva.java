package beans;

import java.sql.Time;

public class Reserva {
	private int seq;
	private Time hora_inicio;
	private Time hora_fim;
	private StatusReserva status;
	private int num_pessoas;

	public Reserva(int seq, Time hora_inicio, Time hora_fim, StatusReserva status, int num_pessoas) {
		this.seq = seq;
		this.hora_inicio = hora_inicio;
		this.hora_fim = hora_fim;
		this.status = status;
		this.num_pessoas = num_pessoas;
		
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public Time getHora_inicio() {
		return hora_inicio;
	}

	public void setHora_inicio(Time hora_inicio) {
		this.hora_inicio = hora_inicio;
	}

	public Time getHora_fim() {
		return hora_fim;
	}

	public void setHora_fim(Time hora_fim) {
		this.hora_fim = hora_fim;
	}

	public StatusReserva getStatus() {
		return status;
	}

	public void setStatus(StatusReserva status) {
		this.status = status;
	}

	public int getNum_pessoas() {
		return num_pessoas;
	}

	public void setNum_pessoas(int num_pessoas) {
		this.num_pessoas = num_pessoas;
	}
	
	

}

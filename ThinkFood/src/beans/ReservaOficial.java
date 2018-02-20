package beans;

import java.sql.Date;
import java.sql.Time;

public class ReservaOficial {
	private int seq;
	private Time hora_inicio;
	private Time hora_fim;
	private StatusReserva status;
	private int num_pessoas;
	private String cpfFuncionario;
	private int seqReserva;
	private int idCliente;
	private Date dataReserva;
	private Date dataValidade;
	
	
	public ReservaOficial(int seq, Time hora_inicio, Time hora_fim, StatusReserva status, int num_pessoas, String cpfFunc, int seqReserva, int idCliente, Date dtReserva, Date dtVal) {
		this.seq = seq;
		this.hora_inicio = hora_inicio;
		this.hora_fim = hora_fim;
		this.status = status;
		this.num_pessoas = num_pessoas;
		this.cpfFuncionario = cpfFunc;
		this.seqReserva = seqReserva;
		this.idCliente = idCliente;
		this.dataReserva = dtReserva;
		this.dataValidade = dtVal;
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


	public String getCpfFuncionario() {
		return cpfFuncionario;
	}


	public void setCpfFuncionario(String cpfFuncionario) {
		this.cpfFuncionario = cpfFuncionario;
	}


	public int getSeqReserva() {
		return seqReserva;
	}


	public void setSeqReserva(int seqReserva) {
		this.seqReserva = seqReserva;
	}


	public int getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}


	public Date getDataReserva() {
		return dataReserva;
	}


	public void setDataReserva(Date dataReserva) {
		this.dataReserva = dataReserva;
	}


	public Date getDataValidade() {
		return dataValidade;
	}


	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}

	
}

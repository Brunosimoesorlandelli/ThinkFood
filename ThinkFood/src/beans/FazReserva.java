package beans;

import java.sql.Date;

public class FazReserva {

	private String cpfFuncionario;
	private int seqReserva;
	private int idCliente;
	private Date dataReserva;
	private Date dataValidade;

	public FazReserva(String cpfFunc, int seqReserva, int idCliente, Date dtReserva, Date dtVal) {
		this.cpfFuncionario = cpfFunc;
		this.seqReserva = seqReserva;
		this.idCliente = idCliente;
		this.dataReserva = dtReserva;
		this.dataValidade = dtVal;
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

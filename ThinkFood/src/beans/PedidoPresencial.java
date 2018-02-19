package beans;

import java.sql.Time;

public class PedidoPresencial {

	private int idPedido;
	private int num_Mesa;
	private String cpfFuncionario;
	private Time hora;

	public PedidoPresencial(int idPedido, int num_mesa, String cpfFunc, Time hora) {
		this.idPedido = idPedido;
		this.num_Mesa = num_mesa;
		this.cpfFuncionario = cpfFunc;
		this.hora = hora;
	}

	public PedidoPresencial() {

	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		idPedido = idPedido;
	}

	public int getNum_Mesa() {
		return num_Mesa;
	}

	public void setNum_Mesa(int num_Mesa) {
		this.num_Mesa = num_Mesa;
	}

	public String getCpfFuncionario() {
		return cpfFuncionario;
	}

	public void setCpfFuncionario(String cpfFuncionario) {
		this.cpfFuncionario = cpfFuncionario;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

}

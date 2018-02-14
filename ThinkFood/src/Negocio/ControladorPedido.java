package Negocio;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Pedido;
import dados.IRepositorioPedido;
import dados.RepositorioPedido;

public class ControladorPedido implements IControladorPedido, Serializable{

	private static final long serialVersionUID = 1;
	private IRepositorioPedido repositorio;

	public ControladorPedido() {
		this.repositorio = RepositorioPedido.getInstance();

	}

	public void conectar(Connection connect) {
		repositorio.conectar(connect);
	}

	public boolean cadastrar(Pedido p) throws SQLException {
		return repositorio.cadastrar(p);
	}

	public Pedido procurar(int id) throws SQLException {
		return repositorio.procurar(id);
	}

	public boolean remover(Pedido p) throws SQLException {
		return repositorio.remover(p);
	}

	public void printar(Pedido p) {
		repositorio.printar(p);
	}

	public ArrayList<Pedido> listar() {
		return repositorio.listar();
	}
	
	
}

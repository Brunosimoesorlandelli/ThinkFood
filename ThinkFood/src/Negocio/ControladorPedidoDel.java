package Negocio;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.PedidoDelivery;
import dados.IRepositorioPedidoDel;
import dados.RepositorioPedidoDel;

public class ControladorPedidoDel implements IControladorPedidoDel, Serializable{

	private static final long serialVersionUID = 1;
	private IRepositorioPedidoDel repositorio;

	public ControladorPedidoDel() {
		this.repositorio = RepositorioPedidoDel.getInstance();
	}

	public void conectar(Connection connect) {
		repositorio.conectar(connect);
	}

	public boolean cadastrar(PedidoDelivery p) throws SQLException {
		return repositorio.cadastrar(p);
	}

	public PedidoDelivery procurar(int id) throws SQLException {
		return repositorio.procurar(id);
	}

	public boolean remover(PedidoDelivery p) throws SQLException {
		return repositorio.remover(p);
	}

	public void printar(PedidoDelivery p) {
		repositorio.printar(p);
	}

	public ArrayList<PedidoDelivery> listar() {
		return repositorio.listar();
	}

}

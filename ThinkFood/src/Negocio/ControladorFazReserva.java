package Negocio;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.FazReserva;
import dados.IRepositorioFazReserva;
import dados.RepositorioFazReserva;

public class ControladorFazReserva implements IControladorFazReserva, Serializable{

	private static final long serialVersionUID = 1;
	private IRepositorioFazReserva repositorio;

	public ControladorFazReserva() {
		this.repositorio = RepositorioFazReserva.getInstance();
	}

	public void conectar(Connection connect) {
		repositorio.conectar(connect);
	}

	public boolean cadastrar(FazReserva r) throws SQLException {
		return repositorio.cadastrar(r);
	}

	public FazReserva procurar(int seq) throws SQLException {
		return repositorio.procurar(seq);
	}

	public boolean remover(FazReserva f) throws SQLException {
		return repositorio.remover(f);
	}

	public void printar(FazReserva p) {
		repositorio.printar(p);
	}

	public ArrayList<FazReserva> listar() {
		return repositorio.listar();
	}

}

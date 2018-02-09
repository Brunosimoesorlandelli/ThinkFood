package Negocio;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Mesa;
import dados.IRepositorioMesa;
import dados.RepositorioMesa;

public class ControladorMesa implements IControladorMesa, Serializable{

	private static final long serialVersionUID = 1;
	private IRepositorioMesa repositorio;

	public ControladorMesa() {
		this.repositorio = RepositorioMesa.getInstance();
	}

	public void conectar(Connection connect) {
		repositorio.conectar(connect);
	}

	public boolean cadastrar(Mesa p) throws SQLException {
		return repositorio.cadastrar(p);
	}

	public Mesa procurar(int num) throws SQLException {
		return repositorio.procurar(num);
	}

	public boolean remover(Mesa p) throws SQLException {
		return repositorio.remover(p);
	}

	public void printar(Mesa p) {
		repositorio.printar(p);
	}

	public ArrayList<Mesa> listar() {
		return repositorio.listar();
	}

}

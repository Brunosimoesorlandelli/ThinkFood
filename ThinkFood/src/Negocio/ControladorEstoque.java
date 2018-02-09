package Negocio;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Estoque;
import dados.IRepositorioEstoque;
import dados.RepositorioEstoque;

public class ControladorEstoque implements IControladorEstoque, Serializable {

	private static final long serialVersionUID = 1;
	private IRepositorioEstoque repositorio;

	public ControladorEstoque() {
		this.repositorio = RepositorioEstoque.getInstance();
	}

	public void conectar(Connection connect) {
		repositorio.conectar(connect);
	}

	public boolean cadastrar(Estoque p) throws SQLException {
		return repositorio.cadastrar(p);
	}

	public Estoque procurar(int id) throws SQLException {
		return repositorio.procurar(id);
	}

	public boolean remover(Estoque p) throws SQLException {
		return repositorio.remover(p);
	}

	public void printar(Estoque p) {
		repositorio.printar(p);
	}

	public ArrayList<Estoque> listar() {
		return repositorio.listar();
	}

}

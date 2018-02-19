package Negocio;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.ItemEstoque;
import dados.IRepositorioItemEstoque;
import dados.RepositorioItemEstoque;

public class ControladorItemEstoque implements IControladorItemEstoque, Serializable {

	private static final long serialVersionUID = 1;
	private IRepositorioItemEstoque repositorio;

	public ControladorItemEstoque() {
		this.repositorio = RepositorioItemEstoque.getInstance();
	}

	public void conectar(Connection connect) {
		repositorio.conectar(connect);
	}

	public boolean cadastrar(ItemEstoque p) throws SQLException {
		return repositorio.cadastrar(p);
	}

	public ItemEstoque procurar(int id) throws SQLException {
		return repositorio.procurar(id);
	}

	public boolean remover(ItemEstoque p) throws SQLException {
		return repositorio.remover(p);
	}

	public void printar(ItemEstoque p) {
		repositorio.printar(p);
	}

	public ArrayList<ItemEstoque> listar() {
		return repositorio.listar();
	}

}

package Negocio;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.ItemMenu;
import dados.IRepositorioItemMenu;
import dados.RepositorioItemMenu;

public class ControladorItemMenu implements IControladorItemMenu, Serializable {

	private static final long serialVersionUID = 1;
	private IRepositorioItemMenu repositorio;

	public ControladorItemMenu() {
		this.repositorio = RepositorioItemMenu.getInstance();
	}

	public boolean cadastrar(ItemMenu p) throws SQLException {
		return repositorio.cadastrar(p);
	}

	public ItemMenu procurar(int id) throws SQLException {
		return repositorio.procurar(id);
	}

	public boolean remover(ItemMenu p) throws SQLException {
		return repositorio.remover(p);
	}

	public void printar(ItemMenu p) {
		repositorio.printar(p);
	}

	public ArrayList<ItemMenu> listar() {
		return repositorio.listar();
	}

}

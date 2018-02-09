package Negocio;

import java.sql.SQLException;
import java.util.ArrayList;

import beans.ItemMenu;
import dados.RepositorioItemMenu;

public interface IControladorItemMenu {

	public boolean cadastrar(ItemMenu p) throws SQLException;

	public ItemMenu procurar(int id) throws SQLException;

	public boolean remover(ItemMenu p) throws SQLException;

	public void printar(ItemMenu p);

	public ArrayList<ItemMenu> listar();
}

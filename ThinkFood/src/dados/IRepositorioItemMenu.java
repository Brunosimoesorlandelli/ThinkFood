package dados;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.ItemMenu;

public interface IRepositorioItemMenu {

	public void conectar(Connection connect);
	
	boolean cadastrar(ItemMenu p) throws SQLException;

	ItemMenu procurar(int id) throws SQLException;

	boolean remover(ItemMenu p) throws SQLException;

	void printar(ItemMenu p);

	ArrayList<ItemMenu> listar();
}

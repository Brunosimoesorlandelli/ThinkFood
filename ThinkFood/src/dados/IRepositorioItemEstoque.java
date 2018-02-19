package dados;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.ItemEstoque;

public interface IRepositorioItemEstoque {

	public void conectar(Connection connect);

	public boolean cadastrar(ItemEstoque p) throws SQLException;

	public ItemEstoque procurar(int cod) throws SQLException;

	public boolean remover(ItemEstoque p) throws SQLException;

	public void printar(ItemEstoque p);

	public ArrayList<ItemEstoque> listar();
}

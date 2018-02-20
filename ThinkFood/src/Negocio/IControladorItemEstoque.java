package Negocio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.ItemEstoque;

public interface IControladorItemEstoque {

	public void conectar(Connection connect);

	public boolean cadastrar(ItemEstoque p) throws SQLException;

	public ItemEstoque procurar(int id) throws SQLException;

	public boolean remover(ItemEstoque p) throws SQLException;

	public void printar(ItemEstoque p);

	public ArrayList<ItemEstoque> listar();
}
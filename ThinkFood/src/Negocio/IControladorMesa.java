package Negocio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Mesa;

public interface IControladorMesa {

	public void conectar(Connection connect);

	public boolean cadastrar(Mesa p) throws SQLException;

	public Mesa procurar(int num) throws SQLException;

	public boolean remover(Mesa p) throws SQLException;

	public void printar(Mesa p);

	public ArrayList<Mesa> listar();
}

package Negocio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Estoque;

public interface IControladorEstoque {

	public void conectar(Connection connect);

	public boolean cadastrar(Estoque p) throws SQLException;

	public Estoque procurar(int id) throws SQLException;

	public boolean remover(Estoque p) throws SQLException;

	public void printar(Estoque p);

	public ArrayList<Estoque> listar();
}

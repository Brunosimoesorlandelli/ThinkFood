package Negocio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Produto;

public interface IControladorProduto {

	public void conectar(Connection connect);

	public boolean cadastrar(Produto p) throws SQLException;

	public Produto procurar(int id) throws SQLException;

	public boolean remover(Produto p) throws SQLException;

	public void printar(Produto p);

	public ArrayList<Produto> listar();

}

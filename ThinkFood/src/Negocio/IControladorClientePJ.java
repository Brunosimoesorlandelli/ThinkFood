package Negocio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.ClientePJ;

public interface IControladorClientePJ {

	public void conectar(Connection connect);

	public boolean cadastrar(ClientePJ p) throws Exception;

	public ClientePJ procurar(int id) throws Exception;

	public boolean remover(ClientePJ f) throws SQLException;

	public boolean atualizarClientePJ(ClientePJ c) throws Exception;

	public void printar(ClientePJ p);

	public ArrayList<ClientePJ> listar();
}

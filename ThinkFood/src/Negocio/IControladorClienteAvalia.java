package Negocio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.ClientePF;

public interface IControladorClienteAvalia {

	public void conectar(Connection connect);

	public boolean cadastrar(ClientePF p) throws Exception;

	public ClientePF procurar(int id) throws Exception;

	public boolean remover(ClientePF f) throws SQLException;

	public void printar(ClientePF p);

	public ArrayList<ClientePF> listar();
}

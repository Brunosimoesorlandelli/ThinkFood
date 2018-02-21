package Negocio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.ClientePF;
import beans.Cliente_Avalia;

public interface IControladorClienteAvalia {

	public void conectar(Connection connect);

	public boolean cadastrar(Cliente_Avalia c) throws SQLException;

	public Cliente_Avalia procurar(int id) throws SQLException;

	public boolean remover(Cliente_Avalia p) throws SQLException;

	public boolean atualizarCliente_Avalia(Cliente_Avalia c) throws Exception;

	public void printar(Cliente_Avalia p);

	public ArrayList<Cliente_Avalia> listar();
}

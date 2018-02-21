package Negocio;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Cliente_Avalia;
import dados.IRepositorioClienteAvalia;
import dados.RepositorioClienteAvalia;

public class ControladorClienteAvalia implements IControladorClienteAvalia, Serializable {

	private static final long serialVersionUID = 1;
	private IRepositorioClienteAvalia repositorio;

	public ControladorClienteAvalia() {
		this.repositorio = RepositorioClienteAvalia.getInstance();
	}

	public void conectar(Connection connect) {
		repositorio.conectar(connect);
	}

	public boolean cadastrar(Cliente_Avalia c) throws SQLException {
		return repositorio.cadastrar(c);
	}

	public Cliente_Avalia procurar(int id) throws SQLException {
		return repositorio.procurar(id);
	}

	public boolean remover(Cliente_Avalia p) throws SQLException {
		return repositorio.remover(p);
	}

	public boolean atualizarCliente_Avalia(Cliente_Avalia c) throws Exception {
		return repositorio.atualizarCliente_Avalia(c);
	}

	public void printar(Cliente_Avalia p) {
		repositorio.printar(p);
	}

	public ArrayList<Cliente_Avalia> listar() {
		return repositorio.listar();
	}

}

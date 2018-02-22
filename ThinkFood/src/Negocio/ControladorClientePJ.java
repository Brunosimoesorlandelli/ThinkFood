package Negocio;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.ClientePJ;
import dados.IRepositorioClientePJ;
import dados.RepositorioClientePJ;

public class ControladorClientePJ implements IControladorClientePJ, Serializable {

	private static final long serialVersionUID = 1;
	private IRepositorioClientePJ repositorio;

	public ControladorClientePJ() {
		this.repositorio = RepositorioClientePJ.getInstance();
	}

	public void conectar(Connection connect) {
		repositorio.conectar(connect);
	}

	public boolean cadastrar(ClientePJ p) throws Exception {
		return repositorio.cadastrar(p);
	}

	public ClientePJ procurar(int id) throws Exception {
		return repositorio.procurar(id);
	}

	public boolean atualizarClientePJ(ClientePJ c) throws Exception {
		return repositorio.atualizarClientePJ(c);
	}

	public boolean remover(ClientePJ f) throws SQLException {
		return repositorio.remover(f);
	}

	public void printar(ClientePJ p) {
		repositorio.printar(p);
	}

	public ArrayList<ClientePJ> listar() {
		return repositorio.listar();
	}

}

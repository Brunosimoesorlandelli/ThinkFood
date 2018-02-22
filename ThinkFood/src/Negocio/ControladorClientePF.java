package Negocio;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.ClientePF;
import dados.IRepositorioClientePF;
import dados.RepositorioClientePF;

public class ControladorClientePF implements IControladorClientePF, Serializable{

	private static final long serialVersionUID = 1;
	private IRepositorioClientePF repositorio;

	public ControladorClientePF() {
		this.repositorio = RepositorioClientePF.getInstance();
	}

	public void conectar(Connection connect) {
		repositorio.conectar(connect);
	}

	public boolean cadastrar(ClientePF p) throws Exception {
		return repositorio.cadastrar(p);
	}

	public ClientePF procurar(int id) throws Exception {
		return repositorio.procurar(id);
	}

	public boolean remover(ClientePF f) throws SQLException {
		return repositorio.remover(f);
	}

	public boolean atualizarClientePF(ClientePF c) throws Exception {
		return repositorio.atualizarClientePF(c);
	}

	public void printar(ClientePF p) {
		repositorio.printar(p);
	}

	public ArrayList<ClientePF> listar() {
		return repositorio.listar();
	}

}

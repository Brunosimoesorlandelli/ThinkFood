package Negocio;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Funcionario_Secretario;
import dados.IRepositorioSecretario;
import dados.RepositorioSecretario;

public class ControladorSecretario implements IControladorSecretario, Serializable{

	private static final long serialVersionUID = 1;
	private IRepositorioSecretario repositorio;

	public ControladorSecretario() {
		this.repositorio = RepositorioSecretario.getInstance();
	}

	public void conectar(Connection connect) {
		repositorio.conectar(connect);
	}

	public boolean cadastrar(Funcionario_Secretario p) throws Exception {
		return repositorio.cadastrar(p);
	}

	public Funcionario_Secretario procurar(String cpf) throws Exception {
		return repositorio.procurar(cpf);
	}

	public boolean remover(Funcionario_Secretario f) throws SQLException {
		return repositorio.remover(f);
	}

	public void printar(Funcionario_Secretario p) {
		repositorio.printar(p);
	}

	public ArrayList<Funcionario_Secretario> listar() {
		return repositorio.listar();
	}
	
	
}

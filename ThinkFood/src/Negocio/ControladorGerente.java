package Negocio;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Funcionario_Gerente;
import dados.IRepositorioGerente;
import dados.RepositorioGerente;

public class ControladorGerente implements IControladorGerente, Serializable{

	private static final long serialVersionUID = 1;
	private IRepositorioGerente repositorio;
	
	public ControladorGerente() {
		this.repositorio = RepositorioGerente.getInstance();
	}

	public void conectar(Connection connect) {
		repositorio.conectar(connect);
	}

	public boolean cadastrar(Funcionario_Gerente p) throws Exception {
		return repositorio.cadastrar(p);
	}

	public Funcionario_Gerente procurar(String cpf) throws Exception {
		return repositorio.procurar(cpf);
	}

	public boolean remover(Funcionario_Gerente f) throws SQLException {
		return repositorio.remover(f);
	}

	public void printar(Funcionario_Gerente p) {
		repositorio.printar(p);
	}

	public ArrayList<Funcionario_Gerente> listar() {
		return repositorio.listar();
	}

	public boolean atualizarGerente(Funcionario_Gerente f) throws Exception {
		return repositorio.atualizarGerente(f);
	}
	
	
	
}

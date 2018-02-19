package Negocio;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Funcionario_Garcon;
import dados.IRepositorioGarcom;
import dados.RepositorioGarcom;

public class ControladorGarcom implements  IControladorGarcom, Serializable{

	private static final long serialVersionUID = 1;
	private IRepositorioGarcom repositorio;
	
	public ControladorGarcom() {
		this.repositorio = RepositorioGarcom.getInstance();
	}

	public void conectar(Connection connect) {
		repositorio.conectar(connect);
	}

	public boolean cadastrar(Funcionario_Garcon p) throws Exception {
		return repositorio.cadastrar(p);
	}

	public Funcionario_Garcon procurar(String cpf) throws Exception {
		return repositorio.procurar(cpf);
	}

	public boolean remover(Funcionario_Garcon f) throws SQLException {
		return repositorio.remover(f);
	}

	public void printar(Funcionario_Garcon p) {
		repositorio.printar(p);
	}

	public ArrayList<Funcionario_Garcon> listarGarcon() {
		return repositorio.listar();
	}

	public boolean atualizarGarcon(Funcionario_Garcon f) throws Exception {
		return repositorio.atualizarGarcon(f);
	}
	
	
	
	
}

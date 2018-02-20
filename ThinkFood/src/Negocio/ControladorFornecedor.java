package Negocio;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import beans.Fornecedor;
import dados.IRepositorioFornecedores;
import dados.RepositorioFornecedores;

public class ControladorFornecedor implements IControladorFornecedor, Serializable {

	private static final long serialVersionUID = 1L;
	private IRepositorioFornecedores repositorio;

	public ControladorFornecedor() {
		this.repositorio = RepositorioFornecedores.getInstance();
	}

	public void conectar(Connection connect) {
		repositorio.conectar(connect);
	}

	public boolean cadastrar(Fornecedor p) throws Exception {
		return repositorio.cadastrar(p);
	}

	public Fornecedor procurar(String cnpj) throws Exception {
		return repositorio.procurar(cnpj);
	}

	public boolean remover(Fornecedor f) throws SQLException {
		return repositorio.remover(f);
	}

	public void printar(Fornecedor p) {
		repositorio.printar(p);
	}

	public ArrayList<Fornecedor> listar() {
		return repositorio.listar();
	}

	public boolean atualizarFornecedor(Fornecedor f) throws Exception {
		return repositorio.atualizarFornecedor(f);
	}
	
	

}

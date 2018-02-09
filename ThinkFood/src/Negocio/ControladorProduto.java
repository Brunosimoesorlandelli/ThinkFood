package Negocio;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import beans.Produto;
import dados.IRepositorioProdutos;
import dados.RepositorioProdutos;

public class ControladorProduto implements IControladorProduto, Serializable {

	private static final long serialVersionUID = 2L;
	private IRepositorioProdutos repositorio;

	public ControladorProduto() {
		this.repositorio = RepositorioProdutos.getInstance();
	}

	public void conectar(Connection connect) {
		repositorio.conectar(connect);
	}

	public boolean cadastrar(Produto p) throws SQLException {
		return repositorio.cadastrar(p);
	}

	public Produto procurar(int id) throws SQLException {
		return repositorio.procurar(id);
	}

	public boolean remover(Produto p) throws SQLException {
		return repositorio.remover(p);
	}

	public void printar(Produto p) {
		repositorio.printar(p);
	}

	public ArrayList<Produto> listar() {
		return repositorio.listar();
	}

}

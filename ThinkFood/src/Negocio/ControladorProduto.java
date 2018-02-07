package Negocio;

import java.io.Serializable;

import javax.swing.JOptionPane;

import beans.Produto;
import dados.IRepositorioProdutos;
import dados.RepositorioProdutos;

public class ControladorProduto implements Serializable {

	private static final long serialVersionUID = 2L;
	private IRepositorioProdutos repositorio;

	public ControladorProduto() {
		this.repositorio = RepositorioProdutos.getInstance();
	}

	public boolean cadastro(Produto p) {
		boolean retorno = false;
		if (p == null) {
			JOptionPane.showMessageDialog(null, "PARAMETRO INVALIDO");
		} else {
			repositorio.cadastrar(p);
			retorno = true;
		}
		return retorno;
	}

	public Produto procurar() {

	}
}

package Negocio;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import beans.Fornecedor;
import dados.IRepositorioFornecedores;
import dados.RepositorioFornecedores;

public class ControladorFornecedor implements Serializable {

	private static final long serialVersionUID = 1L;
	private IRepositorioFornecedores repositorio;

	public ControladorFornecedor() {
		this.repositorio = RepositorioFornecedores.getInstance();
	}

	public boolean cadastrar(Fornecedor f) throws Exception {
		boolean retorno = false;
		if (f == null) {
			JOptionPane.showMessageDialog(null, "PARAMETRO INVALIDO");
		} else {
			repositorio.cadastrar(f);
			retorno = true;
		}
		return retorno;
	}

	public Fornecedor procurar(String cnpj) throws Exception {
		return repositorio.procurar(cnpj);
	}

	public boolean remover(Fornecedor f) throws SQLException {
		boolean retorno = false;
		if (repositorio.remover(f)) {
			retorno = true;
		}
		return retorno;
	}

	public ArrayList<Fornecedor> listar() {
		return repositorio.listar();
	}

}

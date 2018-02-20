package dados;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Fornecedor;

public interface IRepositorioFornecedores {

	public void conectar(Connection connect);

	boolean cadastrar(Fornecedor p) throws Exception;

	Fornecedor procurar(String cnpj) throws Exception;

	boolean remover(Fornecedor f) throws SQLException;
	/*
	 * @Override public boolean alterarProduto(String nome) { if
	 * (getInstance().existe(nome)) { Produto c = procurar(nome);
	 * fornecedores.set(fornecedores.indexOf(c), c);
	 * RepositorioFornecedores.salvar(); return true; } return false;
	 * 
	 * }
	 */
	boolean atualizarFornecedor(Fornecedor f) throws Exception;

	// boolean existe(String cnpj);

	void printar(Fornecedor p);

	ArrayList<Fornecedor> listar();
	/*
	 * public void salvarFornecedor() { salvar(); }
	 */

}
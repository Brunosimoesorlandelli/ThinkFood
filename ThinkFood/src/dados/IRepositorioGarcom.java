package dados;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Funcionario_Garcon;
import beans.Funcionario_Gerente;

public interface IRepositorioGarcom {

	void conectar(Connection connect);

	boolean cadastrar(Funcionario_Garcon p) throws Exception;

	/*
	 * (non-Javadoc)
	 * 
	 * @see dados.IRepositorioFornecedores#procurar(java.lang.String)
	 */
	Funcionario_Garcon procurar(String cpf) throws Exception;

	/*
	 * (non-Javadoc)
	 * 
	 * @see dados.IRepositorioFornecedores#remover(java.lang.String)
	 */
	boolean remover(Funcionario_Garcon f) throws SQLException;
	/*
	 * @Override public boolean alterarFornecedor(String nome) { if
	 * (getInstance().existe(nome)) { Fornecedor c = procurar(nome);
	 * fornecedores.set(fornecedores.indexOf(c), c);
	 * RepositorioFornecedores.salvar(); return true; } return false;
	 * 
	 * }
	 */

	void printar(Funcionario_Garcon p);

	ArrayList<Funcionario_Garcon> listar();
	/*
	 * public void salvarFornecedor() { salvar(); }
	 */
	
	boolean atualizarGarcon(Funcionario_Garcon f) throws Exception;

}
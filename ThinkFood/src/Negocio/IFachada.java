package Negocio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Fornecedor;
import beans.Funcionario_Entregador;
import beans.Funcionario_Garcon;
import beans.Funcionario_Gerente;
import beans.Funcionario_Secretario;
import beans.Produto;

public interface IFachada {

	public void conectar(Connection connect);

	public boolean cadastrar(Funcionario_Entregador p) throws Exception;

	public Funcionario_Entregador procurarEntregador(String cpf) throws Exception;

	public boolean remover(Funcionario_Entregador f) throws SQLException;

	public void printar(Funcionario_Entregador p);

	public ArrayList<Funcionario_Entregador> listar();

	public boolean cadastrar(Fornecedor p) throws Exception;

	public Fornecedor procurarFornecedor(String cnpj) throws Exception;

	public boolean remover(Fornecedor f) throws SQLException;

	public void printar(Fornecedor p);

	public boolean cadastrar(Funcionario_Garcon p) throws Exception;

	public Funcionario_Garcon procurarGarcom(String cnpj) throws Exception;

	public boolean remover(Funcionario_Garcon f) throws SQLException;

	public void printar(Funcionario_Garcon p);

	public boolean cadastrar(Funcionario_Gerente p) throws Exception;

	public Funcionario_Gerente procurarGerente(String cpf) throws Exception;

	public boolean remover(Funcionario_Gerente f) throws SQLException;

	public void printar(Funcionario_Gerente p);

	public boolean cadastrar(Produto p) throws SQLException;

	public Produto procurar(int id) throws SQLException;

	public boolean remover(Produto p) throws SQLException;

	public void printar(Produto p);

	public void salvarProduto();

	public boolean cadastrar(Funcionario_Secretario p) throws Exception;

	public Funcionario_Secretario procurarSecretario(String cpf) throws Exception;

	public boolean remover(Funcionario_Secretario f) throws SQLException;

	public void printar(Funcionario_Secretario p);

}

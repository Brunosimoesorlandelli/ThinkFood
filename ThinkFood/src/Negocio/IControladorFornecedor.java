package Negocio;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import beans.Fornecedor;

public interface IControladorFornecedor {

	public boolean cadastrar(Fornecedor p) throws Exception;

	public Fornecedor procurar(String cnpj) throws Exception;

	public boolean remover(Fornecedor f) throws SQLException;

	public void printar(Fornecedor p);

	public ArrayList<Fornecedor> listar();
}

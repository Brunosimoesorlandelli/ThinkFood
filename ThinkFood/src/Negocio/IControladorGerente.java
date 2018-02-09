package Negocio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Funcionario_Gerente;

public interface IControladorGerente {

	public void conectar(Connection connect);

	public boolean cadastrar(Funcionario_Gerente p) throws Exception;

	public Funcionario_Gerente procurar(String cpf) throws Exception;

	public boolean remover(Funcionario_Gerente f) throws SQLException;

	public void printar(Funcionario_Gerente p);

	public ArrayList<Funcionario_Gerente> listar();

}

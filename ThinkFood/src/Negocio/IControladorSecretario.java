package Negocio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Funcionario_Secretario;

public interface IControladorSecretario {

	public void conectar(Connection connect);

	public boolean cadastrar(Funcionario_Secretario p) throws Exception;

	public Funcionario_Secretario procurar(String cpf) throws Exception;

	public boolean remover(Funcionario_Secretario f) throws SQLException;

	public void printar(Funcionario_Secretario p);

	public ArrayList<Funcionario_Secretario> listar();
}

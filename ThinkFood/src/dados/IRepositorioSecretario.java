package dados;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Funcionario_Secretario;

public interface IRepositorioSecretario {

	void conectar(Connection connect);

	boolean cadastrar(Funcionario_Secretario p) throws Exception;

	Funcionario_Secretario procurar(String cpf) throws Exception;

	boolean remover(Funcionario_Secretario f) throws SQLException;

	void printar(Funcionario_Secretario p);

	ArrayList<Funcionario_Secretario> listar();

	
}

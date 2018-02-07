package dados;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Funcionario_Gerente;

public interface IRepositorioGerente {

	void conectar(Connection connect);

	boolean cadastrar(Funcionario_Gerente p) throws Exception;

	Funcionario_Gerente procurar(String cpf) throws Exception;

	boolean remover(Funcionario_Gerente f) throws SQLException;

	void printar(Funcionario_Gerente p);

	ArrayList<Funcionario_Gerente> listar();

}

package dados;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Funcionario_Entregador;
import beans.Funcionario_Gerente;

public interface IRepositorioEntregador {

	void conectar(Connection connect);

	boolean cadastrar(Funcionario_Entregador p) throws Exception;

	Funcionario_Entregador procurar(String cpf) throws Exception;

	boolean remover(Funcionario_Entregador f) throws SQLException;

	void printar(Funcionario_Entregador p);

	ArrayList<Funcionario_Entregador> listar();
	
	boolean atualizarEntregador(Funcionario_Entregador f) throws Exception;

}

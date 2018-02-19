package Negocio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Funcionario_Garcon;
import beans.Funcionario_Gerente;

public interface IControladorGarcom {

	public void conectar(Connection connect);

	public boolean cadastrar(Funcionario_Garcon p) throws Exception;

	public Funcionario_Garcon procurar(String cpf) throws Exception;

	public boolean remover(Funcionario_Garcon f) throws SQLException;

	public void printar(Funcionario_Garcon p);

	public ArrayList<Funcionario_Garcon> listarGarcon();
	
	boolean atualizarGarcon(Funcionario_Garcon f) throws Exception;
}

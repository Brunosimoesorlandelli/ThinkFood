package Negocio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Funcionario_Entregador;

public interface IControladorEntregador {

	public void conectar(Connection connect);

	public boolean cadastrar(Funcionario_Entregador p) throws Exception;

	public boolean equals(Object arg0);

	public int hashCode();

	public Funcionario_Entregador procurar(String cpf) throws Exception;

	public boolean remover(Funcionario_Entregador f) throws SQLException;

	public void printar(Funcionario_Entregador p);

	public ArrayList<Funcionario_Entregador> listar();

	public String toString();
}

package dados;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Pedido;

public interface IRepositorioPedido {

	public void conectar(Connection connect);

	public boolean cadastrar(Pedido p) throws SQLException;

	public Pedido procurar(int id) throws SQLException;

	public boolean remover(Pedido p) throws SQLException;

	public void printar(Pedido p);

	public ArrayList<Pedido> listar();
}

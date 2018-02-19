package dados;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Pedido;
import beans.PedidoPresencial;

public interface IRepositorioPedidoPresencial {

	public void conectar(Connection connect);

	public boolean cadastrar(PedidoPresencial p) throws SQLException;

	public PedidoPresencial procurar(int id) throws SQLException;

	public boolean remover(PedidoPresencial p) throws SQLException;

	public void printar(Pedido p);

	public ArrayList<PedidoPresencial> listar();
}

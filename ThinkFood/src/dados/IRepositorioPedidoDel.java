package dados;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.PedidoDelivery;

public interface IRepositorioPedidoDel {

	public void conectar(Connection connect);
	
	public boolean cadastrar(PedidoDelivery p) throws SQLException;
	
	public PedidoDelivery procurar(int id) throws SQLException;
	
	public boolean remover(PedidoDelivery p) throws SQLException;
	
	public void printar(PedidoDelivery p);
	
	public ArrayList<PedidoDelivery> listar();
	
	
	
}

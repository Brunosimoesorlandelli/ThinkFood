package dados;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.FazReserva;

public interface IRepositorioFazReserva {

	public void conectar(Connection connect);

	public boolean cadastrar(FazReserva r) throws SQLException;

	public FazReserva procurar(int seq) throws SQLException;

	public boolean remover(FazReserva f) throws SQLException;

	public void printar(FazReserva p);

	public ArrayList<FazReserva> listar();
}

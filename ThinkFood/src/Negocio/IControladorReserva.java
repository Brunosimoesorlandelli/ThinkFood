package Negocio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Reserva;

public interface IControladorReserva {

	void conectar(Connection connect);

	boolean cadastrar(Reserva p) throws SQLException;

	Reserva procurar(int seq) throws SQLException;

	boolean remover(Reserva f) throws SQLException;

	void printar(Reserva r);

	ArrayList<Reserva> listar();

}
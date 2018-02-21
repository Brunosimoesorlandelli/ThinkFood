package Negocio;

import java.sql.Connection;
import java.sql.SQLException;

import beans.ReservaOficial;

public interface IControladorReservaOficial {
	
	void conectarReservaOficial(Connection c);

	boolean cadastrarReservaOficial(ReservaOficial r) throws SQLException;

	ReservaOficial procurarReservaOficial(int cod) throws SQLException;

	boolean atualizarReservaOficial(ReservaOficial f) throws Exception;

	boolean removerReservaOficial(ReservaOficial f) throws SQLException;

}
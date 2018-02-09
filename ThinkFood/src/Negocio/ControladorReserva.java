package Negocio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Reserva;
import dados.IRepositorioReserva;
import dados.RepositorioReserva;

public class ControladorReserva implements IControladorReserva {
	private static final long serialVersionUID = 2L;
	private IRepositorioReserva repositorio;

	public ControladorReserva() {
		this.repositorio = RepositorioReserva.getInstance();
	}

	/* (non-Javadoc)
	 * @see Negocio.IControladorReserva#conectar(java.sql.Connection)
	 */
	@Override
	public void conectar(Connection connect) {
		repositorio.conectar(connect);
	}

	/* (non-Javadoc)
	 * @see Negocio.IControladorReserva#cadastrar(beans.Reserva)
	 */
	@Override
	public boolean cadastrar(Reserva p) throws SQLException {
		return repositorio.cadastrar(p);
	}

	/* (non-Javadoc)
	 * @see Negocio.IControladorReserva#procurar(int)
	 */
	@Override
	public Reserva procurar(int seq) throws SQLException {
		return repositorio.procurar(seq);
	}

	/* (non-Javadoc)
	 * @see Negocio.IControladorReserva#remover(beans.Reserva)
	 */
	@Override
	public boolean remover(Reserva f) throws SQLException {
		return repositorio.remover(f);
	}

	/* (non-Javadoc)
	 * @see Negocio.IControladorReserva#printar(beans.Reserva)
	 */
	@Override
	public void printar(Reserva r) {
		repositorio.printar(r);
	}

	/* (non-Javadoc)
	 * @see Negocio.IControladorReserva#listar()
	 */
	@Override
	public ArrayList<Reserva> listar() {
		return repositorio.listar();
	}
	
	
}

package Negocio;

import java.sql.Connection;
import java.sql.SQLException;

import beans.ReservaOficial;
import dados.IRepositorioReservaOficial;
import dados.RepositorioReservaOficial;

public class ControladorReservaOficial implements IControladorReservaOficial {

	private static final long serialVersionUID = 2L;
	private IRepositorioReservaOficial repositorio;

	public ControladorReservaOficial() {
		this.repositorio = RepositorioReservaOficial.getInstance();
	}
	
	

	public void conectarReservaOficial(Connection c) {
		repositorio.conectarReservaOficial(c);
	}


	/* (non-Javadoc)
	 * @see Negocio.IControladorReservaOficial#cadastrarReservaOficial(beans.ReservaOficial)
	 */
	@Override
	public boolean cadastrarReservaOficial(ReservaOficial r) throws SQLException {
		return repositorio.cadastrarReservaOficial(r);
	}

	/* (non-Javadoc)
	 * @see Negocio.IControladorReservaOficial#procurarReservaOficial(int)
	 */
	@Override
	public ReservaOficial procurarReservaOficial(int cod) throws SQLException {
		return repositorio.procurarReservaOficial(cod);
	}

	/* (non-Javadoc)
	 * @see Negocio.IControladorReservaOficial#atualizarReservaOficial(beans.ReservaOficial)
	 */
	@Override
	public boolean atualizarReservaOficial(ReservaOficial f) throws Exception {
		return repositorio.atualizarReservaOficial(f);
	}

	/* (non-Javadoc)
	 * @see Negocio.IControladorReservaOficial#removerReservaOficial(beans.ReservaOficial)
	 */
	@Override
	public boolean removerReservaOficial(ReservaOficial f) throws SQLException {
		return repositorio.removerReservaOficial(f);
	}
	
	

}

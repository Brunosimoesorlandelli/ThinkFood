package dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Reserva;
import beans.ReservaOficial;
import beans.StatusReserva;

public class RepositorioReservaOficial {
	private static final long serialVersionUID = 1L;
	/**
	 *
	 */
	private static Connection connection;
	private static IRepositorioReserva instanceUser;
	private ArrayList<ReservaOficial> reservas;
	private int next;

	public RepositorioReservaOficial() {
		this.reservas = new ArrayList<ReservaOficial>();
		this.next = 0;
	}

	public static synchronized IRepositorioReserva getInstance() {
		if (instanceUser == null) {
			instanceUser = new RepositorioReservaOficial();
		}
		return instanceUser;
	}

 void conectar(Connection connect) {
		RepositorioReservaOficial.connection = connect;
	}

	
	
	public boolean cadastrar(Reserva r) throws SQLException {
		String query = "insert into reserva (seq, hora_inicio, hora_fim, status, num_pessoas)values(?,?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, r.getSeq());
		ps.setTime(2, r.getHora_inicio());
		ps.setTime(3, r.getHora_fim());
		ps.setString(4, r.getStatus().name());
		ps.setInt(5, r.getNum_pessoas());
	
		ps.executeUpdate();
		return true;
	}

	
	public Reserva procurar(int seq) throws SQLException {
		Reserva f = null;
		String query = "select * from reserva where seq = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, seq);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			f = new Reserva(rs.getInt("seq"), rs.getTime("hora_inicio"), rs.getTime("hora_fim"),
					StatusReserva.valueOf(rs.getString("status")), rs.getInt("num_pessoas"));
		}
		return f;

	}


	public boolean remover(Reserva f) throws SQLException {
		String query = "delete from reserva where seq =?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, f.getSeq());
		ps.executeUpdate();
		return true;
	}
	

	

	
}

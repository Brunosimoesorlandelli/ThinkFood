package dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Funcionario_Secretario;
import beans.Reserva;
import beans.ReservaOficial;
import beans.StatusReserva;

public class RepositorioReservaOficial implements IRepositorioReservaOficial {
	private static final long serialVersionUID = 1L;
	/**
	 *
	 */
	private static Connection connection;
	private static IRepositorioReservaOficial instanceUser;
	private ArrayList<ReservaOficial> reservas;
	private int next;

	public RepositorioReservaOficial() {
		this.reservas = new ArrayList<ReservaOficial>();
		this.next = 0;
	}

	public static synchronized IRepositorioReservaOficial getInstance() {
		if (instanceUser == null) {
			instanceUser = new RepositorioReservaOficial();
		}
		return instanceUser;
	}

	public void conectarReservaOficial(Connection connect) {
		RepositorioReservaOficial.connection = connect;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dados.IRepositorioReservaOficial#cadastrarReservaOficial(beans.
	 * ReservaOficial)
	 */
	@Override
	public boolean cadastrarReservaOficial(ReservaOficial r) throws SQLException {
		String query = "insert into reserva (seq, hora_inicio, hora_fim, status, num_pessoas)values(?,?,?,?,?)";
		String query2 = "insert into faz_reserva (cpf_funcionario, seq_reserva, id_cliente, data_reserva, dt_validade)values(?,?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		PreparedStatement ps2 = connection.prepareStatement(query2);
		ps.setInt(1, r.getSeq());
		ps.setTime(2, r.getHora_inicio());
		ps.setTime(3, r.getHora_fim());
		ps.setString(4, r.getStatus().name());
		ps.setInt(5, r.getNum_pessoas());
		
		ps2.setString(1, r.getCpfFuncionario());
		ps2.setInt(2, r.getSeq());
		ps2.setInt(3, r.getIdCliente());
		ps2.setDate(4, r.getDataReserva());
		ps2.setDate(5, r.getDataValidade());
		ps.executeUpdate();
		ps2.executeUpdate();
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dados.IRepositorioReservaOficial#procurarReservaOficial(int)
	 */
	@Override
	public ReservaOficial procurarReservaOficial(int seq) throws SQLException {
		ReservaOficial f = null;
		String query = "select * from reserva where seq = ?";
		String query2 = "select * from faz_reserva where seq_reserva = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		PreparedStatement ps2 = connection.prepareStatement(query2);
		ps.setInt(1, seq);
		ps2.setInt(1, seq);
		ResultSet rs = ps.executeQuery();
		ResultSet rs2 = ps2.executeQuery();

		while (rs.next() && rs2.next()) {
			f = new ReservaOficial(rs.getInt("seq"), rs.getTime("hora_inicio"), rs.getTime("hora_fim"),
					StatusReserva.valueOf(rs.getString("status")), rs.getInt("num_pessoas"),
					rs2.getString("cpf_funcionario"), rs2.getInt("id_cliente"), rs2.getDate("data_reserva"),
					rs2.getDate("dt_validade"));
		}
		return f;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dados.IRepositorioReservaOficial#atualizarReservaOficial(beans.
	 * ReservaOficial)
	 */
	@Override
	public boolean atualizarReservaOficial(ReservaOficial f) throws Exception {
		String query = "update reserva set seq = ?, hora_inicio = ?, hora_fim = ?, status = ?, num_pessoas = ? where seq = " + f.getSeq();
		String query2 = "update faz_reserva set cpf_funcionario = ?, seq_reserva = ?, id_cliente = ?, data_reserva = ?, dt_validade = ? where seq_reserva = " + f.getSeq();
		PreparedStatement ps = connection.prepareStatement(query);
		PreparedStatement ps2 = connection.prepareStatement(query2);

		ps.setInt(1, f.getSeq());
		ps.setTime(2, f.getHora_inicio());
		ps.setTime(3, f.getHora_fim());
		ps.setString(4, f.getStatus().name());
		ps.setInt(5, f.getNum_pessoas());
		ps2.setString(1, f.getCpfFuncionario());
		ps2.setInt(2, f.getSeq());
		ps2.setInt(3, f.getIdCliente());
		ps2.setDate(4, f.getDataReserva());
		ps2.setDate(5, f.getDataValidade());

		ps.executeUpdate();
		ps2.executeUpdate();
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * dados.IRepositorioReservaOficial#removerReservaOficial(beans.ReservaOficial)
	 */
	@Override
	public boolean removerReservaOficial(ReservaOficial f) throws SQLException {
		String query = "delete from reserva where seq =?";
		String query2 = "delete from faz_reserva where seq_reserva =?";
		PreparedStatement ps = connection.prepareStatement(query);
		PreparedStatement ps2 = connection.prepareStatement(query2);
		
		ps.setInt(1, f.getSeq());
		ps2.setInt(1, f.getSeq());
		ps.executeUpdate();
		ps2.executeUpdate();
		return true;
	}

}

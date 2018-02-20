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

	public static synchronized IRepositorioReservaOficial getInstance() {
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

	
	public ReservaOficial procurarReservaOficial(int seq) throws SQLException {
		ReservaOficial f = null;
		String query = "select * from reserva where seq = ?";
		String query2  = "select * from faz_reserva where seq_reserva = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		PreparedStatement ps2 = connection.prepareStatement(query2);
		ps.setInt(1, seq);
		ps.setInt(1, seq);
		ResultSet rs = ps.executeQuery();
		ResultSet rs2 = ps.executeQuery();

		while (rs.next() && rs2.next()) {
			f = new ReservaOficial(rs.getInt("seq"), rs.getTime("hora_inicio"), rs.getTime("hora_fim"),
					StatusReserva.valueOf(rs.getString("status")), rs.getInt("num_pessoas"), rs2.getString("cpf_funcionario"), rs2.getInt("id_cliente"), rs2.getDate("data_reserva"), rs2.getDate("dt_validade"));
		}
		return f;

	}


	public boolean atualizarReservaOficial(ReservaOficial f) throws Exception {
		String query = "update funcionario nome = ?, data_nasc = ?, salario = ?, complemento = ?, numero = ?, cep_endereco = ?, seq_loja = ?, senha = ? where cpf = " + "'" + f.getCpf() + "'";
		String query2 = "";
		PreparedStatement ps = connection.prepareStatement(query);

		
		ps.setString(1, f.getNome());
		ps.setDate(2, f.getDataNasc());
		ps.setDouble(3, f.getSalario());
		ps.setString(4, f.getCompl());
		ps.setInt(5, f.getNumero());
		ps.setString(6, f.getCEP());
		ps.setInt(7, f.getSeq_loja());
		ps.setString(8, f.getSenha());
		

		ps.executeUpdate();

		return true;
	}
	
	public boolean removerReservaOficial(ReservaOficial f) throws SQLException {
		String query = "delete from reserva where seq =?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, f.getSeq());
		ps.executeUpdate();
		return true;
	}
	

	

	
}

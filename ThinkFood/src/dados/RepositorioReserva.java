package dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import beans.Reserva;
import beans.StatusReserva;

public class RepositorioReserva implements IRepositorioReserva {

	private static final long serialVersionUID = 1L;
	/**
	 *
	 */
	private static Connection connection;
	private static IRepositorioReserva instanceUser;
	private ArrayList<Reserva> reservas;
	private int next;

	public RepositorioReserva() {
		this.reservas = new ArrayList<Reserva>();
		this.next = 0;
	}

	public static synchronized IRepositorioReserva getInstance() {
		if (instanceUser == null) {
			instanceUser = new RepositorioReserva();
		}
		return instanceUser;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dados.IRepositorioGarcom#conectar(java.sql.Connection)
	 */
	/* (non-Javadoc)
	 * @see dados.IRepositorioReserva#conectar(java.sql.Connection)
	 */
	@Override
	public void conectar(Connection connect) {
		RepositorioReserva.connection = connect;
	}

	/*
	 * private static void salvar() { if (instanceUser == null) { return; } File out
	 * = new File("RepositorioFornecedores.db"); FileOutputStream fos = null;
	 * ObjectOutputStream oos = null;
	 * 
	 * try { fos = new FileOutputStream(out); oos = new ObjectOutputStream(fos);
	 * oos.writeObject(instanceUser); } catch (Exception e) { e.printStackTrace(); }
	 * finally { if (oos != null) { try { oos.close(); } catch (IOException e) { } }
	 * } }
	 * 
	 * private static RepositorioFornecedor ler() { RepositorioProduto
	 * instanciaLocal = null;
	 * 
	 * File in = new File("RepositorioFornecedores.db"); FileInputStream fis = null;
	 * ObjectInputStream ois = null;
	 * 
	 * try { fis = new FileInputStream(in); ois = new ObjectInputStream(fis); Object
	 * o = ois.readObject(); instanciaLocal = (RepositorioFornecedor) o; } catch
	 * (Exception e) { instanciaLocal = new RepositorioFornecedor(); } finally { if
	 * (ois != null) { try { ois.close(); } catch (IOException e) { } } } return
	 * instanciaLocal; }
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see dados.IRepositorioFornecedores#cadastrar(beans.Fornecedor)
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see dados.IRepositorioGarcom#cadastrar(beans.Funcionario_Garcon)
	 */
	/* (non-Javadoc)
	 * @see dados.IRepositorioReserva#cadastrar(beans.Funcionario_Gerente)
	 */
	
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see dados.IRepositorioFornecedores#procurar(java.lang.String)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see dados.IRepositorioGarcom#procurar(java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see dados.IRepositorioReserva#procurar(java.lang.String)
	 */

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see dados.IRepositorioFornecedores#remover(java.lang.String)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see dados.IRepositorioGarcom#remover(beans.Funcionario_Garcon)
	 */
	/* (non-Javadoc)
	 * @see dados.IRepositorioReserva#remover(beans.Funcionario_Gerente)
	 */
	public boolean remover(Reserva f) throws SQLException {
		String query = "delete from reserva where seq =?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, f.getSeq());
		ps.executeUpdate();
		return true;
	}
	/*
	 * @Override public boolean alterarFornecedor(String nome) { if
	 * (getInstance().existe(nome)) { Fornecedor c = procurar(nome);
	 * fornecedores.set(fornecedores.indexOf(c), c);
	 * RepositorioFornecedores.salvar(); return true; } return false;
	 * 
	 * }
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see dados.IRepositorioFornecedores#existe(java.lang.String)
	 */
	/*
	 * public boolean existe(String cnpj) { boolean existe = false; Fornecedor u =
	 * this.procurar(cnpj); if (u != null) { existe = true;
	 * System.out.println("Fornecedor existe!"); } else {
	 * System.out.println("Fornecedor nao existe!"); } return existe; }
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see dados.IRepositorioFornecedores#printar(beans.Fornecedor)
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see dados.IRepositorioGarcom#printar(beans.Funcionario_Garcon)
	 */
	/* (non-Javadoc)
	 * @see dados.IRepositorioReserva#printar(beans.Funcionario_Gerente)
	 */
	public void printar(Reserva p) {
		try {
			JOptionPane.showMessageDialog(null, p.toString());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dados.IRepositorioFornecedores#listar()
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see dados.IRepositorioGarcom#listar()
	 */
	/* (non-Javadoc)
	 * @see dados.IRepositorioReserva#listar()
	 */
	public ArrayList<Reserva> listar() {
		return this.reservas;

	}
	/*
	 * public void salvarFornecedor() { salvar(); }
	 */

}


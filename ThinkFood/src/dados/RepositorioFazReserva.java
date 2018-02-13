package dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import beans.FazReserva;

public class RepositorioFazReserva implements IRepositorioFazReserva {

	private static final long serialVersionUID = 1L;
	/**
	 *
	 */
	private static Connection connection;
	private static IRepositorioFazReserva instanceUser;
	private ArrayList<FazReserva> reservas;
	private int next;

	public RepositorioFazReserva() {
		this.reservas = new ArrayList<FazReserva>();
		this.next = 0;
	}

	public static synchronized IRepositorioFazReserva getInstance() {
		if (instanceUser == null) {
			instanceUser = new RepositorioFazReserva();
		}
		return instanceUser;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dados.IRepositorioGarcom#conectar(java.sql.Connection)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see dados.IRepositorioReserva#conectar(java.sql.Connection)
	 */
	@Override
	public void conectar(Connection connect) {
		RepositorioFazReserva.connection = connect;
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
	/*
	 * (non-Javadoc)
	 * 
	 * @see dados.IRepositorioReserva#cadastrar(beans.Funcionario_Gerente)
	 */

	public boolean cadastrar(FazReserva r) throws SQLException {
		String query = "insert into faz_reserva ()values(?,?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, r.getCpfFuncionario());
		ps.setInt(2, r.getSeqReserva());
		ps.setInt(3, r.getIdCliente());
		ps.setDate(4, r.getDataReserva());
		ps.setDate(4, r.getDataValidade());

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
	/*
	 * (non-Javadoc)
	 * 
	 * @see dados.IRepositorioReserva#procurar(java.lang.String)
	 */

	public FazReserva procurar(int seq) throws SQLException {
		FazReserva f = null;
		String query = "select * from faz_reserva where seq = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(2, seq);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			f = new FazReserva(rs.getString("cpf_funcionario"), rs.getInt("seq_reserva"), rs.getInt("id_cliente"),
					rs.getDate("data_reserva"), rs.getDate("dt_validade"));
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
	/*
	 * (non-Javadoc)
	 * 
	 * @see dados.IRepositorioReserva#remover(beans.Funcionario_Gerente)
	 */
	public boolean remover(FazReserva f) throws SQLException {
		String query = "delete from faz_reserva where seq =?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(2, f.getSeqReserva());
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
	/*
	 * (non-Javadoc)
	 * 
	 * @see dados.IRepositorioReserva#printar(beans.Funcionario_Gerente)
	 */
	public void printar(FazReserva p) {
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
	/*
	 * (non-Javadoc)
	 * 
	 * @see dados.IRepositorioReserva#listar()
	 */
	public ArrayList<FazReserva> listar() {
		return this.reservas;

	}
	/*
	 * public void salvarFornecedor() { salvar(); }
	 */

}

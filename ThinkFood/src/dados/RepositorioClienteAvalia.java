package dados;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import beans.Cliente_Avalia;
import beans.Funcionario_Secretario;
import beans.Mesa;
import beans.Nota;

public class RepositorioClienteAvalia implements IRepositorioClienteAvalia, Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	/**
	 *
	 */
	private static Connection connection;
	private static IRepositorioClienteAvalia instanceUser;
	private ArrayList<Cliente_Avalia> avaliacoes;
	private int next;

	public RepositorioClienteAvalia() {
		this.avaliacoes = new ArrayList<Cliente_Avalia>();
		this.next = 0;
	}

	public static synchronized IRepositorioClienteAvalia getInstance() {
		if (instanceUser == null) {
			instanceUser = new RepositorioClienteAvalia();
		}
		return instanceUser;
	}

	public void conectar(Connection connect) {
		RepositorioClienteAvalia.connection = connect;
	}

	/*
	 * private static void salvar() { if (instanceUser == null) { return; } File out
	 * = new File("RepositorioProdutos.db"); FileOutputStream fos = null;
	 * ObjectOutputStream oos = null;
	 * 
	 * try { fos = new FileOutputStream(out); oos = new ObjectOutputStream(fos);
	 * oos.writeObject(instanceUser); } catch (Exception e) { e.printStackTrace(); }
	 * finally { if (oos != null) { try { oos.close(); } catch (IOException e) { } }
	 * } }
	 * 
	 * private static RepositorioProduto ler() { RepositorioProduto instanciaLocal =
	 * null;
	 * 
	 * File in = new File("RepositorioProdutos.db"); FileInputStream fis = null;
	 * ObjectInputStream ois = null;
	 * 
	 * try { fis = new FileInputStream(in); ois = new ObjectInputStream(fis); Object
	 * o = ois.readObject(); instanciaLocal = (RepositorioProdutos) o; } catch
	 * (Exception e) { instanciaLocal = new RepositorioProdutos(); } finally { if
	 * (ois != null) { try { ois.close(); } catch (IOException e) { } } } return
	 * instanciaLocal; }
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see Dados.IRepositorioProdutos#cadastrar(Beans.Produto)
	 */
	public boolean cadastrar(Cliente_Avalia c) throws SQLException {
		String query = "insert into cliente_avalia (seq_loja, id_cliente, nota, data_ava, comentario) values(?,?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, c.getSeq_loja());
		ps.setInt(2, c.getId_cliente());
		ps.setString(3, c.getNota().name());
		ps.setDate(4, c.getData_avaliacao());
		ps.setString(5, c.getComentario());

		ps.executeUpdate();
		return true;
	}

	// private int procurarIndice(int id) {
	// int indice = 0;
	// boolean found = false;
	// while (found != true && indice < this.next) {
	// if (id == produtos.get(indice).getCodigo()) {
	// found = true;
	// } else {
	// indice = indice + 1;
	// }
	// }
	// return indice;
	// }

	/*
	 * (non-Javadoc)
	 * 
	 * @see Dados.IRepositorioProdutos#procurar(int)
	 */

	public Cliente_Avalia procurar(int id) throws SQLException {
		Cliente_Avalia p = null;
		String query = "select * from cliente_avalia where id_cliente = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			p = new Cliente_Avalia(rs.getInt("seq_loja"), rs.getInt("id_cliente"), Nota.valueOf(rs.getString("nota")),
					rs.getDate("data_ava"), rs.getString("comentario"));
		}
		return p;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Dados.IRepositorioProdutos#remover(int)
	 */

	public boolean remover(Cliente_Avalia p) throws SQLException {
		String query = "delete from cliente_avalia where id_cliente =?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, p.getId_cliente());
		ps.executeUpdate();
		return true;
	}

	/*
	 * public boolean alterarProduto(String nome) { if (getInstance().existe(nome))
	 * { Produto c = procurar(nome); produtos.set(produtos.indexOf(c), c);
	 * RepositorioProduto.salvar(); return true; } return false;
	 * 
	 * }
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see Dados.IRepositorioProdutos#existe(int)
	 */
	// @Override
	// public boolean existe(int id) {
	// boolean existe = false;
	// Produto u = this.procurar(id);
	// if (u != null) {
	// existe = true;
	// System.out.println("Produto existe!");
	// } else {
	// System.out.println("Produto nao existe!");
	// }
	// return existe;
	// }

	public boolean atualizarCliente_Avalia(Cliente_Avalia c) throws Exception {
		String query = "update cliente_avalia seq_loja = ?, id_cliente = ?, nota = ?, data_ava = ?, comentario = ? where id_cliente = "
				+ "'" + c.getId_cliente() + "'";

		PreparedStatement ps = connection.prepareStatement(query);

		ps.setInt(1, c.getSeq_loja());
		ps.setInt(2, c.getId_cliente());
		ps.setString(3, c.getNota().name());
		ps.setDate(4, c.getData_avaliacao());
		ps.setString(5, c.getComentario());

		ps.executeUpdate();

		return true;
	}

	public void printar(Cliente_Avalia p) {
		try {
			JOptionPane.showMessageDialog(null, p.toString());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Dados.IRepositorioProdutos#listar()
	 */
	public ArrayList<Cliente_Avalia> listar() {
		return this.avaliacoes;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Dados.IRepositorioProdutos#salvarProduto()
	 */

}

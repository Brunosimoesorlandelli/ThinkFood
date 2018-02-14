package dados;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import beans.Pedido;

public class RepositorioPedido implements IRepositorioPedido, Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	/**
	 *
	 */
	private static Connection connection;
	private static IRepositorioPedido instanceUser;
	private ArrayList<Pedido> pedidos;
	private int next;

	public RepositorioPedido() {
		this.pedidos = new ArrayList<Pedido>();
		this.next = 0;
	}

	public static synchronized IRepositorioPedido getInstance() {
		if (instanceUser == null) {
			instanceUser = new RepositorioPedido();
		}
		return instanceUser;
	}

	public void conectar(Connection connect) {
		RepositorioPedido.connection = connect;
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
	public boolean cadastrar(Pedido p) throws SQLException {
		String query = "insert into pedido (id, pedido_hora, pedido_data, valor) values(?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, p.getId());
		ps.setTime(2, p.getHora());
		ps.setDate(3, p.getData());
		ps.setDouble(4, p.getValor());

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

	public Pedido procurar(int id) throws SQLException {
		Pedido p = null;
		String query = "select * from pedido where id = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			p = new Pedido(rs.getInt("id"), rs.getTime("pedido_hora"), rs.getDate("pedido_data"),
					rs.getDouble("valor"));
		}
		return p;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Dados.IRepositorioProdutos#remover(int)
	 */

	public boolean remover(Pedido p) throws SQLException {
		String query = "delete from pedido where id =?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, p.getId());
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

	public void printar(Pedido p) {
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
	public ArrayList<Pedido> listar() {
		return this.pedidos;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Dados.IRepositorioProdutos#salvarProduto()
	 */

}

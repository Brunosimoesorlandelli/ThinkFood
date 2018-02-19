package dados;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import beans.Pedido;
import beans.PedidoPresencial;

public class RepositorioPedidoPresencial implements IRepositorioPedidoPresencial, Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	/**
	 *
	 */
	private static Connection connection;
	private static IRepositorioPedidoPresencial instanceUser;
	private ArrayList<PedidoPresencial> pedidos;
	private int next;

	public RepositorioPedidoPresencial() {
		this.pedidos = new ArrayList<PedidoPresencial>();
		this.next = 0;
	}

	public static synchronized IRepositorioPedidoPresencial getInstance() {
		if (instanceUser == null) {
			instanceUser = new RepositorioPedidoPresencial();
		}
		return instanceUser;
	}

	public void conectar(Connection connect) {
		RepositorioPedidoPresencial.connection = connect;
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
	public boolean cadastrar(PedidoPresencial p) throws SQLException {
		String query = "insert into pedido_presencial (id_pedido, num_mesa) values(?,?)";
		String query2 = "insert into garcon_atende (cpf_funcionario, mesa_num, data_hora) values(?,?,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		PreparedStatement ps2 = connection.prepareStatement(query2);
		ps.setInt(1, p.getIdPedido());
		ps.setInt(2, p.getNum_Mesa());
		ps2.setString(1, p.getCpfFuncionario());
		ps2.setInt(2, p.getNum_Mesa());
		ps2.setTime(3, p.getHora());

		ps.executeUpdate();
		ps2.executeUpdate();
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

	public PedidoPresencial procurar(int id) throws SQLException {
		PedidoPresencial p = null;
		String query = "select * from pedido_presencial where id_pedido = ?";
		String query2 = "select * from garcon_atende where ";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			// p = new PedidoPresencial(rs.getInt("id_pedido"), rs.getInt("num_mesa"));
		}
		return p;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Dados.IRepositorioProdutos#remover(int)
	 */

	public boolean remover(PedidoPresencial p) throws SQLException {
		String query = "delete from pedido_presencial where id_pedido =?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, p.getIdPedido());
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
	public ArrayList<PedidoPresencial> listar() {
		return this.pedidos;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Dados.IRepositorioProdutos#salvarProduto()
	 */

}

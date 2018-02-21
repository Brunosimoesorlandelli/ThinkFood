package dados;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import beans.Funcionario_Secretario;
import beans.PedidoDelivery;
import beans.StatusDelivery;

public class RepositorioPedidoDel implements IRepositorioPedidoDel, Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	/**
	 *
	 */
	private static Connection connection;
	private static IRepositorioPedidoDel instanceUser;
	private ArrayList<PedidoDelivery> pedidos;
	private int next;

	public RepositorioPedidoDel() {
		this.pedidos = new ArrayList<PedidoDelivery>();
		this.next = 0;
	}

	public static synchronized IRepositorioPedidoDel getInstance() {
		if (instanceUser == null) {
			instanceUser = new RepositorioPedidoDel();
		}
		return instanceUser;
	}

	public void conectar(Connection connect) {
		RepositorioPedidoDel.connection = connect;
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
	public boolean cadastrar(PedidoDelivery p) throws SQLException {
		String query2 = "insert into contemdel(qtd, id_pedido_del, id_itemmenu) values(?,?,?)";
		String query = "insert into pedidodel (pedidoDel_id, pedidoDel_Status, endereco_cep, entrega_hrSaida, entrega_data, entregador_cpf, complemento, taxa) values(?,?,?,?,?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		PreparedStatement ps2 = connection.prepareStatement(query2);
		ps2.setInt(1, 10);
		ps2.setInt(2, p.getNumero());
		ps2.setInt(3, 853324876);
		ps.setInt(1, p.getNumero());
		ps.setString(2, p.getStatus().name());
		ps.setString(3, p.getCEP());
		ps.setTime(4, p.getHoraSaida());
		ps.setDate(5, p.getData());
		ps.setString(6, p.getCpfEntregador());
		ps.setString(7, p.getComplemento());
		ps.setInt(8, p.getTaxa());

		ps2.executeUpdate();
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

	public PedidoDelivery procurar(int id) throws SQLException {
		PedidoDelivery p = null;
		String query = "select * from pedidoDel where pedidoDel_id = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			p = new PedidoDelivery(rs.getInt("taxa"), StatusDelivery.valueOf(rs.getString("pedidoDel_status")),
					rs.getString("endereco_cep"), rs.getTime("entrega_hrSaida"), rs.getDate("entrega_data"),
					rs.getInt("pedidoDel_id"), rs.getString("complemento"), rs.getString("entregador_cpf"));
		}
		return p;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Dados.IRepositorioProdutos#remover(int)
	 */

	public boolean remover(PedidoDelivery p) throws SQLException {
		String query = "delete from pedidodel where pedidoDel_id =?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, p.getNumero());
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

	public boolean atualizarPedidoDelivery(PedidoDelivery p) throws Exception {
		String query = "update pedidoDel pedidoDel_id = ?, pedidoDel_status = ?, endereco_cep = ?, entrega_hrSaida = ?, entrega_data = ?, entregador_cpf = ?, complemento = ?, taxa = ? where pedidoDel_id = "
				+ "'" + p.getNumero() + "'";

		PreparedStatement ps = connection.prepareStatement(query);

		ps.setInt(1, p.getNumero());
		ps.setString(2, p.getStatus().name());
		ps.setString(3, p.getCEP());
		ps.setTime(4, p.getHoraSaida());
		ps.setDate(5, p.getData());
		ps.setString(6, p.getCpfEntregador());
		ps.setString(7, p.getComplemento());
		ps.setInt(8, p.getTaxa());

		ps.executeUpdate();

		return true;
	}

	public void printar(PedidoDelivery p) {
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
	public ArrayList<PedidoDelivery> listar() {
		return this.pedidos;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Dados.IRepositorioProdutos#salvarProduto()
	 */

}

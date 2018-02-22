package dados;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import beans.Estoque;
import beans.Funcionario_Gerente;
import beans.ItemEstoque;

public class RepositorioItemEstoque implements Serializable, IRepositorioItemEstoque {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	/**
	 *
	 */
	private static Connection connection;
	private static IRepositorioItemEstoque instanceUser;
	private ArrayList<ItemEstoque> itens;
	private int next;

	public RepositorioItemEstoque() {
		this.itens = new ArrayList<ItemEstoque>();
		this.next = 0;
	}

	public static synchronized IRepositorioItemEstoque getInstance() {
		if (instanceUser == null) {
			instanceUser = new RepositorioItemEstoque();
		}
		return instanceUser;
	}

	public void conectar(Connection connect) {
		this.connection = connect;
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
	public boolean cadastrar(ItemEstoque p) throws SQLException {
		String query = "insert into item_estoque (seq, produtoRef_cod, id_estoque, data_entrada, lote, qtd, data_validade)values(?,?,?,?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, p.getSeq());
		ps.setInt(2, p.getCodProduto());
		ps.setInt(3, p.getIdEstoque());
		ps.setDate(4, p.getDataEntrada());
		ps.setInt(5, p.getLote());
		ps.setInt(6, p.getQtd());
		ps.setDate(7, p.getDataValidade());

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

	public ItemEstoque procurar(int seq) throws SQLException {
		ItemEstoque p = null;
		String query = "select * from item_estoque where seq = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, seq);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			p = new ItemEstoque(rs.getInt("seq"), rs.getInt("produtoRef_cod"), rs.getInt("id_estoque"), rs.getDate("data_entrada"),
					rs.getInt("lote"), rs.getInt("qtd"), rs.getDate("data_validade"));
		}
		return p;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Dados.IRepositorioProdutos#remover(int)
	 */

	public boolean remover(ItemEstoque p) throws SQLException {
		String query = "delete from item_estoque where seq=?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, p.getSeq());
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see Dados.IRepositorioProdutos#printar(Beans.Produto)
	 */

	public boolean atualizarItemEstoque(ItemEstoque i) throws Exception {
		String query = "update item_estoque set seq = ?, produtoRef_cod = ?, id_estoque = ?, data_entrada = ?, lote = ?, qtd = ?, data_validade = ? where seq = " + i.getSeq();

		PreparedStatement ps = connection.prepareStatement(query);

		ps.setInt(1, i.getSeq());
		ps.setInt(2, i.getCodProduto());
		ps.setInt(3, i.getIdEstoque());
		ps.setDate(4, i.getDataEntrada());
		ps.setInt(5, i.getLote());
		ps.setInt(6, i.getQtd());
		ps.setDate(7, i.getDataValidade());

		ps.executeUpdate();

		return true;
	}

	public void printar(ItemEstoque p) {
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
	public ArrayList<ItemEstoque> listar() {
		return this.itens;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Dados.IRepositorioProdutos#salvarProduto()
	 */

}
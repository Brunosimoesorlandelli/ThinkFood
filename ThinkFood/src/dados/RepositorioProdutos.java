package dados;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import beans.Fornecedor;
import beans.Produto;

public class RepositorioProdutos implements Serializable, IRepositorioProdutos {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	/**
	 *
	 */
	private static Connection connection;
	private static IRepositorioProdutos instanceUser;
	private ArrayList<Produto> produtos;
	private int next;

	public RepositorioProdutos() {
		this.produtos = new ArrayList<Produto>();
		this.next = 0;
	}

	public static synchronized IRepositorioProdutos getInstance() {
		if (instanceUser == null) {
			instanceUser = new RepositorioProdutos();
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
	@Override
	public boolean cadastrar(Produto p) throws SQLException {
		String query = "insert into produtoref (unidade, codigo, descricao, qtdMinStk, dtInicio, dtFim, cnpj_fornecedor, cod_categ, preco_ult_compra, qtd_atual_estoque, freq_pedido)values(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, p.getUnidade());
		ps.setInt(2, p.getCodigo());
		ps.setString(3, p.getDescr());
		ps.setInt(4, p.getQtdMinStk());
		ps.setDate(5, p.getDt_inicio());
		ps.setDate(6, p.getDt_fim());
		ps.setString(7, p.getCnpj_fornecedor());
		ps.setInt(8, p.getCod_categ());
		ps.setDouble(9, p.getPreco_ult_compra());
		ps.setInt(10, p.getQtd_atual_estoque());
		ps.setInt(11, p.getFreq_pedido());

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

	public Produto procurar(int id) throws SQLException {
		Produto p = null;
		String query = "select * from produtoRef where produtoRef_cod = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(2, id);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			p = new Produto(rs.getInt("produtoRef_unit"), rs.getInt("produtoRef_cod"), rs.getString("produtoRef_desc"),
					rs.getInt("produtoRef_qtdMinStk"), rs.getDate("fornece_dtInicio"), rs.getDate("fornece_dtFim"),
					rs.getString("cnpj_fornecedor"), rs.getInt("cod_categ"), rs.getDouble("preco_ult_compra"),
					rs.getInt("qtd_atual_estoque"), rs.getInt("freq_pedido"));
		}
		return p;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Dados.IRepositorioProdutos#remover(int)
	 */

	public boolean remover(Produto p) throws SQLException {
		String query = "delete from produtoRef where produtoRef_cod =?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(2, p.getCodigo());
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

	public boolean atualizarProduto(Produto p) throws Exception {
		String query = "update produtoRef set produtoRef_unit = ?, produtoRef_cod = ?, produtoRef_desc = ?, produtoRef_qtdMinStk = ?, cnpj_fornecedor = ?, cod_categ = ? where produtoRef_cod = "
				+ "'" + p.getCodigo() + "'";

		PreparedStatement ps = connection.prepareStatement(query);

		ps.setInt(1, p.getUnidade());
		ps.setString(2, p.getCnpj_fornecedor());
		ps.setString(3, p.getDescr());
		ps.setInt(4, p.getQtdMinStk());
		ps.setString(5, p.getCnpj_fornecedor());
		ps.setInt(6, p.getCod_categ());

		ps.executeUpdate();

		return true;
	}

	@Override
	public void printar(Produto p) {
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
	@Override
	public ArrayList<Produto> listar() {
		return this.produtos;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Dados.IRepositorioProdutos#salvarProduto()
	 */

}
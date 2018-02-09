package dados;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import beans.Endereco;
import beans.Fornecedor;

public class RepositorioFornecedores implements Serializable, IRepositorioFornecedores {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	/**
	 *
	 */
	private static Connection connection;
	private static IRepositorioFornecedores instanceUser;
	private ArrayList<Fornecedor> fornecedores;
	private int next;

	public RepositorioFornecedores() {
		this.fornecedores = new ArrayList<Fornecedor>();
		this.next = 0;
	}

	public static synchronized IRepositorioFornecedores getInstance() {
		if (instanceUser == null) {
			instanceUser = new RepositorioFornecedores();
		}
		return instanceUser;
	}

	public void conectar(Connection connect) {
		try {
			if (this.connection != null)
				this.connection.close();

			this.connection = connect;
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
	@Override
	public boolean cadastrar(Fornecedor p) throws Exception {
		String query = "insert into fornecedor (cnpj, email, razao, endereco, fone)values(?,?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, p.getCnpj());
		ps.setString(2, p.getEmail());
		ps.setString(3, p.getRazaoSocial());
		ps.setString(4, p.getCEP());
		ps.setInt(5, p.getFone());

		ps.executeUpdate();
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dados.IRepositorioFornecedores#procurar(java.lang.String)
	 */
	@Override
	public Fornecedor procurar(String cnpj) throws Exception {
		Fornecedor f = null;
		String query = "select * from fornecedor where cnpj_fornecedor = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, cnpj);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			f = new Fornecedor(rs.getString("cnpj_fornecedor"), rs.getString("email_fornecedor"),
					rs.getString("razao_fornecedor"), rs.getString("fornecedor_end"), rs.getInt("fone"));
		}
		return f;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dados.IRepositorioFornecedores#remover(java.lang.String)
	 */
	public boolean remover(Fornecedor f) throws SQLException {
		String query = "delete from fornecedor where cnpj =?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, f.getCnpj());
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
	@Override
	public void printar(Fornecedor p) {
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
	@Override
	public ArrayList<Fornecedor> listar() {
		return this.fornecedores;

	}
	/*
	 * public void salvarFornecedor() { salvar(); }
	 */

}

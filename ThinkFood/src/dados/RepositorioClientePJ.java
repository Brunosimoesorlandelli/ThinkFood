package dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import beans.ClientePF;
import beans.ClientePJ;

public class RepositorioClientePJ implements IRepositorioClientePJ {

	private static final long serialVersionUID = 1L;
	/**
	 *
	 */
	private static Connection connection;
	private static IRepositorioClientePJ instanceUser;
	private ArrayList<ClientePJ> clientes;
	private int next;

	public RepositorioClientePJ() {
		this.clientes = new ArrayList<ClientePJ>();
		this.next = 0;
	}

	public static synchronized IRepositorioClientePJ getInstance() {
		if (instanceUser == null) {
			instanceUser = new RepositorioClientePJ();
		}
		return instanceUser;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dados.IRepositorioGarcom#conectar(java.sql.Connection)
	 */
	@Override
	public void conectar(Connection connect) {
		this.connection = connect;
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
	@Override
	public boolean cadastrar(ClientePJ p) throws Exception {
		String query = "insert into cliente (id) values(?)";
		String query2 = "insert into cliente_pj (id_cliente, cnpj, razao_social, nome_fantasia)values(?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		PreparedStatement ps2 = connection.prepareStatement(query2);
		ps.setInt(1, p.getId());
		ps2.setInt(1, p.getId());
		ps2.setString(2, p.getCnpj());
		ps2.setString(3, p.getRazaoSocial());
		ps2.setString(4, p.getNomeFantasia());

		ps.executeUpdate();
		ps2.executeUpdate();
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
	@Override
	public ClientePJ procurar(int id) throws Exception {
		ClientePJ f = null;
		String query = "select * from cliente_pj where id_cliente = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			f = new ClientePJ(rs.getInt("id_cliente"), rs.getString("cnpj"), rs.getString("razao_social"),
					rs.getString("nome_fantasia"));
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
	@Override
	public boolean remover(ClientePJ f) throws SQLException {
		String query = "delete from cliente where id =?";
		String query2 = "delete from cliente_pj where id_cliente =?";
		PreparedStatement ps = connection.prepareStatement(query);
		PreparedStatement ps2 = connection.prepareStatement(query2);
		ps.setInt(1, f.getId());
		ps2.setInt(1, f.getId());
		ps.executeUpdate();
		ps2.executeUpdate();
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

	public boolean atualizarClientePJ(ClientePJ c) throws Exception {
		String query = "update cliente_pj set cnpj = ?, razao_social = ?, nome_fantasia = ? where id_cliente = " + c.getId();

		PreparedStatement ps = connection.prepareStatement(query);

		ps.setString(1, c.getCnpj());
		ps.setString(2, c.getRazaoSocial());
		ps.setString(3, c.getNomeFantasia());

		ps.executeUpdate();

		return true;
	}

	@Override
	public void printar(ClientePJ p) {
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
	@Override
	public ArrayList<ClientePJ> listar() {
		return this.clientes;

	}
	/*
	 * public void salvarFornecedor() { salvar(); }
	 */

}

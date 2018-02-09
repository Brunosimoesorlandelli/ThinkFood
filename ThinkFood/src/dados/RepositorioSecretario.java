package dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import beans.Fornecedor;
import beans.Funcionario_Garcon;
import beans.Funcionario_Secretario;

public class RepositorioSecretario implements IRepositorioSecretario {

	private static final long serialVersionUID = 1L;
	/**
	 *
	 */
	private static Connection connection;
	private static IRepositorioSecretario instanceUser;
	private ArrayList<Funcionario_Secretario> secretarios;
	private int next;

	public RepositorioSecretario() {
		this.secretarios = new ArrayList<Funcionario_Secretario>();
		this.next = 0;
	}

	public static synchronized IRepositorioSecretario getInstance() {
		if (instanceUser == null) {
			instanceUser = new RepositorioSecretario();
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
		RepositorioSecretario.connection = connect;
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
	public boolean cadastrar(Funcionario_Secretario p) throws Exception {
		String query = "insert into funcionario_secretario (nome, cpf, dataNasc, cep, salario, numero, senha)values(?,?,?,?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, p.getNome());
		ps.setString(2, p.getCpf());
		ps.setDate(3, p.getDataNasc());
		ps.setString(4, p.getCEP());
		ps.setDouble(5, p.getSalario());
		ps.setInt(6, p.getNumero());
		ps.setString(7, p.getSenha());

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
	@Override
	public Funcionario_Secretario procurar(String cpf) throws Exception {
		Funcionario_Secretario f = null;
		String query = "select * from funcionario_secretario where cpf_funcionario = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, cpf);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			f = new Funcionario_Secretario(rs.getString("nome"), rs.getString("cpf"), rs.getDate("data_nasc"),
					rs.getString("cep_endereco"), rs.getDouble("salario"), rs.getInt("seq_loja"),
					rs.getString("senha"));
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
	public boolean remover(Funcionario_Secretario f) throws SQLException {
		String query = "delete from funcionario_secretario where cpf =?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, f.getCpf());
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
	@Override
	public void printar(Funcionario_Secretario p) {
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
	public ArrayList<Funcionario_Secretario> listar() {
		return this.secretarios;

	}
	/*
	 * public void salvarFornecedor() { salvar(); }
	 */

}

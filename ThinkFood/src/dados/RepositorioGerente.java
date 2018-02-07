package dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import beans.Fornecedor;
import beans.Funcionario_Entregador;
import beans.Funcionario_Garcon;
import beans.Funcionario_Gerente;
import beans.Funcionario_Secretario;

public class RepositorioGerente implements IRepositorioGerente {

	private static final long serialVersionUID = 1L;
	/**
	 *
	 */
	private static Connection connection;
	private static IRepositorioGerente instanceUser;
	private ArrayList<Funcionario_Gerente> gerentes;
	private int next;

	public RepositorioGerente() {
		this.gerentes = new ArrayList<Funcionario_Gerente>();
		this.next = 0;
	}

	public static synchronized IRepositorioGerente getInstance() {
		if (instanceUser == null) {
			instanceUser = new RepositorioGerente();
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
		RepositorioGerente.connection = connect;
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
	public boolean cadastrar(Funcionario_Gerente p) throws Exception {
		String query = "insert into funcionario_gerente (nome, cpf, dataNasc, cep, salario, numero)values(?,?,?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, p.getNome());
		ps.setString(2, p.getCpf());
		ps.setDate(3, p.getDataNasc());
		ps.setString(4, p.getCEP());
		ps.setDouble(5, p.getSalario());
		ps.setInt(6, p.getNumero());

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
	public Funcionario_Gerente procurar(String cpf) throws Exception {
		Funcionario_Gerente f = null;
		String query = "select * from funcionario_gerente where cpf_funcionario = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, cpf);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			f = new Funcionario_Gerente(rs.getString("nome"), rs.getString("cpf"), rs.getDate("data_nasc"),
					rs.getString("cep_endereco"), rs.getDouble("salario"), rs.getInt("seq_loja"));
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
	public boolean remover(Funcionario_Gerente f) throws SQLException {
		String query = "delete from funcionario_gerente where cpf =?";
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
	public void printar(Funcionario_Gerente p) {
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
	public ArrayList<Funcionario_Gerente> listar() {
		return this.gerentes;

	}
	/*
	 * public void salvarFornecedor() { salvar(); }
	 */

}

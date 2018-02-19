package dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

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
		String query = "insert into funcionario (cpf, nome, data_nasc, salario,complemento, numero,cep_endereco,seq_loja, senha)values(?,?,?,?,?,?,?,?,?)";
		String query2 = "insert into funcionario_secretario(cpf_funcionarioS) values(?)";
		PreparedStatement ps = connection.prepareStatement(query);
		PreparedStatement ps2 = connection.prepareStatement(query2);
		ps.setString(2, p.getNome());
		ps.setString(1, p.getCpf());
		ps.setDate(3, p.getDataNasc());
		ps.setString(7, p.getCEP());
		ps.setString(5, p.getCompl());
		ps.setDouble(4, p.getSalario());
		ps.setInt(6, p.getNumero());
		ps.setInt(8,1);
		ps.setString(9, p.getSenha());

		ps2.setString(1, p.getCpf());
		
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
	public Funcionario_Secretario procurar(String cpf) throws Exception {
		Funcionario_Secretario f = null;
		String query = "select * from (funcionario join funcionario_secretario on funcionario.cpf = funcionario_secretario.cpf_funcionarioS) where cpf_funcionarioS = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, cpf);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			f = new Funcionario_Secretario(rs.getString("nome"), rs.getString("cpf"), rs.getDate("data_nasc"),
					rs.getString("cep_endereco"), rs.getDouble("salario"), rs.getInt("numero"),
					rs.getString("complemento"), rs.getInt("seq_loja"), rs.getString("senha"));
		}

		return f;

	}
	
	public boolean atualizarSecretario(Funcionario_Secretario f) throws Exception {
		String query = "update funcionario set cpf = ?, nome = ?,data_nasc = ?, salario = ?, complemento = ?, numero = ?, cep_endereco = ?, seq_loja = ?, senha = ?";
		String query2 = "update funcionario_secretario set cpf_funcionarioS = ? where cpf_funcionarioS = " + f.getCpf(); 

		PreparedStatement ps = connection.prepareStatement(query);
		PreparedStatement ps2 = connection.prepareStatement(query2);
		
		ps.setString(1, f.getCpf());
		ps.setString(2, f.getNome());
		ps.setDate(3, f.getDataNasc());
		ps.setDouble(4, f.getSalario());
		ps.setString(5, f.getCompl());
		ps.setInt(6, f.getNumero());
		ps.setString(7, f.getCEP());
		ps.setInt(8, f.getSeq_loja());
		ps.setString(9, f.getSenha());
		
		ps.executeUpdate();
		ps2.executeUpdate();
		
		return true;
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
		String query = "delete from funcionario where cpf =?";
		String query2 = "delete from funcionario_secretario where cpf_funcionarioS =?";
		PreparedStatement ps = connection.prepareStatement(query);
		PreparedStatement ps2 = connection.prepareStatement(query2);
		ps.setString(1, f.getCpf());
		ps2.setString(1, f.getCpf());
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
	@Override
	public void printar(Funcionario_Secretario p) {
		try {
			JOptionPane.showMessageDialog(null, p.toString());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public ArrayList<Funcionario_Secretario> listar() {
		return secretarios;
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
	/*
	 * public void salvarFornecedor() { salvar(); }
	 */

}

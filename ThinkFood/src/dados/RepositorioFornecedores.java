package dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import beans.Fornecedor;

public class RepositorioFornecedores implements  Serializable, IRepositorioFornecedores{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	/**
	 *
	 */
	private static IRepositorioFornecedores instanceUser;
	private ArrayList<Fornecedor> fornecedores;
	private int next;

	public RepositorioFornecedores() {
		this.fornecedores = new ArrayList<Fornecedor>();
		this.next = 0;
	}

	public static synchronized IRepositorioFornecedores getInstance() {
		if(instanceUser == null) {
			instanceUser = new RepositorioFornecedores();
		}
		return instanceUser;
	}

	
	/*private static void salvar() {
		if (instanceUser == null) {
			return;
		}
		File out = new File("RepositorioFornecedores.db");
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			fos = new FileOutputStream(out);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(instanceUser);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
				}
			}
		}
	}

	private static RepositorioFornecedor ler() {
		RepositorioProduto instanciaLocal = null;

		File in = new File("RepositorioFornecedores.db");
		FileInputStream fis = null;
		ObjectInputStream ois = null;

		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			instanciaLocal = (RepositorioFornecedor) o;
		} catch (Exception e) {
			instanciaLocal = new RepositorioFornecedor();
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
				}
			}
		}
		return instanciaLocal;
	}*/

	/* (non-Javadoc)
	 * @see dados.IRepositorioFornecedores#cadastrar(beans.Fornecedor)
	 */
	@Override
	public boolean cadastrar(Fornecedor p){
		if (p != null) {
			fornecedores.add(p);
			this.next = next + 1;
			//RepositorioFornecedores.salvar();
			return true;
		}
		return false;
	}

	private int procurarIndice(String cnpj) {
		int indice = 0;
		boolean found = false;
		while (found != true && indice < this.next) {
			if (cnpj.equals(this.fornecedores.get(indice).getCnpj())) {
				found = true;
			} else {
				indice = indice + 1;
			}
		}
		return indice;
	}

	/* (non-Javadoc)
	 * @see dados.IRepositorioFornecedores#procurar(java.lang.String)
	 */
	@Override
	public Fornecedor procurar(String cnpj) {
		int i = this.procurarIndice(cnpj);
		Fornecedor saida = null;
		if (i != this.next) {
			saida = this.fornecedores.get(i);
		} else {
			System.out.println("O FORNECEDOR NAO FOI ENCONTRADO!");
		}

		return saida;
	}

	/* (non-Javadoc)
	 * @see dados.IRepositorioFornecedores#remover(java.lang.String)
	 */
	@Override
	public boolean remover(String cnpj) {
		if (existe(cnpj)) {
			Fornecedor p = procurar(cnpj);
			this.fornecedores.remove(p);
			//RepositorioFornecedores.salvar();
			return true;
		}
		return false;
	}
	/*
	@Override
	public boolean alterarFornecedor(String nome) {
		if (getInstance().existe(nome)) {
			Fornecedor c = procurar(nome);
			fornecedores.set(fornecedores.indexOf(c), c);
			RepositorioFornecedores.salvar();
			return true;
		}
		return false;

	}*/

	
	/* (non-Javadoc)
	 * @see dados.IRepositorioFornecedores#existe(java.lang.String)
	 */
	@Override
	public boolean existe(String cnpj) {
		boolean existe = false;
		Fornecedor u = this.procurar(cnpj);
		if (u != null) {
			existe = true;
			System.out.println("Fornecedor existe!");
		} else {
			System.out.println("Fornecedor nao existe!");
		}
		return existe;
	}

	
	/* (non-Javadoc)
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
	
	/* (non-Javadoc)
	 * @see dados.IRepositorioFornecedores#listar()
	 */
	@Override
	public ArrayList<Fornecedor> listar(){
		return this.fornecedores;
	
	}
	/*
	public void salvarFornecedor() {
		salvar();
	}
	*/
	
}

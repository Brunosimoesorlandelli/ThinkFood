package dados;

import java.util.ArrayList;

import beans.Fornecedor;

public interface IRepositorioFornecedores {

	boolean cadastrar(Fornecedor p);

	Fornecedor procurar(String cnpj);

	boolean remover(String cnpj);
	/*
	@Override
	public boolean alterarProduto(String nome) {
		if (getInstance().existe(nome)) {
			Produto c = procurar(nome);
			fornecedores.set(fornecedores.indexOf(c), c);
			RepositorioFornecedores.salvar();
			return true;
		}
		return false;
	
	}*/

	boolean existe(String cnpj);

	void printar(Fornecedor p);

	ArrayList<Fornecedor> listar();
	/*
	public void salvarFornecedor() {
		salvar();
	}
	*/

}
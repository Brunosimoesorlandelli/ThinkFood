package dados;

import java.sql.SQLException;
import java.util.ArrayList;

import beans.Produto;

public interface IRepositorioProdutos {

	boolean cadastrar(Produto p) throws SQLException;

	Produto procurar(int id);

	boolean remover(int id);

	boolean existe(int id);

	void printar(Produto p);

	ArrayList<Produto> listar();

	void salvarProduto();

}
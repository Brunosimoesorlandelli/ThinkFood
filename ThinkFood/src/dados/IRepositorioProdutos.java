package dados;

import java.sql.SQLException;
import java.util.ArrayList;

import beans.Produto;

public interface IRepositorioProdutos {

	boolean cadastrar(Produto p) throws SQLException;

	Produto procurar(int id) throws SQLException;

	boolean remover(Produto p) throws SQLException;

	void printar(Produto p);

	ArrayList<Produto> listar();

	void salvarProduto();

}
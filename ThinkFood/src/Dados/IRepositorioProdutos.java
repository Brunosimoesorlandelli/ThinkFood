package Dados;

import java.util.ArrayList;

import Beans.Produto;

public interface IRepositorioProdutos {

	boolean cadastrar(Produto p);

	Produto procurar(int id);

	boolean remover(int id);

	boolean existe(int id);

	void printar(Produto p);

	ArrayList<Produto> listar();

	void salvarProduto();

}
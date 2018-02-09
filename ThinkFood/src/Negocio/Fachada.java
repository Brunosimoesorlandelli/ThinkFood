package Negocio;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Fornecedor;
import beans.Funcionario_Entregador;
import beans.Funcionario_Garcon;
import beans.Funcionario_Gerente;
import beans.Funcionario_Secretario;
import beans.ItemMenu;
import beans.Produto;
import negocio.Fachada;
import negocio.IFachada;

public class Fachada implements IFachada, Serializable {

	private IControladorEntregador cEntregador;
	private IControladorFornecedor cFornecedor;
	private IControladorGarcom cGarcom;
	private IControladorGerente cGerente;
	private IControladorProduto cProduto;
	private IControladorSecretario cSecretario;
	private IControladorItemMenu cItemMenu;

	private static IFachada instance;

	public Fachada() {
		this.cEntregador = new ControladorEntregador();
		this.cFornecedor = new ControladorFornecedor();
		this.cGarcom = new ControladorGarcom();
		this.cGerente = new ControladorGerente();
		this.cProduto = new ControladorProduto();
		this.cSecretario = new ControladorSecretario();
		this.cItemMenu = new ControladorItemMenu();
	}

	public static IFachada getInstance() {
		if (instance == null) {
			instance = new Fachada();
		}
		return instance;
	}

	public void conectar(Connection connect) {
		cEntregador.conectar(connect);
	}

	public boolean cadastrar(Funcionario_Entregador p) throws Exception {
		return cEntregador.cadastrar(p);
	}

	public Funcionario_Entregador procurarEntregador(String cpf) throws Exception {
		return cEntregador.procurar(cpf);
	}

	public boolean remover(Funcionario_Entregador f) throws SQLException {
		return cEntregador.remover(f);
	}

	public void printar(Funcionario_Entregador p) {
		cEntregador.printar(p);
	}

	public ArrayList<Funcionario_Entregador> listar() {
		return cEntregador.listar();
	}

	public boolean cadastrar(Fornecedor p) throws Exception {
		return cFornecedor.cadastrar(p);
	}

	public Fornecedor procurarFornecedor(String cnpj) throws Exception {
		return cFornecedor.procurar(cnpj);
	}

	public boolean remover(Fornecedor f) throws SQLException {
		return cFornecedor.remover(f);
	}

	public void printar(Fornecedor p) {
		cFornecedor.printar(p);
	}

	public boolean cadastrar(Funcionario_Garcon p) throws Exception {
		return cGarcom.cadastrar(p);
	}

	public Funcionario_Garcon procurarGarcom(String cnpj) throws Exception {
		return cGarcom.procurar(cnpj);
	}

	public boolean remover(Funcionario_Garcon f) throws SQLException {
		return cGarcom.remover(f);
	}

	public void printar(Funcionario_Garcon p) {
		cGarcom.printar(p);
	}

	public boolean cadastrar(Funcionario_Gerente p) throws Exception {
		return cGerente.cadastrar(p);
	}

	public Funcionario_Gerente procurarGerente(String cpf) throws Exception {
		return cGerente.procurar(cpf);
	}

	public boolean remover(Funcionario_Gerente f) throws SQLException {
		return cGerente.remover(f);
	}

	public void printar(Funcionario_Gerente p) {
		cGerente.printar(p);
	}

	public boolean cadastrar(Produto p) throws SQLException {
		return cProduto.cadastrar(p);
	}

	public Produto procurar(int id) throws SQLException {
		return cProduto.procurar(id);
	}

	public boolean remover(Produto p) throws SQLException {
		return cProduto.remover(p);
	}

	public void printar(Produto p) {
		cProduto.printar(p);
	}

	public void salvarProduto() {
		cProduto.salvarProduto();
	}

	public boolean cadastrar(Funcionario_Secretario p) throws Exception {
		return cSecretario.cadastrar(p);
	}

	public Funcionario_Secretario procurarSecretario(String cpf) throws Exception {
		return cSecretario.procurar(cpf);
	}

	public boolean remover(Funcionario_Secretario f) throws SQLException {
		return cSecretario.remover(f);
	}

	public void printar(Funcionario_Secretario p) {
		cSecretario.printar(p);
	}

	public boolean cadastrar(ItemMenu p) throws SQLException {
		return cItemMenu.cadastrar(p);
	}

	public ItemMenu procurarItemMenu(int id) throws SQLException {
		return cItemMenu.procurar(id);
	}

	public boolean remover(ItemMenu p) throws SQLException {
		return cItemMenu.remover(p);
	}

	public void printar(ItemMenu p) {
		cItemMenu.printar(p);
	}

}

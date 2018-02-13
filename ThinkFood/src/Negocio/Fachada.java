package Negocio;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import beans.ClientePF;
import beans.ClientePJ;
import beans.Estoque;
import beans.FazReserva;
import beans.Fornecedor;
import beans.Funcionario;
import beans.Funcionario_Entregador;
import beans.Funcionario_Garcon;
import beans.Funcionario_Gerente;
import beans.Funcionario_Secretario;
import beans.ItemMenu;
import beans.Mesa;
import beans.PedidoDelivery;
import beans.Produto;
import beans.Reserva;

public class Fachada implements IFachada, Serializable {

	private IControladorEntregador cEntregador;
	private IControladorFornecedor cFornecedor;
	private IControladorGarcom cGarcom;
	private IControladorGerente cGerente;
	private IControladorProduto cProduto;
	private IControladorSecretario cSecretario;
	private IControladorItemMenu cItemMenu;
	private IControladorReserva cReserva;
	private IControladorPedidoDel cPedidoDel;
	private IControladorEstoque cEstoque;
	private IControladorMesa cMesa;
	private IControladorClientePF cClientePF;
	private IControladorClientePJ cClientePJ;
	private IControladorFazReserva cFazReserva;

	private static Connection connect;
	private static Connection conexaoLogin;
	private ConexaoDB conex;
	private static IFachada instance;

	public Fachada() {
		this.cEntregador = new ControladorEntregador();
		this.cFornecedor = new ControladorFornecedor();
		this.cGarcom = new ControladorGarcom();
		this.cGerente = new ControladorGerente();
		this.cProduto = new ControladorProduto();
		this.cSecretario = new ControladorSecretario();
		this.cItemMenu = new ControladorItemMenu();
		this.cReserva = new ControladorReserva();
		this.cPedidoDel = new ControladorPedidoDel();
		this.cEstoque = new ControladorEstoque();
		this.cMesa = new ControladorMesa();
		this.cClientePF = new ControladorClientePF();
		this.cClientePJ = new ControladorClientePJ();
		this.cFazReserva = new ControladorFazReserva();
		this.conex = new ConexaoDB();
		try {
			this.conexaoLogin = conex.getConexao("God", "senha");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static IFachada getInstance() {
		if (instance == null) {
			instance = new Fachada();
		}
		return instance;
	}

	public void Conectar(Connection connect) {
		this.cGarcom.conectar(connect);
		this.cEntregador.conectar(connect);
		this.cFornecedor.conectar(connect);
		this.cGerente.conectar(connect);
		this.cProduto.conectar(connect);
		this.cSecretario.conectar(connect);
		this.cItemMenu.conectar(connect);
		this.cReserva.conectar(connect);
		this.cPedidoDel.conectar(connect);
		this.cEstoque.conectar(connect);
		this.cMesa.conectar(connect);
		this.cClientePF.conectar(connect);
		this.cClientePJ.conectar(connect);
		this.cFazReserva.conectar(connect);
	}

	public boolean cadastrarEntregador(Funcionario_Entregador p) throws Exception {
		return cEntregador.cadastrar(p);
	}

	public Funcionario_Entregador procurarEntregador(String cpf) throws Exception {
		return cEntregador.procurar(cpf);
	}

	public boolean removerEntregador(Funcionario_Entregador f) throws SQLException {
		return cEntregador.remover(f);
	}

	public void printarEntregador(Funcionario_Entregador p) {
		cEntregador.printar(p);
	}

	public ArrayList<Funcionario_Entregador> listarEntregador() {
		return cEntregador.listar();
	}

	public boolean cadastrarFornecedor(Fornecedor p) throws Exception {
		return cFornecedor.cadastrar(p);
	}

	public Fornecedor procurarFornecedor(String cnpj) throws Exception {
		return cFornecedor.procurar(cnpj);
	}

	public boolean removerFornecedor(Fornecedor f) throws SQLException {
		return cFornecedor.remover(f);
	}

	public void printarFornecedor(Fornecedor p) {
		cFornecedor.printar(p);
	}

	public boolean cadastrarGarcon(Funcionario_Garcon p) throws Exception {
		return cGarcom.cadastrar(p);
	}

	public Funcionario_Garcon procurarGarcom(String cnpj) throws Exception {
		return cGarcom.procurar(cnpj);
	}

	public boolean removerGarcon(Funcionario_Garcon f) throws SQLException {
		return cGarcom.remover(f);
	}

	public void printarGarcon(Funcionario_Garcon p) {
		cGarcom.printar(p);
	}

	public boolean cadastrarGerente(Funcionario_Gerente p) throws Exception {
		return cGerente.cadastrar(p);
	}

	public Funcionario_Gerente procurarGerente(String cpf) throws Exception {
		return cGerente.procurar(cpf);
	}

	public boolean removerGerente(Funcionario_Gerente f) throws SQLException {
		return cGerente.remover(f);
	}

	public void printarGerente(Funcionario_Gerente p) {
		cGerente.printar(p);
	}

	public boolean cadastrarProduto(Produto p) throws SQLException {
		return cProduto.cadastrar(p);
	}

	public Produto procurarProduto(int id) throws SQLException {
		return cProduto.procurar(id);
	}

	public boolean removerProduto(Produto p) throws SQLException {
		return cProduto.remover(p);
	}

	public void printarProduto(Produto p) {
		cProduto.printar(p);
	}

	public boolean cadastrarSecretario(Funcionario_Secretario p) throws Exception {
		return cSecretario.cadastrar(p);
	}

	public Funcionario_Secretario procurarSecretario(String cpf) throws Exception {
		return cSecretario.procurar(cpf);
	}

	public boolean removerSecretario(Funcionario_Secretario f) throws SQLException {
		return cSecretario.remover(f);
	}

	public void printarSecretario(Funcionario_Secretario p) {
		cSecretario.printar(p);
	}

	public boolean cadastrarItemMenu(ItemMenu p) throws SQLException {
		return cItemMenu.cadastrar(p);
	}

	public ItemMenu procurarItemMenu(int id) throws SQLException {
		return cItemMenu.procurar(id);
	}

	public boolean removerItemMenu(ItemMenu p) throws SQLException {
		return cItemMenu.remover(p);
	}

	public void printarItemMenu(ItemMenu p) {
		cItemMenu.printar(p);
	}

	public boolean cadastrarReserva(Reserva p) throws SQLException {
		return cReserva.cadastrar(p);
	}

	public Reserva procurarReserva(int seq) throws SQLException {
		return cReserva.procurar(seq);
	}

	public boolean removerReserva(Reserva f) throws SQLException {
		return cReserva.remover(f);
	}

	public void printarReserva(Reserva r) {
		cReserva.printar(r);
	}

	public boolean cadastrarPedidoDel(PedidoDelivery p) throws SQLException {
		return cPedidoDel.cadastrar(p);
	}

	public PedidoDelivery procurarPedidoDel(int id) throws SQLException {
		return cPedidoDel.procurar(id);
	}

	public boolean removerPedidoDel(PedidoDelivery p) throws SQLException {
		return cPedidoDel.remover(p);
	}

	public void printarPedidoDel(PedidoDelivery p) {
		cPedidoDel.printar(p);
	}

	public ArrayList<PedidoDelivery> listarPedidoDel() {
		return cPedidoDel.listar();
	}

	public boolean cadastrarEstoque(Estoque p) throws SQLException {
		return cEstoque.cadastrar(p);
	}

	public Estoque procurarEstoque(int id) throws SQLException {
		return cEstoque.procurar(id);
	}

	public boolean removerEstoque(Estoque p) throws SQLException {
		return cEstoque.remover(p);
	}

	public void printarEstoque(Estoque p) {
		cEstoque.printar(p);
	}

	public ArrayList<Estoque> listarEstoque() {
		return cEstoque.listar();
	}

	public boolean cadastrarMesa(Mesa p) throws SQLException {
		return cMesa.cadastrar(p);
	}

	public Mesa procurarMesa(int num) throws SQLException {
		return cMesa.procurar(num);
	}

	public boolean removerMesa(Mesa p) throws SQLException {
		return cMesa.remover(p);
	}

	public void printarMesa(Mesa p) {
		cMesa.printar(p);
	}

	public ArrayList<Mesa> listarMesa() {
		return cMesa.listar();
	}

	public boolean cadastrarClientePF(ClientePF p) throws Exception {
		return cClientePF.cadastrar(p);
	}

	public ClientePF procurarClientePF(int id) throws Exception {
		return cClientePF.procurar(id);
	}

	public boolean removerClientePF(ClientePF f) throws SQLException {
		return cClientePF.remover(f);
	}

	public void printarClientePF(ClientePF p) {
		cClientePF.printar(p);
	}

	public ArrayList<ClientePF> listarClientePF() {
		return cClientePF.listar();
	}

	public boolean cadastrarClientePJ(ClientePJ p) throws Exception {
		return cClientePJ.cadastrar(p);
	}

	public ClientePJ procurarClientePJ(int id) throws Exception {
		return cClientePJ.procurar(id);
	}

	public boolean removerClientePJ(ClientePJ f) throws SQLException {
		return cClientePJ.remover(f);
	}

	public void printarClientePJ(ClientePJ p) {
		cClientePJ.printar(p);
	}

	public ArrayList<ClientePJ> listarClientePJ() {
		return cClientePJ.listar();
	}

	public ArrayList<Funcionario_Garcon> listarGarcon() {
		return cGarcom.listarGarcon();
	}

	public ArrayList<Funcionario_Secretario> listarSecretario() {
		return cSecretario.listarSecretario();
	}

	public void conectar(Connection connect) {
		cFazReserva.conectar(connect);
	}

	public boolean cadastrar(FazReserva r) throws SQLException {
		return cFazReserva.cadastrar(r);
	}

	public FazReserva procurar(int seq) throws SQLException {
		return cFazReserva.procurar(seq);
	}

	public boolean remover(FazReserva f) throws SQLException {
		return cFazReserva.remover(f);
	}

	public void printar(FazReserva p) {
		cFazReserva.printar(p);
	}

	public ArrayList<FazReserva> listar() {
		return cFazReserva.listar();
	}

	public Funcionario logar(String cpf) throws Exception {
		Conectar(conexaoLogin);
		Funcionario func = null;
		if (procurarEntregador(cpf) != null) {
			func = procurarEntregador(cpf);
			this.connect = conex.getConexao("Entregador", "senha");
			Conectar(connect);
		} else if (procurarGarcom(cpf) != null) {
			func = procurarGarcom(cpf);
			this.connect = conex.getConexao("Garcom", "senha");
			Conectar(connect);
		} else if (procurarGerente(cpf) != null) {
			func = procurarGerente(cpf);
			this.connect = conex.getConexao("Gerente", "senha");
			Conectar(connect);
		} else if (procurarSecretario(cpf) != null) {
			func = procurarSecretario(cpf);
			this.connect = conex.getConexao("Secretario", "senha");
			Conectar(connect);
		} else {
			JOptionPane.showMessageDialog(null, "Esta combinação de CPF e Senha não existe. Tente novamente.");
		}

		return func;
	}

}

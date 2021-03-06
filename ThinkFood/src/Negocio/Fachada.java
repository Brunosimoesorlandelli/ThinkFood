package Negocio;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import beans.Categoria;
import beans.ClientePF;
import beans.ClientePJ;
import beans.Cliente_Avalia;
import beans.Estoque;
import beans.FazReserva;
import beans.Fornecedor;
import beans.Funcionario;
import beans.Funcionario_Entregador;
import beans.Funcionario_Garcon;
import beans.Funcionario_Gerente;
import beans.Funcionario_Secretario;
import beans.ItemEstoque;
import beans.ItemMenu;
import beans.Mesa;
import beans.Nota;
import beans.Pedido;
import beans.PedidoDelivery;
import beans.Produto;
import beans.Reserva;
import beans.ReservaOficial;
import beans.StatusDelivery;
import beans.StatusReserva;
import beans.UnidadeLoja;

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
	private IControladorPedido cPedido;
	private IControladorItemEstoque cItemEstoque;
	private IControladorClienteAvalia cClienteAvalia;
	private IControladorReservaOficial cReservaOficial;

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
		this.cPedido = new ControladorPedido();
		this.cItemEstoque = new ControladorItemEstoque();
		this.cClienteAvalia = new ControladorClienteAvalia();
		this.cReservaOficial = new ControladorReservaOficial();
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
		this.cItemEstoque.conectar(connect);
		this.cClienteAvalia.conectar(connect);
		this.cReservaOficial.conectarReservaOficial(connect);
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

	public ArrayList<Funcionario_Garcon> listarGarcon() {
		return cGarcom.listarGarcon();
	}

	public ArrayList<Funcionario_Secretario> listarSecretario() {
		return cSecretario.listarSecretario();
	}

	public boolean cadastrarFazReserva(FazReserva r) throws SQLException {
		return cFazReserva.cadastrar(r);
	}

	public FazReserva procurarFazReserva(int seq) throws SQLException {
		return cFazReserva.procurar(seq);
	}

	public boolean removerFazReserva(FazReserva f) throws SQLException {
		return cFazReserva.remover(f);
	}

	public void printarFazReserva(FazReserva p) {
		cFazReserva.printar(p);
	}

	public ArrayList<FazReserva> listarFazReserva() {
		return cFazReserva.listar();
	}

	public boolean cadastrarPedido(Pedido p) throws SQLException {
		return cPedido.cadastrar(p);
	}

	public Pedido procurarPedido(int id) throws SQLException {
		return cPedido.procurar(id);
	}

	public boolean removerPedido(Pedido p) throws SQLException {
		return cPedido.remover(p);
	}

	public void printarPedido(Pedido p) {
		cPedido.printar(p);
	}

	public boolean atualizarEntregador(Funcionario_Entregador f) throws Exception {
		return cEntregador.atualizarEntregador(f);
	}

	public boolean atualizarGarcon(Funcionario_Garcon f) throws Exception {
		return cGarcom.atualizarGarcon(f);
	}

	public boolean atualizarGerente(Funcionario_Gerente f) throws Exception {
		return cGerente.atualizarGerente(f);
	}

	public boolean atualizarSecretario(Funcionario_Secretario f) throws Exception {
		return cSecretario.atualizarSecretario(f);
	}

	public void conectarItemEstoque(Connection connect) {
		cItemEstoque.conectar(connect);
	}

	public boolean cadastrarItemEstoque(ItemEstoque p) throws SQLException {
		return cItemEstoque.cadastrar(p);
	}

	public ItemEstoque procurarItemEstoque(int id) throws SQLException {
		return cItemEstoque.procurar(id);
	}

	public boolean removerItemEstoque(ItemEstoque p) throws SQLException {
		return cItemEstoque.remover(p);
	}

	public void printarItemEstoque(ItemEstoque p) {
		cItemEstoque.printar(p);
	}

	public boolean cadastrarCliente_Avalia(Cliente_Avalia c) throws SQLException {
		return cClienteAvalia.cadastrar(c);
	}

	public Cliente_Avalia procurarCliente_Avalia(int id) throws SQLException {
		return cClienteAvalia.procurar(id);
	}

	public boolean removerCliente_Avalia(Cliente_Avalia p) throws SQLException {
		return cClienteAvalia.remover(p);
	}

	public boolean atualizarCliente_Avalia(Cliente_Avalia c) throws Exception {
		return cClienteAvalia.atualizarCliente_Avalia(c);
	}

	public void printarCliente_Avalia(Cliente_Avalia p) {
		cClienteAvalia.printar(p);
	}

	public ArrayList<Cliente_Avalia> listarCliente_Avalia() {
		return cClienteAvalia.listar();
	}

	public void conectarReservaOficial(Connection c) {
		cReservaOficial.conectarReservaOficial(c);
	}

	public boolean cadastrarReservaOficial(ReservaOficial r) throws SQLException {
		return cReservaOficial.cadastrarReservaOficial(r);
	}

	public ReservaOficial procurarReservaOficial(int cod) throws SQLException {
		return cReservaOficial.procurarReservaOficial(cod);
	}

	public boolean atualizarReservaOficial(ReservaOficial f) throws Exception {
		return cReservaOficial.atualizarReservaOficial(f);
	}

	public boolean removerReservaOficial(ReservaOficial f) throws SQLException {
		return cReservaOficial.removerReservaOficial(f);
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
			JOptionPane.showMessageDialog(null, "Esta combina��o de CPF e Senha n�o existe. Tente novamente.");
		}

		return func;
	}

	public Funcionario[] listarFuncionarios() {
		ArrayList<Funcionario> funcionariosList = new ArrayList<Funcionario>();
		Funcionario[] funcionarios = null;
		int tamanho = 0;
		try {
			Statement stmt1 = connect.createStatement();
			ResultSet result1 = stmt1.executeQuery("SELECT * FROM funcionario");
			while (result1.next()) {

				Funcionario funcionario = new Funcionario();
				funcionario.setCpf(result1.getString(1));
				funcionario.setNome(result1.getString(2));
				funcionario.setDataNasc(result1.getDate(3));
				funcionario.setSalario(result1.getFloat(4));
				funcionario.setCompl((result1.getString(5)));
				funcionario.setNumero(result1.getInt(6));
				funcionario.setCEP((result1.getString(7)));
				funcionario.setSeq_loja(result1.getInt(8));
				funcionario.setSenha(result1.getString(9));

				funcionariosList.add(funcionario);

				tamanho = funcionariosList.size();
				funcionarios = new Funcionario[tamanho];
				for (int i = 0; i < tamanho; i++) {
					if (funcionariosList.get(i) != null)
						funcionarios[i] = funcionariosList.get(i);
				}

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return funcionarios;

	}

	public Fornecedor[] listarFornecedores() {
		ArrayList<Fornecedor> fornecedoresList = new ArrayList<Fornecedor>();
		Fornecedor[] fornecedores = null;
		int tamanho = 0;
		try {
			Statement stmt = connect.createStatement();
			ResultSet result = stmt.executeQuery("SELECT * FROM fornecedor");
			while (result.next()) {

				Fornecedor fornecedor = new Fornecedor();
				fornecedor.setCnpj(result.getString(1));
				fornecedor.setEmail(result.getString(2));
				fornecedor.setRazaoSocial(result.getString(3));
				fornecedor.setCEP((result.getString(4)));
				fornecedor.setFone(result.getInt(5));

				fornecedoresList.add(fornecedor);

				tamanho = fornecedoresList.size();
				fornecedores = new Fornecedor[tamanho];
				for (int i = 0; i < tamanho; i++) {
					if (fornecedoresList.get(i) != null)
						fornecedores[i] = fornecedoresList.get(i);
				}

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return fornecedores;

	}

	public UnidadeLoja[] listarLojas() {
		ArrayList<UnidadeLoja> unidadeLojaList = new ArrayList<UnidadeLoja>();
		UnidadeLoja[] lojas = null;
		int tamanho = 0;
		try {
			Statement stmt = connect.createStatement();
			ResultSet result = stmt.executeQuery("SELECT * FROM unidade_loja");
			while (result.next()) {

				UnidadeLoja loja = new UnidadeLoja();
				loja.setTelefone(result.getString(5));
				loja.setCep((result.getString(2)));
				loja.setQtdFunc(result.getInt(4));
				loja.setSeq(result.getInt(1));

				unidadeLojaList.add(loja);

				tamanho = unidadeLojaList.size();
				lojas = new UnidadeLoja[tamanho];
				for (int i = 0; i < tamanho; i++) {
					if (unidadeLojaList.get(i) != null)
						lojas[i] = unidadeLojaList.get(i);
				}

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return lojas;

	}

	public ItemEstoque[] listarItemEstoque() {
		ArrayList<ItemEstoque> estoqueList = new ArrayList<ItemEstoque>();
		ItemEstoque[] estoque = null;
		int tamanho = 0;
		try {
			Statement stmt = connect.createStatement();
			ResultSet result = stmt.executeQuery("SELECT * FROM item_estoque");
			while (result.next()) {

				ItemEstoque itemEstoque = new ItemEstoque();
				itemEstoque.setSeq(result.getInt(1));
				itemEstoque.setCodProduto(result.getInt(2));
				itemEstoque.setIdEstoque(result.getInt(3));
				itemEstoque.setDataEntrada(result.getDate(4));
				itemEstoque.setLote(result.getInt(5));
				itemEstoque.setQtd(result.getInt(6));
				itemEstoque.setDataValidade(result.getDate(7));

				estoqueList.add(itemEstoque);

				tamanho = estoqueList.size();
				estoque = new ItemEstoque[tamanho];
				for (int i = 0; i < tamanho; i++) {
					if (estoqueList.get(i) != null)
						estoque[i] = estoqueList.get(i);
				}

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return estoque;

	}

	public Mesa[] listarMesa() {
		ArrayList<Mesa> mesaList = new ArrayList<Mesa>();
		Mesa[] mesa = null;
		int tamanho = 0;
		try {
			Statement stmt = connect.createStatement();
			ResultSet result = stmt.executeQuery("SELECT * FROM mesa");
			while (result.next()) {

				Mesa mesa1 = new Mesa();
				mesa1.setNum(result.getInt(1));
				mesa1.setCpfGarcom(result.getString(5));
				mesaList.add(mesa1);

				tamanho = mesaList.size();
				mesa = new Mesa[tamanho];
				for (int i = 0; i < tamanho; i++) {
					if (mesaList.get(i) != null)
						mesa[i] = mesaList.get(i);
				}

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return mesa;

	}

	public PedidoDelivery[] listarPedidoDelivery() {
		ArrayList<PedidoDelivery> pedidoList = new ArrayList<PedidoDelivery>();
		PedidoDelivery[] pedidos = null;
		int tamanho = 0;
		try {
			Statement stmt = connect.createStatement();
			ResultSet result = stmt.executeQuery("SELECT * FROM pedidoDel");
			while (result.next()) {

				PedidoDelivery pedidoDel = new PedidoDelivery();
				pedidoDel.setNumero(result.getInt(1));
				pedidoDel.setStatus(StatusDelivery.valueOf(result.getString(2).toUpperCase()));
				pedidoDel.setCEP(result.getString(3));
				pedidoDel.setHoraSaida(result.getTime(4));
				pedidoDel.setData(result.getDate(5));
				pedidoDel.setCpfEntregador(result.getString(6));
				pedidoDel.setComplemento(result.getString(7));
				pedidoDel.setTaxa(result.getInt(8));

				pedidoList.add(pedidoDel);

				tamanho = pedidoList.size();
				pedidos = new PedidoDelivery[tamanho];
				for (int i = 0; i < tamanho; i++) {
					if (pedidoList.get(i) != null)
						pedidos[i] = pedidoList.get(i);
				}

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return pedidos;

	}

	public Funcionario[] listarEntregadores() {
		ArrayList<Funcionario> funcionariosList = new ArrayList<Funcionario>();
		Funcionario[] funcionarios = null;
		int tamanho = 0;
		try {
			Statement stmt1 = connect.createStatement();
			ResultSet result1 = stmt1.executeQuery(
					"SELECT DISTINCT * FROM funcionario WHERE (cpf) IN (SELECT funcionario_cpf FROM funcionario_entregador)");
			while (result1.next()) {

				Funcionario funcionario = new Funcionario();
				funcionario.setCpf(result1.getString(1));
				funcionario.setNome(result1.getString(2));
				funcionario.setDataNasc(result1.getDate(3));
				funcionario.setSalario(result1.getFloat(4));
				funcionario.setCompl((result1.getString(5)));
				funcionario.setNumero(result1.getInt(6));
				funcionario.setCEP((result1.getString(7)));
				funcionario.setSeq_loja(result1.getInt(8));
				funcionario.setSenha(result1.getString(9));

				funcionariosList.add(funcionario);

				tamanho = funcionariosList.size();
				funcionarios = new Funcionario[tamanho];
				for (int i = 0; i < tamanho; i++) {
					if (funcionariosList.get(i) != null)
						funcionarios[i] = funcionariosList.get(i);
				}

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return funcionarios;

	}

	public Produto[] listarProduto() {
		ArrayList<Produto> produtosList = new ArrayList<Produto>();
		Produto[] produtos = null;
		int tamanho = 0;
		try {
			Statement stmt1 = connect.createStatement();
			ResultSet result1 = stmt1.executeQuery("SELECT * FROM produtoRef");
			while (result1.next()) {

				Produto produto = new Produto();
				produto.setUnidade(result1.getInt(1));
				produto.setCodigo(result1.getInt(2));
				produto.setDescr(result1.getString(3));
				produto.setQtdMinStk(result1.getInt(4));
				produto.setDt_inicio(result1.getDate(5));
				produto.setDt_fim(result1.getDate(6));
				produto.setCnpj_fornecedor(result1.getString(7));
				produto.setCod_categ(result1.getInt(8));
				produto.setPreco_ult_compra(result1.getDouble(9));
				produto.setQtd_atual_estoque(result1.getInt(10));
				produto.setFreq_pedido(result1.getInt(11));
				produtosList.add(produto);

				tamanho = produtosList.size();
				produtos = new Produto[tamanho];
				for (int i = 0; i < tamanho; i++) {
					if (produtosList.get(i) != null)
						produtos[i] = produtosList.get(i);
				}

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return produtos;

	}

	public Cliente_Avalia[] listarClienteAvalia() {
		ArrayList<Cliente_Avalia> clienteAvalia = new ArrayList<Cliente_Avalia>();
		Cliente_Avalia[] avaliacoes = null;
		int tamanho = 0;
		try {
			Statement stmt = connect.createStatement();
			ResultSet result = stmt.executeQuery("SELECT * FROM cliente_avalia");
			while (result.next()) {

				Cliente_Avalia avaliacao = new Cliente_Avalia();
				avaliacao.setSeq_loja(result.getInt(1));
				avaliacao.setId_cliente(result.getInt(2));
				avaliacao.setNota(Nota.valueOf(result.getString(3)));
				avaliacao.setData_avaliacao(result.getDate(4));
				avaliacao.setComentario(result.getString(5));
				clienteAvalia.add(avaliacao);

				tamanho = clienteAvalia.size();
				avaliacoes = new Cliente_Avalia[tamanho];
				for (int i = 0; i < tamanho; i++) {
					if (clienteAvalia.get(i) != null)
						avaliacoes[i] = clienteAvalia.get(i);
				}

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return avaliacoes;

	}

	public ReservaOficial[] listarReservaOficial() {
		ArrayList<ReservaOficial> reservas = new ArrayList<ReservaOficial>();
		ReservaOficial[] reservasOficiais = null;
		int tamanho = 0;
		try {
			Statement stmt = connect.createStatement();
			Statement stmt2 = connect.createStatement();
			ResultSet result = stmt.executeQuery("SELECT * FROM reserva");
			ResultSet result2 = stmt2.executeQuery("SELECT * FROM faz_reserva");
			while (result.next() && result2.next()) {

				ReservaOficial reserva = new ReservaOficial();
				reserva.setSeq(result.getInt(1));
				reserva.setHora_inicio(result.getTime(2));
				reserva.setHora_fim(result.getTime(3));
				reserva.setStatus(StatusReserva.valueOf(result.getString(4).toUpperCase()));
				reserva.setNum_pessoas(result.getInt(5));
				reserva.setCpfFuncionario(result2.getString(1));
				reserva.setIdCliente(result2.getInt(3));
				reserva.setDataReserva(result2.getDate(4));
				reserva.setDataValidade(result2.getDate(5));
				reservas.add(reserva);

				tamanho = reservas.size();
				reservasOficiais = new ReservaOficial[tamanho];
				for (int i = 0; i < tamanho; i++) {
					if (reservas.get(i) != null)
						reservasOficiais[i] = reservas.get(i);
				}

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return reservasOficiais;

	}

	public Categoria[] listarCategoria() {
		ArrayList<Categoria> categoriasList = new ArrayList<Categoria>();
		Categoria[] categorias = null;
		int tamanho = 0;
		try {
			Statement stmt = connect.createStatement();

			ResultSet result = stmt.executeQuery("SELECT * FROM categoria");

			while (result.next()) {

				Categoria categoria = new Categoria();
				categoria.setCodCateg(result.getInt(1));
				categoria.setDescr(result.getString(2));
				categoriasList.add(categoria);

				tamanho = categoriasList.size();
				categorias = new Categoria[tamanho];
				for (int i = 0; i < tamanho; i++) {
					if (categoriasList.get(i) != null)
						categorias[i] = categoriasList.get(i);
				}

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return categorias;

	}

	public ClientePF[] listarClientePF() {
		ArrayList<ClientePF> clientePFList = new ArrayList<ClientePF>();
		ClientePF[] clientesPF = null;
		int tamanho = 0;
		try {
			Statement stmt = connect.createStatement();

			ResultSet result = stmt.executeQuery("SELECT * FROM clientePF");

			while (result.next()) {

				ClientePF cliente = new ClientePF();
				cliente.setNome(result.getString(1));
				cliente.setDataDeNascimento(result.getDate(2));
				cliente.setId(result.getInt(3));
				clientePFList.add(cliente);

				tamanho = clientePFList.size();
				clientesPF = new ClientePF[tamanho];
				for (int i = 0; i < tamanho; i++) {
					if (clientePFList.get(i) != null)
						clientesPF[i] = clientePFList.get(i);
				}

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return clientesPF;

	}

	public ClientePF[] listarClientePF2(int seq) {
		ArrayList<ClientePF> clientePFList = new ArrayList<ClientePF>();
		ClientePF[] clientesPF = null;
		int tamanho = 0;
		try {
			Statement stmt = connect.createStatement();

			ResultSet result = stmt.executeQuery(
					"SELECT * FROM clientePF JOIN cliente_avalia ON clientePF.clientePF_id = cliente_avalia.id_cliente WHERE cliente_avalia.seq_loja = "
							+ seq);

			while (result.next()) {

				ClientePF cliente = new ClientePF();
				cliente.setNome(result.getString(1));
				cliente.setDataDeNascimento(result.getDate(2));
				cliente.setId(result.getInt(3));
				clientePFList.add(cliente);

				tamanho = clientePFList.size();
				clientesPF = new ClientePF[tamanho];
				for (int i = 0; i < tamanho; i++) {
					if (clientePFList.get(i) != null)
						clientesPF[i] = clientePFList.get(i);
				}

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return clientesPF;

	}

	public ClientePJ[] listarClientePJ() {
		ArrayList<ClientePJ> clientePJList = new ArrayList<ClientePJ>();
		ClientePJ[] clientesPJ = null;
		int tamanho = 0;
		try {
			Statement stmt = connect.createStatement();

			ResultSet result = stmt.executeQuery("SELECT * FROM cliente_pj");

			while (result.next()) {

				ClientePJ cliente = new ClientePJ();
				cliente.setId(result.getInt(1));
				cliente.setCnpj(result.getString(2));
				cliente.setRazaoSocial(result.getString(3));
				cliente.setNomeFantasia(result.getString(4));
				clientePJList.add(cliente);

				tamanho = clientePJList.size();
				clientesPJ = new ClientePJ[tamanho];
				for (int i = 0; i < tamanho; i++) {
					if (clientePJList.get(i) != null)
						clientesPJ[i] = clientePJList.get(i);
				}

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return clientesPJ;

	}

	public ClientePJ[] listarClientePJ2(int seq) {
		ArrayList<ClientePJ> clientePJList = new ArrayList<ClientePJ>();
		ClientePJ[] clientesPJ = null;
		int tamanho = 0;
		try {
			Statement stmt = connect.createStatement();

			ResultSet result = stmt.executeQuery(
					"SELECT * FROM cliente_pj JOIN cliente_avalia ON cliente_pj.id_cliente = cliente_avalia.id_cliente WHERE cliente_avalia.seq_loja = "
							+ seq);

			while (result.next()) {

				ClientePJ cliente = new ClientePJ();
				cliente.setId(result.getInt(1));
				cliente.setCnpj(result.getString(2));
				cliente.setRazaoSocial(result.getString(3));
				cliente.setNomeFantasia(result.getString(4));
				clientePJList.add(cliente);

				tamanho = clientePJList.size();
				clientesPJ = new ClientePJ[tamanho];
				for (int i = 0; i < tamanho; i++) {
					if (clientePJList.get(i) != null)
						clientesPJ[i] = clientePJList.get(i);
				}

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return clientesPJ;

	}

	public boolean atualizarFornecedor(Fornecedor f) throws Exception {
		return cFornecedor.atualizarFornecedor(f);
	}

	public boolean atualizarProduto(Produto p) throws Exception {
		return cProduto.atualizarProduto(p);
	}

	public boolean atualizarItemEstoque(ItemEstoque i) throws Exception {
		return cItemEstoque.atualizarItemEstoque(i);
	}

	public boolean atualizarPedidoDelivery(PedidoDelivery p) throws Exception {
		return cPedidoDel.atualizarPedidoDelivery(p);
	}

	public boolean atualizarClientePF(ClientePF c) throws Exception {
		return cClientePF.atualizarClientePF(c);
	}

	public boolean atualizarClientePJ(ClientePJ c) throws Exception {
		return cClientePJ.atualizarClientePJ(c);
	}

}
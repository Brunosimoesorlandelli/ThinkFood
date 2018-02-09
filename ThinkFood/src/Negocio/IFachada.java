package Negocio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.ClientePF;
import beans.ClientePJ;
import beans.Estoque;
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

public interface IFachada {

	public void Conectar(Connection connect);

	public boolean cadastrarEntregador(Funcionario_Entregador p) throws Exception;

	public Funcionario_Entregador procurarEntregador(String cpf) throws Exception;

	public boolean removerEntregador(Funcionario_Entregador f) throws SQLException;

	public void printarEntregador(Funcionario_Entregador p);

	public ArrayList<Funcionario_Entregador> listarEntregador();

	public boolean cadastrarFornecedor(Fornecedor p) throws Exception;

	public Fornecedor procurarFornecedor(String cnpj) throws Exception;

	public boolean removerFornecedor(Fornecedor f) throws SQLException;

	public void printarFornecedor(Fornecedor p);

	public boolean cadastrarGarcon(Funcionario_Garcon p) throws Exception;

	public Funcionario_Garcon procurarGarcom(String cnpj) throws Exception;

	public boolean removerGarcon(Funcionario_Garcon f) throws SQLException;

	public void printarGarcon(Funcionario_Garcon p);

	public boolean cadastrarGerente(Funcionario_Gerente p) throws Exception;

	public Funcionario_Gerente procurarGerente(String cpf) throws Exception;

	public boolean removerGerente(Funcionario_Gerente f) throws SQLException;

	public void printarGerente(Funcionario_Gerente p);

	public boolean cadastrarProduto(Produto p) throws SQLException;

	public Produto procurarProduto(int id) throws SQLException;

	public boolean removerProduto(Produto p) throws SQLException;

	public void printarProduto(Produto p);

	public boolean cadastrarSecretario(Funcionario_Secretario p) throws Exception;

	public Funcionario_Secretario procurarSecretario(String cpf) throws Exception;

	public boolean removerSecretario(Funcionario_Secretario f) throws SQLException;

	public void printarSecretario(Funcionario_Secretario p);

	public boolean cadastrarItemMenu(ItemMenu p) throws SQLException;

	public ItemMenu procurarItemMenu(int id) throws SQLException;

	public boolean removerItemMenu(ItemMenu p) throws SQLException;

	public void printarItemMenu(ItemMenu p);

	public boolean cadastrarReserva(Reserva r) throws SQLException;

	public Reserva procurarReserva(int seq) throws SQLException;

	public boolean removerReserva(Reserva r) throws SQLException;

	public void printarReserva(Reserva r);

	public Funcionario logar(String cpf) throws Exception;

	public boolean cadastrarPedidoDel(PedidoDelivery p) throws SQLException;

	public PedidoDelivery procurarPedidoDel(int id) throws SQLException;

	public boolean removerPedidoDel(PedidoDelivery p) throws SQLException;

	public void printarPedidoDel(PedidoDelivery p);

	public ArrayList<PedidoDelivery> listarPedidoDel();

	public boolean cadastrarEstoque(Estoque p) throws SQLException;

	public Estoque procurarEstoque(int id) throws SQLException;

	public boolean removerEstoque(Estoque p) throws SQLException;

	public void printarEstoque(Estoque p);

	public ArrayList<Estoque> listarEstoque();

	public boolean cadastrarMesa(Mesa p) throws SQLException;

	public Mesa procurarMesa(int num) throws SQLException;

	public boolean removerMesa(Mesa p) throws SQLException;

	public void printarMesa(Mesa p);

	public ArrayList<Mesa> listarMesa();

	public boolean cadastrarClientePF(ClientePF p) throws Exception;

	public ClientePF procurarClientePF(int id) throws Exception;

	public boolean removerClientePF(ClientePF f) throws SQLException;

	public void printarClientePF(ClientePF p);

	public ArrayList<ClientePF> listarClientePF();

	public boolean cadastrarClientePJ(ClientePJ p) throws Exception;

	public ClientePJ procurarClientePJ(int id) throws Exception;

	public boolean removerClientePJ(ClientePJ f) throws SQLException;

	public void printarClientePJ(ClientePJ p);

	public ArrayList<ClientePJ> listarClientePJ();

}

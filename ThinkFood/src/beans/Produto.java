package beans;

import java.sql.Date;

public class Produto {
	private int unidade;
	private int codigo;
	private String descr;
	private int qtdMinStk;
	private Date dt_inicio;
	private Date dt_fim;
	private String cnpj_fornecedor;
	private int cod_categ;
	private double preco_ult_compra;
	private int qtd_atual_estoque;
	private int freq_pedido;

	public Produto(int unidade, int codigo, String descr, int qtdMinStk, Date dt_inicio, Date dt_fim,
			String cnpj_fornecedor, int cod_categ, double preco_ult_compra, int qtd_atual_estoque, int freq_pedido) {
		this.unidade = unidade;
		this.codigo = codigo;
		this.descr = descr;
		this.qtdMinStk = qtdMinStk;
		this.dt_inicio = dt_inicio;
		this.dt_fim = dt_fim;
		this.cnpj_fornecedor = cnpj_fornecedor;
		this.cod_categ = cod_categ;
		this.preco_ult_compra = preco_ult_compra;
		this.qtd_atual_estoque = qtd_atual_estoque;
		this.freq_pedido = freq_pedido;

	}

	public Produto(int unidade, String descr, int qtdMinStk, String cnpj_fornecedor, int cod_categ) {
		this.unidade = unidade;
		this.descr = descr;
		this.qtdMinStk = qtdMinStk;
		this.cnpj_fornecedor = cnpj_fornecedor;
		this.cod_categ = cod_categ;

	}

	public Produto() {

	}

	public int getUnidade() {
		return unidade;
	}

	public void setUnidade(int unidade) {
		this.unidade = unidade;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public int getQtdMinStk() {
		return qtdMinStk;
	}

	public void setQtdMinStk(int qtdMinStk) {
		this.qtdMinStk = qtdMinStk;
	}

	public Date getDt_inicio() {
		return dt_inicio;
	}

	public void setDt_inicio(Date dt_inicio) {
		this.dt_inicio = dt_inicio;
	}

	public Date getDt_fim() {
		return dt_fim;
	}

	public void setDt_fim(Date dt_fim) {
		this.dt_fim = dt_fim;
	}

	public String getCnpj_fornecedor() {
		return cnpj_fornecedor;
	}

	public void setCnpj_fornecedor(String cnpj_fornecedor) {
		this.cnpj_fornecedor = cnpj_fornecedor;
	}

	public int getCod_categ() {
		return cod_categ;
	}

	public void setCod_categ(int cod_categ) {
		this.cod_categ = cod_categ;
	}

	public double getPreco_ult_compra() {
		return preco_ult_compra;
	}

	public void setPreco_ult_compra(double preco_ult_compra) {
		this.preco_ult_compra = preco_ult_compra;
	}

	public int getQtd_atual_estoque() {
		return qtd_atual_estoque;
	}

	public void setQtd_atual_estoque(int qtd_atual_estoque) {
		this.qtd_atual_estoque = qtd_atual_estoque;
	}

	public int getFreq_pedido() {
		return freq_pedido;
	}

	public void setFreq_pedido(int freq_pedido) {
		this.freq_pedido = freq_pedido;
	}

}

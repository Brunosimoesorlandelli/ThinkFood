package beans;

//VERIFICAR SE TA CERTO.

import java.sql.Date;

public class ItemEstoque {

	private int codProduto;
	private int idEstoque;
	private int lote;
	private int qtd;
	private Date dataEntrada;
	private Date dataValidade;

	public ItemEstoque(int codProduto, int idEstoque, Date dataEntrada, int lote, int qtd, Date dataValidade) {
		this.dataEntrada = dataEntrada;
		this.lote = lote;
		this.qtd = qtd;
		this.dataValidade = dataValidade;
		this.codProduto = codProduto;
		this.idEstoque = idEstoque;
	}

	public ItemEstoque() {
		
	}
	
	public int getCodProduto() {
		return codProduto;
	}

	public void setCodProduto(int codProduto) {
		this.codProduto = codProduto;
	}

	public int getIdEstoque() {
		return idEstoque;
	}

	public void setIdEstoque(int idEstoque) {
		this.idEstoque = idEstoque;
	}

	public int getLote() {
		return lote;
	}

	public void setLote(int lote) {
		this.lote = lote;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Date getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}

}

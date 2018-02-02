package beans;

//VERIFICAR SE TA CERTO.

import java.sql.Date;

public class ItemEstoque extends Estoque {

	private Date dataEntrada;
	private int lote;
	private int qtd;
	private Date dataValidade;

	public ItemEstoque(int id, Date dataEntrada, int lote, int qtd, Date dataValidade) {
		super(id, null, dataValidade);
		this.dataEntrada = dataEntrada;
		this.lote = lote;
		this.qtd = qtd;
		this.dataValidade = dataValidade;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
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

	public Date getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}

}

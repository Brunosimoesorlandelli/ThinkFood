package beans;

public class ItemPedido {
	private int qtd;
	private double priceUnit;
	
	public ItemPedido(int qtd, double priceUnit) {
		this.qtd = qtd;
		this.priceUnit = priceUnit;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public double getPriceUnit() {
		return priceUnit;
	}

	public void setPriceUnit(double priceUnit) {
		this.priceUnit = priceUnit;
	}

	
}

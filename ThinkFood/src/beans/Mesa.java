package beans;
//TEM MAIS COISA PRA IMPLEMENTAR EU ACHO.

public class Mesa {

	private int num;
	private int qtdLugares;
	private boolean estaLivre;

	public Mesa(int num, int qtdLugares, boolean estaLivre) {
		this.num = num;
		this.qtdLugares = qtdLugares;
		this.estaLivre = estaLivre;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getQtdLugares() {
		return qtdLugares;
	}

	public void setQtdLugares(int qtdLugares) {
		this.qtdLugares = qtdLugares;
	}

	public boolean getEstaLivre() {
		return estaLivre;
	}

	public void setEstaLivre(boolean estaLivre) {
		this.estaLivre = estaLivre;
	}

}

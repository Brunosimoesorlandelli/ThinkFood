package beans;

public class ItemMenu {
	private int id;
	private double preco;
	private String descr;
	private String detalhes;
	private String nome_curto;
	private int cod_Menu;
	
	public ItemMenu(int id, double preco, String descr, String detalhes, String nome_curto, int cod_Menu) {
		this.id = id;
		this.preco = preco;
		this.descr = descr;
		this.detalhes = detalhes;
		this.nome_curto = nome_curto;
		this.cod_Menu = cod_Menu;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}

	public String getNome_curto() {
		return nome_curto;
	}

	public void setNome_curto(String nome_curto) {
		this.nome_curto = nome_curto;
	}

	public int getCod_Menu() {
		return cod_Menu;
	}

	public void setCod_Menu(int cod_Menu) {
		this.cod_Menu = cod_Menu;
	}
	
	
	

}

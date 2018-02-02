package Beans;

public class Categoria {
	
	private int codCateg;
	private String descr;
	
	public Categoria(int codCateg, String descr) {
		this.codCateg = codCateg;
		this.descr = descr;
		
	}

	public int getCodCateg() {
		return codCateg;
	}

	public void setCodCateg(int codCateg) {
		this.codCateg = codCateg;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}
	

}

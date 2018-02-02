package Negocio.beans;

public class Caixa {
	
	private int cod;
	private String obs;
	private boolean ePreferencial;
	private String descr;
	private StatusCaixa status;
	
	public Caixa(int cod, String obs, boolean ePreferencial, String descr, StatusCaixa status) {
		
		this.cod = cod;
		this.obs = obs;
		this.ePreferencial = ePreferencial;
		this.descr = descr;
		this.status = status;
		
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public boolean isePreferencial() {
		return ePreferencial;
	}

	public void setePreferencial(boolean ePreferencial) {
		this.ePreferencial = ePreferencial;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public StatusCaixa getStatus() {
		return status;
	}

	public void setStatus(StatusCaixa status) {
		this.status = status;
	}

}

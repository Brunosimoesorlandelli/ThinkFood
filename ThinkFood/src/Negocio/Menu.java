package Negocio;

import java.sql.Date;

public class Menu {

	private int cod;
	private String descr;
	private Date dataM;
	private Date dataInicio;
	private Date dataFim;

	public Menu(int cod, String descr, Date dataM, Date dataInicio, Date dataFim) {
		this.cod = cod;
		this.descr = descr;
		this.dataM = dataM;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public Date getDataM() {
		return dataM;
	}

	public void setDataM(Date dataM) {
		this.dataM = dataM;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

}

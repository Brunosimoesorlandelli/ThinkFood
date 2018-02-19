package beans;

//
//TALVEZ TENHA ALGO FALTANDO
//
import java.sql.Date;

public class Estoque {

	private int id;
	private String descr;
	private Date dtUltimaEntrada;

	public Estoque(int id, String descr, Date dtUltimaEntrada) {
		this.id = id;
		this.descr = descr;
		this.dtUltimaEntrada = dtUltimaEntrada;

	}

	public Estoque() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public Date getDtUltimaEntrada() {
		return dtUltimaEntrada;
	}

	public void setDtUltimaEntrada(Date dtUltimaEntrada) {
		this.dtUltimaEntrada = dtUltimaEntrada;
	}

}

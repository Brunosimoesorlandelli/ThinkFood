package beans;

import java.sql.Date;

public class Cliente_Avalia {

	private int seq_loja;
	private int id_cliente;
	private Nota nota;
	private Date data_avaliacao;
	private String comentario;

	public Cliente_Avalia(int seq_loja, int id_cliente, Nota nota, Date data_ava, String comentario) {
		this.seq_loja = seq_loja;
		this.id_cliente = id_cliente;
		this.nota = nota;
		this.data_avaliacao = data_ava;
		this.comentario = comentario;
	}

	public Cliente_Avalia() {

	}

	public int getSeq_loja() {
		return seq_loja;
	}

	public void setSeq_loja(int seq_loja) {
		this.seq_loja = seq_loja;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public Nota getNota() {
		return nota;
	}

	public void setNota(Nota nota) {
		this.nota = nota;
	}

	public Date getData_avaliacao() {
		return data_avaliacao;
	}

	public void setData_avaliacao(Date data_avaliacao) {
		this.data_avaliacao = data_avaliacao;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

}

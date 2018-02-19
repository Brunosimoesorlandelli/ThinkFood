package Negocio;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Funcionario_Entregador;
import dados.IRepositorioEntregador;
import dados.RepositorioEntregador;

public class ControladorEntregador implements IControladorEntregador, Serializable {

	private static final long serialVersionUID = 1;
	private IRepositorioEntregador rep;

	public ControladorEntregador() {
		this.rep = RepositorioEntregador.getInstance();
	}

	public void conectar(Connection connect) {
		rep.conectar(connect);
	}

	public boolean cadastrar(Funcionario_Entregador p) throws Exception {
		return rep.cadastrar(p);
	}

	public boolean equals(Object arg0) {
		return rep.equals(arg0);
	}

	public int hashCode() {
		return rep.hashCode();
	}

	public Funcionario_Entregador procurar(String cpf) throws Exception {
		return rep.procurar(cpf);
	}

	public boolean remover(Funcionario_Entregador f) throws SQLException {
		return rep.remover(f);
	}

	public void printar(Funcionario_Entregador p) {
		rep.printar(p);
	}

	public ArrayList<Funcionario_Entregador> listar() {
		return rep.listar();
	}

	public String toString() {
		return rep.toString();
	}

	public boolean atualizarEntregador(Funcionario_Entregador f) throws Exception {
		return rep.atualizarEntregador(f);
	}
	
	

}

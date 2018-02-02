package beans;

import java.sql.Date;

public class Funcionario_Garcon extends Funcionario {
	
	public Funcionario_Garcon(String nome, String cpf, Date dataNasc, Endereco endereco, double salario, int numero) {
		super(nome, cpf, dataNasc, endereco, salario, numero);
	}

}

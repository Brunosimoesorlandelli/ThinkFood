package beans;

import java.sql.Date;

public class Funcionario_Gerente extends Funcionario {

	public Funcionario_Gerente(String nome, String cpf, Date dataNasc, Endereco endereco, double salario, int numero) {
		super(nome, cpf, dataNasc, endereco, salario, numero);
		
	}


}

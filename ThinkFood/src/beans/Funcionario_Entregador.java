package beans;

import java.sql.Date;

public class Funcionario_Entregador extends Funcionario{

	public Funcionario_Entregador(String nome, String cpf, Date dataNasc, Endereco endereco, double salario,
			int numero) {
		super(nome, cpf, dataNasc, endereco, salario, numero);
	}

	
}

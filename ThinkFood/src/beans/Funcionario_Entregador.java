package beans;

import java.sql.Date;

public class Funcionario_Entregador extends Funcionario {

	public Funcionario_Entregador(String nome, String cpf, Date dataNasc, String endereco, double salario, int seq_Loja,
			String compl, int numero, String senha) {
		super(nome, cpf, dataNasc, endereco, salario, numero, compl, seq_Loja, senha);
	}

}

package beans;

import java.sql.Date;

public class Funcionario_Secretario extends Funcionario {

	public Funcionario_Secretario(String nome, String cpf, Date dataNasc, String endereco, double salario, int seq_Loja,
			String compl, int numero, String senha) {
		super(nome, cpf, dataNasc, endereco, salario, seq_Loja, compl, numero, senha);
	}

}

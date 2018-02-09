package Negocio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {
	private String host = "localhost";
	private String projeto = "jdbc:mysql://" + host + ":3306/ThinkFood";

	public Connection getConexao(String cpf, String senha) throws Exception {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(projeto, cpf, senha);

		} catch (SQLException | ClassNotFoundException e) {
			throw e;
		}
	}

	public String getHost() {
		return host;
	}
}

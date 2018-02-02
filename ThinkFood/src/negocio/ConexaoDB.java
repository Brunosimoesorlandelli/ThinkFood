package negocio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {
	private String host = "localhost";
	private String projeto = "jdbc:mysql://" + host + ":3306/sys";

	public Connection getConexao() throws Exception {
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(projeto, "root", "deadman123");

		} catch (SQLException | ClassNotFoundException e) {
			throw e;
		}
	}

	public String getHost() {
		return host;
	}
}

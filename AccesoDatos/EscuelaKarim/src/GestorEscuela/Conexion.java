// Karim Zinnatullin
package GestorEscuela;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	private static final String URL = "jdbc:mysql://79.72.53.157/escuela";
	private static final String USER = "director";
	private static final String PASSWORD = "Director123";

	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

}

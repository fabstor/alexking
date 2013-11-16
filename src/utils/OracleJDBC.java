package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleJDBC {

	private static String driver = "oracle.jdbc.driver.OracleDriver";
	private static String password = "userir";
	private static String dbname = "XE";	//select ora_database_name from dual;
	private static String username = "userir";

	public Connection getConnection() {

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC Driver ne marche pas");
			e.printStackTrace();
			return null;
		}

		Connection connection = null;

		try {
			connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:" + dbname, username,
					password);
		} catch (SQLException e) {
			System.out.println("Connection Failed");
			e.printStackTrace();
			return null;
		}
		return connection;

	}

	public void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
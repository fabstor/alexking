package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleJDBC {

	private static String driver = "oracle.jdbc.driver.OracleDriver";
	// private static String password = "qwerty12345";
	private static String password = "userir";
	private static String dbname = "XE";
	private static String username = "userir";

	public static void main(String[] argv) {

		try {

			Class.forName(driver);

		} catch (ClassNotFoundException e) {

			System.out.println("JDBC Driver ne marche pas");
			e.printStackTrace();
			return;

		}

		Connection connection = null;

		try {

			connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:" + dbname, username,
					password);

		} catch (SQLException e) {

			System.out.println("Connection Failed");
			e.printStackTrace();
			return;

		}

		Statement st;
		try {
			st = connection.createStatement();
			st.executeUpdate("INSERT INTO test " + "VALUES ('Fabien')");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
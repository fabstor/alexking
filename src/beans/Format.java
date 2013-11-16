package beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import utils.OracleJDBC;
import interfaces.IDBBean;

public class Format implements IDBBean{

	private Integer idFormat;
	private String name;
	private Integer price;


	public Format(Integer idFormat, String name, Integer price) {
		super();
		this.idFormat = idFormat;
		this.name = name;
		this.price = price;
	}

	@Override
	public ResultSet add() {
		ResultSet result = null;

		OracleJDBC oracleJDBC = new OracleJDBC();
		Connection dbConnection = oracleJDBC.getConnection();
		String s = "INSERT INTO Format VALUES (?,?,?)";

		try {
			PreparedStatement preparedStatement = dbConnection
					.prepareStatement(s);

			preparedStatement.setInt(1, this.idFormat);
			preparedStatement.setString(2, this.name);
			preparedStatement.setInt(3, this.price);

			result = preparedStatement.executeQuery();

			dbConnection.close();

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return result;
	}
	
	public Integer getIdFormat() {
		return idFormat;
	}
	public void setIdFormat(Integer idFormat) {
		this.idFormat = idFormat;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	
}

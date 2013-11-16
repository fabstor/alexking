package beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.OracleJDBC;
import interfaces.IDBBean;

public class SimpleOrder implements IDBBean{

	private Integer idSimpleOrder;
	private Integer idAlbum;
	private Integer idFormat;
	private Integer quantity;
	private Boolean isBook;

	public SimpleOrder(){}
	
	public SimpleOrder(Integer idSimpleOrder, Integer idAlbum,
			Integer idFormat, Integer quantity, Boolean isBook) {
		super();
		this.idSimpleOrder = idSimpleOrder;
		this.idAlbum = idAlbum;
		this.idFormat = idFormat;
		this.quantity = quantity;
		this.isBook = isBook;
	}

	@Override
	public ResultSet add() {

		ResultSet result = null;

		OracleJDBC oracleJDBC = new OracleJDBC();
		Connection dbConnection = oracleJDBC.getConnection();
		String s = "INSERT INTO SimpleOrder VALUES (?,?,?,?,?)";

		try {
			PreparedStatement preparedStatement = dbConnection
					.prepareStatement(s);

			preparedStatement.setInt(1, this.idSimpleOrder);
			preparedStatement.setInt(2, this.idAlbum);
			preparedStatement.setInt(3, this.idFormat);
			preparedStatement.setInt(4, this.quantity);
			if (this.isBook) {
				preparedStatement.setString(5, "T");
			} else {
				preparedStatement.setString(5, "F");
			}

			result = preparedStatement.executeQuery();

			dbConnection.close();

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return result;
	}
	
	public Integer getIdSimpleOrder() {
		return idSimpleOrder;
	}

	public void setIdSimpleOrder(Integer idSimpleOrder) {
		this.idSimpleOrder = idSimpleOrder;
	}

	public Integer getIdAlbum() {
		return idAlbum;
	}

	public void setIdAlbum(Integer idAlbum) {
		this.idAlbum = idAlbum;
	}

	public Integer getIdFormat() {
		return idFormat;
	}

	public void setIdFormat(Integer idFormat) {
		this.idFormat = idFormat;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Boolean getIsBook() {
		return isBook;
	}

	public void setIsBook(Boolean isBook) {
		this.isBook = isBook;
	}
	/*
	@Override
	public ResultSet remove(Integer idRemove) {

		ResultSet result = null;

		OracleJDBC oracleJDBC = new OracleJDBC();
		Connection dbConnection = oracleJDBC.getConnection();
		String s = "DELETE FROM simpleOrder WHERE idSimpleOrder = ?";

		try {
			PreparedStatement preparedStatement = dbConnection
					.prepareStatement(s);

			preparedStatement.setInt(1, idRemove);
			result = preparedStatement.executeQuery();

			dbConnection.close();

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return result;
	}
	*/
}

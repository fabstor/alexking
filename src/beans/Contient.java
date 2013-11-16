package beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.OracleJDBC;
import interfaces.IDBBean;

public class Contient implements IDBBean {
	private Integer idAlbum;
	private Integer idPhoto;
	private String name;
	private String comment;
	private Integer order;

	public Contient(Integer idAlbum, Integer idPhoto, String name,
			String comment, Integer order) {
		super();
		this.idAlbum = idAlbum;
		this.idPhoto = idPhoto;
		this.name = name;
		this.comment = comment;
		this.order = order;
	}

	@Override
	public ResultSet add() {
		ResultSet result = null;

		OracleJDBC oracleJDBC = new OracleJDBC();
		Connection dbConnection = oracleJDBC.getConnection();
		String s = "INSERT INTO Contient VALUES (?,?,?,?,?)";

		try {
			PreparedStatement preparedStatement = dbConnection
					.prepareStatement(s);

			preparedStatement.setInt(1, this.idAlbum);
			preparedStatement.setInt(2, this.idPhoto);
			preparedStatement.setString(3, this.name);
			preparedStatement.setString(4, this.comment);
			preparedStatement.setInt(5, this.order);

			result = preparedStatement.executeQuery();

			dbConnection.close();

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return result;
	}

	public Integer getIdAlbum() {
		return idAlbum;
	}

	public void setIdAlbum(Integer idAlbum) {
		this.idAlbum = idAlbum;
	}

	public Integer getIdPhoto() {
		return idPhoto;
	}

	public void setIdPhoto(Integer idPhoto) {
		this.idPhoto = idPhoto;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

}

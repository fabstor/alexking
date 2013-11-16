package beans;

import interfaces.IDBBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import utils.OracleJDBC;

public class Book implements IDBBean {
	private Integer idBook;
	private Integer idAlbum;
	private Integer idPhotoCouverture;
	private String firstPage;
	private String lastPage;
	private Boolean isPublic;
	private Timestamp creationDate;

	public Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public Book(Integer idBook, Integer idAlbum, Integer idPhotoCouverture,
			String firstPage, String lastPage, Boolean isPublic, Timestamp creationDate) {
		super();
		this.idBook = idBook;
		this.idAlbum = idAlbum;
		this.idPhotoCouverture = idPhotoCouverture;
		this.firstPage = firstPage;
		this.lastPage = lastPage;
		this.isPublic = isPublic;
		this.creationDate = creationDate;
	}

	@Override
	public ResultSet add() {
		ResultSet result = null;

		OracleJDBC oracleJDBC = new OracleJDBC();
		Connection dbConnection = oracleJDBC.getConnection();
		String s = "INSERT INTO Book VALUES (?,?,?,?,?,?,?)";

		try {
			PreparedStatement preparedStatement = dbConnection
					.prepareStatement(s);

			preparedStatement.setInt(1, this.idBook);
			preparedStatement.setInt(2, this.idAlbum);
			preparedStatement.setInt(3, this.idPhotoCouverture);
			preparedStatement.setString(4, this.firstPage);
			preparedStatement.setString(5, this.lastPage);
			if (this.isPublic) {
				preparedStatement.setString(6, "T");
			} else {
				preparedStatement.setString(6, "F");
			}
			preparedStatement.setTimestamp(7, this.creationDate);

			result = preparedStatement.executeQuery();

			dbConnection.close();

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return result;
	}

	public Integer getIdBook() {
		return idBook;
	}

	public void setIdBook(Integer idBook) {
		this.idBook = idBook;
	}

	public Integer getIdAlbum() {
		return idAlbum;
	}

	public void setIdAlbum(Integer idAlbum) {
		this.idAlbum = idAlbum;
	}

	public Integer getIdPhotoCouverture() {
		return idPhotoCouverture;
	}

	public void setIdPhotoCouverture(Integer idPhotoCouverture) {
		this.idPhotoCouverture = idPhotoCouverture;
	}

	public String getFirstPage() {
		return firstPage;
	}

	public void setFirstPage(String firstPage) {
		this.firstPage = firstPage;
	}

	public String getLastPage() {
		return lastPage;
	}

	public void setLastPage(String lastPage) {
		this.lastPage = lastPage;
	}

	public Boolean getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(Boolean isPublic) {
		this.isPublic = isPublic;
	}

}

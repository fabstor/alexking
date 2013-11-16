package beans;

import interfaces.IDBBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import utils.OracleJDBC;

public class Utilisateur implements IDBBean {
	private Integer idUser;
	private String email;
	private String password;
	private Boolean isAdmin;
	private String name;
	private String surname;
	private String street;
	private String streetNumber;
	private String country;
	private String city;
	private String zipcode;
	private java.sql.Timestamp lastConnexion;
	private java.sql.Timestamp creationDate;

	public Utilisateur(Integer idUser, String email, String password,
			Boolean isAdmin, String name, String surname, String street,
			String streetNumber, String country, String city, String zipcode,
			java.sql.Timestamp lastConnexion, java.sql.Timestamp creationDate) {
		super();
		this.idUser = idUser;
		this.email = email;
		this.password = password;
		this.isAdmin = isAdmin;
		this.name = name;
		this.surname = surname;
		this.street = street;
		this.streetNumber = streetNumber;
		this.country = country;
		this.city = city;
		this.zipcode = zipcode;
		this.lastConnexion = lastConnexion;
		this.creationDate = creationDate;
	}

	@Override
	public ResultSet add() {

		ResultSet result = null;

		OracleJDBC oracleJDBC = new OracleJDBC();
		Connection dbConnection = oracleJDBC.getConnection();
		String s = "INSERT INTO Utilisateur VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement preparedStatement = dbConnection
					.prepareStatement(s);

			preparedStatement.setInt(1, this.idUser);
			preparedStatement.setString(2, this.email);
			preparedStatement.setString(3, this.password);

			if (this.isAdmin) {
				preparedStatement.setString(4, "T");
			} else {
				preparedStatement.setString(4, "F");
			}
			preparedStatement.setString(5, this.name);
			preparedStatement.setString(6, this.surname);
			preparedStatement.setString(7, this.street);
			preparedStatement.setString(8, this.streetNumber);
			preparedStatement.setString(9, this.country);
			preparedStatement.setString(10, this.city);
			preparedStatement.setString(11, this.zipcode);
			preparedStatement.setTimestamp(12, this.lastConnexion);
			preparedStatement.setTimestamp(13, this.creationDate);

			result = preparedStatement.executeQuery();

			dbConnection.close();

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return result;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public Timestamp getLastConnexion() {
		return lastConnexion;
	}

	public void setLastConnexion(Timestamp lastConnexion) {
		this.lastConnexion = lastConnexion;
	}

	public Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

}

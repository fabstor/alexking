package beans;

import interfaces.IDBBean;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import utils.OracleJDBC;

public class ComplexOrder implements IDBBean {

	private Integer idOrder;
	private Integer idUser;
	private Timestamp orderDate;
	private Integer totalPrice;
	private String invoiceStreet;
	private String invoiceNumber;
	private String invoiceCountry;
	private String invoiceCity;
	private String invoiceZipcode;
	private String deliveryStreet;
	private String deliveryNumber;
	private String deliveryCountry;
	private String deliveryCity;
	private String deliveryZipcode;

	public ComplexOrder(Integer idOrder, Integer idUser, Timestamp orderDate,
			Integer totalPrice, String invoiceStreet, String invoiceNumber,
			String invoiceCountry, String invoiceCity, String invoiceZipcode,
			String deliveryStreet, String deliveryNumber,
			String deliveryCountry, String deliveryCity, String deliveryZipcode) {
		super();
		this.idOrder = idOrder;
		this.idUser = idUser;
		this.orderDate = orderDate;
		this.totalPrice = totalPrice;
		this.invoiceStreet = invoiceStreet;
		this.invoiceNumber = invoiceNumber;
		this.invoiceCountry = invoiceCountry;
		this.invoiceCity = invoiceCity;
		this.invoiceZipcode = invoiceZipcode;
		this.deliveryStreet = deliveryStreet;
		this.deliveryNumber = deliveryNumber;
		this.deliveryCountry = deliveryCountry;
		this.deliveryCity = deliveryCity;
		this.deliveryZipcode = deliveryZipcode;
	}

	@Override
	public ResultSet add() {

		ResultSet result = null;

		OracleJDBC oracleJDBC = new OracleJDBC();
		Connection dbConnection = oracleJDBC.getConnection();
		String s = "INSERT INTO ComplexOrder VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement preparedStatement = dbConnection
					.prepareStatement(s);

			preparedStatement.setInt(1, this.idOrder);
			preparedStatement.setInt(2, this.idUser);
			preparedStatement.setTimestamp(3, this.orderDate);
			preparedStatement.setInt(4, this.totalPrice);
			preparedStatement.setString(5, this.invoiceStreet);
			preparedStatement.setString(6, this.invoiceNumber);
			preparedStatement.setString(7, this.invoiceCountry);
			preparedStatement.setString(8, this.invoiceCity);
			preparedStatement.setString(9, this.invoiceZipcode);
			preparedStatement.setString(10, this.deliveryStreet);
			preparedStatement.setString(11, this.deliveryNumber);
			preparedStatement.setString(12, this.deliveryCountry);
			preparedStatement.setString(13, this.deliveryCity);
			preparedStatement.setString(14, this.deliveryZipcode);

			result = preparedStatement.executeQuery();

			dbConnection.close();

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return result;
	}

	public Integer getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(Integer idOrder) {
		this.idOrder = idOrder;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public Timestamp getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getInvoiceStreet() {
		return invoiceStreet;
	}

	public void setInvoiceStreet(String invoiceStreet) {
		this.invoiceStreet = invoiceStreet;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getInvoiceCountry() {
		return invoiceCountry;
	}

	public void setInvoiceCountry(String invoiceCountry) {
		this.invoiceCountry = invoiceCountry;
	}

	public String getInvoiceCity() {
		return invoiceCity;
	}

	public void setInvoiceCity(String invoiceCity) {
		this.invoiceCity = invoiceCity;
	}

	public String getInvoiceZipcode() {
		return invoiceZipcode;
	}

	public void setInvoiceZipcode(String invoiceZipcode) {
		this.invoiceZipcode = invoiceZipcode;
	}

	public String getDeliveryStreet() {
		return deliveryStreet;
	}

	public void setDeliveryStreet(String deliveryStreet) {
		this.deliveryStreet = deliveryStreet;
	}

	public String getDeliveryNumber() {
		return deliveryNumber;
	}

	public void setDeliveryNumber(String deliveryNumber) {
		this.deliveryNumber = deliveryNumber;
	}

	public String getDeliveryCountry() {
		return deliveryCountry;
	}

	public void setDeliveryCountry(String deliveryCountry) {
		this.deliveryCountry = deliveryCountry;
	}

	public String getDeliveryCity() {
		return deliveryCity;
	}

	public void setDeliveryCity(String deliveryCity) {
		this.deliveryCity = deliveryCity;
	}

	public String getDeliveryZipcode() {
		return deliveryZipcode;
	}

	public void setDeliveryZipcode(String deliveryZipcode) {
		this.deliveryZipcode = deliveryZipcode;
	}

}

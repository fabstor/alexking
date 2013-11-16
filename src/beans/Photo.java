package beans;

import interfaces.IDBBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import utils.OracleJDBC;

public class Photo implements IDBBean {

	private Integer idPhoto;
	private Integer idUser;
	private String url;
	private String camera;
	private String objective;
	private String focalDistance;
	private String sensitivity;
	private String obturationSpeed;
	private String resolution;
	private java.sql.Timestamp creationDate;

	public Photo(Integer idPhoto, Integer idUser, String url, String camera,
			String objective, String focalDistance, String sensitivity,
			String obturationSpeed, String resolution, Timestamp creationDate) {
		super();
		this.idPhoto = idPhoto;
		this.idUser = idUser;
		this.url = url;
		this.camera = camera;
		this.objective = objective;
		this.focalDistance = focalDistance;
		this.sensitivity = sensitivity;
		this.obturationSpeed = obturationSpeed;
		this.resolution = resolution;
		this.creationDate = creationDate;
	}

	@Override
	public ResultSet add() {

		ResultSet result = null;

		OracleJDBC oracleJDBC = new OracleJDBC();
		Connection dbConnection = oracleJDBC.getConnection();
		String s = "INSERT INTO Photo VALUES (?,?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement preparedStatement = dbConnection
					.prepareStatement(s);

			preparedStatement.setInt(1, this.idPhoto);
			preparedStatement.setInt(2, this.idUser);
			preparedStatement.setString(3, this.url);
			preparedStatement.setString(4, this.camera);
			preparedStatement.setString(5, this.objective);
			preparedStatement.setString(6, this.focalDistance);
			preparedStatement.setString(7, this.sensitivity);
			preparedStatement.setString(8, this.obturationSpeed);
			preparedStatement.setString(9, this.resolution);
			preparedStatement.setTimestamp(10, this.creationDate);

			result = preparedStatement.executeQuery();

			dbConnection.close();

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return result;

	}

	public Integer getIdPhoto() {
		return idPhoto;
	}

	public void setIdPhoto(Integer idPhoto) {
		this.idPhoto = idPhoto;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCamera() {
		return camera;
	}

	public void setCamera(String camera) {
		this.camera = camera;
	}

	public String getObjective() {
		return objective;
	}

	public void setObjective(String objective) {
		this.objective = objective;
	}

	public String getFocalDistance() {
		return focalDistance;
	}

	public void setFocalDistance(String focalDistance) {
		this.focalDistance = focalDistance;
	}

	public String getSensitivity() {
		return sensitivity;
	}

	public void setSensitivity(String sensitivity) {
		this.sensitivity = sensitivity;
	}

	public String getObturationSpeed() {
		return obturationSpeed;
	}

	public void setObturationSpeed(String obturationSpeed) {
		this.obturationSpeed = obturationSpeed;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public java.sql.Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(java.sql.Timestamp creationDate) {
		this.creationDate = creationDate;
	}
	
	
}

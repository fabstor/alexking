package beans;

import interfaces.IDBBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import utils.OracleJDBC;

public class Album implements IDBBean {

	private Integer idAlbum;
	private Integer idUser;
	private String title;
	private String subtitle;
	private Boolean isPublic;
	private Timestamp creationDate;

	public Album(Integer idAlbum, Integer idUser, String title,
			String subtitle, Boolean isPublic, Timestamp creationDate) {
		super();
		this.idAlbum = idAlbum;
		this.idUser = idUser;
		this.title = title;
		this.subtitle = subtitle;
		this.isPublic = isPublic;
		this.creationDate = creationDate;
	}

	@Override
	public ResultSet add() {
		ResultSet result = null;

		OracleJDBC oracleJDBC = new OracleJDBC();
		Connection dbConnection = oracleJDBC.getConnection();
		String s = "INSERT INTO Album VALUES (?,?,?,?,?,?)";

		try {
			PreparedStatement preparedStatement = dbConnection
					.prepareStatement(s);

			preparedStatement.setInt(1, this.idAlbum);
			preparedStatement.setInt(2, this.idUser);
			preparedStatement.setString(3, this.title);
			preparedStatement.setString(4, this.subtitle);
			if (this.isPublic) {
				preparedStatement.setString(5, "T");
			} else {
				preparedStatement.setString(5, "F");
			}
			preparedStatement.setTimestamp(6, this.creationDate);

			result = preparedStatement.executeQuery();

			dbConnection.close();

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return result;
	}


	/*static public ArrayList<Album> getThreeLast() {
		ResultSet result = null;
		
		ArrayList<Album> list = new ArrayList<Album>();

		OracleJDBC oracleJDBC = new OracleJDBC();
		Connection dbConnection = oracleJDBC.getConnection();
		String s = "SELECT * FROM album WHERE isPublic like 'T' and ROWNUM <= 3";
		//TODO : rajouter order by
		try {
			Statement statement = dbConnection
					.createStatement();
			if (statement.execute(s) ){

				result = statement.getResultSet();

			}
			else{
				System.out.println("Error !");
			}


			
			try {
				while(result.next()){
					if( result.getString(5).equals("T") )
						list.add(new Album(result.getInt(1), result.getInt(2), result.getString(3),
								result.getString(4), true));
					else
						list.add(new Album(result.getInt(1), result.getInt(2), result.getString(3),
								result.getString(4), false));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dbConnection.close();

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}


		return list;
	}
*/
	public Integer getIdAlbum() {
		return idAlbum;
	}

	public void setIdAlbum(Integer idAlbum) {
		this.idAlbum = idAlbum;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public Boolean getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(Boolean isPublic) {
		this.isPublic = isPublic;
	}

	public Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

}

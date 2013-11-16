package DBManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import utils.OracleJDBC;

public class AlbumsUtils {

	public Set<Integer> getThreeRandomAlbums() {
		
		OracleJDBC oracleJDBC = new OracleJDBC();
		Connection dbConnection = oracleJDBC.getConnection();
		String s = "SELECT IDALBUM FROM Album";
		Statement preparedStatement;
		
		List<Integer> listOfAll = new ArrayList<Integer>();
		
		try {
			preparedStatement = dbConnection.createStatement();
			ResultSet result = preparedStatement.executeQuery(s);
			while (result.next()) {
				Integer i = new Integer(result.getString("IDALBUM"));
				listOfAll.add(i);
			}
			dbConnection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		Random rng = new Random();
		Set<Integer> setOfThree = new LinkedHashSet<Integer>(); // with Set we will have no duplicates
		while (setOfThree.size() < 3) {
		    Integer next = rng.nextInt(listOfAll.size());
		    setOfThree.add(next);
		}

		return setOfThree;
	}
	
	public int getRandomPhoto(int nrAlbum) {
		List<Integer> listOfAll = new ArrayList<Integer>();
		
		OracleJDBC oracleJDBC = new OracleJDBC();
		Connection dbConnection = oracleJDBC.getConnection();
		String s = "SELECT IDPHOTO FROM CONTIENT WHERE IDALBUM = ?";
		try {
			PreparedStatement preparedStatement = dbConnection
					.prepareStatement(s);

			preparedStatement.setInt(1, nrAlbum);

			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				Integer i = new Integer(result.getString("IDPHOTO"));
				listOfAll.add(i);
			}
			dbConnection.close();

		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
		
		Random rng = new Random();
		int randomNumber = rng.nextInt(listOfAll.size());
		
		return randomNumber;

	}
}

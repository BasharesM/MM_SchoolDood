package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;

import com.mysql.jdbc.PreparedStatement;

import entities.Doodle;
import entities.Doodles;
import entities.Email;
import entities.Emails;



public class DoodleRepository extends AbstractRepository{

	public DoodleRepository() {
		super("doodles");
	}

	public int save(int uid, int caid, int status, String question) {
		try {
			String sql = "INSERT INTO `doodles`(`uid`, `caid`, `status`, `question`, `token`) VALUES (?, ?, ?, ?, ?)" ;
    		
			PreparedStatement preparedStatement =
					(PreparedStatement) this.connexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date now = new Date();
			String dateStr = DigestUtils.sha1Hex(dateFormat.format(now));
						
			preparedStatement.setInt(1, uid);
			preparedStatement.setInt(2, caid);
			preparedStatement.setInt(3, status); 
			preparedStatement.setString(4, question);
			preparedStatement.setString(5, dateStr);
			
			int rowAffected = preparedStatement.executeUpdate();
			
					
		     if (rowAffected == 0) {
		    	 throw new SQLException("Creating user failed, no rows affected.");
		     }
			
			  try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
		            if (generatedKeys.next()) {
		                return (int) generatedKeys.getLong(1);
		            }
		            else {
		                throw new SQLException("Creating user failed, no ID obtained.");
		            }
		        }
			
		} catch (Exception e) {
			System.err.println(e.toString());
		}
		
		return 0;	
	}
	
	public Doodle findById(int did) {
		try {
			String sql = "SELECT * FROM doodles WHERE did=?;" ;
    		
			PreparedStatement preparedStatement =
					(PreparedStatement) this.connexion.prepareStatement(sql);
						
			preparedStatement.setInt(1, did);
			
			ResultSet item = preparedStatement.executeQuery();
			
			if (item.next()) {
				return new Doodle(
							Integer.parseInt(item.getString("did")), 
							Integer.parseInt(item.getString("uid")),
							Integer.parseInt(item.getString("caid")), 
							Integer.parseInt(item.getString("status")), 
							item.getString("question"), 
							item.getString("token"));
			}
		} catch (Exception e) {
			System.err.println(e.toString());
		}
	
		return null;
	}
	
	/**
	 * Récupération des doodles d'un utilisateur
	 * 
	 * @param uid
	 * @return doodles
	 */
	public Doodles findAllByUserId(int uid) {
		try {
			String sql = "select * from doodles where uid=? " ;
		        		
			PreparedStatement preparedStatement =
					(PreparedStatement) this.connexion.prepareStatement(sql);

			preparedStatement.setInt(1, uid);
			
			ResultSet item = preparedStatement.executeQuery();

			Doodles doodles = new Doodles();
			
			while (item.next()){
				Doodle doodle = new Doodle(Integer.parseInt(item.getString("did")), Integer.parseInt(item.getString("uid")), Integer.parseInt(item.getString("caid")), Integer.parseInt(item.getString("status")), item.getString("question"), item.getString("token"));
								
				doodles.push(doodle);
			}
			
			return doodles;
		} catch (Exception e) {
			System.err.println(e.toString());
		}
		
		return null;
	}
	
	/**
	 * Vérifie si un user est propriétaire d'un doodle
	 * 
	 * @param did
	 * @param uid
	 * @return boolean
	 * @throws SQLException
	 */
	public boolean checkIfAuthor(int did, int uid) throws SQLException {
		String sql = "select did from doodles where uid=? and did=? " ;
	        		
		PreparedStatement preparedStatement =
				(PreparedStatement) this.connexion.prepareStatement(sql);

		preparedStatement.setInt(1, uid);
		preparedStatement.setInt(2, did);
		
		ResultSet item = preparedStatement.executeQuery();
		
		return item.first();
	}
}

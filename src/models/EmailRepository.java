package models;

import java.sql.ResultSet;

import org.apache.commons.codec.digest.DigestUtils;

import com.mysql.jdbc.PreparedStatement;

import entities.Email;
import entities.User;

public class EmailRepository extends AbstractRepository {

	public EmailRepository() {
		super("doodle_emails");
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Insertion d'un email pour un utilisateur en BDD
	 * 
	 * @param int uid
	 * @param String email
	 * 
	 * @return boolean
	 */
	public boolean insert(int uid, String email) {
		try {
 	        
			String sql = "INSERT INTO `doodle_emails`(`uid`, `email`) VALUES (?,?)" ;
		        		
			PreparedStatement preparedStatement =
					(PreparedStatement) this.connexion.prepareStatement(sql);

			preparedStatement.setInt(1, uid);
			preparedStatement.setString(2, email);

			int rowsAffected = preparedStatement.executeUpdate();
		        			
			if (rowsAffected > 0){
				return true;
			}
		} catch (Exception e) {
			System.err.println(e.toString());
		}
		
		return false;
	}

}

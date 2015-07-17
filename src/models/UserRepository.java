package models;

import java.sql.ResultSet;

import org.apache.commons.codec.digest.DigestUtils;

import com.mysql.jdbc.PreparedStatement;

import entities.User;

public class UserRepository extends AbstractRepository {
		
	public UserRepository() {
		super("users");
	}
	
	public boolean save(String first_name, String last_name, String email, String password) {
		
		try {
			String sql = "insert into users (first_name, last_name, email, password) value (?,?,?,?);";
			
			PreparedStatement preparedStatement = 
					(PreparedStatement) this.connexion.prepareStatement(sql);
			
			preparedStatement.setString(1, first_name);
			preparedStatement.setString(2, last_name);
			preparedStatement.setString(3, email);
			preparedStatement.setString(4, DigestUtils.sha1Hex(password));
			
			if (preparedStatement.executeUpdate() == 1) {
				return true;
			}
		} catch (Exception e) {
			System.err.println(e.toString());
		}
		return false;
	}
	
	public User login(String username, String password) {
				
		try {
		 	        
			String sql = "select * from users where first_name=? and password=?;" ;
		        		
			PreparedStatement preparedStatement =
					(PreparedStatement) this.connexion.prepareStatement(sql);

			preparedStatement.setString(1, username);
			preparedStatement.setString(2, DigestUtils.sha1Hex(password));

			ResultSet item = preparedStatement.executeQuery();
		        
			if (item.next()){
				User user = new User(
						item.getInt("uid"),
						item.getString("first_name"),
						item.getString("last_name"),
						item.getString("password"),
						item.getString("email")
				);
				
				return user;
			}
		} catch (Exception e) {
			System.err.println(e.toString());
		}
		
		return null;
	}
}

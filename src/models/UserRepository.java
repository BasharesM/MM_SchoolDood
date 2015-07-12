package models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.codec.digest.DigestUtils;

import com.mysql.jdbc.PreparedStatement;

import entities.User;
import utils.MysqlDriver;

public class UserRepository {
		
	public User login(String username, String password) {
		
		java.sql.Connection connexion = null;
		
		try {
		   
			MysqlDriver driver = MysqlDriver.getDriver();
			connexion = driver.getConnector();
		        
			String sql = "select * from users where first_name=? and password=?;" ;
		        		
			PreparedStatement preparedStatement =
					(PreparedStatement) connexion.prepareStatement(sql);

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
				
				driver.disconnect();
				return user;
			}
		} catch (Exception e) {
			if (connexion != null) {
				try {
					connexion.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			System.out.println(e.toString());
		}
		
		return null;
	}
}

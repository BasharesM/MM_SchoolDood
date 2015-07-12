package models;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.codec.digest.DigestUtils;

import com.mysql.jdbc.PreparedStatement;

import entities.User;

public class UserRepository {
		
	public User login(String username, String password) {
		
		try {

		    Class.forName( "com.mysql.jdbc.Driver" );
		   
		    /* Connexion à la base de données */
		    String url = "jdbc:mysql://localhost:3306/school_doodle";
		    String utilisateur = "root";
		    String motDePasse = "root";
		    java.sql.Connection connexion = null;
		    try {
		        connexion = DriverManager.getConnection( url, utilisateur, motDePasse );

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
		        	return user;
		        }
		        else {
		        	return null;		        	
		        }

		    } catch ( SQLException e ) {

		        System.out.println("cerise !! " + e.toString());

		        /* Gérer les éventuelles erreurs ici */
		    } finally {
		        if ( connexion != null )
		            try {
		                connexion.close();
		            } catch ( SQLException ignore ) {

				        System.out.println("poire ! ");

		            }
		    }

		} catch ( ClassNotFoundException e ) {

	        System.out.println("pomme! ");


		}
		
		return null;
	}
}

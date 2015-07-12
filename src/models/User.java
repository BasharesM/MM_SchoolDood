package models;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.codec.digest.DigestUtils;

import com.mysql.jdbc.PreparedStatement;

public class User {
	private int uid;
	private String first_name;
	private String last_name;
	private String password;
	private String email;
	
	public User(int uid, String first_name, String last_name, String password, String email) {
		super();
		this.uid = uid;
		this.first_name = first_name;
		this.last_name = last_name;
		this.password = password;
		this.email = email;
	}
	
	public User() {
		super();
		this.uid = 0;
		this.first_name = "";
		this.last_name = "";
		this.password = "";
		this.email = "";
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean login(String username, String password) {
		
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

		        ResultSet user = preparedStatement.executeQuery();
		        		
		        if (user.next()){
		        	this.uid = user.getInt("uid");
		        	this.first_name = user.getString("first_name");
		        	this.last_name = user.getString("last_name");
		        	this.password = user.getString("password");
		        	this.email = user.getString("email");
		        	
		        	return true;
		        }
		        else {
		        	return false;		        	
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
		
		return true;
	}
}

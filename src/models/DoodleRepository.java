package models;

import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;

import com.mysql.jdbc.PreparedStatement;



public class DoodleRepository extends AbstractRepository{

	public DoodleRepository() {
		super("doodles");
	}

	public boolean save(int uid, int caid, int status, String question) {
		try {
			String sql = "INSERT INTO `doodles`(`uid`, `caid`, `status`, `question`, `token`) VALUES (?, ?, ?, ?, ?)" ;
    		
			PreparedStatement preparedStatement =
					(PreparedStatement) this.connexion.prepareStatement(sql);

			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date now = new Date();
			String dateStr = DigestUtils.sha1Hex(dateFormat.format(now));
						
			preparedStatement.setInt(1, uid);
			preparedStatement.setInt(2, caid);
			preparedStatement.setInt(3, status); 
			preparedStatement.setString(4, question);
			preparedStatement.setString(5, dateStr);
			
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

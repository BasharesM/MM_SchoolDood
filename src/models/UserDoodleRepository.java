package models;

import com.mysql.jdbc.PreparedStatement;

public class UserDoodleRepository extends AbstractRepository{

	public UserDoodleRepository() {
		super("users_doodle");
	}
	
	public boolean save(int did, int aid, int daid, String name) {
		
		try {
			String sql = "insert into users_doodle (did, aid, daid, name) value (?,?,?,?);";
			
			PreparedStatement preparedStatement = 
					(PreparedStatement) this.connexion.prepareStatement(sql);
			
			preparedStatement.setInt(1, did);
			preparedStatement.setInt(2, aid);
			preparedStatement.setInt(3, daid);
			preparedStatement.setString(4, name);
			
			if (preparedStatement.executeUpdate() == 1) {
				return true;
			}
		} catch (Exception e) {
			System.err.println(e.toString());
		}
		return false;
	}
}

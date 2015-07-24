package models;

import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import com.mysql.jdbc.PreparedStatement;

import entities.Answer;
import entities.Answers;
import entities.Date;
import entities.Dates;

public class DateRepository extends AbstractRepository{

	public DateRepository() {
		super("dates	");
	}

	public Dates findAllByDoodleId(int did) {
		try {
			String sql = "SELECT * FROM dates WHERE did=?;" ;
    		
			PreparedStatement preparedStatement =
					(PreparedStatement) this.connexion.prepareStatement(sql);
						
			preparedStatement.setInt(1, did);
			
			ResultSet item = preparedStatement.executeQuery();
			
			Date date = new Date();
			Dates dates = new Dates();
			
			while (item.next()) {
				date = new Date(Integer.parseInt(item.getString("daid")), Integer.parseInt(item.getString("did")), item.getString("date"), item.getString("heure"));
		
				dates.push(date);
			}
			
			return dates;
		} catch (Exception e) {
			System.err.println(e.toString());
		}
	
		return null;
	}

	public boolean saveAll(Dates dates) {
		boolean status = true;
		
		try {
			for (int i = 0 ; i < dates.size() ; i++) {
				Date date = dates.get(i);
				
				String sql = "INSERT INTO dates (did, heure, date) VALUES (?, ?, ?);";
				
				PreparedStatement preparedStatement = (PreparedStatement) this.connexion.prepareStatement(sql);
					
				preparedStatement.setInt(1, date.getDid());
				preparedStatement.setString(2, date.getHeure());
				preparedStatement.setString(3, date.getDate());
				
				int rowsAffected = preparedStatement.executeUpdate();
				
				if (rowsAffected != 1) {
					status = false;
				}
			}
		} catch (Exception e) {
			System.err.println(e.toString());
		}
		
		return status;
	}
}

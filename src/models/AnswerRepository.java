package models;

import java.sql.ResultSet;

import com.mysql.jdbc.PreparedStatement;

import entities.Answer;
import entities.Answers;

public class AnswerRepository extends AbstractRepository{

	public AnswerRepository() {
		super("answers");
	}
	
	public Answers findAllByCatId(int caid) {
		try {
			String sql = "SELECT * FROM answers WHERE caid=?;" ;
    		
			PreparedStatement preparedStatement =
					(PreparedStatement) this.connexion.prepareStatement(sql);
			
			preparedStatement.setInt(1, caid);
			
			ResultSet item = preparedStatement.executeQuery();
			
			Answer answer = new Answer();
			Answers answers = new Answers();
			
			while (item.next()) {
				answer = new Answer(
							Integer.parseInt(item.getString("aid")), 
							Integer.parseInt(item.getString("caid")),
							Integer.parseInt(item.getString("caid")),
							item.getString("label"));
				
				answers.push(answer);
			}
			
			return answers;
		} catch (Exception e) {
			System.err.println(e.toString());
		}
	
		return null;
	}
}

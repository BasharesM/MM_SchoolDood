package models;

import java.sql.ResultSet;
import java.util.HashMap;

import com.mysql.jdbc.PreparedStatement;

import entities.Answer;
import entities.AnswerResult;
import entities.AnswerResults;
import entities.Answers;
import entities.Doodle;
import entities.Doodles;

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
	
	public AnswerResults getAllByDid(int did) {
		try {
			String sql = "select count(users_doodle.did) as nb, aid, daid, label, date, heure from users_doodle LEFT JOIN answers USING(aid) LEFT JOIN dates USING(daid) where users_doodle.did=? GROUP BY aid,daid" ;
		        		
			PreparedStatement preparedStatement =
					(PreparedStatement) this.connexion.prepareStatement(sql);

			preparedStatement.setInt(1, did);
			
			ResultSet item = preparedStatement.executeQuery();

			AnswerResults results = new AnswerResults();
			AnswerResult row = new AnswerResult();
			
			while (item.next()){
				row = new AnswerResult(
							item.getString("nb"), 
							item.getString("aid"), 
							item.getString("daid"), 
							item.getString("heure"), 
							item.getString("label"), 
							item.getString("date"));
				
				results.push(row);
				
			} 
			
			return results;
		} catch (Exception e) {
			System.err.println(e.toString());
		}
		
		return null;
	}
}

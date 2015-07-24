package models;

import java.sql.ResultSet;

import com.mysql.jdbc.PreparedStatement;

import entities.Answer;
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
	
//	public String[] getAllByDid(int did) {
//		try {
//			String sql = "select count(users_doodle.did) as nb, label, date from users_doodle LEFT JOIN answers USING(aid) LEFT JOIN dates USING(daid) where users_doodle.did=? GROUP BY aid,daid" ;
//		        		
//			PreparedStatement preparedStatement =
//					(PreparedStatement) this.connexion.prepareStatement(sql);
//
//			preparedStatement.setInt(1, did);
//			
//			ResultSet item = preparedStatement.executeQuery();
//
//			String[][] array;
//			
//			while (item.next()){
//				Doodle doodle = new Doodle(Integer.parseInt(item.getString("did")), Integer.parseInt(item.getString("uid")), Integer.parseInt(item.getString("caid")), Integer.parseInt(item.getString("status")), item.getString("question"), item.getString("token"));
//								
//				array.push(item.getString("nb"));
//				array = item.getString("aid");
//				array = item.getString("daid");
//			}
//			
//			return doodles;
//		} catch (Exception e) {
//			System.err.println(e.toString());
//		}
//		
//		return null;
//	}
}

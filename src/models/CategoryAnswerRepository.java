package models;

import java.sql.ResultSet;

import org.apache.commons.codec.digest.DigestUtils;

import com.mysql.jdbc.PreparedStatement;

import entities.CategoryAnswer;
import entities.CategoryAnswers;
import entities.User;

public class CategoryAnswerRepository extends AbstractRepository{

	public CategoryAnswerRepository() {
		super("categories_answers");
	}

	public CategoryAnswers findAll() {
		try {
 	        
			String sql = "select * from categories_answers;" ;
		        		
			PreparedStatement preparedStatement =
					(PreparedStatement) this.connexion.prepareStatement(sql);

			ResultSet item = preparedStatement.executeQuery();

			CategoryAnswers categories = new CategoryAnswers();
			
			while (item.next()){
				CategoryAnswer category = new CategoryAnswer(Integer.parseInt(item.getString("caid")), item.getString("label"));
								
				categories.push(category);
			}
			
			return categories;
		} catch (Exception e) {
			System.err.println(e.toString());
		}
		
		return null;	
	}
}

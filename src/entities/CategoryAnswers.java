package entities;

import java.util.LinkedList;

public class CategoryAnswers {

	private LinkedList<CategoryAnswer> categories; 
	
	public CategoryAnswers() {
		this.categories = new LinkedList<CategoryAnswer>();
	}
	
	public void push(CategoryAnswer category) {
		this.categories.push(category);
	}

	public void remove(int index) {
		this.categories.remove(index);
	}
	
	public CategoryAnswer get(int index) {
		return this.categories.get(index);
	}
	
	public int size(){
		return this.categories.size();
	}
}

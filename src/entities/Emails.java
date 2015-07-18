package entities;

import java.util.LinkedList;

public class Emails {

	private LinkedList<Email> categories; 
	
	public Emails() {
		this.categories = new LinkedList<Email>();
	}
	
	public void push(Email category) {
		this.categories.push(category);
	}

	public void remove(int index) {
		this.categories.remove(index);
	}
	
	public Email get(int index) {
		return this.categories.get(index);
	}
	
	public int size(){
		return this.categories.size();
	}
}

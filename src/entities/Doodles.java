package entities;

import java.util.LinkedList;

public class Doodles {

	private LinkedList<Doodle> categories; 
	
	public Doodles() {
		this.categories = new LinkedList<Doodle>();
	}
	
	public void push(Doodle category) {
		this.categories.push(category);
	}

	public void remove(int index) {
		this.categories.remove(index);
	}
	
	public Doodle get(int index) {
		return this.categories.get(index);
	}
	
	public int size(){
		return this.categories.size();
	}
}

package entities;

import java.util.LinkedList;

public class UserDoodles {

	private LinkedList<UserDoodle> user_doodles; 
	
	public UserDoodles() {
		this.user_doodles = new LinkedList<UserDoodle>();
	}
	
	public void push(UserDoodle category) {
		this.user_doodles.push(category);
	}

	public void remove(int index) {
		this.user_doodles.remove(index);
	}
	
	public UserDoodle get(int index) {
		return this.user_doodles.get(index);
	}
	
	public int size(){
		return this.user_doodles.size();
	}
}

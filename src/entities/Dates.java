package entities;

import java.util.LinkedList;

import entities.Date;

public class Dates {

	private LinkedList<Date> dates; 
	
	public Dates() {
		this.dates = new LinkedList<Date>();
	}
	
	public void push(Date date) {
		this.dates.push(date);
	}

	public void remove(int index) {
		this.dates.remove(index);
	}
	
	public Date get(int index) {
		return this.dates.get(index);
	}
	
	public int size(){
		return this.dates.size();
	}
}

package entities;

import java.util.LinkedList;

public class Answers {

	private LinkedList<Answer> answers; 
	
	public Answers() {
		this.answers = new LinkedList<Answer>();
	}
	
	public void push(Answer answer) {
		this.answers.push(answer);
	}

	public void remove(int index) {
		this.answers.remove(index);
	}
	
	public Answer get(int index) {
		return this.answers.get(index);
	}
	
	public int size(){
		return this.answers.size();
	}
}

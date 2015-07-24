package entities;

import java.util.LinkedList;

public class AnswerResults {

	private LinkedList<AnswerResult> answers; 
	
	public AnswerResults() {
		this.answers = new LinkedList<AnswerResult>();
	}
	
	public void push(AnswerResult answer) {
		this.answers.push(answer);
	}

	public void remove(int index) {
		this.answers.remove(index);
	}
	
	public AnswerResult get(int index) {
		return this.answers.get(index);
	}
	
	public int size(){
		return this.answers.size();
	}
}

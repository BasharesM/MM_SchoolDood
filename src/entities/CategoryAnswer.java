package entities;

public class CategoryAnswer {

	private int caid;
	private String label;
	
	public CategoryAnswer(int caid, String label) {
		this.caid = caid;
		this.label = label;
	}
	
	public CategoryAnswer() {
		this.caid = 0;
		this.label = "";		
	}

	public int getCaid() {
		return caid;
	}

	public void setCaid(int caid) {
		this.caid = caid;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}

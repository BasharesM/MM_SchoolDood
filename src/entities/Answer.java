package entities;

public class Answer {

	private int aid;
	private int caid;
	private int daid;
	private String label;
	
	public Answer() {
		this.aid = 0;
		this.caid = 0;
		this.daid = 0;
		this.label = "";
	}
	
	public Answer(int aid, int caid, int daid, String label) {
		this.aid = aid;
		this.caid = caid;
		this.daid = daid;
		this.label = label;
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

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public int getDaid() {
		return daid;
	}

	public void setDaid(int daid) {
		this.daid = daid;
	}
}

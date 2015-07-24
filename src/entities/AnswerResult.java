package entities;

public class AnswerResult {
	private String count;
	private String aid;
	private String daid;
	private String label;
	private String date;
	private String heure;
	
	public AnswerResult(){
	}
	
	public AnswerResult(String count, String aid, String daid, String label, String date, String heure) {
		this.count = count;
		this.aid = aid;
		this.daid = daid;
		this.heure = heure;
		this.label = label;
		this.date = date;
	}

	public String getCount() {
		return count;
	}


	public void setCount(String count) {
		this.count = count;
	}


	public String getAid() {
		return aid;
	}


	public void setAid(String aid) {
		this.aid = aid;
	}


	public String getDaid() {
		return daid;
	}


	public void setDaid(String daid) {
		this.daid = daid;
	}


	public String getLabel() {
		return label;
	}


	public void setLabel(String label) {
		this.label = label;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getHeure() {
		return heure;
	}


	public void setHeure(String heure) {
		this.heure = heure;
	}

}

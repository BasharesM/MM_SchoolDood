package entities;

public class Date {

	private int daid;
	private int did;
	private String date;
	private String heure;
	
	public Date() {
		this.daid = 0;
		this.did = 0;
		this.date = "";
		this.heure = "";
	}

	public Date(int did, String heure, String date){
		this.date = date;
		this.heure = heure;
		this.did = did;
	}
	
	public Date(int daid, int did, String date, String heure) {
		this.daid = daid;
		this.did = did;
		this.date = date;
		this.heure = heure;
	}
	
	public int getDaid() {
		return daid;
	}

	public void setDaid(int daid) {
		this.daid = daid;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
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

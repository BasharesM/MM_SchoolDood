package entities;

public class Doodle {

	private int did;
	private int uid;
	private int caid;
	private String question;
	private String token;
	private boolean status;
	
	public Doodle() {
		this.did = 0;
		this.uid = 0;
		this.question = "";
		this.caid = 0;
		this.token = "";
		this.status = false;
	}
	
	public Doodle(int did, int uid, int caid, boolean status, String question, String token) {
		this.did = did;
		this.uid = uid;
		this.question = question;
		this.caid = caid;
		this.token = token;
		this.status = status;		
	}
	
	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public int getCaid() {
		return caid;
	}

	public void setCaid(int caid) {
		this.caid = caid;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}

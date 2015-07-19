package entities;

public class Doodle {

	private int did;
	private int uid;
	private int caid;
	private int status;
	private String question;
	private String token;
	
	public Doodle() {
		this.did = 0;
		this.uid = 0;
		this.question = "";
		this.caid = 0;
		this.token = "";
		this.status = 0;
	}
	
	public Doodle(int did, int uid, int caid, int status, String question, String token) {
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}

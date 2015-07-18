package entities;

public class Email {
	private int eid;
	private int uid;
	private String email;
	
	public Email(int eid, int uid, String email) {
		this.eid = eid;
		this.uid = uid;
		this.email = email;
	}
	
	public Email() {
		this.eid = 0;
		this.uid = 0;
		this.email = "";
	}
	
	public int getEid() {
		return eid;
	}
	
	public void setEid(int eid) {
		this.eid = eid;
	}
	
	public int getUid() {
		return uid;
	}
	
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
}

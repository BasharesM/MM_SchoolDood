package entities;

public class UserDoodle {

	private int did;
	private int aid;
	private int daid;
	private String name;

	public UserDoodle() {
		this.did = 0;
		this.aid = 0;
		this.daid = 0;
		this.name = "";
	}
	
	public UserDoodle(int did, int aid, int daid, String name) {
		this.did = did;
		this.aid = aid;
		this.daid = daid;
		this.name = name;
	}
	
	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

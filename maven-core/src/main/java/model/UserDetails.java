package model;

public class UserDetails {
	private int id;
	private String name;
	private String mobileNumber;
	private String setPassword;

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ",name=" + name + ", mobileNumber=" + mobileNumber + ", setPassword=" + setPassword + "]";
	}

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String phone_number) {
		this.mobileNumber = phone_number;
		
	}
	public String getSetPassword() {
		return setPassword;
	}

	public void setSetPassword(String setPassword) {
		this.setPassword = setPassword;
	}

	
}

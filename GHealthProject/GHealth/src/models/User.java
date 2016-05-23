package models;

import com.j256.ormlite.field.DatabaseField;

public abstract class User extends Person {
	@DatabaseField()
	private String pass;
	
	@DatabaseField()
	private boolean isOnline;
	
	public boolean isOnline() {
		return isOnline;
	}
	public void setOnline(boolean isOnline) {
		this.isOnline = isOnline;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	} 
	
}

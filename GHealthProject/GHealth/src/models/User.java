package models;

import com.j256.ormlite.field.DatabaseField;

public abstract class User extends Person {
	@DatabaseField()
	private String pass;
	
	@DatabaseField()
	private boolean isLocked;
	
	public boolean isLocked() {
		return isLocked;
	}
	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	} 
	
}

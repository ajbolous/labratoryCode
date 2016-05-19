package models;

import com.j256.ormlite.field.DatabaseField;

public abstract class User extends Person {
	@DatabaseField()
	private String pass ;
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	} 
	
}

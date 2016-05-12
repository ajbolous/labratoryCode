package models;

import Orm.*;

@extensionTable(table="persons", field="sid")
public class User extends Person {
	@dataField
	private String pass ;

	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	} 
	
}

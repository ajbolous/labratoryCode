package models;

import java.sql.Date;

import Orm.*;

public class Person extends Entity{
	
	public static final String tableName = "persons";
	
	@dataField
	@pkField
	private String sid;
	
	@dataField
	private String lastName;
	@dataField
	private String firstName;
	@dataField
	private Date birthDate;
	@dataField
	private String email;
	@dataField
	private String phone;

	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}

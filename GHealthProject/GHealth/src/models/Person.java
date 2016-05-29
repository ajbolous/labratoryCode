package models;

import java.util.Date;



import com.j256.ormlite.field.DatabaseField;

public abstract class Person extends Entity{
	@DatabaseField(id = true)
	private String sid;
	
	@DatabaseField()
	private String lastName;
	
	@DatabaseField()
	private String firstName;
	
	@DatabaseField()
	private Date birthDate;
	
	@DatabaseField()
	private String email;
	
	@DatabaseField()
	private String phone;
	
	@DatabaseField()
	private String address;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
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
	public void setBirthDate(Date date) {
		this.birthDate =  date;
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

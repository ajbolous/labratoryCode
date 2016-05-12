package models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class Person extends Entity{
	private String sid;
	private String lastName;
	private String firstName;
	private Date birthDate;
	private String email;
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

	public static boolean createTable(Connection connection) throws SQLException{
		
		Statement stmt = connection.createStatement();
		stmt.execute("CREATE TABLE persons("
				+ "sid VARCHAR(50),"
				+ "firstName VARCHAR(50),"
				+ "lastName VARCHAR(50),"
				+ "birthdate DATE,"
				+ "email VARCHAR(50),"
				+ "phone VARCHAR(50),"
				+ "PRIMARY KEY(sid))");
		stmt.close();
		return true;
	}
	public boolean update(Connection connection) throws SQLException {
		PreparedStatement s = connection.prepareStatement(
				"UPDATE persons"
				+ " SET"
				+ " firstName=?"
				+ " lastName=?"
				+ " birthdate=?"
				+ " email=?"
				+ " phone=?"
				+ " where sid=?");
		s.setString(1, firstName);
		s.setString(2, lastName);
		s.setDate(3, birthDate);
		s.setString(4, email);
		s.setString(5, phone);
		s.setString(6, getSid());
		return s.execute();
	}
	
	
	public boolean delete(Connection connection) throws SQLException {
		PreparedStatement s = connection.prepareStatement(
				"DELETE from persons"
				+ " where sid=?");
		s.setString(1, getSid());
		return s.execute();
	}
	
	
	public boolean save(Connection connection) throws SQLException {
		PreparedStatement s = connection.prepareStatement(
				"INSERT into persons"
				+ " VALUES(?,?,?,?,?,?)");
		s.setString(1, sid);
		s.setString(2, firstName);
		s.setString(3, lastName);
		s.setString(4, email);
		s.setDate(5, birthDate);
		s.setString(6, phone);
		return s.execute();
	}
	
}

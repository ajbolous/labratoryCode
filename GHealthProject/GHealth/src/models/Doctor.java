package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Doctor extends Person{
	private String speciality;
	private ArrayList<Shift> shifts;

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public ArrayList<Shift> getShifts() {
	
		return shifts;
	}

	public void setShifts(ArrayList<Shift> shifts) {
		this.shifts = shifts;
	}

	
	public static boolean createTable(Connection connection) throws SQLException {
		Statement stmt = connection.createStatement();
		stmt.execute("CREATE TABLE doctors("
				+ "sid VARCHAR(50),"
				+ "speciality varchar(50),"
				+ "PRIMARY KEY(sid),"
				+ "FOREIGN KEY(sid) REFERENCES persons(sid));");
		stmt.close();
		return true;
	}
	
	public boolean update(Connection connection) throws SQLException {
		super.update(connection);
		PreparedStatement s = connection.prepareStatement(
				"UPDATE doctors"
				+ " SET"
				+ " speciality=?"
				+ " where sid=?");
		s.setString(1, getSpeciality());
		s.setString(2, getSid());
		return s.execute();
	}

	public boolean delete(Connection connection) throws SQLException {
		super.delete(connection);
		PreparedStatement s = connection.prepareStatement(
				"DELETE from doctors"
				+ " where sid=?");
		s.setString(2, getSid());
		return s.execute();
	}

	public boolean save(Connection connection) throws SQLException {
		super.save(connection);
		PreparedStatement s = connection.prepareStatement(
				"INSERT into doctors"
				+ " VALUES(?,?)");
		s.setString(1, getSid());
		s.setString(2, getSpeciality());
		return s.execute();
	}



	

}

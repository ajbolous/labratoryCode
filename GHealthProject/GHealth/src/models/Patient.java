package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Patient extends Person{
	private float weight;
	private float height ;
	private String gender;
	private ArrayList<Referral> referrals; 
	private InformationFromHMo information ; 
	private MedicalRecord medicalRecord ;
	
	public static boolean createTable(Connection connection) throws SQLException {
		Statement stmt = connection.createStatement();
		stmt.execute("CREATE TABLE patients("
				+ "sid VARCHAR(50) REFERENCES persons(sid),"
				+ "height FLOAT,"
				+ "weight FLOAT,"
				+ "gender varchar(50),"
				+ "PRIMARY KEY(sid),"
				+ "FOREIGN KEY(sid) REFERENCES persons(sid))");
		stmt.close();
		return true;
	} 
	
	public boolean update(Connection connection) throws SQLException {
		super.update(connection);
		PreparedStatement s = connection.prepareStatement(
				"UPDATE patients"
				+ " SET"
				+ " weight=?"
				+ " height=?"
				+ " gender=?"
				+ " where sid=?");
		s.setFloat(1, weight);
		s.setFloat(1, height);
		s.setString(2, gender);
		return s.execute();
	}

	public boolean delete(Connection connection) throws SQLException {
		super.delete(connection);
		PreparedStatement s = connection.prepareStatement(
				"DELETE from patients"
				+ " where sid=?");
		s.setString(2, getSid());
		return s.execute();
	}

	public boolean save(Connection connection) throws SQLException {
		super.save(connection);
		PreparedStatement s = connection.prepareStatement(
				"INSERT into patients"
				+ " VALUES(?,?,?,?,?)");
		s.setString(1, getSid());
		s.setFloat(2, weight);
		s.setFloat(2, height);
		s.setString(2, gender);
		return s.execute();
	}

	
	
}

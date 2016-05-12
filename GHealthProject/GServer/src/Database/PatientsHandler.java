package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.Doctor;
import models.Entity;
import models.Patient;
import models.Person;
import Server.Config;

public class PatientsHandler extends AbstractHandler implements Persistable<Patient> {

	public PatientsHandler(Connection con) {
		super(con);
	}

	public boolean createTable() {
		try {
			Statement stmt = getConnection().createStatement();
			stmt.execute("CREATE TABLE patients(" + "sid VARCHAR(50) REFERENCES persons(sid)," + "height FLOAT,"
					+ "weight FLOAT," + "gender varchar(50)," + "PRIMARY KEY(sid),"
					+ "FOREIGN KEY(sid) REFERENCES persons(sid))");
			stmt.close();
			return true;
		} catch (SQLException e) {
			Config.getConfig().getLogger().exception(e);
			return false;
		}
	}

	public ArrayList<Patient> getAll() {
		try {
			ArrayList<Patient> doctors = new ArrayList<Patient>();
			Statement stmt = getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("select * from doctors");
			while (rs.next()) {
				Patient p = new Patient();
				p.setFirstName(rs.getString(1));
				p.setLastName(rs.getString(2));
				doctors.add(p);
			}
			rs.close();
			return doctors;
		} catch (SQLException e) {
			Config.getConfig().getLogger().exception(e);
			return null;
		}
	}

	public boolean update(Patient p) {
		try {
			PreparedStatement s = getConnection().prepareStatement(
					"UPDATE patients" + " SET" + " weight=?" + " height=?" + " gender=?" + " where sid=?");
			s.setFloat(1, p.getWeight());
			s.setFloat(2, p.getHeight());
			s.setString(3, p.getGender());
			s.setString(4, p.getSid());
			return s.execute();
		} catch (SQLException e) {
			Config.getConfig().getLogger().exception(e);
			return false;
		}
	}

	public boolean delete(Patient p) {
		try {
			PreparedStatement s = getConnection().prepareStatement("DELETE from patients" + " where sid=?");
			s.setString(2, p.getSid());
			return s.execute();
		} catch (SQLException e) {
			Config.getConfig().getLogger().exception(e);
			return false;
		}
	}

	public boolean save(Patient p) {
		try {
			PreparedStatement s = getConnection().prepareStatement("INSERT into patients" + " VALUES(?,?,?,?)");
			s.setString(1, p.getSid());
			s.setFloat(2, p.getWeight());
			s.setFloat(3, p.getHeight());
			s.setString(4, p.getGender());
			return s.execute();
		} catch (SQLException e) {
			Config.getConfig().getLogger().exception(e);
			return false;
		}
	}

}

package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.Doctor;
import models.Entity;
import models.Person;
import Server.Config;

public class DoctorsHandler extends AbstractHandler implements Persistable<Doctor> {

	public DoctorsHandler(Connection con) {
		super(con);
	}

	public boolean createTable() {
		try {

			Statement stmt = getConnection().createStatement();
			stmt.execute("CREATE TABLE doctors(sid VARCHAR(50),speciality varchar(50), PRIMARY KEY(sid),FOREIGN KEY(sid) REFERENCES persons(sid));");
			stmt.close();
			return true;
		} catch (SQLException e) {
			Config.getConfig().getLogger().exception(e);
			return false;
		}
	}

	public ArrayList<Doctor> getAll() {
		try {

			ArrayList<Doctor> doctors = new ArrayList<Doctor>();
			Statement stmt = getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("select * from doctors");
			while (rs.next()) {
				Doctor d = new Doctor();
				d.setFirstName(rs.getString(1));
				d.setLastName(rs.getString(2));
				doctors.add(d);
			}
			rs.close();
			return doctors;
		} catch (SQLException e) {
			Config.getConfig().getLogger().exception(e);
			return null;
		}
	}

	public boolean update(Doctor d) {
		PreparedStatement s;
		try {
			Config.getConfig().getHandler().getPersonsHandler().update(d);
			s = getConnection().prepareStatement("UPDATE doctors SET speciality=? where sid=?");
			s.setString(1, d.getSpeciality());
			s.setString(2, d.getSid());
			return s.execute();
		} catch (SQLException e) {
			Config.getConfig().getLogger().exception(e);
			return false;
		}
	}

	public boolean delete(Doctor d) {
		try {
			PreparedStatement s = getConnection().prepareStatement("DELETE from doctors where sid=?");
			s.setString(1, d.getSid());
			s.execute();

			Config.getConfig().getHandler().getPersonsHandler().delete(d);
			return true;
		} catch (SQLException e) {
			Config.getConfig().getLogger().exception(e);
			return false;
		}
	}

	public boolean save(Doctor d) {
		try {
			Config.getConfig().getHandler().getPersonsHandler().save(d);
			PreparedStatement s = getConnection().prepareStatement("INSERT into doctors VALUES(?,?)");
			s.setString(1, d.getSid());
			s.setString(2, d.getSpeciality());
			return s.execute();
		} catch (SQLException e) {
			Config.getConfig().getLogger().exception(e);
			return false;
		}
	}

}

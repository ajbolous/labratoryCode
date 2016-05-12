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

public class PersonsHandler extends AbstractHandler implements Persistable<Person> {

	public PersonsHandler(Connection con) {
		super(con);
	}

	public boolean createTable() {
		try {
			Statement stmt = getConnection().createStatement();
			stmt.execute(
					"CREATE TABLE persons(" + "sid VARCHAR(50)," + "firstName VARCHAR(50)," + "lastName VARCHAR(50),"
							+ "birthdate DATE," + "email VARCHAR(50)," + "phone VARCHAR(50)," + "PRIMARY KEY(sid))");
			stmt.close();
			return true;
		} catch (SQLException e) {
			Config.getConfig().getLogger().exception(e);
			return false;
		}
	}

	public ArrayList<Person> getAll() {
		return null;
	}

	public boolean update(Person p) {
		try {
			PreparedStatement s = getConnection().prepareStatement("UPDATE persons" + " SET" + " firstName=?"
					+ " lastName=?" + " birthdate=?" + " email=?" + " phone=?" + " where sid=?");
			s.setString(1, p.getFirstName());
			s.setString(2, p.getLastName());
			s.setDate(3, p.getBirthDate());
			s.setString(4, p.getEmail());
			s.setString(5, p.getPhone());
			s.setString(6, p.getSid());
			return s.execute();
		} catch (SQLException e) {
			Config.getConfig().getLogger().exception(e);
			return false;
		}
	}

	public boolean delete(Person p) {
		try {
			PreparedStatement s = getConnection().prepareStatement("DELETE from persons" + " where sid=?");
			s.setString(1, p.getSid());
			return s.execute();
		} catch (SQLException e) {
			Config.getConfig().getLogger().exception(e);
			return false;
		}
	}

	public boolean save(Person p) {
		try {
			PreparedStatement s = getConnection().prepareStatement("INSERT into persons" + " VALUES(?,?,?,?,?,?)");
			s.setString(1, p.getSid());
			s.setString(2, p.getFirstName());
			s.setString(3, p.getLastName());
			s.setDate(4, p.getBirthDate());
			s.setString(5, p.getEmail());
			s.setString(6, p.getPhone());
			return s.execute();
		} catch (SQLException e) {
			Config.getConfig().getLogger().exception(e);
			return false;
		}
	}

}

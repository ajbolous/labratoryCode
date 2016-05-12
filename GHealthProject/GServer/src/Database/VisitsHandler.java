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
import models.Visit;
import Server.Config;

public class VisitsHandler extends AbstractHandler implements Persistable<Visit> {

	public VisitsHandler(Connection con) {
		super(con);
	}

	public boolean createTable() {
		try {
			String sql = "CREATE TABLE visits("
					+ "vid INTEGER AUTO_INCREMENT, "
					+ "rid INTEGER, "
					+ "comments VARCHAR(255),"
					+ "date DATE,"
					+ "PRIMARY KEY(vid,rid),"
					+ "FOREIGN KEY(rid) REFERENCES records(rid));";
			
			Statement stmt = getConnection().createStatement();
			stmt.execute(sql);
			stmt.close();
			return true;
		} catch (SQLException e) {
			Config.getConfig().getLogger().exception(e);
			return false;
		}
	}

	public ArrayList<Visit> getAll() {
		return null;
	}

	public boolean update(Visit v) {
		try {
			String sql = "UPDATE visits SET weight=?, height=?, gender=? where sid=?";
			PreparedStatement s = getConnection().prepareStatement(sql);
			return s.execute();
		} catch (SQLException e) {
			Config.getConfig().getLogger().exception(e);
			return false;
		}
	}

	public boolean delete(Visit v) {
		try {
			String sql = "DELETE FROM <tbl_name> where id=?";
			PreparedStatement s = getConnection().prepareStatement(sql);
			return s.execute();
		} catch (SQLException e) {
			Config.getConfig().getLogger().exception(e);
			return false;
		}
	}

	public boolean save(Visit v) {
		try {
			String sql = "INSERT INTO <tbl_name> VALUES(<values>);";
			PreparedStatement s = getConnection().prepareStatement(sql);
			return s.execute();
		} catch (SQLException e) {
			Config.getConfig().getLogger().exception(e);
			return false;
		}
	}

}

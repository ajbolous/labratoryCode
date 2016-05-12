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

public class Template extends AbstractHandler implements Persistable<Entity> {

	public Template(Connection con) {
		super(con);
	}

	public boolean createTable() {
		try {
			String sql = "CREATE TABLE <NAME>("
					+ "int INTEGER AUTO_INCREMENT, "
					+ "string VARCHAR(50),"
					+ "date DATE,"
					+ "PRIMARY KEY(int),"
					+ "FOREIGN KEY(pid) REFERENCES patients(sid));";
			
			Statement stmt = getConnection().createStatement();
			stmt.execute(sql);
			stmt.close();
			return true;
		} catch (SQLException e) {
			Config.getConfig().getLogger().exception(e);
			return false;
		}
	}

	public ArrayList<Entity> getAll() {
		return null;
	}

	public boolean update(Entity t) {
		try {
			String sql = "UPDATE <tbl_name> SET weight=?, height=?, gender=? where sid=?";
			PreparedStatement s = getConnection().prepareStatement(sql);
			return s.execute();
		} catch (SQLException e) {
			Config.getConfig().getLogger().exception(e);
			return false;
		}
	}

	public boolean delete(Entity p) {
		try {
			String sql = "DELETE FROM <tbl_name> where id=?";
			PreparedStatement s = getConnection().prepareStatement(sql);
			return s.execute();
		} catch (SQLException e) {
			Config.getConfig().getLogger().exception(e);
			return false;
		}
	}

	public boolean save(Entity p) {
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

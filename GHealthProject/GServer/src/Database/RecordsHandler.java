package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.Doctor;
import models.Entity;
import models.MedicalRecord;
import models.Patient;
import models.Person;
import Server.Config;

public class RecordsHandler extends AbstractHandler implements Persistable<MedicalRecord> {

	public RecordsHandler(Connection con) {
		super(con);
	}

	public boolean createTable() {
		try {
			String sql = "CREATE TABLE records("
					+ "rid INTEGER AUTO_INCREMENT, "
					+ "pid VARCHAR(50),"
					+ "creationDate DATE"
					+ ", PRIMARY KEY(rid),"
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

	public ArrayList<MedicalRecord> getAll() {
		return null;
	}

	public boolean update(MedicalRecord m) {
		try {
			String sql = "UPDATE records SET pid=?, creationDate=? where rid=?";
			PreparedStatement s = getConnection().prepareStatement(sql);
			return s.execute();
		} catch (SQLException e) {
			Config.getConfig().getLogger().exception(e);
			return false;
		}
	}

	public boolean delete(MedicalRecord m) {
		try {
			String sql = "DELETE FROM records where rid=?";
			PreparedStatement s = getConnection().prepareStatement(sql);
			return s.execute();
		} catch (SQLException e) {
			Config.getConfig().getLogger().exception(e);
			return false;
		}
	}

	public boolean save(MedicalRecord m) {
		try {
			String sql = "INSET INTRO records VALUES(?,?)";
			PreparedStatement s = getConnection().prepareStatement(sql);
			return s.execute();
		} catch (SQLException e) {
			Config.getConfig().getLogger().exception(e);
			return false;
		}
	}

}

package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Server.Config;
import models.Physician;


public class PhysiciansHandler {

	private Connection connection;

	public PhysiciansHandler(Connection con) {
		connection = con;
	}

	public ArrayList<Physician> getAllPhysicians() {
		try {
			ArrayList<Physician> physicians = new ArrayList<Physician>();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from physicians");
			while (rs.next()) {
				Physician d = new Physician();
				d.setName(rs.getString(1));
				d.setSpecialization(rs.getString(2));
				physicians.add(d);
			}
			rs.close();
			return physicians;
		} catch (SQLException e) {
			Config.getConfig().getLogger().exception(e);
			return null;
		}
	} 	
	
	public int updatePhysician(Physician p){
		try {
			PreparedStatement stmt = connection.prepareStatement("UPDATE physicians SET specialization=? where name=?");
			stmt.setString(1, p.getSpecialization());
			stmt.setString(2, p.getName());
			return stmt.executeUpdate();
		} catch (SQLException e) {
			Config.getConfig().getLogger().exception(e);
			return 0;
		}
		
	}


}

package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.Doctor;
import Server.Config;

public class DoctorsHandler extends AbstractHandler {

	public DoctorsHandler(Connection con) {
		super(con);
	}

	public void addDoctor(Doctor d){
	
	}
	public ArrayList<Doctor> getDoctors(){
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
	
}

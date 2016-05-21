package Database;

import java.sql.SQLException;
import java.util.Date;
import java.util.Calendar;

import Server.Config;
import models.*;

public class DataFiller {

	DbHandler db;
	public DataFiller(DbHandler d){
		db = d;
	}
	public void fillDoctors() throws SQLException{
		for(int i =0;i<9;i++){
			Doctor d = new Doctor();
			d.setFirstName("Doctor " + i);
			d.setSid("20000000" + i);
			db.doctors.createIfNotExists(d);
		}
	}
	
	public void fillPatients() throws SQLException{
		for(int i =0;i<9;i++){
			Patient p = new Patient();
			p.setFirstName("Patient " + i);
			p.setSid("30000000" + i);
			db.patients.createIfNotExists(p);
		}
	}
	
	public void fillAppointments() throws SQLException{
		Doctor d = db.doctors.queryForId("200000002");
		Patient p = db.patients.queryForId("300000003");
		
		long millis = System.currentTimeMillis();
		Date date = new Date(millis);
		Appointment a = new Appointment(d,p,date);
		
		db.appointments.createIfNotExists(a);
	}
	
	
}

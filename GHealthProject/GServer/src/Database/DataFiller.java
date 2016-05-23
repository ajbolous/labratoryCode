package Database;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	
	public void fillAppointments() throws SQLException, ParseException{
		
		for(int i =0;i<8;i++){
		Doctor d = db.doctors.queryForId("20000000" + i);
		Patient p = db.patients.queryForId("30000000" + i);
	
		//Appointment a = new Appointment(d,p,Utils.DateTime.getDate(2016, 10, 5+i,11,10));

		//db.appointments.createIfNotExists(a);
		}
	
	}
	
	
}

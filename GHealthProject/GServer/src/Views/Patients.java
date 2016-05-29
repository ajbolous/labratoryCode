package Views;

import java.sql.SQLException;
import java.text.ParseException;

import models.Doctor;
import models.MedicalRecord;
import models.Patient;
import Database.DbHandler;
import Server.Config;
import Utils.Request;

public class Patients extends View{
	
	public Object getById(Request request){
		DbHandler db = Config.getConfig().getHandler();
		
		try {
			return db.patients.queryForId((String)request.getParam("sid"));
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public Object all(Request request){
		DbHandler db = Config.getConfig().getHandler();
	     
		return null;
	}
	
	
	public Object add(Request request){
		DbHandler db = Config.getConfig().getHandler();
		 Patient patient = (Patient) request.getParam("patient");
		MedicalRecord md=new MedicalRecord(); 
				
		    md.setPatient(patient);
		    try {
				md.setCreationDate(Utils.DateTime.currentDate());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    try {
				db.records.createIfNotExists(md);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		    try {
		    	patient.setMedicalRecord(md);
				db.patients.createIfNotExists(patient);
				return "success";
				} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
	}
	
	
	public Object remove(Request request) {
		return null;
	}
	
	public Object update(Request request) {
		return null;
	}	
	
	public Object  createMedicalRecord (Request request)
	{
		DbHandler db = Config.getConfig().getHandler();
	    Patient patient = (Patient) request.getParam("patient");
		MedicalRecord md=(MedicalRecord)  request.getParam("medicalRecord");
		try {
			db.records.createIfNotExists(md);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			db.patients.update(patient);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
		
	}
}

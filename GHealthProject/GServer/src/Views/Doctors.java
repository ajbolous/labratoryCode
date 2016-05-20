package Views;

import models.Doctor;

import java.sql.SQLException;
import java.util.HashMap;

import Database.DbHandler;
import Server.Config;
import Utils.Request;

public class Doctors extends View{
	public Object all(Request request){
		DbHandler db = Config.getConfig().getHandler();
		return null;
	}

	public Object bySpeciality(Request request){
		DbHandler db = Config.getConfig().getHandler();
		String s = (String)request.getParam("speciality");
		try {
			return db.doctors.queryForFieldValues(request.getParams());
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
	
	public Object add(Request request){
		DbHandler db = Config.getConfig().getHandler();
		Doctor d = (Doctor)request.getParam("doctor");
		
		try {
			db.doctors.create(d);
		} catch (SQLException e) {
			return "Failed";
		}
		
		return "success";
	}
	
	public Object remove(Request request) {
		DbHandler db = Config.getConfig().getHandler();
		Doctor d = (Doctor)request.getParam("doctor");
		return "success";
	}
	
	public Object update(Request request) {
		DbHandler db = Config.getConfig().getHandler();
		Doctor d = (Doctor)request.getParam("doctor");
		return "success";
	}
	
}

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
		HashMap<String,Object> m = new HashMap<String,Object>();
		m.put("speciality", s);
		try {
			return db.getDoctors().queryForFieldValues(m);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
	
	public Object add(Request request){
		DbHandler db = Config.getConfig().getHandler();
		Doctor d = (Doctor)request.getParam("doctor");
		
		try {
			db.getDoctors().create(d);
		} catch (SQLException e) {
			return "Failed";
		}
		
		return "success";
	}
	
	@Override
	public Object remove(Request request) {
		DbHandler db = Config.getConfig().getHandler();
		Doctor d = (Doctor)request.getParam("doctor");
		return "success";
	}
	@Override
	public Object update(Request request) {
		DbHandler db = Config.getConfig().getHandler();
		Doctor d = (Doctor)request.getParam("doctor");
		return "success";
	}
	
}

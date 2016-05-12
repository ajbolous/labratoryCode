package Views;

import models.Doctor;

import java.sql.SQLException;

import Database.DbHandler;
import Server.Config;
import Utils.Request;

public class Doctors extends View{
	public Object all(Request request){
		DbHandler db = Config.getConfig().getHandler();
		return db.getDoctors().getDoctors();
	}
	
	public Object add(Request request){
		DbHandler db = Config.getConfig().getHandler();
		Doctor d = (Doctor)request.getParam("doctor");
		try {
			d.save(db.getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	@Override
	public Object remove(Request request) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object update(Request request) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

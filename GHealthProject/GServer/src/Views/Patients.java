package Views;

import java.sql.SQLException;

import models.Doctor;
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
		try {
			db.patients.createIfNotExists((Patient) request.getParam("patient"));
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
}

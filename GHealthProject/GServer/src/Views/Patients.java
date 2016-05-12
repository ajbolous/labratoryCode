package Views;

import models.Doctor;
import Database.DbHandler;
import Server.Config;
import Utils.Request;

public class Patients extends View{
	public Object all(Request request){
		DbHandler db = Config.getConfig().getHandler();
		return db.getDoctors().getDoctors();
	}
	public Object add(Request request){
		DbHandler db = Config.getConfig().getHandler();
		return "success";
	}
	
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

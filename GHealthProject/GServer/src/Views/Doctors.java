package Views;

import models.Doctor;
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
		db.getDoctors().addDoctor((Doctor)request.getParam("doctor"));
		return "success";
	}
	
}

package Views;

import models.Doctor;

import Database.DbHandler;
import Server.Config;
import Utils.Request;

public class Doctors extends View{
	public Object all(Request request){
		DbHandler db = Config.getConfig().getHandler();
		return null;
	}
	
	public Object add(Request request){
		DbHandler db = Config.getConfig().getHandler();
		Doctor d = (Doctor)request.getParam("doctor");
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

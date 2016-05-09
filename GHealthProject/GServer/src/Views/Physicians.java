package Views;

import Database.DbHandler;
import Server.Config;
import Utils.Request;
import models.Physician;

public class Physicians extends View {

	public Object all(Request request) {
		DbHandler db = Config.getConfig().getHandler();
		return db.getPhysicians().getAllPhysicians();
	}

	public Object update(Request request){
		DbHandler db = Config.getConfig().getHandler();
		return db.getPhysicians().updatePhysician((Physician)request.getParam("physician"));
	}
	
}

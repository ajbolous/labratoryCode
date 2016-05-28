package Views;

import java.sql.SQLException;

import models.Treatment;
import models.Visit;
import Database.DbHandler;
import Server.Config;
import Utils.Request;

public class Visits extends View{
	
	public void add (Request request){
		DbHandler db = Config.getConfig().getHandler();
		try {
			db.visits.create((Visit) request.getParam("visits")); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

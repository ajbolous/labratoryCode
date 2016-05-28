package Views;

import java.sql.SQLException;

import Database.DbHandler;
import Server.Config;
import Utils.Request;
import models.Treatment;

public class Treatments extends View {
	

	public void add (Request request){
		DbHandler db = Config.getConfig().getHandler();
		try {
			db.treatments.create((Treatment) request.getParam("treatment")); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
		
		
		      



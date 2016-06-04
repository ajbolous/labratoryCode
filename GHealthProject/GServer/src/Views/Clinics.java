package Views;

import java.sql.SQLException;
import Utils.Request;

import Database.DbHandler;
import Server.Config;

public class Clinics extends View  {
	
	public Object getClinics(Request request){
		DbHandler db = Config.getConfig().getHandler();
		
		 try{
			   return db.clinics.queryForAll();
		 }
		catch (SQLException e) {
			e.printStackTrace();
			return "fail";
		}
	}
	
	
	public Object getById(Request request){
		DbHandler db = Config.getConfig().getHandler();
		try {
			return db.clinics.queryForId((int)request.getParam("cid"));
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}

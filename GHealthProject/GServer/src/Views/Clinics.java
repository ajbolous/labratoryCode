package Views;

import java.util.List;
import java.sql.SQLException;

import models.Clinic;

import com.j256.ormlite.stmt.QueryBuilder;

import Utils.Request;
import Database.DbHandler;
import Server.Config;

public class Clinics extends View  {
	
	public Object getClinics(Request request){
		DbHandler db = Config.getConfig().getHandler();
		QueryBuilder<Clinic, Integer> d = db.clinics.queryBuilder();
		List <Clinic> clinic ;
		 try{
			 
			 clinic = d.where().eq("hasLabratory", true)
						.query();
			   return clinic;
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

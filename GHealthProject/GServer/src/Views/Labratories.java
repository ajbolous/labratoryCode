package Views;

import java.sql.SQLException;
import java.util.List;

import models.Visit;

import org.omg.CORBA.Request;

import com.j256.ormlite.stmt.QueryBuilder;

import Database.DbHandler;
import Server.Config;

public class Labratories extends View  {
	
	public Object getLabratories(Request request )
	{
		DbHandler db = Config.getConfig().getHandler();
		
		 try{
			   return db.labratories.queryForAll();

		 }
		catch (SQLException e) {
			e.printStackTrace();
			return "fail";

		}
		
		
			
		
	}

}

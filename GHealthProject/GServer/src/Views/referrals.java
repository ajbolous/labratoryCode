package Views;

import java.sql.SQLException;
import java.text.ParseException;


import models.Referral;
import Database.DbHandler;
import Server.Config;
import Utils.Request;

public class referrals extends View{
	
public Object add (Request request){
	DbHandler db = Config.getConfig().getHandler();

		try {
			return db.refferals.createIfNotExists((Referral) request.getParam("ref"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	

}

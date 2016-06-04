package Views;

import java.sql.SQLException;



import models.Doctor;
import models.Referral;
import Database.DbHandler;
import Server.Config;
import Utils.Request;

public class Referrals extends View{
	
public Object add (Request request){
	DbHandler db = Config.getConfig().getHandler();
	Referral ref = (Referral)request.getParam("ref");
	
	try {
		db.refferals.create(ref);
	} catch (SQLException e) {
		return "Failed";
	}
	
	return "success";
}
	




}

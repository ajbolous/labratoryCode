package Views;

import java.sql.SQLException;




import java.text.ParseException;

import models.Confirmation;
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
		ref.setDate(Utils.DateTime.currentDate());
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
	
		db.refferals.create(ref);
	} catch (SQLException e) {
		return "Failed";
	}
	return "success";
}
public Object update (Request request){
	DbHandler db = Config.getConfig().getHandler();
	Referral ref = (Referral)request.getParam("con");
	Confirmation conf = (Confirmation)ref.getConfirmation(); 
	

	try {
		 ref.setConfirmation(conf);
	     ref.setActive(true);
		db.refferals.createOrUpdate(ref);
		db.confirmations.create((Confirmation)ref.getConfirmation());

	} catch (SQLException e) {
		return "Failed";
	}
	
	return "success";
}

	




}

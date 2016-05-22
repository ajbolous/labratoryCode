package Views;

import java.sql.SQLException;
import java.util.Map;

import models.Appointment;
import Database.DbHandler;
import Server.Config;
import Utils.Request;

public class Appointments extends View{

	public  Object delete(Request request){
		
		try {
			Config.getConfig().getHandler().appointments.delete((Appointment) request.getParam("appointment"));			
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;

		}
		
	}
	
}

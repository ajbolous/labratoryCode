package Views;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;

import models.Appointment;
import models.Doctor;
import models.Labratorian;
import models.Patient;
import models.User;
import Database.DbHandler;
import Server.Config;
import Utils.Request;

public class Users extends View{

	public  Object delete(Request request){
		
		try {
			Config.getConfig().getHandler().appointments.delete( (Appointment) request.getParam("appointment"));	
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;

		}
		
	}
	
	/**
	 * 
	 * @param request
	 * @return all appointments of specific patient in specific doctor
	 * 		(select appointmentTime from appoitments where doctor_id="doctor id" and patient_id=" patient id")
	 * @throws SQLException 
	 */
	public Object getById(Request request) throws SQLException{
		DbHandler db = Config.getConfig().getHandler();		
		
		Doctor d = db.doctors.queryForId((String) request.getParam("sid"));
		if (d != null)
			return d;
		Labratorian l = db.labratorians.queryForId((String) request.getParam("sid"));
		if (l != null)
			return l;
		
		return null;
	}
	
	public Object setOnline(Request request){
		DbHandler db = Config.getConfig().getHandler();		

		User u = (User) request.getParam("user");
		u.setOnline(true);
		try {
			if(u.getClass() == Doctor.class)
				db.doctors.update((Doctor) u);
			if(u.getClass() == Labratorian.class)
				db.labratorians.update((Labratorian) u);
			return u;
		} catch (SQLException e) {
			Config.getConfig().getLogger().exception(e);
			return null;
		}
	}
}

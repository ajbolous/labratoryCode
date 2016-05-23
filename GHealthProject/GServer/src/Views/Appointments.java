package Views;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;

import models.Appointment;
import models.Patient;
import Database.DbHandler;
import Server.Config;
import Utils.Request;

public class Appointments extends View{

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
	public Object timeByDoctorAndPatient(Request request) throws SQLException{
		DbHandler db = Config.getConfig().getHandler();		
		
		QueryBuilder<Appointment, Integer> q = db.appointments.queryBuilder();
			
		List<Appointment> result =  q.orderBy("appointmentTime",false).limit(1).where()
		.eq("doctor_id", request.getParam("doctor_id"))
		.and().eq("patient_id", request.getParam("patient_id"))
		.and().le("appointmentTime",request.getParam("app_time")).query();
		
		return result;
	}
}

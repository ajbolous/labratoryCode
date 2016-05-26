package Views;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.dao.RawRowMapper;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;

import models.Appointment;
import models.Patient;
import Database.DbHandler;
import Server.Config;
import Utils.Request;

public class Appointments extends View{

	
	public Object getPatientAppointments(Request request){
		DbHandler db = Config.getConfig().getHandler();		
		QueryBuilder<Appointment, Integer> q = db.appointments.queryBuilder();
		List<Appointment> app;
		try {
			app=  q.orderBy("appointmentTime",true).where()
			.eq("patient_id", request.getParam("patient_id"))
			.and()
			.ge("appointmentTime",request.getParam("curr_date")).query();
			
			return app;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
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
	 * 		(select MAX(appointmentTime)
	 * 		 from appoitments
	 * 		 where doctor_id="doctor_id" and patient_id=" patient_id" and appointmentTime <= current time)
	 * @throws SQLException 
	 */
	public Object lastVisit(Request request) {
		DbHandler db = Config.getConfig().getHandler();		
		
		QueryBuilder<Appointment, Integer> q = db.appointments.queryBuilder();
		List<Appointment> app;
		try {
			app=  q.orderBy("appointmentTime",false).limit(1).where()
			.eq("doctor_id", request.getParam("doctor_id"))
			.and()
			.eq("patient_id", request.getParam("patient_id"))
			.and()
			.le("appointmentTime",request.getParam("app_time")).query();
			
			return app;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		
		
		
		
	}
}

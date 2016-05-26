package Views;

import java.sql.SQLException;
import java.util.Date;
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
	 * 		(select appointmentTime from appoitments where doctor_id="doctor id" and patient_id=" patient id")
	 * @throws SQLException 
	 */
	public Object timeByDoctorAndPatient(Request request) throws SQLException{
		DbHandler db = Config.getConfig().getHandler();		
		
		QueryBuilder<Appointment, Integer> q = db.appointments.queryBuilder();
		List<Appointment> app;
		List<Appointment> result =  q.orderBy("appointmentTime",false).limit(1).where()
			app=  q.orderBy("appointmentTime",false).limit(1).where()
		.and().eq("patient_id", "200000000")
		.and().le("appointmentTime",new Date()).query();
		
		return result;
	}
}

package Views;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.dao.RawRowMapper;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;

import models.Appointment;
import models.Doctor;
import models.Patient;
import models.Shift;
import Database.DbHandler;
import Server.Config;
import Utils.DateTime;
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
	
	public Object add(Request request){
		DbHandler db = Config.getConfig().getHandler();
		
		Doctor doctor;
		Patient patient;
		try {
			doctor= db.doctors.queryForId((String) request.getParam("doctor_id"));
			patient = db.patients.queryForId((String) request.getParam("patient_id"));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
		if(!isExist(request.getParam("doctor_id"),request.getParam("patient_id"),request.getParam("app_time"))){
			try {
				db.appointments.create(new Appointment(doctor, patient,(Date) request.getParam("app_time")));
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		return false;
		
	}
	
	private boolean isExist(Object doctor_id, Object patient_id, Object app_time) {
		DbHandler db = Config.getConfig().getHandler();
		QueryBuilder<Appointment, Integer> q= db.appointments.queryBuilder();
		ArrayList<Appointment> app;
		
		try {
			app= (ArrayList<Appointment>) q.where()
					.eq("doctor_id", (String)doctor_id)
					.and()
					.eq("patient_id", (String)patient_id)
					.and()
					.eq("appointmentTime", (Date)app_time).query();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		if(app==null || app.size()==0) return false;
		return true;
	}
	/**
	 * 
	 * @param request
	 * @return all appointments of specific patient in specific doctor
	 * 		(select MAX(appointmentTime)
	 * 		 from appointments
	 * 		 where doctor_id="doctor_id" and patient_id=" patient_id" and appointmentTime <= current time)
	 * @throws SQLException 
	 */
	public Object lastVisit(Request request,String doctor_id) {
		DbHandler db = Config.getConfig().getHandler();		
		
		QueryBuilder<Appointment, Integer> q = db.appointments.queryBuilder();
		List<Appointment> app;
		Date curr_date=null;
		
		try {
			 curr_date=DateTime.currentDate();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			app=  q.orderBy("appointmentTime",false).limit(1).where()
			.eq("doctor_id", doctor_id)
			.and()
			.eq("patient_id", request.getParam("patient_id"))
			.and()
			.le("appointmentTime",curr_date).query();
			
			if(app.size()==0) return "";
			else return DateTime.getDateString(app.get(0).getAppointmentTime());
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Object availableTimes(Request request){
		ArrayList<Appointment> unAvailable=
				(ArrayList<Appointment>)
				unAvailableApps(request.getParam("doctor_id"),request.getParam("patient_id"), request.getParam("curr_time"));
		
		ArrayList<Shift> doc_shifts= (ArrayList<Shift>) getDoctorShifts(request.getParam("doctor_id"),request.getParam("curr_time"));
		
		ArrayList<Appointment> allOptions= new ArrayList<Appointment>();
		
		for(Shift shift: doc_shifts){
			Date time = shift.getStartDate();
			while(time.before(shift.getEndDate())){				
				allOptions.add(new Appointment(time));
				time=DateTime.addMinutes(time, 30);
			}
		}
		allOptions.removeAll(unAvailable);
		
		return allOptions;
	}
	
	private List<Shift> getDoctorShifts(Object doctor_id, Object curr_time) {

		DbHandler db = Config.getConfig().getHandler();		
		QueryBuilder<Shift, String> q = db.shifts.queryBuilder();
		
		try {
			return q.orderBy("startDate", true).where()
			.eq("doctor_id",(String) doctor_id)
			.and()
			.ge("startDate", (Date)curr_time).query();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	private List<Appointment> unAvailableApps(Object doctor_id,Object patient_id,Object curr_time){
		DbHandler db = Config.getConfig().getHandler();		
		QueryBuilder<Appointment, Integer> q = db.appointments.queryBuilder();
		Where<Appointment,Integer> where=q.orderBy("appointmentTime", true).where();
		List<Appointment> unavailableApps=null;

		
		try {
			where.ge("appointmentTime", (Date)curr_time);
			where.eq("doctor_id",(String)doctor_id).or().eq("patient_id",(String)patient_id);
			unavailableApps=where.and(where,where).query();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return unavailableApps;
	}
	
	
}

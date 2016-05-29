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

/**
 * Database view for appointments , have all the Appointments Queries. 
 * @author Muhamad Igbaria
 *
 */
public class Appointments extends View{

	/**
	 * Query to get specific patient all future appointments.
	 * @param request : "appointments/getPatientAppointments" ,HashMap params: ("patient_id","curr_date").
	 * 
	 * @return Array list of all future patient's appointment.
	 * 
	 * @throws SQLException
	 */
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
	
	/**
	 * Query to delete an appointment.
	 * @param request : "appointments/delete" ,HashMap params: ("appointment" => Appointment instance).

	 * @return boolean value , id delete success return true , else return false.
	 * 
	 * @throws SQLException
	 */
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
	 * Query to add new appointment to database
	 * @param request : "appointments/add" ,HashMap params: ("doctor_id" ,"patient_id").

	 * @return true id adding success , and false if occur any error like the appointment exist
	 * 
	 * @throws SQLException ,ParseException
	 */
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
				Appointment app = new Appointment(doctor, patient,(Date) request.getParam("app_time"));
				try {
					app.setCreationTime(DateTime.currentDate());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				db.appointments.create(app);
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		return false;
		
	}
	
	/**
	 * check if given appointment exist in database
	 * @param doctor_id 
	 * @param patient_id
	 * @param app_time : appointment time 
	 * @return true if the appointment is exist , return false else .
	 * 
	 * @throws SQLException
	 */
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
	 * Query to get the date if the last visit of patient to specific doctor
	 * @param request : "appointments/lastVisit" ,HashMap params: ("patient_id").

	 * @param doctor_id : the doctor id that need to check the patient last visit for him
	 * @return String date of the last visit if exist such last visit , return empty string if no last visit , return null if exception occured.
	 * @throws ParseException ,SQLException
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
	/**
	 * Query to get all available times to appointment that not overlap with chooses doctor and patient appointments times 
	 * @param request : "appointments/availableTimes" ,HashMap params: ("doctor_id","patient_id","curr_time").

	 * @return Appointments Array list all available times for set appointment 
	 */
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
	
	/**
	 * Query to get all doctor's shifts 
	 * @param doctor_id 
	 * @param curr_time
	 * @return Shift array list of all future all doctor's shifts.
	 * @throws SQLException
	 */
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
	
	/**
	 * Query for get the unavailable times of doctor and patient to set appointment , get the patient and doctor appointments .
	 * @param doctor_id
	 * @param patient_id
	 * @param curr_time
	 * @return Appointment array list of unavailable times of patient and doctor.
	 * @throws SQLException
	 */
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

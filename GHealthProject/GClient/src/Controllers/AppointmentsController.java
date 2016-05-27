package Controllers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.stmt.DeleteBuilder;

import Client.Application;
import Utils.DateTime;
import Utils.Request;
import models.Appointment;
import models.Doctor;
import models.Patient;
import models.Shift;

public class AppointmentsController {

	public boolean deleteAppointment(Appointment app){
		Request r = new Request("appointments/delete");
		r.addParam("appointment", app);
		app=null;
		return   (boolean) Application.client.sendRequest(r);
	}

	
	public String [] getSpecialties(){
		Request r = new Request("doctors/getSpecialities");
		ArrayList<String> specs= (ArrayList<String>) Application.client.sendRequest(r);
		Collections.sort(specs);
		specs.add(0, "");
		return  specs.toArray(new String[specs.size()]);

	}
	
	public ArrayList<Doctor> getDoctorsBySpeciality(String spec){
		Request r = new Request("doctors/bySpeciality");
		r.addParam("speciality",spec);

		return  (ArrayList<Doctor>) Application.client.sendRequest(r);
	}
	
	public ArrayList<Appointment> getPatientAppointments(Patient patient){
		Request r = new Request("appointments/getPatientAppointments");
		r.addParam("patient_id",patient.getSid());
		Date curr= new Date();
		try {
			r.addParam("curr_date", DateTime.getDate(curr.getYear()+1900, curr.getMonth()+1, curr.getDate(), curr.getHours(), curr.getMinutes()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (ArrayList<Appointment>) Application.client.sendRequest(r);
		
	}

	
	public String getLastVisit(String doctor_id,String patient_id,Date date){
		Request r = new Request("appointments/lastVisit");
		r.addParam("doctor_id",doctor_id);
		r.addParam("patient_id", patient_id);
		r.addParam("app_time", date);
		ArrayList<Appointment> app = (ArrayList<Appointment>) Application.client.sendRequest(r);
		if (app.size()==0) return "";
		return DateTime.getDateString(app.get(0).getAppointmentTime());

	}
	
	public void test(){
		Request r = new Request("appointments/availableTimes");
		try {
			r.addParam("curr_time", DateTime.currentDate());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		r.addParam("doctor_id", "200000000");
		
		r.addParam("patient_id", "300000000");
		ArrayList<Appointment> a= (ArrayList<Appointment>) Application.client.sendRequest(r);
		
		for(Appointment b : a){
			System.out.println(b.toString());
		}
	}


	public ArrayList<Appointment> getTimes(String doctor_id, String patient_id) {
		Request r = new Request("appointments/availableTimes");
		try {
			r.addParam("curr_time", DateTime.currentDate());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		r.addParam("doctor_id", doctor_id);
		
		r.addParam("patient_id", patient_id);
		return (ArrayList<Appointment>) Application.client.sendRequest(r);
	}
}


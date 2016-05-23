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
	
	public ForeignCollection<Appointment> getPatientAppointments(Patient patient){
		return 	patient.getAppointments();
	}

	
//	public Date getLastVisit(Doctor doctor, Patient patient){
//		Request r = new Request("appointments/timeByDoctorAndPatient");
//		r.addParam("doctor_id",doctor.getSid());
//		r.addParam("patient_id", patient.getSid());
//		ArrayList<Date> times = (ArrayList<Date>) Application.client.sendRequest(r);
//		ArrayList<Date> dates= new ArrayList<Date>();
//		Date curr=new Date();
//		for(Date time: times){
//			try {
//				dates.add(DateTime.getDate(time.getYear(), time.getMonth(), time.getDay()));
//			} catch (ParseException e) {
//				e.printStackTrace();
//			}
//		}
//
//		
//	}
	public void test(int doctor,int patient,Date date){
		Request r = new Request("appointments/timeByDoctorAndPatient");
		r.addParam("doctor_id",doctor);
		r.addParam("patient_id", patient);
		r.addParam("app_time", date);
		ArrayList<Appointment> app = (ArrayList<Appointment>) Application.client.sendRequest(r);
		for(Appointment a: app){
			System.out.println(a.getAppointmentTime());
		}
	}
}


package Fixtures;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import Utils.DateTime;
import Controllers.AppointmentsController;
import models.Appointment;
import fit.ActionFixture;

public class getTimes extends ActionFixture {
	ArrayList<Appointment> apps;
	
	public boolean isAvailable(String doc_id,String patient_id,String date) throws ParseException{
		apps=AppointmentsController.getTimes(doc_id, patient_id);
		String[] sp= date.split(" ");
		String [] day= sp[0].split("/");
		String [] time=sp[1].split(":");
		Date d=DateTime.getDate(Integer.parseInt(day[2]), Integer.parseInt(day[1]), Integer.parseInt(day[0]),
				Integer.parseInt(time[0]), Integer.parseInt(time[1]));
		if(apps.size()==0) return false;
		for(Appointment a:apps){
			if(a.getAppointmentTime().equals(d)) return true;
		}
		return false;
		
	}
	public boolean overlapTimes(String doc_id,String patient_id){
		apps=AppointmentsController.getTimes(doc_id, patient_id);
		if(apps.size()==0) return false;
		for(int i=1;i<apps.size();i++){
			if(apps.get(i-1).equals(apps.get(i))) return true;
		}
		return false;
	}
}

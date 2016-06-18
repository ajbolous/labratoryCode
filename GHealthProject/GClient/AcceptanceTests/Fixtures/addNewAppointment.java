package Fixtures;

import java.text.ParseException;
import java.util.Date;

import Controllers.AppointmentsController;
import Utils.DateTime;
import fit.ActionFixture;

public class addNewAppointment extends ActionFixture {

	
	public boolean addIfNotExist(String doc_id,String patient_id,String time) throws NumberFormatException, ParseException{
		String[] sp= time.split(" ");
		String [] day= sp[0].split("/");
		String [] hour=sp[1].split(":");
		Date d=DateTime.getDate(Integer.parseInt(day[2]), Integer.parseInt(day[1]), Integer.parseInt(day[0]),
				Integer.parseInt(hour[0]), Integer.parseInt(hour[1]));
		
		return AppointmentsController.addNewAppointment(doc_id, patient_id, d);
	}
}

package Fixtures;

import java.util.ArrayList;

import Controllers.AppointmentsController;
import fit.ActionFixture;

public class getDoctorsBySpeciality extends ActionFixture {
	private ArrayList<Object[]> doctors;
	
	public int numOfDoctors(String spec){
		doctors= AppointmentsController.getDoctorsBySpeciality(spec, "300000000");
		return doctors.size();
	}
	
	public String lastVisitById(String spec,String id){
		doctors= AppointmentsController.getDoctorsBySpeciality(spec, id);
		Object[] firstDoc=doctors.get(0);
		return (String) firstDoc[0];
	}
	
	public String lastVisitByDate(String spec,String id){
		doctors= AppointmentsController.getDoctorsBySpeciality(spec, id);
		Object[] firstDoc=doctors.get(0);
		return (String) firstDoc[3];
	}
	
	public String doctorAt(int i,String spec,String id){
		doctors= AppointmentsController.getDoctorsBySpeciality(spec, id);
		if(doctors==null || i>=doctors.size() || i<0) return "error";
		Object[] d= doctors.get(i);
		return (String) d[0];
	}
}

package FitTests.Fixtures;

import java.util.ArrayList;

import models.Appointment;
import Controllers.AppointmentsController;
import fit.ActionFixture;

public class getSpecialties extends ActionFixture {

	
	public int numOfSpec(){
		String[] all =AppointmentsController.getSpecialties();
		if(all==null) return 0;
		return all.length;
	}
	
	public boolean isExist(String spec){
		String[] all =AppointmentsController.getSpecialties();
		if(all==null) return false;
		for(int i=0;i<all.length;i++){
			if(all[i].equals(spec)) return true;
		}
		return false;
	}
	
	public String specAt(int i){
		String[] all =AppointmentsController.getSpecialties();
		if(all==null || i>=all.length || i<0) return "error";
		return all[i];
	}
}

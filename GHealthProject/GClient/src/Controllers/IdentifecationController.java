package Controllers;

import java.text.ParseException;


import models.Patient;
import Client.Application;
import ClientUI.DoctorMedicalRecordUI;
import Utils.Request;
import models.User;


 
public class IdentifecationController {
	
	 private PatientsController patientController = new PatientsController();
	
	 //this method will be added to identificationUI then deleted it 
	public void openMedicalRecord(String id) throws ParseException
	{
		Patient p = patientController.getById(id);

	DoctorMedicalRecordUI s = new DoctorMedicalRecordUI(p);
	
	}
	

}

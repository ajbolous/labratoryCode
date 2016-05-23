package Controllers;

import java.text.ParseException;

import models.Patient;
import ClientUI.DoctorMedicalRecordUI;

public class IdentifecationController {
	public void openMedicalRecord(String Id) throws ParseException
	{
		Patient p = new Patient();
		DoctorMedicalRecordUI s = new DoctorMedicalRecordUI(p);
	}

}

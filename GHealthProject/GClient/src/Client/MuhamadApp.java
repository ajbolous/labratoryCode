package Client;

import java.text.ParseException;

import ClientUI.DoctorMedicalRecordUI;
import ClientUI.Identification;
import ClientUI.SignInUI;
import ClientUI.UsersManagingUI;
import Controllers.AppointmentsController;
import Controllers.PatientsController;
import models.Patient;

public class MuhamadApp {

	public static void main(String[] args) {
		Application.connect();
		new Identification().getFrame().setVisible(true);
		
//		new AppointmentsController().test();
	
	}
}

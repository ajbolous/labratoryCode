package Client;

import java.text.ParseException;

import models.Doctor;
import models.Patient;
import ClientUI.*;
import Controllers.PatientsController;

public class TestApp {

	public static void main(String[] args) {
		Application.connect();
		//UsersManagingUI iden= new UsersManagingUI();
		//AddPatientUI u = new AddPatientUI();
		new SignInUI();
		//Application.user=new Doctor();
		//PatientUI p = new PatientUI();
	//RequestInformationUI p = new RequestInformationUI();
		PatientsController ctrl= new PatientsController(); 
		Patient patient=ctrl.getById("300000002");
	    new NewConformUI(patient); 
	    //new DoctorMedicalRecordUI(patient); 

		
	}
}

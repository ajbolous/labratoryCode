package Client;

import models.Labratorian;
import models.Patient;
import models.Secretary;
import ui.appointments.NewConfirmUI;
import ui.appointments.testconfirm;
import ui.labratories.Labratory;
import ui.main.Identification;
import ui.main.SignInUI;
import Controllers.MedicalRecordController;
import Controllers.PatientsController;
import Controllers.UsersController;

public class TestApp {

	public static void main(String[] args) {
		Application.connect();
		//UsersManagingUI iden= new UsersManagingUI();
		//AddPatientUI u = new AddPatientUI();
	//	new SignInUI();
		//MedicalRecordController.examinationTest();
		//MonthlyReport r=new MonthlyReport();
		//PatientsController ctrl= new PatientsController(); 
		//Patient patient=ctrl.getById("300000002");
		Labratorian lab = (Labratorian)UsersController.getUser("400000000");
		
		Application.user = lab;
		//new NewConfirmUI(patient); 
	    //new testconfirm(patient); 
		new Labratory();
		//Secretary sec = (Secretary)UsersController.getUser("400000010");
		//Application.user = sec;
		//new Identification();
		
	}
}

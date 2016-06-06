package Client;

import models.Examination;
import models.Labratorian;
import models.Patient;
import ui.labratories.Labratory;
import ui.main.SignInUI;
import Controllers.ExaminationController;
import Controllers.PatientsController;
import Controllers.UsersController;

public class TestApp {

	public static void main(String[] args) {
		Application.connect();
		//UsersManagingUI iden= new UsersManagingUI();
		//AddPatientUI u = new AddPatientUI();
		
		//Examination ex = new Examination();
	//	ExaminationController.addReferral(ex);
		
		
		
		new SignInUI();
		
		//MonthlyReport r=new MonthlyReport();
		//PatientsController ctrl= new PatientsController(); 
		//Patient patient=ctrl.getById("300000002");
	//Labratorian lab = (Labratorian)UsersController.getUser("400000000");
		//Application.user = lab;
		//new NewConfirmUI(patient); 
		//new Labratory();
		
	}
}

package Client;

import models.Patient;
import ui.labratories.labratoryUI;
import Controllers.PatientsController;

public class TestApp {

	public static void main(String[] args) {
		Application.connect();
		//UsersManagingUI iden= new UsersManagingUI();
		//AddPatientUI u = new AddPatientUI();
		//new SignInUI();
		
		//MonthlyReport r=new MonthlyReport();
		PatientsController ctrl= new PatientsController(); 
		Patient patient=ctrl.getById("300000002");
		//new NewConfirmUI(patient); 
		
		new labratoryUI();
		
	}
}

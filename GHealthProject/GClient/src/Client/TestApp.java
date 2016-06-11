package Client;

import ui.appointments.AddPatientUI;
import ui.main.Identification;
import ui.main.SignInUI;
import ui.medical.InvoiceUI;
import ui.reports.CeoReport;
import ui.reports.MonthlyReport;


public class TestApp {

	public static void main(String[] args) {
		Application.connect();
		//UsersManagingUI iden= new UsersManagingUI();
		//AddPatientUI u = new AddPatientUI();
		new SignInUI();
		
		//new Identification();  
		//MonthlyReport r=new MonthlyReport();
	//	CeoReport r=new CeoReport();
		//PatientsController ctrl= new PatientsController(); 
		//Patient patient=ctrl.getById("300000002");
		///S lab = (Labratorian)UsersController.getUser("400000000");
		
		//Application.user = lab;
	//	new NewConfirmUI(patient); 
	//	new testconfirm(patient); 
		//new Labratory();
	
	}
}

package Client;

import java.sql.Date;
import java.text.ParseException;

import ClientUI.AddPatientUI;
import ClientUI.ClientUI;
import ClientUI.DoctorMedicalRecordUI;
import ClientUI.Identification;
import ClientUI.NewApp;
import ClientUI.PatientUI;
import Utils.DateTime;
import Utils.Request;
import models.Doctor;
import models.Patient;

public class Application {

	public static Client client = null;

	public static void connect() {
		Config cfg = Config.getConfig();
		if (client != null) {
			client.close();
			client = null;
		}
		client = new Client(cfg.getHost(), cfg.getPort());
		client.open();
		if(client.isConnected()){
			//NewApp settings = new NewApp();

		//	ClientUI ui = new ClientUI();
		}
		else
			System.exit(0);
	}

	public static void main(String[] args) throws ParseException {
		//connect();
		//AddPatientUI u =new AddPatientUI();
		
		
		
		
		//DoctorMedicalRecordUI v = new DoctorMedicalRecordUI(p);
		//Identification iden= new Identification();
		//iden.getFrame().setVisible(true);
		
	}
}

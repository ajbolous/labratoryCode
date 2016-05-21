package Client;

import ClientUI.AddPatientUI;
import ClientUI.ClientUI;
import ClientUI.DoctorMedicalRecordUI;
import ClientUI.Identification;
import ClientUI.NewApp;
import Utils.Request;
import models.Doctor;

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

			ClientUI ui = new ClientUI();
		}
		else
			System.exit(0);
	}

	public static void main(String[] args) {
		//connect();
		//AddPatientUI p = new AddPatientUI();
		DoctorMedicalRecordUI v = new DoctorMedicalRecordUI();
		//Identification iden= new Identification();
	//	iden.getFrame().setVisible(true);
		
	}
}

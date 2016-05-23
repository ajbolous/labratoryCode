package Client;
<<<<<<< HEAD

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
=======
import ClientUI.ClientUI;
import ClientUI.SignInUI;
import Utils.Logger;
import models.User;
>>>>>>> 2f428870a04d59736b344114cea9761637250a04

public class Application {

	public static Client client = null;
	public static User user = null;
	public static void connect() {
		Config cfg = Config.getConfig();
		if (client != null) {
			client.close();
			client = null;
		}
		client = new Client(cfg.getHost(), cfg.getPort());
		client.open();
	}
<<<<<<< HEAD

	public static void main(String[] args) throws ParseException {
		//connect();
		//AddPatientUI u =new AddPatientUI();
		
		
		
		
		//DoctorMedicalRecordUI v = new DoctorMedicalRecordUI(p);
		//Identification iden= new Identification();
		//iden.getFrame().setVisible(true);
		
=======
	
	public static void main(String[] args) {
		Logger log = Config.getConfig().getLogger();
		SignInUI sin;
		ClientUI ui;
		connect();
		if(client.isConnected()){
			log.debug("Connceted");
			new SignInUI();
		}
>>>>>>> 2f428870a04d59736b344114cea9761637250a04
	}
}

package Client;

import java.sql.Date;
import java.text.ParseException;

import ClientUI.AddPatientUI;
import ClientUI.ClientUI;
import ClientUI.DoctorMedicalRecordUI;
import ClientUI.Identification;
import ClientUI.NewApp;
import ClientUI.PatientUI;
import ClientUI.WeeklyReport;
import Utils.DateTime;
import Utils.Request;
import models.Doctor;
import models.Patient;
import ClientUI.ClientUI;
import ClientUI.SignInUI;
import Utils.Logger;
import models.User;

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

	public static void main(String[] args) {
		Logger log = Config.getConfig().getLogger();
		SignInUI sin;
		ClientUI ui;
		connect();
		WeeklyReport rp = new WeeklyReport();
//		if(client.isConnected()){
//			log.debug("Connceted");
//			new SignInUI();
//		}
	}
}

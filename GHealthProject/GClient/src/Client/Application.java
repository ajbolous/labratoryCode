package Client;

import java.sql.Date;
import java.text.ParseException;

import Utils.DateTime;
import Utils.Request;
import models.Doctor;
import models.Patient;
import Utils.Logger;
import models.User;
import ui.appointments.AddApointment;
import ui.appointments.AddPatientUI;
import ui.main.ClientUI;
import ui.main.Identification;
import ui.main.SignInUI;
import ui.medical.DoctorMedicalRecordUI;
import ui.reports.WeeklyReport;

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
		connect();
		if(client.isConnected()){
			log.debug("Connceted");
			new SignInUI();
		}	
	}
}

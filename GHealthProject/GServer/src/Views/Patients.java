package Views;

import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.ImageIcon;

import models.Appointment;
import models.Doctor;
import models.MedicalRecord;
import models.Patient;
import Database.DbHandler;
import Server.Config;
import Utils.Request;

public class Patients extends View {

	/**
	 * Query to get patient from database by his id.
	 * 
	 * @param request
	 *            : "patients/getById" params: "sid" (patient id)
	 * @return Patient instance
	 * @throws SQLException
	 */
	public Object getById(Request request) {
		DbHandler db = Config.getConfig().getHandler();

		try {
			Patient p = db.patients.queryForId((String) request.getParam("sid"));
			return p;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Object getHmoInformation(Request request) {
		return new ImageIcon("/information/" + request.getParam("info"));
	}

	public Object all(Request request) {
		DbHandler db = Config.getConfig().getHandler();
		return null;
	}

	public Object add(Request request) {
		DbHandler db = Config.getConfig().getHandler();
		Patient patient = (Patient) request.getParam("patient");
		MedicalRecord md = new MedicalRecord();

		md.setPatient(patient);
		try {
			md.setCreationDate(Utils.DateTime.currentDate());
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		try {
			db.records.createIfNotExists(md);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			patient.setMedicalRecord(md);
			db.patients.createIfNotExists(patient);
			return "success";
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Object remove(Request request) {
		return null;
	}

	public Object update(Request request) {
		return null;
	}

	public Object createMedicalRecord(Request request) {
		DbHandler db = Config.getConfig().getHandler();
		Patient patient = (Patient) request.getParam("patient");
		MedicalRecord md = (MedicalRecord) request.getParam("medicalRecord");
		try {
			db.records.createIfNotExists(md);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			db.patients.update(patient);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

	public Object sendRequest(Request request) {
		Patient patient = (Patient) request.getParam("patient");
		System.out.println("----------------------------------------");
		System.out.println();

		System.out.println("Request Information about Patient : " + patient.getFirstName() + " " + patient.getLastName()
				+ " sended to HMo :");

		System.out.println("----------------------------------------");
		return "success";
	}
}

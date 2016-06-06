package Controllers;

import java.text.ParseException;
import Client.Application;
import Utils.DateTime;
import Utils.Request;
import models.Doctor;
import models.Examination;
import models.MedicalRecord;
import models.Patient;
import models.Treatment;
import models.Visit;

/**
 * The medicalRecordController contains all the methods necessary to create new
 * visit , treatment , and Examination and to save them in database
 * 
 * @author maisam marjieh
 *
 */
public class MedicalRecordController {



	
	/**
	 * the method send Request to server to save a new treatment in database
	 * @param t treatment will be added to database 
	 * @return the treatment that added to database 
	 */

	public static Object saveTreatment(Treatment t) {
		Request r = new Request("treatments/add");
		r.addParam("treatment", t);
		r.addParam("medical_id", t.getMedicalRecord().getMid());
		r.addParam("date", "start");
		return Application.client.sendRequest(r);

	}
	/**
	 * the method send Request to save a new visit 
	 * @param v visit will be saved in dataBase
	 * @return
	 */

	public static Object saveVisit(Visit v) {

		Request r = new Request("visits/add");
		r.addParam("visit", v);
		r.addParam("treatment_id", v.getTreatment().getTid());
		return Application.client.sendRequest(r);

	}


	public static Object AddMedicalRecord(MedicalRecord md) {

		Request r = new Request("MedicalRecords/add");
		r.addParam("mid", md);
		return Application.client.sendRequest(r);

	}

	public static Object updatTreatment(Treatment t) {
		Request r = new Request("treatments/updateTreatment");
		r.addParam("treatment", t);
		r.addParam("medical_id", t.getMedicalRecord().getMid());
		r.addParam("date", "End");

		return Application.client.sendRequest(r);

	}

	public static Object sendReguestToHMO(Patient p) {
		// TODO Auto-generated method stub
		Request r = new Request("patients/sendRequest");
		r.addParam("patient", p);
		return Application.client.sendRequest(r);

	}

	public static Object getAllLabratories() {
		Request r = new Request("clinics/getClinics");
		return Application.client.sendRequest(r);

	}

}

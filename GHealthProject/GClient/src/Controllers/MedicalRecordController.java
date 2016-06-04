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

public class MedicalRecordController {

	public static void createMedicalRecord(Patient p) {
		MedicalRecord mr = new MedicalRecord();

		try {
			mr.setCreationDate(DateTime.currentDate());
			mr.setPatient(p);
			p.setMedicalRecord(mr);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Request r = new Request("patients/createMedicalRecord");
		r.addParam("medicalRecord", mr);
		r.addParam("patient", p);

		Application.client.sendRequest(r);
	}

	public static Treatment getNewTreatment(Doctor d, MedicalRecord mr) throws ParseException {
		Treatment t = new Treatment();
		t.setDoctor(d);

		try {
			t.setStart(DateTime.currentDate());
		} catch (Exception e) {

		}
		t.setMedicalRecord(mr);
		return t;
	}

	public static Visit getNewVisit(Treatment t) throws ParseException {
		Visit v = new Visit();
		v.setTreatment(t);

		try {
			v.setVisitDate(DateTime.currentDate());
		} catch (Exception e) {

		}
		return v;
	}

	public static Examination getNewReferral(Treatment t) {
		Examination ex = new Examination();
		ex.setTreatment(t);
		try {
			ex.setReferralDate(DateTime.currentDate());
			return ex;
		} catch (Exception e) {
			return ex;
		}
	}

	public static Object saveTreatment(Treatment t) {
		Request r = new Request("treatments/add");
		r.addParam("treatment", t);
		r.addParam("medical_id", t.getMedicalRecord().getMid());
		r.addParam("date", "start");
		return Application.client.sendRequest(r);

	}
	/*
	 * public Object getLastTreatmentInMR(int id) {
	 * 
	 * Request r = new Request("treatments/getLastTreatment");
	 * r.addParam("medical_id", id); r.addParam("date", "start"); return
	 * Application.client.sendRequest(r); }
	 */
	/*
	 * public Object getLastVisitByTid(int id ) {
	 * 
	 * Request r = new Request("visits/getVisit"); r.addParam("treatment_id",
	 * id); return Application.client.sendRequest(r);
	 * 
	 * 
	 * }
	 */

	/*
	 * public Object getLastReferralByTid(int id ) {
	 * 
	 * Request r = new Request("examinations/getLastReferral");
	 * r.addParam("treatment_id", id); return Application.client.sendRequest(r);
	 * 
	 * 
	 * }
	 */

	public static Object saveVisit(Visit v) {

		Request r = new Request("visits/add");
		r.addParam("visits", v);
		r.addParam("treatment_id", v.getTreatment().getTid());
		return Application.client.sendRequest(r);

	}

	public static Object saveReferral(Examination e) {

		Request r = new Request("examinations/add");
		r.addParam("examination", e);
		r.addParam("treatment_id", e.getTreatment().getTid());
		return Application.client.sendRequest(r);

	}

	public static Object saveExaminationResult(Examination e) {
		Request r = new Request("examinations/update");
		r.addParam("examinations", e);
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

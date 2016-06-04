package Controllers;

import models.Clinic;
import models.Examination;

import Client.Application;
import Utils.Request;


public class ExaminationController {
	
	public static Examination getById(int id){
		
		Request r = new Request("Examinations/getById");
		r.addParam("sid", id);
		return (Examination)Application.client.sendRequest(r);
	}
	
	
	public static Clinic getClinic(int cid){
		Request r = new Request("clinics/getById");
		r.addParam("cid", cid);
		return (Clinic)Application.client.sendRequest(r);
	}
}

package Controllers;

import models.Examination;

import Client.Application;
import Utils.Request;


public class Examinationcontroller {
	
	public Examination getById(int id){
		
		Request r = new Request("Examinations/getById");
		r.addParam("sid", id);
		return (Examination)Application.client.sendRequest(r);

	}
}

package Controllers;

import Client.Application;
import Utils.Request;
import models.Patient;

public class PatientsController {

	
	public boolean exists(String id){
		if(getById(id)!=null)
			return true;
		return false;
	}
	public Patient getById(String id){
		
		Request r = new Request("patients/getById");
		r.addParam("sid", id);
		return (Patient)Application.client.sendRequest(r);

	}
	public void AddNewPatient(Patient patient ){
		Request r = new Request("patients/add");
		r.addParam("patient", patient);
		String ress= (String) Application.client.sendRequest(r);
		
		
		
	}
}

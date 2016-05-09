package Controllers;

import java.util.ArrayList;

import ClientUI.Application;
import Utils.Request;
import models.Doctor;

public class DoctorsController {
	public ArrayList<Doctor> getAllDoctors(){
		Request r = new Request("doctors/all");
		return (ArrayList<Doctor>) Application.client.Request(r);
	}
	
	public void addDoctor(String name, String phone){
		Request r = new Request("doctors/add");
		Doctor d = new Doctor();
		d.setFirstName(name);
	
		r.addParam("doctor",d);
		Application.client.Request(r);
	}
}

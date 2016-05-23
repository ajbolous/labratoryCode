package Controllers;

import Client.Application;
import ClientUI.DoctorMedicalRecordUI;
import Utils.Request;
import models.User;

public class IdentifecationController {
	public static void openMedicalRecord(String Id)
	{
		DoctorMedicalRecordUI s = new DoctorMedicalRecordUI();
	}
	
	public static User getUser(String sid){
		Request r = new Request("users/getById");
		r.addParam("sid", sid);
		return (User)Application.client.sendRequest(r);
	}
	
	public static boolean authinticateUser(User u, String password){
		if(u.isOnline())
			return false;
		return u.getPass().equals(password);
	}

	public static User setOnline(User u){
		Request r = new Request("users/setOnline");
		r.addParam("user", u);
		return (User)Application.client.sendRequest(r);
	}
	
}

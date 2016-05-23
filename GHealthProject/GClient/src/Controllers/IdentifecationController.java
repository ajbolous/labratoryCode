package Controllers;

<<<<<<< HEAD
import java.text.ParseException;

import models.Patient;
=======
import Client.Application;
>>>>>>> 2f428870a04d59736b344114cea9761637250a04
import ClientUI.DoctorMedicalRecordUI;
import Utils.Request;
import models.User;

public class IdentifecationController {
<<<<<<< HEAD
	public void openMedicalRecord(String Id) throws ParseException
=======
	public static void openMedicalRecord(String Id)
>>>>>>> 2f428870a04d59736b344114cea9761637250a04
	{
		Patient p = new Patient();
		DoctorMedicalRecordUI s = new DoctorMedicalRecordUI(p);
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

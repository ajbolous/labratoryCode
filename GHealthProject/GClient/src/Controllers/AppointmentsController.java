package Controllers;

import java.util.ArrayList;

import com.j256.ormlite.stmt.DeleteBuilder;

import Client.Application;
import Utils.Request;
import models.Appointment;
import models.Patient;

public class AppointmentsController {

	public boolean deleteAppointment(Appointment app){
		Request r = new Request("appointments/delete");
		r.addParam("appointment", app);
		app=null;
		return   (boolean) Application.client.sendRequest(r);
	}

}

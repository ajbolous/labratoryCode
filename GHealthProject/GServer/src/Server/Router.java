package Server;

import Utils.Request;
import Views.*;

public class Router {
	Doctors doctors = new Doctors();
	Patients patients = new Patients();
	Appointments appointments = new  Appointments();
	Users users = new Users();

	public Router() {
	}

	public Object resolve(Request request) {
		switch (request.getView()) {
		case "doctors":
			return doctors.resolve(request);
		case "patients":
			return patients.resolve(request);
		case "appointments":
			return appointments.resolve(request);
		case "users":
			return users.resolve(request);
		}
		return null;
	}
}
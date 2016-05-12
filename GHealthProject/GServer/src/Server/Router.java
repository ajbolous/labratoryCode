package Server;

import Utils.Request;
import Views.*;

public class Router {
	Doctors doctors = new Doctors();
	Patients patients = new Patients();
	
	public Router() {
	}

	public Object resolve(Request request) {
		switch (request.getView()) {
		case "doctors":
			return doctors.resolve(request);
		case "patients":
			return patients.resolve(request);
		}
		return null;
	}
}
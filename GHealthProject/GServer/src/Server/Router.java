package Server;

import Utils.Request;
import Views.*;

public class Router {
	public Physicians physicians;
	private Doctors doctors;
	public Router() {
		physicians = new Physicians();
	}

	public Object resolve(Request request) {
		switch (request.getView()) {
		case "physicians":
			return physicians.resolve(request);
		case "doctors":
			return doctors.resolve(request);
		}
		return null;
	}
}
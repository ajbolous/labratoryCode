package Client;

import Utils.Request;
import models.Doctor;

public class Application {

	public static Client client = null;

	public static void connect() {
		Config cfg = Config.getConfig();
		if (client != null) {
			client.close();
			client = null;
		}
		client = new Client(cfg.getHost(), cfg.getPort());
		client.open();
		if(client.isConnected()){
			//ClientUI ui = new ClientUI();
		}
		else
			System.exit(0);
	}

	public static void main(String[] args) {
		connect();
		
		Doctor d = new Doctor();
		d.setSid("2007691491");
		d.setFirstName("Bolous");
		d.setLastName("AbuJaber");
		d.setSpeciality("Surgeon");
		Request r = new Request("doctors/add");
		r.addParam("doctor", d);
		client.Request(r);
		
		r = new Request("doctors/update");
		d.setEmail("ajbolous@gmail.com");
		d.setFirstName("Boulos");
		r.addParam("doctor", d);
		client.Request(r);
		 System.exit(0);
	//	Settings settings = new Settings();
	}
}

package Client;

import ClientUI.ClientUI;
import ClientUI.Dis_Identification;
import ClientUI.NewApp;
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
			//NewApp settings = new NewApp();

			ClientUI ui = new ClientUI();
		}
		else
			System.exit(0);
	}

	public static void main(String[] args) {
		connect();
		
		//Dis_Identification iden= new Dis_Identification();
	//	iden.getFrame().setVisible(true);
		
	}
}

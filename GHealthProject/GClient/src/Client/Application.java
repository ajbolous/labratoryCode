package Client;

import Utils.Logger;
import models.User;
import ui.main.SignInUI;

public class Application {

	public static Client client = null;
	public static User user = null;
	
	public static void connect() {
		Config cfg = Config.getConfig();
		if (client != null) {
			client.close();
			client = null;
		}
		client = new Client(cfg.getHost(), cfg.getPort());
		client.open();
	}

	public static void main(String[] args) {
		Logger log = Config.getConfig().getLogger();
		SignInUI sin;
		connect();
		new SignInUI();
	}
}

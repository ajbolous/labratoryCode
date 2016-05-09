package ClientUI;

import Client.Client;
import Client.Config;

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
			ClientUI ui = new ClientUI();
		}
		else
			System.exit(0);
	}

	public static void main(String[] args) {
		connect();
		Settings settings = new Settings();
	}
}

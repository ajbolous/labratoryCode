package Client;

import Utils.Logger;

public class Config {
	public boolean isDebug= true;
	private String host = "localhost";
	private int port = 5000;
	private Logger logger = new Logger(isDebug);
	
	private static Config instance = new Config();

	private Config() {
	}

	public static Config getConfig() {
		return instance;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}


}

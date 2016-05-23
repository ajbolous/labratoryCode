package Server;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;

import com.mysql.jdbc.Driver;

import Database.DbHandler;
import Utils.Logger;
import Utils.Request;
import Views.Appointments;
import models.Person;
import models.Visit;
import ocsf.server.*;

public class Server extends AbstractServer {
	private Logger logger;
	private Router router;

	public Server(int port) {
		super(port);
		this.logger = Config.getConfig().getLogger();
		this.router = new Router();
		logger.info("[GHealth project server]");
		logger.info("Starting local TCP server");
	}

	protected void printStatus() {
		logger.info("Status");
		logger.info("\t[Server is " + (this.isListening() == true ? "online" : "offline"));
		logger.info("\t[Port " + this.getPort());
		logger.info("\t[Clients connected " + this.getNumberOfClients());
		logger.info("-------------------------");
	}

	protected void serverStarted() {
		printStatus();
	}

	protected void clientConnected(ConnectionToClient client) {
		logger.debug("New client connected: " + client.getInetAddress() + ", total : " + this.getNumberOfClients());
	}

	protected void clientDisconnected(ConnectionToClient client) {
		logger.debug("client disconnected: " + client.getInetAddress() + ", total : " + this.getNumberOfClients());
	}

	protected void serverStopped() {
		logger.error("SERVER STOPPED..");
		printStatus();
	}

	protected void handleMessageFromClient(Object message, ConnectionToClient client) {
		Request request = (Request)message;
		logger.info("[REQUEST] from " + client.getInetAddress() + " : " + request.getUrl() + " " + request.getParams().toString());
		try {
			client.sendToClient(router.resolve((Request)request));
		} catch (IOException e) {
			logger.error("Response not sent");
		}
	}

	public static void main(String[] args) throws IOException, SQLException, ParseException {
		Config cfg = Config.fromArgs(args);


		cfg.setHandler(new DbHandler(cfg.getDbUrl(),cfg.getUser(), cfg.getDbPassword()));
		DbHandler db = cfg.getHandler();
		Server server = new Server(cfg.getPort());
		server.listen();
		
		
		
	}
}

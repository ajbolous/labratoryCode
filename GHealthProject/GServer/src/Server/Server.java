package Server;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Date;
import java.util.List;

import com.j256.ormlite.logger.LocalLog;
import com.mysql.jdbc.Driver;

import Database.DbHandler;
import Utils.DateTime;
import Utils.Logger;
import Utils.Request;
import Views.Appointments;
import Views.Reports;
import Views.Users;
import models.Appointment;
import models.Person;
import models.Statistic;
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
		logger.info("-----------------------");
		logger.info("     Server status");
		logger.info("-----------------------");
		logger.info("\t[Server is " + (this.isListening() == true ? "online" : "offline"));
		logger.info("\t[Port " + this.getPort());
		logger.info("\t[Clients connected " + this.getNumberOfClients());
		logger.info("\t[Connected to database : " + Config.getConfig().getDbUrl());
	}

	protected void serverStarted() {
		printStatus();
	}

	protected void clientConnected(ConnectionToClient client) {
		logger.info("New client connected: " + client.getInetAddress() + ", total : " + this.getNumberOfClients());
	}

	 synchronized protected void clientException(ConnectionToClient client, Throwable exception)  {
		logger.info("Client disconnected: " + client.getIp() + ", total : " + this.getNumberOfClients());
		Users.clientDisconnected(client.getIp());
	}
	
	 synchronized protected void clientDisconnected(ConnectionToClient client){
			logger.info("Client unexpectedly disconnected: " + client.getIp() + ", total : " + this.getNumberOfClients());
			Users.clientDisconnected(client.getIp());
	 }

	protected void serverStopped() {
		logger.error("SERVER STOPPED..");
		printStatus();
	}

	protected void handleMessageFromClient(Object message, ConnectionToClient client) {
		Request request = (Request)message;
		request.addParam("ip", client.getInetAddress().getHostAddress());
		logger.info("[REQUEST] from " + client.getInetAddress() + " : " + request.getUrl() + " " + request.getParams().toString());
		try {
			client.sendToClient(router.resolve((Request)request));
		} catch (IOException e) {
			logger.error("Response not sent");
		}
	}

	public static void main(String[] args) throws IOException, SQLException, ParseException {
		Config cfg = Config.fromArgs(args);
		if(!cfg.isDebug())
			System.setProperty(LocalLog.LOCAL_LOG_LEVEL_PROPERTY, "INFO");
		cfg.setHandler(new DbHandler(cfg.getDbUrl(),cfg.getUser(), cfg.getDbPassword()));
		Server server = new Server(cfg.getPort());
		server.listen();		
	}
}

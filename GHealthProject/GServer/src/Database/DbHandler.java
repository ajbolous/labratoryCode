package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Server.Config;
import Utils.Logger;
import models.*;

public class DbHandler {

	private Connection connection;
	private Logger logger;
    private DoctorsHandler doctors;
	public DbHandler(String url, String username, String password) {
		this.logger = Config.getConfig().getLogger();
		try {
			logger.debug("Starting Database driver..");
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			logger.debug("Connecting to Database " + url + " as user: " + username);
			connection = DriverManager.getConnection("jdbc:mysql://" + url, username, password);
			logger.debug("Connected to database.");

		} catch (Exception ex) {
			logger.exception(ex);
		}

		doctors = new DoctorsHandler(connection);
	}

	public boolean createDataBase(){
		try {
			Person.createTable(connection);
		} catch (SQLException e) {
			Config.getConfig().getLogger().exception(e);
		}
		try {
			Doctor.createTable(connection);
		} catch (SQLException e) {
			Config.getConfig().getLogger().exception(e);
		}
		try {
			Patient.createTable(connection);
		} catch (SQLException e) {
			Config.getConfig().getLogger().exception(e);
		}
		return true;
	}
	public Connection getConnection(){
		return connection;
	}
	public DoctorsHandler getDoctors() {
		return doctors;
	}


}

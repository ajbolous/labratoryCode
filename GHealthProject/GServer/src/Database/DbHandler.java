package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Server.Config;
import Utils.Logger;

public class DbHandler {

	private Connection connection;
	private Logger logger;
    private PhysiciansHandler physicians;
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

		physicians = new PhysiciansHandler(connection);
		doctors = new DoctorsHandler(connection);
	}

	public PhysiciansHandler getPhysicians() {
		return physicians;

	}

	public DoctorsHandler getDoctors() {
		return doctors;
	}


}

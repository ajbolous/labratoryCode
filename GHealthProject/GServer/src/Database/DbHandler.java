package Database;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Orm.Orm;
import Server.Config;
import Utils.Logger;
import models.*;

public class DbHandler {

	private Connection connection;
	private Logger logger;
	private DoctorsHandler doctorsHandler;
	private PatientsHandler patientsHandler;
	private PersonsHandler personsHandler;
	private Orm orm;
	
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
		orm = new Orm(connection);
		doctorsHandler = new DoctorsHandler(connection);
		personsHandler = new PersonsHandler(connection);
		patientsHandler = new PatientsHandler(connection);
	}

	public boolean Test() {
		
			try {
				for(Entity t : orm.getObjects(Doctor.class, "doctors.sid=23431 and firstName like '%Bo%'")){
					Doctor d = (Doctor)t;
					Config.getConfig().getLogger().info(d.getFirstName() + d.getSid());

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		
		return false;
	}
	public boolean createDataBase() throws SQLException {
		return false;
	}

	public Connection getConnection() {
		return connection;
	}

	public DoctorsHandler getDoctorsHandler() {
		return doctorsHandler;
	}

	public PersonsHandler getPersonsHandler() {
		return personsHandler;
	}

	public PatientsHandler getPatientsHandler() {
		return patientsHandler;
	}

}

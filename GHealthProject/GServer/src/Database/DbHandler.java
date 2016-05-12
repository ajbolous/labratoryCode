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

		doctorsHandler = new DoctorsHandler(connection);
		personsHandler = new PersonsHandler(connection);
		patientsHandler = new PatientsHandler(connection);
	}

	public boolean Test() throws SQLException{
		Statement stmt = getConnection().createStatement();
		//createDataBase();
		
		Doctor u = new Doctor();
		u.setSid("162559149");
		u.setFirstName("bolous");
		u.setPass("123123");
		u.setSpeciality("Surgon");
		try {
			Orm.put(u, Doctor.class, getConnection());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException e1) {
			e1.printStackTrace();
		}
		
		try {
			Doctor b = (Doctor) Orm.get(Doctor.class, getConnection());
			return true;
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean createDataBase() throws SQLException {
		Statement stmt = getConnection().createStatement();

		
		String sql = Orm.createSql(Person.class);
		try {
			stmt.execute(sql);
		} catch (SQLException e) {
			Config.getConfig().getLogger().exception(e);
		}
		try {
			sql = Orm.createSql(User.class);
			stmt.execute(sql);
		} catch (SQLException e) {
			Config.getConfig().getLogger().exception(e);
		}
		try {
			sql = Orm.createSql(Doctor.class);
			stmt.execute(sql);
		} catch (SQLException e) {
			Config.getConfig().getLogger().exception(e);
		}
		return true;
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

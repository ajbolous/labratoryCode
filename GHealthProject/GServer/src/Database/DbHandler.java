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
			for(int i = 1;i<10;i++){
			Doctor s = new Doctor();
			s.setFirstName("Bolous");
			s.setLastName("abu");
			s.setEmail("ajbol@gma.com");
			s.setPass("123123");
			s.setSid("2" + i);
			s.setSpeciality("doctor");
			orm.saveObject(s);
			}
			
			for(Entity t : orm.getObject(Doctor.class, "")){
				Doctor d = (Doctor)t;
				Config.getConfig().getLogger().info(d.getFirstName());

			}
		} catch (Exception e) {
			Config.getConfig().getLogger().exception(e);
		}
		
		return false;
	}
	public boolean createDataBase() throws SQLException {
		Statement stmt = getConnection().createStatement();

		
		String sql = orm.createSql(Person.class);
		try {
			stmt.execute(sql);
		} catch (SQLException e) {
			Config.getConfig().getLogger().exception(e);
		}
		try {
			sql = orm.createSql(User.class);
			stmt.execute(sql);
		} catch (SQLException e) {
			Config.getConfig().getLogger().exception(e);
		}
		try {
			sql = orm.createSql(Doctor.class);
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

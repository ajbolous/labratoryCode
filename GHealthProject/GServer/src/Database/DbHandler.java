package Database;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.print.attribute.standard.DateTimeAtCompleted;

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
				Visit v = new Visit();
				v.setComments("hello test");
				Date  d = new Date(31, 10, 1988);
				v.setVisitDate(d);
				v.setTid(10);
				v.setVid(2);
				try {
					v.save(orm);
					v.setComments("just changing");
					v.update(orm);
					v.delete(orm);
				} catch (Exception e) {
					// TODO Auto-generated catch block
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

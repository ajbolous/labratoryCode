package Database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
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
		Orm.setOrm(connection);
		doctorsHandler = new DoctorsHandler(connection);
		personsHandler = new PersonsHandler(connection);
		patientsHandler = new PatientsHandler(connection);
	}

	public boolean Test() {

		for (int i = 0; i < 5; i++) {
			try {
				Orm.createTable(MedicalRecord.class);
			} catch (Exception e) {
			}
			try {
				Orm.createTable(Person.class);
			} catch (Exception e) {
			}
			try {
				Orm.createTable(User.class);
			} catch (Exception e) {
			}
			try {
				Orm.createTable(ClinicEmployee.class);
			} catch (Exception e1) {
			}
			try {
				Orm.createTable(Manager.class);
			} catch (Exception e) {
			}

			try {
				Orm.createTable(Labratorian.class);
			} catch (Exception e) {
			}

			try {
				Orm.createTable(Labratory.class);
			} catch (Exception e1) {
			}
			try {
				Orm.createTable(Clinic.class);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		try {
			Clinic c = new Clinic();
			c.setCid(5);
			c.setAddress("addsdheasd");

			Labratory lab = new Labratory();
			lab.setLab_id(10);

			Labratorian l = new Labratorian();
			l.setSid("2023");
			l.setFirstName("bolous");

			lab.setLabratorian(l);
			c.setLabratory(lab);

			Manager m = new Manager();
			m.setSid("120");
			m.setFirstName("bolous abu jaber");
			m.setClinic(c);
			m.save();

			Manager z = (Manager) Orm.getObject(Manager.class, "persons.sid='120'");
			int x = 1;

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

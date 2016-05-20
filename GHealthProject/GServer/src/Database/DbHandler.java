package Database;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import Server.Config;
import Utils.Logger;
import models.*;

public class DbHandler {

	private ConnectionSource connection;
	private Logger logger;

	
	private Dao<Doctor, String> doctors;
	private Dao<Treatment, Integer> treatments;
	private Dao<Visit, Integer> visits;
	private Dao<Patient, String> patients;
	private Dao<MedicalRecord, Integer> records;

	public DbHandler(String url, String username, String password) {
		this.logger = Config.getConfig().getLogger();
		try {
			logger.debug("Connecting to Database " + url + " as user: " + username);
			connection=new JdbcConnectionSource("jdbc:mysql://localhost:3306/test","root","123123");
			
			setDoctors(DaoManager.createDao(connection, Doctor.class));
			setTreatments(DaoManager.createDao(connection, Treatment.class));
			visits =DaoManager.createDao(connection, Visit.class);
			records = DaoManager.createDao(connection, MedicalRecord.class);
			patients = DaoManager.createDao(connection, Patient.class);
			
			createAllTables();

		} catch (Exception ex) {
			logger.exception(ex);
		}
	}
	
	public void createAllTables() throws Exception{
		TableUtils.createTableIfNotExists(connection, Doctor.class);
		TableUtils.createTableIfNotExists(connection, Visit.class);
		TableUtils.createTableIfNotExists(connection, Treatment.class);
		TableUtils.createTableIfNotExists(connection, Patient.class);
		TableUtils.createTableIfNotExists(connection, MedicalRecord.class);		
	}
	
	public ConnectionSource getConnection() {
		return connection;
	}

	public void setConnection(ConnectionSource connection) {
		this.connection = connection;
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public Dao<Visit, Integer> getVisits() {
		return visits;
	}

	public void setVisits(Dao<Visit, Integer> visits) {
		this.visits = visits;
	}

	public Dao<Patient, String> getPatients() {
		return patients;
	}

	public void setPatients(Dao<Patient, String> patients) {
		this.patients = patients;
	}

	public Dao<MedicalRecord, Integer> getRecords() {
		return records;
	}

	public void setRecords(Dao<MedicalRecord, Integer> records) {
		this.records = records;
	}

	public Dao<Doctor, String> getDoctors() {
		return doctors;
	}

	public void setDoctors(Dao<Doctor, String> doctors) {
		this.doctors = doctors;
	}

	public Dao<Treatment, Integer> getTreatments() {
		return treatments;
	}

	public void setTreatments(Dao<Treatment, Integer> treatments) {
		this.treatments = treatments;
	}
}

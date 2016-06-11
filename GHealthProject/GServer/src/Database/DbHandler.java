package Database;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import Server.Config;
import Utils.Logger;
import models.*;

/**
 * Database Handler, the main class that intializes, fills and controls the
 * database using DAO objects.
 * 
 * @author aj_pa
 *
 */
public class DbHandler {

	private ConnectionSource connection;

	public Dao<Doctor, String> doctors;
	public Dao<Patient, String> patients;

	public Dao<MedicalRecord, Integer> records;
	public Dao<Treatment, Integer> treatments;
	public Dao<Visit, Integer> visits;
	public Dao<Examination, Integer> examinations;
	public Dao<Appointment, Integer> appointments;
	public Dao<Statistic, Integer> statistics;
	public Dao<Labratorian, String> labratorians;

	public Dao<Referral, String> refferals;
	public Dao<Shift, String> shifts;
	public Dao<Confirmation, String> confirmations;
	public Dao<Clinic, Integer> clinics;
	public Dao<Secretary, String> secretaries;
	public Dao<Dispatcher, String> dispatchers;
	public Dao<Manager, String> managers;

	/**
	 * need to provide url , user ,pass to conenct to database
	 * 
	 * @param url
	 * @param username
	 * @param password
	 */
	public DbHandler(String url, String username, String password) {
		try {
			connection = new JdbcConnectionSource(url, username, password);
			createAllTables();
			initializeDao();
			fillDataBase();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * fills the database with random data.
	 * 
	 * @throws Exception
	 */
	public void fillDataBase() throws Exception {
		DataFiller df = new DataFiller(this);
		df.fillClinics();
		df.fillDoctors();
		df.fillPatients();
		df.fillMedicalRecords();
		df.fillAppointments();
		df.fillStatistics();
		df.fillShifts();
		df.fillDispatchers();
		df.fillManagers();
	}

	/**
	 * initializes all the DAO for ORM usage
	 * 
	 * @throws Exception
	 */
	public void initializeDao() throws Exception {
		patients = DaoManager.createDao(connection, Patient.class);
		doctors = DaoManager.createDao(connection, Doctor.class);

		records = DaoManager.createDao(connection, MedicalRecord.class);
		treatments = DaoManager.createDao(connection, Treatment.class);
		visits = DaoManager.createDao(connection, Visit.class);
		examinations = DaoManager.createDao(connection, Examination.class);
		appointments = DaoManager.createDao(connection, Appointment.class);

		statistics = DaoManager.createDao(connection, Statistic.class);
		labratorians = DaoManager.createDao(connection, Labratorian.class);
		confirmations = DaoManager.createDao(connection, Confirmation.class);
		shifts = DaoManager.createDao(connection, Shift.class);
		refferals = DaoManager.createDao(connection, Referral.class);
		clinics = DaoManager.createDao(connection, Clinic.class);
		secretaries = DaoManager.createDao(connection, Secretary.class);
		dispatchers = DaoManager.createDao(connection, Dispatcher.class);
		managers = DaoManager.createDao(connection, Manager.class);
	}

	/**
	 * creates all the tables using ORM, it also drops the tables first
	 * 
	 * @throws Exception
	 */
	public void createAllTables() throws Exception {
		TableUtils.dropTable(connection, Manager.class, true);
		TableUtils.dropTable(connection, Patient.class, true);
		TableUtils.dropTable(connection, Doctor.class, true);
		TableUtils.dropTable(connection, Visit.class, true);
		TableUtils.dropTable(connection, Treatment.class, true);
		TableUtils.dropTable(connection, MedicalRecord.class, true);
		TableUtils.dropTable(connection, Examination.class, true);
		TableUtils.dropTable(connection, Labratorian.class, true);
		TableUtils.dropTable(connection, Statistic.class, true);
		TableUtils.dropTable(connection, Appointment.class, true);
		TableUtils.dropTable(connection, Confirmation.class, true);
		TableUtils.dropTable(connection, Shift.class, true);
		TableUtils.dropTable(connection, Referral.class, true);
		TableUtils.dropTable(connection, Secretary.class, true);
		TableUtils.dropTable(connection, Clinic.class, true);
		TableUtils.dropTable(connection, Dispatcher.class, true);

		TableUtils.createTableIfNotExists(connection, Manager.class);
		TableUtils.createTableIfNotExists(connection, Patient.class);
		TableUtils.createTableIfNotExists(connection, Doctor.class);

		TableUtils.createTableIfNotExists(connection, Visit.class);
		TableUtils.createTableIfNotExists(connection, Treatment.class);
		TableUtils.createTableIfNotExists(connection, MedicalRecord.class);
		TableUtils.createTableIfNotExists(connection, Examination.class);

		TableUtils.createTableIfNotExists(connection, Labratorian.class);
		TableUtils.createTableIfNotExists(connection, Statistic.class);
		TableUtils.createTableIfNotExists(connection, Appointment.class);
		TableUtils.createTableIfNotExists(connection, Confirmation.class);
		TableUtils.createTableIfNotExists(connection, Shift.class);
		TableUtils.createTableIfNotExists(connection, Referral.class);
		TableUtils.createTableIfNotExists(connection, Secretary.class);
		TableUtils.createTableIfNotExists(connection, Clinic.class);
		TableUtils.createTableIfNotExists(connection, Dispatcher.class);

	}
}

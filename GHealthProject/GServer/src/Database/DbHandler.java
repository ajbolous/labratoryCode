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
	
	public Dao<Doctor, String> doctors;
	public Dao<Patient, String> patients;
	
	public Dao<MedicalRecord, Integer> records;
	public Dao<Treatment, Integer> treatments;
	public Dao<Visit, Integer> visits;
	public Dao<Examination, Integer> examinations;
	public Dao<Appointment, Integer> appointments;

	public Dao<Labratory, Integer> labratories;
	public Dao<Labratorian, String> labratorians;
	
	public Dao<Referral, String> refferals;
	public Dao<Shift, String> shifts;
	public Dao<Confirmation, String> confirmations;
	public Dao<Clinic, Integer> clinics;


	public DbHandler(String url, String username, String password) {
		try{
			connection=new JdbcConnectionSource(url,username,password);
			createAllTables();
			initializeDao();
			DataFiller df = new DataFiller(this);
			df.fillDoctors();
			df.fillPatients();
			df.fillAppointments();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void initializeDao() throws Exception{
		patients = DaoManager.createDao(connection, Patient.class);
		doctors  = DaoManager.createDao(connection, Doctor.class);
		
		records = DaoManager.createDao(connection, MedicalRecord.class);
		treatments = DaoManager.createDao(connection, Treatment.class);
		visits =DaoManager.createDao(connection, Visit.class);
		examinations =DaoManager.createDao(connection, Examination.class);
		appointments =DaoManager.createDao(connection, Appointment.class);

		
		labratories = DaoManager.createDao(connection, Labratory.class);
		labratorians = DaoManager.createDao(connection, Labratorian.class);
		confirmations = DaoManager.createDao(connection, Confirmation.class);
		shifts = DaoManager.createDao(connection, Shift.class);
		refferals = DaoManager.createDao(connection, Referral.class);
		clinics=DaoManager.createDao(connection, Clinic.class);
	}
	
	public void createAllTables() throws Exception{
		TableUtils.createTableIfNotExists(connection, Patient.class);
		TableUtils.createTableIfNotExists(connection, Doctor.class);
		
		TableUtils.createTableIfNotExists(connection, Visit.class);
		TableUtils.createTableIfNotExists(connection, Treatment.class);
		TableUtils.createTableIfNotExists(connection, MedicalRecord.class);	
		TableUtils.createTableIfNotExists(connection, Examination.class);	

		TableUtils.createTableIfNotExists(connection, Labratory.class);
		TableUtils.createTableIfNotExists(connection, Labratorian.class);
		
		TableUtils.createTableIfNotExists(connection, Appointment.class);	
		TableUtils.createTableIfNotExists(connection, Confirmation.class);	
		TableUtils.createTableIfNotExists(connection, Shift.class);	
		TableUtils.createTableIfNotExists(connection, Referral.class);
		TableUtils.createTableIfNotExists(connection, Clinic.class);	


		
	}
}

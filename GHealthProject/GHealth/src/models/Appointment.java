package models;

import java.sql.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "appoitments")
public class Appointment extends Entity{
	
	public Appointment(){
	}
	public Appointment(Doctor d, Patient p, Date t){
		this.doctor = d;
		this.patient = p;
		this.time = t;
	}
	
	@DatabaseField(generatedId = true)
	private int appointment_id;
	
	@DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "doctor_id")
	private Doctor doctor ; 
	

	@DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "patient_id")
	private Patient patient; 
	
	@DatabaseField()
	private Date time ; 
	
	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	public int getId(){
		return appointment_id;
	}

}

package models;

import java.util.Date;

import Utils.DateTime;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "appoitments")
public class Appointment extends Entity{
	
	public Appointment(){
	}
	public Appointment(Doctor d, Patient p, Date t){
		this.doctor = d;
		this.patient = p;
		this.appointmentTime = t;
		this.appointmentTimeFinish=DateTime.addHoursToTime(t, 30);
	}
	
	@DatabaseField(generatedId = true)
	private int id;
	
	@DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "doctor_id")
	private Doctor doctor ; 
	

	@DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "patient_id")
	private Patient patient; 
	
	@DatabaseField()
	private Date creationTime ; 
	
	@DatabaseField()
	private Date appointmentTime ;
	
	@DatabaseField()
	private Date appointmentTimeFinish;

	@DatabaseField()
	private boolean isCanceled;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	public Date getAppointmentTime() {
		return appointmentTime;
	}
	public void setAppointmentTime(Date appointmentTime) {
		this.appointmentTime = appointmentTime;
	}
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

	public boolean isCanceled() {
		return isCanceled;
	}
	public void setCanceled(boolean isCanceled) {
		this.isCanceled = isCanceled;
	}
	
}

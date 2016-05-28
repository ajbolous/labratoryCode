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
	}
	
	public Appointment(Date t){
		this.appointmentTime = t;
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
	
	public Date getfinishTime(){
		return DateTime.addMinutes(appointmentTime, 30);
	}
	
	
	@Override
	public boolean equals(Object obj){
		
		if(!(obj instanceof Appointment)) return false;
		Date d1_start=((Appointment)obj).getAppointmentTime();
		Date d1_end=((Appointment)obj).getfinishTime();
		Date d2_start=this.appointmentTime;
		Date d2_end=this.getfinishTime();
		if(DateTime.isOverlap(d1_start, d1_end, d2_start, d2_end)) return true;
		return false;
	}
}
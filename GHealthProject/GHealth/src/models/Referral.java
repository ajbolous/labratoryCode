package models;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "referals")
public class Referral extends Entity{
	
	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Confirmation getConfirmation() {
		return confirmation;
	}

	public void setConfirmation(Confirmation confirmation) {
		this.confirmation = confirmation;
	}

	@DatabaseField(generatedId = true)
	private int rid ; 
	
	@DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "patient_id")
	private Patient patient ; 
	
	@DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "doctor_id")
	private Doctor doctor ; 
	
	@DatabaseField()
	private Date date ; 
	
	@DatabaseField()
	private String Description; 
	
	@DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "medical_id")
	private Confirmation confirmation;

}

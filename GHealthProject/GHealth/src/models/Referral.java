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
	public String getDoctor_name() {
		return doctor_name;
	}
	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
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
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
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
	
	@DatabaseField()
	private String doctor_name ; 
	
	@DatabaseField()
	private Date date ; 
	
	@DatabaseField()
	private String Description; 
	@DatabaseField()
	private String speciality; 
	@DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "medical_id")
	private Confirmation confirmation;
	
	
}

package models;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "referals")
public class Referral extends Entity{
	
	private int getRid() {
		return rid;
	}
	private void setRid(int rid) {
		this.rid = rid;
	}
	private Patient getPatient() {
		return patient;
	}
	private void setPatient(Patient patient) {
		this.patient = patient;
	}
	private String getDoctor_name() {
		return doctor_name;
	}
	private void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}
	private Date getDate() {
		return date;
	}
	private void setDate(Date date) {
		this.date = date;
	}
	private String getDescription() {
		return Description;
	}
	private void setDescription(String description) {
		Description = description;
	}
	private String getSpeciality() {
		return speciality;
	}
	private void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	private Confirmation getConfirmation() {
		return confirmation;
	}
	private void setConfirmation(Confirmation confirmation) {
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
	private  String speciality; 
	@DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "medical_id")
	private Confirmation confirmation;
	
	
}

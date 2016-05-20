package models;

import java.sql.Connection;
import java.util.ArrayList;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "patients")
public class Patient extends Person{
	
	@DatabaseField()
	private float weight;
	
	@DatabaseField()
	private float height ;
	
	@DatabaseField()
	private String gender;
	
	//@DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "mid")
	//private ArrayList<Referral> referrals; 
//	@DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "mid")
	//private InformationFromHMo information;
	
	@DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "medical_id")
	private MedicalRecord medicalRecord;
	
	
	public MedicalRecord getMedicalRecord() {
		return medicalRecord;
	}
	public void setMedicalRecord(MedicalRecord medicalRecord) {
		this.medicalRecord = medicalRecord;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

}

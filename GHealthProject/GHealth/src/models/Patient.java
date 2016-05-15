package models;

import java.sql.Connection;
import java.util.ArrayList;

import Orm.*;

@extensionTable(table="persons", field="sid")
public class Patient extends Person{
	@dataField
	private float weight;
	@dataField
	private float height ;
	@dataField
	private String gender;
	
	private ArrayList<Referral> referrals; 
	private InformationFromHMo information;
	
	@objectField(field="mid")
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

package models;

import java.util.ArrayList;

public class Patient extends Person{
	private float weight;
	private float height ;
	private String gender;
	private ArrayList<Referral> referrals; 
	private InformationFromHMo information ; 
	private MedicalRecord medicalRecord ;
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

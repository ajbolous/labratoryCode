package models;

import java.util.ArrayList;

public class Patient extends Person{
	private String nameOfHMO; 
	private int HMOcode ; 
	private float weight; 
	private float hight ; 
	private String gender; 
	private String EmailOfHMO; 
	private  ArrayList<Referral> Referrals; 
	private InformationFromHMo inform ; 
	private MedicalRecord medicalrecord ; 
	
	
}

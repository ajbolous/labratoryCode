package models;

import java.util.ArrayList;

public class Doctor extends Person{
	private String speciality;
	private ArrayList<Shift> shifts;
	private ArrayList<Treatment> treatment ; 

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public ArrayList<Shift> getShifts() {
	
		return shifts;
	}

	public void setShifts(ArrayList<Shift> shifts) {
		this.shifts = shifts;
	}
}

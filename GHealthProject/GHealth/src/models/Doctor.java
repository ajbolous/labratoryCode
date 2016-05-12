package models;

import java.util.ArrayList;

import Orm.*;

@extensionTable(table="users", field="sid")
public class Doctor extends User{

	@dataField
	private String speciality;

	private ArrayList<Shift> shifts;

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

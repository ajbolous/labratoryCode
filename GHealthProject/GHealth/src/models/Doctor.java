package models;

import java.util.ArrayList;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="doctors")
public class Doctor extends User{
	private static final long serialVersionUID = 1L;

	@DatabaseField()
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

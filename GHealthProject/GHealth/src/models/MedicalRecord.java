package models;

import java.sql.Date;
import java.util.ArrayList;

import Orm.*;

public class MedicalRecord extends Entity{
	@pkField
	@dataField
	private int mid;
	@dataField
	private Date creationDate;
	private ArrayList<Treatment> treatments;
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public ArrayList<Treatment> getTreatments() {
		return treatments;
	}
	public void setTreatments(ArrayList<Treatment> treatments) {
		this.treatments = treatments;
	}
}

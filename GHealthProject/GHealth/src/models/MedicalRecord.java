package models;

import java.util.Date;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "medical_records")
public class MedicalRecord extends Entity{

	@DatabaseField(generatedId = true)
	private int mid;
	
	@DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "patient_id")
	private Patient patient;
	
	@DatabaseField()
	private Date creationDate;
	
	@ForeignCollectionField(eager=true , maxEagerLevel=2)
    private ForeignCollection<Treatment> treatments;

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public ForeignCollection<Treatment> getTreatments() {
		return treatments;
	}

	public void setTreatments(ForeignCollection<Treatment> treatments) {
		this.treatments = treatments;
	}
	

}

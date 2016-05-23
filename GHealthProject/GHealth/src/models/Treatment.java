package models;
import java.util.Date;
import java.util.ArrayList;
import java.util.Collection;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "treatments")
public class Treatment extends Entity{

	@DatabaseField(generatedId = true)
	private int tid;
	
	@DatabaseField()
	private Date start;
	
	@DatabaseField()
    private Date end;
	
	@DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "doctor_id")
	private Doctor doctor;
    
	@DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "medical_id")
	private MedicalRecord medicalRecord;
	
	@ForeignCollectionField(eager=true)
    private ForeignCollection<Visit> visits;
	
	@DatabaseField()
    private String status;
	
	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public MedicalRecord getMedicalRecord() {
		return medicalRecord;
	}

	public void setMedicalRecord(MedicalRecord medicalRecord) {
		this.medicalRecord = medicalRecord;
	}

	public ForeignCollection<Visit> getVisits() {
		return visits;
	}

	public void setVisits(ForeignCollection<Visit> visits) {
		this.visits = visits;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public void setDoctor (Doctor doctor)
	{
		this.doctor=doctor;
	}
	
	public Doctor getDoctor()
	{
		return doctor;
	}
	
	public String toString()
	{
		return "Treatment"+this.tid;
	}

	
    
}

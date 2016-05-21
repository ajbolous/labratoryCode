package models;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "examinations")
public class Examination extends Entity{
	@DatabaseField()
	private int eid ; 
	
	@DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "patient_id")
	private Patient patient;
	
	@DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "labratory_id")
	private Labratory labratory;
	
	@DatabaseField()
	private String comments;
	
	@DatabaseField()
	private Date examinationDate;
	
	@DatabaseField()
    private String results;
	
	@DatabaseField()
    private String file;
	
	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Labratory getLabratory() {
		return labratory;
	}

	public void setLabratory(Labratory labratory) {
		this.labratory = labratory;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Date getExaminationDate() {
		return examinationDate;
	}

	public void setExaminationDate(Date examinationDate) {
		this.examinationDate = examinationDate;
	}

	public String getResults() {
		return results;
	}

	public void setResults(String results) {
		this.results = results;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	
}

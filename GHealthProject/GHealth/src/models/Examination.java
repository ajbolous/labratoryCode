package models;

import java.util.Date;

import Utils.DateTime;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "examinations")
public class Examination extends Entity {
	@DatabaseField(generatedId = true)
	private int eid;

	@DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "treatment_id")
	private Treatment treatment;

	@DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "labratorian_id")
	private Labratorian labratorian;

	@DatabaseField()
	private String eType;

	@DatabaseField()
	private String comments;

	@DatabaseField()
	private Date examinationDate;

	@DatabaseField()
	private Date referralDate;
	
	public Date getReferralDate() {
		return referralDate;
	}

	public void setReferralDate(Date referralDate) {
		this.referralDate = referralDate;
	}

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

	public Treatment getTreatment() {
		return treatment;
	}

	public void setTreatment(Treatment treatment) {
		this.treatment = treatment;
	}

	public Labratorian getLabratorian() {
		return labratorian;
	}

	public void setLabratorian(Labratorian lab) {
		labratorian = lab;
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
	public void setEType(String t)
	{
		eType = t;
	}
	
	public String getEType()
	{
		return eType;
	}
	
	public String toString()
	{
		return "Examination"+this.eid+": "+DateTime.getDateString(examinationDate);
	}

}

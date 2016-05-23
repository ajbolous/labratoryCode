package models;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "visits")
public class Visit extends Entity{
	
	

	@DatabaseField(generatedId = true)
	private int vid;	
	
	@DatabaseField()
	private Date visitDate;
	
	@DatabaseField()
	private String comments;
	
	@DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "treatment_id")
	private Treatment treatment;
	
	public int getVid() {
		return vid;
	}

	public void setVid(int vid) {
		this.vid = vid;
	}

	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Treatment getTreatment() {
		return treatment;
	}

	public void setTreatment(Treatment treatment) {
		this.treatment = treatment;
	}
<<<<<<< HEAD

	
	public String toString(){
		return "Visit id:" + this.vid;
	}
	
=======
	
	public String toString(){
		return "Visit"+vid;
		
	}
>>>>>>> 2f428870a04d59736b344114cea9761637250a04
	
}

package models;


import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "shifts")
public class Shift extends Entity{
	
	public Shift(){
		super();
	}
	public Shift(Date startDate, Date endDate,Doctor doctor){
		this.startDate=startDate;
		this.endDate=endDate;
		this.doctor=doctor;
	}
	@DatabaseField(generatedId = true)
	private int id;
	@DatabaseField(uniqueCombo=true)
	private Date startDate;
	
	@DatabaseField(uniqueCombo=true)
	private Date endDate;
	
	@DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "doctor_id" , uniqueCombo=true)
	private Doctor doctor;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
}

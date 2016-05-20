package models;

import java.sql.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "shifts")
public class Shift extends Entity{
	
	@DatabaseField(generatedId = true)
	private int id;
	@DatabaseField()
	private Date startDate;
	
	@DatabaseField()
	private Date endDate;
	
	@DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "doctor_id")
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

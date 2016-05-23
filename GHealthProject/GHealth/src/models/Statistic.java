package models;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
@DatabaseTable(tableName = "statistics")
public class Statistic {
	@DatabaseField(id = true)
    private String id;
	@DatabaseField()
	private Date date;
	@DatabaseField()
	private int numOfPatients;

	@DatabaseField()
	private int waitingPeriod;
	
	public String getid() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getdate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getNumOfPatients() {
		return numOfPatients;
	}
	public void setNumOfPatient(int numOfPatients) {
		this.numOfPatients = numOfPatients;
	}
	
	public int getWaitingPeriod() {
		return waitingPeriod;
	}
	public void setWaitingPeriod(int waitingPeriod) {
		this.waitingPeriod = waitingPeriod;
	} 
	
	
}

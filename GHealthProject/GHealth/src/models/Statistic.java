package models;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
@DatabaseTable(tableName = "statistics")
public class Statistic extends Entity{
	@DatabaseField(generatedId = true)
    private int id;
	@DatabaseField()
	private Date date;
	@DatabaseField()
	private int numOfPatients;

	@DatabaseField()
	private int waitingPeriod;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getNumOfPatients() {
		return numOfPatients;
	}

	public void setNumOfPatients(int numOfPatients) {
		this.numOfPatients = numOfPatients;
	}

	public int getWaitingPeriod() {
		return waitingPeriod;
	}

	public void setWaitingPeriod(int waitingPeriod) {
		this.waitingPeriod = waitingPeriod;
	}

	

	
	
	
}

package models;

import java.sql.Date;
import java.util.ArrayList;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "medical_records")
public class MedicalRecord extends Entity{

	@DatabaseField(generatedId = true)
	private int mid;
	
	@DatabaseField()
	private Date creationDate;
	//private ArrayList<Treatment> treatments;
	
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

}

package models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "confirmations")
public class Confirmation {
	
	@DatabaseField(generatedId = true)
	private int cid ; 
	
	@DatabaseField()
	private int hmo_id ; 
	
	@DatabaseField()
	private String details; 
}

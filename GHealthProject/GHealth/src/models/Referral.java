package models;

import java.sql.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "referals")
public class Referral {
	@DatabaseField(id = true)
	private int Id ; 
	private String DoctorName ; 
	private Date date ; 
	private String Description; 
	private String Specially ; 
	private Patient patient ; 
	private Conformation conform ; //aproval of 
	
	
	

}

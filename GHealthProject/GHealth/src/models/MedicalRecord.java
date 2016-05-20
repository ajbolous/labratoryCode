package models;

import java.util.Date;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "medical_records")
public class MedicalRecord extends Entity{

	@DatabaseField(generatedId = true)
	private int mid;
	
	@DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "patient_id")
	private Patient patient;
	
	@DatabaseField()
	private Date creationDate;
	
	@ForeignCollectionField(eager=true)
    private ForeignCollection<Treatment> treatments;
	

}

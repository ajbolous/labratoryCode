package models;

import java.util.ArrayList;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "labratories")
public class Labratory extends Entity {
	
	@DatabaseField(generatedId = true)
	private int lid;
	
	@DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "clinic_id")
	private Clinic clinc ;
	
	@ForeignCollectionField(eager=true)
    private ForeignCollection<Labratorian>  labratorian;
	
	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public Clinic getClinc() {
		return clinc;
	}

	public void setClinc(Clinic clinc) {
		this.clinc = clinc;
	}

	public ForeignCollection<Labratorian> getLabratorian() {
		return labratorian;
	}

	public void setLabratorian(ForeignCollection<Labratorian> labratorian) {
		this.labratorian = labratorian;
	}
public String toString()
{
	return ""+clinc.getName();
}
	

	
}

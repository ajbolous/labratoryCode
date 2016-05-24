package models;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "labratorians")
public class Labratorian extends ClinicEmployee {
	
	@DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "labratory_id")
	private Labratory labratory;
	
	@ForeignCollectionField(eager=true)
    private ForeignCollection<Examination> examinations;

	public ForeignCollection<Examination> getExaminations() {
		return examinations;
	}

	public void setExaminations(ForeignCollection<Examination> examinations) {
		this.examinations = examinations;
	}

	public Labratory getLabratory() {
		return labratory;
	}

	public void setLabratory(Labratory labratory) {
		this.labratory = labratory;
	}
}

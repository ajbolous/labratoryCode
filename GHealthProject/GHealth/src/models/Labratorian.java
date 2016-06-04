package models;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "labratorians")
public class Labratorian extends ClinicEmployee {
	
	@ForeignCollectionField(eager=false)
    private ForeignCollection<Examination> examinations;

	public ForeignCollection<Examination> getExaminations() {
		return examinations;
	}

	public void setExaminations(ForeignCollection<Examination> examinations) {
		this.examinations = examinations;
	}
}

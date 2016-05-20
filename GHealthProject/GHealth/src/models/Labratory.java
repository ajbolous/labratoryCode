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
	
	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public Labratorian getLabratorian() {
		return labratorian;
	}

	public void setLabratorian(Labratorian labratorian) {
		this.labratorian = labratorian;
	}

	public ForeignCollection<Examination> getExaminations() {
		return examinations;
	}

	public void setExaminations(ForeignCollection<Examination> examinations) {
		this.examinations = examinations;
	}

	@DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "labratorian_id")
	private Labratorian labratorian;

	@ForeignCollectionField(eager=true)
    private ForeignCollection<Examination> examinations;

}

package models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


@DatabaseTable(tableName = "managers")
public class Manager extends ClinicEmployee {
	@DatabaseField()
	private boolean isCeo;

	public boolean isCeo() {
		return isCeo;
	}

	public void setCeo(boolean isCeo) {
		this.isCeo = isCeo;
	}
}
 
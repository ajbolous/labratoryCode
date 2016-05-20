package models;

import com.j256.ormlite.field.DatabaseField;

public abstract class ClinicEmployee extends User{
	
	@DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "clinic_id")
	private Clinic clinic ;

	public Clinic getClinic() {
		return clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	} 
}
 
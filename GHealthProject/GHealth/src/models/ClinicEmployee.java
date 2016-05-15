package models;

import Orm.extensionTable;

@extensionTable(table="users", field="sid")
public class ClinicEmployee extends User{
	private Clinic clinic ;

	public Clinic getClinic() {
		return clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	} 
}
 
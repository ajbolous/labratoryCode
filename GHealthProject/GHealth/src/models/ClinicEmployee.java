package models;

import Orm.extensionTable;
import Orm.objectField;

@extensionTable(table="users", field="sid")
public class ClinicEmployee extends User{
	@objectField(field="cid")
	private Clinic clinic ;

	public Clinic getClinic() {
		return clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	} 
}
 
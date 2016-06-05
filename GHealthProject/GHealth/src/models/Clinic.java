package models;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "clinics")
public class Clinic extends Entity{
	
	@DatabaseField(generatedId = true)
	private int cid ; 
	
	@DatabaseField()
	private String name;
	
	@DatabaseField()
	private String address;
	
	@DatabaseField()
	private String email ;
	
	@DatabaseField()
	private String phone;

	@DatabaseField()
	private boolean hasLabratory;
	
	@ForeignCollectionField(eager=true)
    private ForeignCollection<Labratorian> labratorians;
	
	@ForeignCollectionField(eager=true)
    private ForeignCollection<Doctor> doctors; 
	
	
	
	public boolean isHasLabratory() {
		return hasLabratory;
	}


	public void setHasLabratory(boolean hasLabratory) {
		this.hasLabratory = hasLabratory;
	}


	public int getCid() {
		return cid;
	}


	public void setCid(int cid) {
		this.cid = cid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public ForeignCollection<Labratorian> getLabratorians() {
		return labratorians;
	}


	public void setLabratorians(ForeignCollection<Labratorian> labratorians) {
		this.labratorians = labratorians;
	}


	public ForeignCollection<Doctor> getDoctors() {
		return doctors;
	}


	public void setDoctors(ForeignCollection<Doctor> doctors) {
		this.doctors = doctors;
	}


	public String toString(){
		return "" + getName();
	}
}

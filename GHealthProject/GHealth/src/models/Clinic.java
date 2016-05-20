package models;

import java.util.ArrayList;

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

	public Labratory getLabratory() {
		return labratory;
	}

	public void setLabratory(Labratory labratory) {
		this.labratory = labratory;
	}

	public ForeignCollection<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(ForeignCollection<Doctor> doctors) {
		this.doctors = doctors;
	}

	public Secretary getSecretary() {
		return secretary;
	}

	public void setSecretary(Secretary secretary) {
		this.secretary = secretary;
	}

	@DatabaseField()
	private String phone;

	@DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "labratory_id")
	private Labratory labratory;
	
	@ForeignCollectionField(eager=true)
    private ForeignCollection<Doctor> doctors; 
	
	@DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "secretary_id")
    private Secretary secretary; 
	
}

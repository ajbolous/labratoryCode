package models;

import java.util.ArrayList;

import Orm.*;

public class Clinic extends Entity{
	@dataField
	@pkField
	private int cid ; 
	
	@dataField
	private String name;
	@dataField
	private String address;
	@dataField
	private String email ;
	@dataField
	private String phone;
	@objectField(field="lab_id")
	private Labratory labratory;
	private ArrayList<ClinicEmployee> employees ; 
	
	
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public Labratory getLabratory() {
		return labratory;
	}
	public void setLabratory(Labratory labratory) {
		this.labratory = labratory;
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
	public ArrayList<ClinicEmployee> getEmployees() {
		return employees;
	}
	public void setEmployees(ArrayList<ClinicEmployee> employees) {
		this.employees = employees;
	}


}

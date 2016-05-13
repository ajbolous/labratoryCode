package models;

import java.util.ArrayList;

public class Clinic {
	private int cid ; 
	private String Name;
	private String Address; 
	private String Email ; 
	private String Phone;
	private ArrayList<ClinicEmployees> Employees ;
	private Manager manager ; //manager Of clinic 
	private ArrayList <Labratory> labs; 

}

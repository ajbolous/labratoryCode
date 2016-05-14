package models;

import java.util.ArrayList;

import Orm.*;

public class Clinic {
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
	private ArrayList<ClinicEmployees> employees ; 

}

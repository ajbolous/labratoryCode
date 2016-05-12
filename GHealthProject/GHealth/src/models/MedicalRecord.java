package models;

import java.sql.Date;
import java.util.ArrayList;

public class MedicalRecord {
	private int id ; 
	private Patient patient;
	private Date creationDate;
	private ArrayList<Treatment> treatments;
}

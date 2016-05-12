package models;

import java.sql.Date;
import java.util.ArrayList;

public class MedicalRecord {
	private int mid;
	private String pid;
	private Patient patient;
	private Date creationDate;
	private ArrayList<Treatment> treatments;
}

package models;

import java.sql.Date;
import java.util.ArrayList;

public class Treatment {
	private int Inum ; 
	private Date BeginDate;
	private Doctor doctor ; 
    private Date EndDate; 
    private ArrayList<Visit> visits ; 
    private String TreatmentReport;  //private TreatmentReport treatmentreport
}

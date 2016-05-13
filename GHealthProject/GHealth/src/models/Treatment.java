package models;

import java.sql.Date;
import java.util.ArrayList;

public class Treatment {
	private int Inum; 
	private Date BeginDate;
    private Date EndDate; 
    private ArrayList<Visit> visits ;
    private ArrayList<ExaminationReferral> ExaminationRef; // I don't sure 
    private String TreatmentReport;  //private TreatmentReport treatmentreport
    private Invoice payment ; // payment for treatment 
}

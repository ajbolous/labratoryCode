package Controllers;

import java.text.ParseException;
import java.util.Calendar;

import Client.Application;
import ClientUI.DoctorMedicalRecordUI;
import Utils.DateTime;
import Utils.Request;
import models.Doctor;
import models.Examination;
import models.MedicalRecord;
import models.Patient;
import models.Treatment;
import models.Visit;

public class MedicalRecordController {

	
	public Treatment getNewTreatment(Doctor d , MedicalRecord mr ) throws ParseException
	{
		Treatment t =new Treatment();
		t.setDoctor(d);
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		int currentMonth=Calendar.getInstance().get(Calendar.MONTH);
		int currentday= Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		try{
		t.setStart(DateTime.getDate(currentYear, currentMonth, currentday));
		}
		catch(Exception e)
		{
			
		}
		t.setMedicalRecord(mr);
		return t;
	}
	
	public Visit getNewVisit(Treatment t ) throws ParseException
	{
		Visit v =new Visit();
		v.setTreatment(t);
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		int currentMonth=Calendar.getInstance().get(Calendar.MONTH);
		int currentday= Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		try{
		v.setVisitDate((DateTime.getDate(currentYear, currentMonth, currentday)));
		}
		catch(Exception e)
		{
			
		}
		return v;
	}
	
	public Examination getNewExamination(Treatment t ) throws ParseException
	{
		Examination ex =new Examination();
		ex.setTreatment(t);
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		int currentMonth=Calendar.getInstance().get(Calendar.MONTH);
		int currentday= Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		try{
		ex.setExaminationDate(DateTime.getDate(currentYear, currentMonth, currentday));
		}
		catch(Exception e)
		{
			
		}
		
		return ex;
	}
	
	
	 public void saveTreatment(Treatment t)
	 {
		 Request r = new Request("treatments/add");
		 r.addParam("treatment", t);
		 
		 Application.client.sendRequest(r);
		
		 
	 }
	 
	 public void saveVisit(Visit v )
	 {
		
		 Request r = new Request("visits/add");
		 r.addParam("visit", v);
		 Application.client.sendRequest(r);
		 
	 }
	 
	 public void saveExamination(Examination e )
	 {
		
		 Request r = new Request("examinations/add");
		 r.addParam("examination", e);
		 Application.client.sendRequest(r);
		 
	 }
	 public void AddMedicalRecord(MedicalRecord md )
	 {
		
		 Request r = new Request("MedicalRecords/add");
		 r.addParam("mid", md);
		 Application.client.sendRequest(r);
		 
	 }


}

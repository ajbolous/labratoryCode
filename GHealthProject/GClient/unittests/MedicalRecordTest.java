import Client.Application;
import Client.Config;
import Controllers.PatientsController;
import models.MedicalRecord;
import models.Patient;
import junit.framework.TestCase;


public class MedicalRecordTest extends TestCase {

	private Patient p ;
	private Patient p2;
	private MedicalRecord m ;
	
	
	
	protected void setUp() throws Exception {
		Config.getConfig().readTextConfig();
		Application.connect();
		p = new Patient();
	   p.setSid("205495165");
	   p.setLastName("cohen");
	   p.setFirstName("toni");
	   p2 = new Patient();
	   p2.setSid("300000000");
	   m = new MedicalRecord();
	   m.setMid(1);
	   m.setPatient(p2);
	   p2.setMedicalRecord(m);
	   
		
	}
	
	public void testadd_patientNotExist()
	{
		boolean result = PatientsController.AddNewPatient(p);
		boolean expected =true; 
		assertEquals(expected, result);
	}
	
	public void testadd_patientExist()
	{
		boolean result = PatientsController.AddNewPatient(p);
		boolean expected =false; 
		assertEquals(expected, result);
	}
	
	

}

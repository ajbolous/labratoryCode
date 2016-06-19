
import Client.Application;
import Client.Config;
import Controllers.PatientsController;
import Controllers.UsersController;
import models.Doctor;
import models.Patient;
import models.User;
import junit.framework.TestCase;


public class LoginTests extends TestCase {
	
	private Doctor d1 ;

	
	protected void setUp() throws Exception {
		Config.getConfig().readTextConfig();
		Application.connect();
		
		d1 = new Doctor ();
		d1.setSid("200000000");
		d1.setPass("123123");
		
		
	}
	
	public void getUserTest_UserIsExist() {
		Doctor result = (Doctor) UsersController.getUser("200000000");
		Doctor expected = d1;
		assertTrue(expected.getSid().equals(result.getSid()));
	}

	// check if the method return null about wrong id(user not exist )
	public void getUserTest2() {
		Doctor result = (Doctor)UsersController.getUser("205495161");
		Doctor expected = null;
		assertEquals(expected, result);
	}

	public void authinticateUserTest_correct_password() {
		boolean result = UsersController.authinticateUser(d1, "200000000");
		boolean expected = true;
		assertEquals(expected, result);
	}

	public void authinticateUserTest_incorrect_password() {
		boolean result = UsersController.authinticateUser(d1, "200000235");
		boolean expected = false;
		assertEquals(expected, result);
	}

	public void isOnlineTest_is_not_online() {
		boolean result = UsersController.setOnline(d1);
		boolean expected = true;
		assertEquals(expected, result);
		}

	public void isOnlineTest_is_online() {
		boolean result = UsersController.setOnline(d1);
		boolean expected = false;
		assertEquals(expected, result);
	}
	
	

	

}

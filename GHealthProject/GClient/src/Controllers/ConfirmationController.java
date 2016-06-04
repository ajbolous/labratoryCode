package Controllers;

import models.Confirmation;
import models.Doctor;
import Client.Application;
import Utils.Request;

public class ConfirmationController {
	
	public void addConfirmation(Confirmation c){
		Request r = new Request("confirmations/add");
		r.addParam("confirmation", c);
		Application.client.sendRequest(r);
	}
	
	/*public boolean IshasConfirm(Patient p){
		
	}*/

}

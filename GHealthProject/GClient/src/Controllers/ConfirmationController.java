package Controllers;

import models.Confirmation;
import models.Doctor;
import Client.Application;
import Utils.Request;

public class ConfirmationController {
	public void addDoctor(String NumRefferal ,String NumApproval, String details ){
		Request r = new Request("confirmations/add");
		Confirmation c = new Confirmation();
		Application.client.sendRequest(r);
	}

}

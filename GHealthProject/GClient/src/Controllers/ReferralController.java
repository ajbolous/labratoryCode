package Controllers;


import models.Referral;
import Client.Application;
import Utils.Request;

public class ReferralController {
	
	public void addReferralHMO(Referral ref){
		Request r = new Request("referrals/add");
		r.addParam("ref", ref);
		Application.client.sendRequest(r);
	}

}

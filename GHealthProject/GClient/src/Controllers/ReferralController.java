package Controllers;

import models.Patient;
import models.Referral;
import Client.Application;
import Utils.Request;

public class ReferralController {

	public void addReferralHMO(Referral ref) {
		Request r = new Request("referrals/add");
		r.addParam("ref", ref);
		Application.client.sendRequest(r);
	}

	public void addConfirmHMO(Referral referal) {
		Request r = new Request("referrals/update");
		r.addParam("con", referal);
		Application.client.sendRequest(r);
		
	}
	public boolean referralActiveForSpec(Patient p , String Spec){
		for(Referral ref : p.getReferrals()){
			   if (ref.isActive()== true && 
					   ref.getSpeciality().compareTo(Spec)== 0 ){
				   return true ; 
			   }
			}
		return false ; 
		}
	
	public boolean referralFinshed(Patient p , String Spec){
		Request r = new Request("referrals/update");
		for(Referral ref : p.getReferrals()){
			   if (ref.isActive()== true && ref.getSpeciality().compareTo(Spec)== 0 ){
				   ref.setActive(false);
				   r.addParam("ref", ref);
					Application.client.sendRequest(r);
				   return true ; 
			}
		}
		return false;
	}
	
	
}


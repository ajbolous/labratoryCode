package Controllers;

import models.Invoice;
import models.Secretary;
import Client.Application;
import Utils.Request;

public class InvoiceController {
	
public Object getAllopenTreatments(Secretary sec)
	
	{
		 Request r = new Request("treatments/getTreatment");
		 r.addParam("Secretary",sec);
		  return  Application.client.sendRequest(r);
		
	}
public Object sendInvoice(Invoice invoice)
{
	
	 Request r = new Request("invoices/send");
	 r.addParam("Invoice",invoice);
	  return  Application.client.sendRequest(r);
	
	
	
}


}

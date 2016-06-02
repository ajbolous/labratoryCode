package Views;

import java.sql.SQLException;

import models.Invoice;
import models.Treatment;
import Database.DbHandler;
import Server.Config;
import Utils.Request;
 
public class Invoices extends View{
	public Object send (Request request)
	{
		DbHandler db = Config.getConfig().getHandler();
		Invoice invoice = (Invoice)request.getParam("Invoice");
		Treatment treatment  = invoice.getTreatment();
		treatment.setHasInvoice(false);
		try {
			db.treatments.update(treatment);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("----------------------------------------");
		System.out.println();
	
				System.out.println("Invoice was send to HMO. \nInvoice Details  : "+"Invoice number" +invoice.getInvoiceId() +" \nTreatment"+invoice.getTreatment().getTid() +
						" \n Payment : "+invoice.getPayment());
				
		
		
		System.out.println("----------------------------------------");
		return "success";
	}
	

}

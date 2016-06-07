package Views;

import java.sql.SQLException;

import models.Invoice;
import models.Treatment;
import Database.DbHandler;
import Server.Config;
import Utils.Request;
 
/**
 * Database view for invoice , have all the invoice  Queries.
 * @author maisam marjieh 
 *
 */
public class Invoices extends View{
	

	/**
	 * send the invoice to HMO 
	 * @param request contains the new invoice 
	 * @return success message 
	 */
	public Object send (Request request)
	{
		DbHandler db = Config.getConfig().getHandler();
		Invoice invoice = (Invoice)request.getParam("Invoice");

		System.out.println("----------------------------------------");
		System.out.println();
	
				System.out.println("Invoice was send to HMO. \nInvoice Details  : "+"\nInvoice " +invoice.getInvoiceId() +" \nabout\nTreatment"+invoice.getTreatment().getTid() +
						" \n Payment : "+invoice.getPayment());
				
		
		
		System.out.println("----------------------------------------");
		return "success";
	}
	

}

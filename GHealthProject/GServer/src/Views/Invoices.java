package Views;

import java.sql.SQLException;

import models.Invoice;
import models.Treatment;
import Database.DbHandler;
import Server.Config;
import Utils.Request;

/**
 * Database view for invoice , have all the invoice Queries.
 * 
 * @author maisam marjieh
 *
 */
public class Invoices extends View {

	/**
	 * send the invoice to HMO
	 * 
	 * @param request
	 *            contains the new invoice
	 * @return success message
	 */
	public Object send(Request request) {
		Invoice invoice = (Invoice) request.getParam("Invoice");
		System.out.println("----------------------------------------");
		System.out.println("Invoice was sent to HMO. \nDetails: " + "\nID : " + invoice.getInvoiceId()
				+ "\nTreatment id :" + invoice.getTreatment().getTid() + "\nTreatment type : "
				+ invoice.getTreatment().gettType() + "\nPayment : " + invoice.getPayment());

		System.out.println("----------------------------------------");
		return "success";
	}

}

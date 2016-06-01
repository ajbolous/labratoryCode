package models;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
@DatabaseTable(tableName = "invoices")
public class Invoice extends Entity {
	
	@DatabaseField(generatedId = true)
	private int InvoiceId; 
	@DatabaseField()
	private double Payment; 
	@DatabaseField()
	private Date date;
	@DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "treatment_id")
	private Treatment treatment;
	
	@DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "secretary_id")
	private Secretary secretary;
	
	public Secretary getSecretary() {
		return secretary;
	}
	public void setSecretary(Secretary secretary) {
		this.secretary = secretary;
	}
	public int getInvoiceId() {
		return InvoiceId;
	}
	public void setInvoiceId(int invoiceId) {
		this.InvoiceId = invoiceId;
	}
	public double getPayment() {
		return Payment;
	}
	public void setPayment(double payment) {
		Payment = payment;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Treatment getTreatment() {
		return treatment;
	}
	public void setTreatment(Treatment treatment) {
		this.treatment = treatment;
	}
	
}

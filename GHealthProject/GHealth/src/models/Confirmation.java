package models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "confirmations")
public class Confirmation {
	
	private int getCid() {
		return cid;
	}

	private void setCid(int cid) {
		this.cid = cid;
	}

	private int getHmo_id() {
		return hmo_id;
	}

	private void setHmo_id(int hmo_id) {
		this.hmo_id = hmo_id;
	}

	private String getRefferal_id() {
		return Refferal_id;
	}

	private void setRefferal_id(String refferal_id) {
		Refferal_id = refferal_id;
	}

	private String getApproval_id() {
		return Approval_id;
	}

	private void setApproval_id(String approval_id) {
		Approval_id = approval_id;
	}

	private String getDetails() {
		return details;
	}

	private void setDetails(String details) {
		this.details = details;
	}

	private int getApprovalStatus() {
		return ApprovalStatus;
	}

	private void setApprovalStatus(int approvalStatus) {
		ApprovalStatus = approvalStatus;
	}

	private Patient getPatient() {
		return patient;
	}

	private void setPatient(Patient patient) {
		this.patient = patient;
	}

	@DatabaseField(generatedId = true)
	private int cid ; 
	
	@DatabaseField()
	private int hmo_id ; 
	
	@DatabaseField()
	private String Refferal_id ; 
	
	@DatabaseField()
	private String Approval_id ; 
	
	@DatabaseField()
	private String details; 
	
    @DatabaseField()
    private int ApprovalStatus;
    
	@DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "patient_id")
	private Patient patient;
}

package models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "confirmations")
public class Confirmation  extends Entity {
	
	@DatabaseField(generatedId = true)
	private int cid ; 
	@DatabaseField()
	private String refferal_id ; 
	
	@DatabaseField()
	private String approval_id ; 
	
	@DatabaseField()
	private String details; 
	
	@DatabaseField()
	private String hmo_id ; 
	
	
	
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getHmo_id() {
		return hmo_id;
	}

	public void setHmo_id(String idHMOO) {
		this.hmo_id = idHMOO;
	}

	public String getRefferal_id() {
		return refferal_id;
	}

	public void setRefferal_id(String refferal_id) {
		this.refferal_id = refferal_id;
	}

	public String getApproval_id() {
		return approval_id;
	}

	public void setApproval_id(String approval_id) {
		this.approval_id = approval_id;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
    
}

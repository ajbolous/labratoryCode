package models;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

import Orm.*;

public class Treatment extends Entity{
	@dataField
	@pkField
	private int tid;
	@dataField
	private Date start;
	@dataField
    private Date end;
	
    private ArrayList<Visit> visits ;
    @dataField
    private String status;  //private TreatmentReport treatmentreport
    
    public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public ArrayList<Visit> getVisits() {
		return visits;
	}
	public void setVisits(ArrayList<Visit> visits) {
		this.visits = visits;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}

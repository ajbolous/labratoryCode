package models;

import java.sql.Connection;
import java.sql.Date;

import Orm.Orm;
import Orm.dataField;
import Orm.fkField;
import Orm.pkField;

public class Visit extends Entity{
	
	@dataField
	@pkField
	private int vid;
	
	@dataField
	@pkField
	@fkField(target = "treatments(tid)")
	private int tid;
	
	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public Date getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	@dataField
	private Date visitDate;
	@dataField
	private String comments;
}

package models;
import java.util.Date;
import java.util.ArrayList;
import java.util.Collection;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "treatments")
public class Treatment extends Entity{

	@DatabaseField(generatedId = true)
	private int tid;
	
	@DatabaseField()
	private Date start;
	@DatabaseField()

    private Date end;
    
	@ForeignCollectionField(eager=true)
    private ForeignCollection<Visit> visits;
	
	@DatabaseField()
    private String status;  //private TreatmentReport treatmentreport
    
	
	public void addVisit(Visit v){
		v.setTreatment(this);
		visits.add(v);
	}
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
	public Collection<Visit> getVisits() {
		return visits;
	}
	public void setVisits(ForeignCollection<Visit> visits) {
		this.visits = visits;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}

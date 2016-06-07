package models;

import java.util.Date;

import Utils.DateTime;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Visit Entity class
 * @author maisam marjieh
 *
 */
@DatabaseTable(tableName = "visits")
public class Visit extends Entity{
	
	/**
	 * visit id
	 */
	@DatabaseField(generatedId = true)
	private int vid;
	
	/**
	 * visit date
	 */
	
	@DatabaseField()
	private Date visitDate;
	
	/**
	 * visit comments 
	 */
	
	@DatabaseField()
	private String comments;
	
	/**
	 * the treatment that visit belongs to him 
	 */
	
	@DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "treatment_id")
	private Treatment treatment;
	
	/**
	 * 
	 * @return visit id
	 */
	
	public int getVid() {
		return vid;
	}
	
	/**
	 * set visit id
	 */

	public void setVid(int vid) {
		this.vid = vid;
	}
	/**
	 * 
	 * @return visit Date
	 */

	public Date getVisitDate() {
		return visitDate;
	}
	
	/**
	 * set visit Date 
	 * @param visitDate
	 */

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}
	/**
	 * 
	 * @return visit comments
	 */

	public String getComments() {
		return comments;
	}
	/**
	 * set visit comments 
	 * @param comments
	 */

	public void setComments(String comments) {
		this.comments = comments;
	}
	
	/**
	 * 
	 * @return treatment 
	 */

	public Treatment getTreatment() {
		return treatment;
	}
	/**
	 * set the treatment that visit belongs to him  
	 * @param treatment
	 */

	public void setTreatment(Treatment treatment) {
		this.treatment = treatment;
	}
	
	
	public String toString(){
		return "Visit" +vid+ ": "+DateTime.getDateString(visitDate);
		
	}
	
}

package models;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="doctors")
public class Doctor extends ClinicEmployee{
	private static final long serialVersionUID = 1L;

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public ForeignCollection<Shift> getShifts() {
		return shifts;
	}

	public void setShifts(ForeignCollection<Shift> shifts) {
		this.shifts = shifts;
	}

	public ForeignCollection<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(ForeignCollection<Appointment> appointments) {
		this.appointments = appointments;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@DatabaseField()
	private String speciality;

	@ForeignCollectionField(eager=true)
    private ForeignCollection<Shift> shifts;
	
	@ForeignCollectionField(eager=true)
    private ForeignCollection<Appointment> appointments;

}

package Views;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.j256.ormlite.stmt.QueryBuilder;

import Database.DbHandler;
import Server.Config;
import Utils.Request;

import models.Doctor;
import models.Secretary;
import models.Treatment;


public class Treatments extends View {

	DbHandler db = Config.getConfig().getHandler();

	public Object add(Request request) {

		try {
			db.treatments.create((Treatment) request.getParam("treatment"));
			return getLastTreatment(request);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public Object updateTreatment(Request request) {
		DbHandler db = Config.getConfig().getHandler();
		try {
			db.treatments.update((Treatment) request.getParam("treatment"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getLastTreatment(request);
	}

	public Object getLastTreatment(Request request) {
		QueryBuilder<Treatment, Integer> q = db.treatments.queryBuilder();
		List<Treatment> treatments;

		try {
			treatments = q
					.orderBy((String) request.getParam("date"), false)
					.limit(1)
					.where()
					.eq("medical_id",
							((Integer) request.getParam("medical_id"))).query();
			if (treatments.size() == 0)
				return null;
			else
				return treatments.get(0);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public Object getTreatment(Request request) {
		QueryBuilder<Doctor, String> d = db.doctors.queryBuilder();
		QueryBuilder<Treatment, Integer> p = db.treatments.queryBuilder();
		List<Doctor> doctor;
		Secretary secr = (Secretary) request.getParam("Secretary");
		List<Treatment> tretmentList;
		List<Treatment> allTreatment = new ArrayList<Treatment>();

		try {
			doctor = d.where().eq("clinic_id", secr.getClinic().getCid())
					.query();
			for (Doctor doc : doctor) {
				tretmentList = p.where().eq("endFlag", true).and()
						.eq("hasInvoice", false).and()
						.eq("doctor_id", doc.getSid()).query();
				allTreatment.addAll(tretmentList);
			}
			return allTreatment;
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;

		}

	}

}

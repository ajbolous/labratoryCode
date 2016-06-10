package Views;

import java.sql.SQLException;
import java.util.List;

import com.j256.ormlite.stmt.QueryBuilder;

import models.Examination;
import models.Visit;
import Database.DbHandler;
import Server.Config;
import Utils.Request;

/**
 * Database view for visits , have all the visit Queries.
 * 
 * @author maisam marjieh
 *
 */
public class Visits extends View {

	/**
	 * Query to add a new visit to database
	 * 
	 * @param request:
	 *            contains the visit which will be saved
	 * @return visit
	 * @throws SQLException
	 */
	public Object add(Request request) {
		DbHandler db = Config.getConfig().getHandler();
		Visit v = (Visit) request.getParam("visit");
		try {
			db.visits.create(v);
			return getVisit(request);
		} catch (SQLException e) {
			Config.getConfig().getLogger().exception(e);
			return null;
		}
	}

	/**
	 * Query to get the last visit which added to specific treatment
	 * 
	 * @param request
	 *            contains the treatment_id of the treatment
	 * @return visit instance
	 * @throws SQLException
	 */
	public Object getVisit(Request request) {
		DbHandler db = Config.getConfig().getHandler();
		QueryBuilder<Visit, Integer> q = db.visits.queryBuilder();
		List<Visit> visit;
		try {
			visit = q.orderBy("visitDate", false).limit(1).where()
					.eq("treatment_id", (Integer) request.getParam("treatment_id")).query();
			if (visit.size() == 0)
				return null;
			else
				return visit.get(0);

		} catch (SQLException e) {
			Config.getConfig().getLogger().exception(e);
			return null;
		}

	}

}

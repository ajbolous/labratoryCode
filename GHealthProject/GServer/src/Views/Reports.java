package Views;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import com.j256.ormlite.dao.RawRowMapper;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;

import models.Appointment;
import models.Doctor;
import models.Report;
import Database.DbHandler;
import Server.Config;
import Utils.DateTime;
import Utils.Request;
import models.Statistic;

public class Reports extends View {

	public Object numOfPatient(Request request) throws Exception {
		DbHandler db = Config.getConfig().getHandler();
		Statistic s = new Statistic();
		QueryBuilder<Appointment, Integer> q = db.appointments.queryBuilder();

		try {
			q.where().between("appointmentTime",
					Utils.DateTime.getDate(2016, 10, 5, 0, 0),
					Utils.DateTime.getDate(2016, 10, 7));
		} catch (SQLException e) {
			e.printStackTrace();
			return null;

		}

		List<Appointment> lp = q.query();
		int x = lp.size();
		s.setNumOfPatients(x);
		return x;
	}

	public Object getMonthlyReport(Request request) {
		Date d = (Date) request.getParam("date");
		return buildMonthlyReport(d);
	}
	
	public Report buildMonthlyReport(Date d){
		Report r = new Report();
		r.setStatistic(new ArrayList<Statistic>());
		int i = 0;

		Statistic stat = new Statistic();
		for (Statistic s : reportByDate(d, Utils.DateTime.addMonth(d))) {
			stat.setDate(s.getDate());
			stat.setNumOfPatients(s.getNumOfPatients()
					+ stat.getNumOfPatients());
			stat.setWaitingPeriod(s.getWaitingPeriod()
					+ stat.getWaitingPeriod());
			i++;

			if (i % 7 == 0) {
				r.getStatistic().add(stat);
				stat = new Statistic();
			}
		}

		fillStat(r);
		return r;
	}
	public Object getNMonths(Request request) {
		Date d = null;
		try {
			d = (Date) DateTime.currentMont();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int n=(int)request.getParam("N");
		Report r = new Report();

		r.setStatistic(new ArrayList<Statistic>());
		int j;
		Statistic stat = new Statistic();
		for(j=0;j<n;j++)
		{
			
			Report rN=buildMonthlyReport(d);	
		d=Utils.DateTime.MinusMonth(d);
		for (Statistic s : rN.getStatistic()) {
			
			stat.setNumOfPatients(s.getNumOfPatients()
					+ stat.getNumOfPatients());
			stat.setWaitingPeriod(s.getWaitingPeriod()
					+ stat.getWaitingPeriod());
			
				
			
		}
		stat.setDate(d);
		r.getStatistic().add(stat);
		stat = new Statistic();	
		}

		fillStat(r);
		return r;
	}

	public Object getWeeklyReport(Request request) {
		Date d = (Date) request.getParam("date");

		return buildWeeklyReport(d);
	}

	public Report buildWeeklyReport(Date d) {
		Report r = new Report();
		ArrayList<Statistic> stat = (ArrayList<Statistic>) reportByDate(d,
				Utils.DateTime.addDay(d, 7));
		r.setStatistic(stat);
		r = fillStat(r);
		return r;
	}

	private Report fillStat(Report r) {
		int size = r.getStatistic().size();
		for (Statistic s : r.getStatistic()) {
			r.setpAvg(r.getpAvg() + s.getNumOfPatients());
			r.setwAvg(r.getwAvg() + s.getWaitingPeriod());
			if (s.getNumOfPatients() > r.getpMax())
				r.setpMax(s.getNumOfPatients());
			if (s.getNumOfPatients() < r.getpMin())
				r.setpMin(s.getNumOfPatients());
			if (s.getWaitingPeriod() > r.getwMax())
				r.setwMax(s.getWaitingPeriod());
			if (s.getWaitingPeriod() < r.getwMin())
				r.setwMin(s.getWaitingPeriod());

		}
		r.setpAvg(r.getpAvg() / size);
		r.setwAvg(r.getwAvg() / size);
		return fillStd(r);
	}

	private Report fillStd(Report r) {
		double pStd = 0;
		double wStd = 0;
		int size = r.getStatistic().size();
		for (Statistic s : r.getStatistic()) {
			pStd += Math.pow(s.getNumOfPatients() - r.getpAvg(), 2);
			wStd += Math.pow(s.getWaitingPeriod() - r.getwAvg(), 2);

		}
		pStd = pStd / size;
		wStd = wStd / size;
		pStd = Math.sqrt(pStd);
		wStd = Math.sqrt(wStd);
		r.setpStd(pStd);
		r.setwStd(wStd);
		return r;
	}

	public static List<Statistic> reportByDate(Date d1, Date d2) {
		DbHandler db = Config.getConfig().getHandler();
		QueryBuilder<Statistic, Integer> q = db.statistics.queryBuilder();

		try {
			return q.orderBy("date", false).where().between("date", d1, d2)
					.query();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}

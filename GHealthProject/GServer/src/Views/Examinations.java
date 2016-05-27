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
import Utils.Request;
import models.Statistic;

public class Examinations extends View {

	public Object numOfPatient(Request request) throws Exception {
		return null;
	}

	public Object getWeeklyReport(Request request) {
		return null;
	}

}

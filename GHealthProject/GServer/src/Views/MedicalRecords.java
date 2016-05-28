package Views;

import java.sql.SQLException;
import java.util.HashMap;




import models.MedicalRecord;
import Database.DbHandler;
import Server.Config;
import Utils.Request;

import com.j256.ormlite.dao.RawRowMapper;


	public class  MedicalRecords extends View{
		
		
		
		public Object add(Request request) {
			DbHandler db = Config.getConfig().getHandler();
			MedicalRecord md = (MedicalRecord)request.getParam("mid");
			try {
				db.records.createIfNotExists(md);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "success";
		}
		
		public Object remove(Request request) {
			DbHandler db = Config.getConfig().getHandler();
			return "success";
		}
		
		public Object update(Request request) {
			DbHandler db = Config.getConfig().getHandler();
			return "success";
		}
		
	}

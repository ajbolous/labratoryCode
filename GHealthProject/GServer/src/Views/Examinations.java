package Views;

import java.sql.SQLException;
import java.util.List;

import com.j256.ormlite.stmt.QueryBuilder;

import models.Examination;
import models.Patient;
import models.Treatment;
import models.Visit;
import Database.DbHandler;
import Server.Config;
import Utils.Request;

public class Examinations extends View {
	
	DbHandler db = Config.getConfig().getHandler();
	public Object add (Request request){
		
		try {
			db.examinations.createIfNotExists((Examination)request.getParam("examination"));
			return getLastReferral(request) ; 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Fail" ; 
		}
	
	}
	public Object getById(Request request){
		
		
		try {
			Examination ex = db.examinations.queryForId((Integer)request.getParam("sid"));
			return ex;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Object update (Request request){
		DbHandler db = Config.getConfig().getHandler();
		try {
			db.examinations.update((Examination)request.getParam("examination"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}
	
	public Object getLastReferral (Request request)
	{
		
			QueryBuilder <Examination , Integer> q = db.examinations.queryBuilder();
			List<Examination> examination;
			
			
				try {
					examination=  q.orderBy("referralDate",false).limit(1).where()
					.eq("treatment_id",(Integer)request.getParam("treatment_id") ).query();
					if(examination.size()== 0) return null;
					else return examination.get(0);
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}					
				
				
		}  
	
	
	

}

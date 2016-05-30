package Views;

import java.sql.SQLException;
import java.util.List;

import com.j256.ormlite.stmt.QueryBuilder;

import Database.DbHandler;
import Server.Config;
import Utils.Request;
import models.Treatment;
import models.Visit;

public class Treatments extends View {
	
	DbHandler db = Config.getConfig().getHandler();
	public Object add (Request request){
		
		try {
			db.treatments.create((Treatment) request.getParam("treatment")); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}
	
	public Object update (Request request){
		DbHandler db = Config.getConfig().getHandler();
		try {
			db.treatments.update((Treatment) request.getParam("treatment")); 
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getLastTreatment(request);
	}
	
	public Object getLastTreatment (Request request)
	{
			QueryBuilder<Treatment, Integer> q = db.treatments.queryBuilder();
			List<Treatment> treatments;
			
			
				try {
					treatments=  q.orderBy( (String)request.getParam("date"),false).limit(1).where()
					.eq("medical_id",request.getParam("medical_id") ).query();
					if(treatments.size()== 0) return null;
					else return treatments.get(0);
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}					
				
	}
				
	
	
	
}
		
		
		      



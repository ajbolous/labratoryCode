package Views;

import java.sql.SQLException;
import java.util.List;
import com.j256.ormlite.stmt.QueryBuilder;
import models.Visit;
import Database.DbHandler;
import Server.Config;
import Utils.Request;

public class Visits extends View{
	DbHandler db = Config.getConfig().getHandler();
	
	public Object add (Request request) {
		
		Visit v =(Visit) request.getParam("visits");
		try {
			
			db.visits.create(v); 
			return getVisit(request) ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	public Object getVisit (Request request)
	{
			QueryBuilder <Visit , Integer> q = db.visits.queryBuilder();
			List<Visit> visits;
			
			
				try {
					visits=  q.orderBy("visitDate",false).limit(1).where()
					.eq("treatment_id",(Integer)request.getParam("treatment_id") ).query();
					if(visits.size()== 0) return null;
					else return visits.get(0);
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}					
				
				
		}  
			
	
		
		
	
}



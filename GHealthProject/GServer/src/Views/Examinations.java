package Views;

import java.sql.SQLException;

import models.Examination;
import models.Treatment;
import Database.DbHandler;
import Server.Config;
import Utils.Request;

public class Examinations extends View {
	
	public void add (Request request){
		DbHandler db = Config.getConfig().getHandler();
		try {
			db.examinations.createIfNotExists((Examination)request.getParam("examinations"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}

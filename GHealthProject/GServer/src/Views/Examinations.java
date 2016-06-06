package Views;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import com.j256.ormlite.stmt.QueryBuilder;
import models.Examination;
import Database.DbHandler;
import Server.Config;
import Utils.Request;

public class Examinations extends View {

	

	public Object add(Request request) {
		try {
			DbHandler db = Config.getConfig().getHandler();
			Examination ex = (Examination) request.getParam("exam");
			db.examinations.create(ex);
			return "success" ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Fail";
		}

	}

	
	public Object getById(Request request) {
		try {
			DbHandler db = Config.getConfig().getHandler();
			Examination ex = db.examinations.queryForId((Integer) request.getParam("sid"));
			return ex;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Object update(Request request) {
		DbHandler db = Config.getConfig().getHandler();
		try {
			Image image = ((ImageIcon) request.getParam("image")).getImage();
			Examination ex = (Examination) request.getParam("examination");
			
			if(image !=null){
				ex.setFile(ex.getEid() +"-" + ex.getFile());
				File outputFile = new File(ex.getFile());
				
				BufferedImage bi = new BufferedImage(image.getWidth(null),image.getHeight(null),BufferedImage.TYPE_BYTE_INDEXED);

				Graphics2D g2 = bi.createGraphics();
				g2.drawImage(image, 0, 0, null);
				g2.dispose();
				ImageIO.write(bi, "jpg", outputFile);
			}
				
			db.examinations.update(ex);
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}

	public Object getLastReferral(Request request) {
		DbHandler db = Config.getConfig().getHandler();

		QueryBuilder<Examination, Integer> q = db.examinations.queryBuilder();
		List<Examination> examination;

		try {
			examination = q.orderBy("referralDate", false).limit(1).where()
					.eq("treatment_id", (Integer) request.getParam("treatment_id")).query();
			if (examination.size() == 0)
				return null;
			else
				return examination.get(0);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

}

package Database;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import Server.Config;
import Utils.Logger;
import models.*;

public class DbHandler {

	private ConnectionSource connection;
	private Logger logger;

	private HashMap<Class,Dao<?,?>> sources;
	
	public DbHandler(String url, String username, String password) {
		this.logger = Config.getConfig().getLogger();
		try {
			logger.debug("Starting Database driver..");
			logger.debug("Connecting to Database " + url + " as user: " + username);
			ConnectionSource connectionSource =new JdbcConnectionSource("jdbc:mysql://localhost:3306/ghealth","root","1111");
	
			logger.debug("Connected to database.");

			
			Dao<Doctor, String> doctors =DaoManager.createDao(connectionSource, Doctor.class);
			Dao<Treatment, Integer> treatments =DaoManager.createDao(connectionSource, Treatment.class);
			Dao<Visit, Integer> visits =DaoManager.createDao(connectionSource, Visit.class);

		TableUtils.createTableIfNotExists(connectionSource, Doctor.class);
		TableUtils.createTableIfNotExists(connectionSource, Visit.class);
		TableUtils.createTableIfNotExists(connectionSource, Treatment.class);

		} catch (Exception ex) {
			logger.exception(ex);
		}
	}

	public ConnectionSource getConnection() {
		return connection;
	}


}

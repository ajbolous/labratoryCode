package Views;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import models.Doctor;
import models.Labratorian;
import models.User;
import Database.DbHandler;
import Server.Config;
import Utils.Request;

public class Users extends View {

	private static HashMap<String, String> connectedUsers = new HashMap<String, String>();

	public static void clientDisconnected(String ip) {
		for (String key : connectedUsers.keySet()) {
			if (connectedUsers.get(key).equalsIgnoreCase(ip)) {
				Config.getConfig().getLogger().debug("Disconnected online user : " + key + " IP:" + ip);
				connectedUsers.remove(key);
			}
		}
	}

	public Object getById(Request request) throws SQLException {
		return getUserById((String) request.getParam("sid"));
	}

	private User getUserById(String id) throws SQLException {
		DbHandler db = Config.getConfig().getHandler();
		Doctor d = db.doctors.queryForId(id);
		if (d != null)
			return d;
		Labratorian l = db.labratorians.queryForId(id);
		if (l != null)
			return l;
		return null;
	}

	public Object getOnlineUsers(Request request) throws SQLException {
		List<User> users = new ArrayList<User>();
		for (String key : Users.connectedUsers.keySet())
			users.add(getUserById(key));
		return users;
	}

	public Object getLockedUsers(Request request) throws SQLException {
		DbHandler db = Config.getConfig().getHandler();
		HashMap<String,Object> values = new HashMap<String,Object>();
		values.put("isLocked", 1);

		List<User> users = new ArrayList<User>();
		List<Doctor> doctors = db.doctors.queryForFieldValues(values);
		List<Labratorian> labratorians = db.labratorians.queryForFieldValues(values);
		users.addAll(doctors);
		users.addAll(labratorians);
		return users;
	}

	public Object setLocked(Request request) throws SQLException{
		User u = (User) request.getParam("user");
		Config.getConfig().getLogger().debug("Account " + u.getSid() + " " + u.getFirstName() + " is Locked");
		u.setLocked((boolean)request.getParam("isLocked"));
		u.update();
		return true;
	}
	
	
	public Object setOnline(Request request) {
		DbHandler db = Config.getConfig().getHandler();

		User u = (User) request.getParam("user");
		if (connectedUsers.containsKey(u.getSid()))
			return false;

		connectedUsers.put(u.getSid(), (String) request.getParam("ip"));
		return true;
	}
}

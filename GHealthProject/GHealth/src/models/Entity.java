package models;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;

public abstract class Entity implements Persistable, Serializable{

	private static final long serialVersionUID = 1L;
	public static boolean createTable(Connection connection) throws SQLException{
		return false;
	}
}

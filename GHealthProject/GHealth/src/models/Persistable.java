package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface Persistable {
	public boolean update(Connection connection)  throws SQLException;
	public boolean delete(Connection connection)  throws SQLException;
	public boolean save(Connection connection)  throws SQLException;
}

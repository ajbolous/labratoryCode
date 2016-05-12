package Database;

import java.sql.Connection;

public abstract class AbstractHandler{
	private Connection connection;

	public AbstractHandler(Connection con) {
		setConnection(con);
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
}

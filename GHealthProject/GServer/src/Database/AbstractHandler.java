package Database;

import java.sql.Connection;

import com.j256.ormlite.support.ConnectionSource;

public abstract class AbstractHandler{
	private ConnectionSource connection;

	public AbstractHandler(ConnectionSource con) {
		setConnection(con);
	}

	public ConnectionSource getConnection() {
		return connection;
	}

	public void setConnection(ConnectionSource connection) {
		this.connection = connection;
	}
}

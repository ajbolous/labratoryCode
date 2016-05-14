package Orm;

import java.sql.Connection;

public interface Queryable {
	public void save(Orm orm) throws Exception;
	public void delete(Orm orm) throws Exception;
	public void update(Orm orm) throws Exception;
}

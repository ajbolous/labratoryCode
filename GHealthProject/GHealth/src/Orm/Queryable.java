package Orm;

import java.sql.Connection;

public interface Queryable {
	public void save() throws Exception;
	public void delete() throws Exception;
	public void update() throws Exception;
}

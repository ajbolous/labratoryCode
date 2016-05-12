package Database;

import java.sql.SQLException;
import java.util.ArrayList;

import models.Entity;

public interface Persistable<T> {
	public boolean update(T entity);
	public boolean delete(T entity);
	public boolean save(T entity);
	public boolean createTable();
	public ArrayList<T> getAll();
}

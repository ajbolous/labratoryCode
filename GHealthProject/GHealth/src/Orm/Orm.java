package Orm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import models.Entity;

@SuppressWarnings("rawtypes")
public class Orm {
	private Connection connection;
	public Orm(Connection connection){
		this.connection = connection;
	}
	public HashMap<Class,String> queries = new HashMap<Class,String>();
	public HashMap<Class,String> insertions = new HashMap<Class,String>();
	public HashMap<Class,String> updates = new HashMap<Class,String>();


	public void saveObject(Entity obj) throws Exception{
		itterObject(obj,obj.getClass());
		
	}

	public Entity getObject(Class<?> c, String where) throws Exception{
		return null;
	}
	
	public ArrayList<Entity> getObjects(Class<?> c, String where) throws Exception{
		Statement stmt = connection.createStatement();
		String sql = "";
		if(queries.containsKey(c))
			sql = queries.get(c);
		else {
			sql = SQLBuilder.querySql(c,where);
			queries.put(c, sql);
		}
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList<Entity> arr = new ArrayList<Entity>();
		while(rs.next())
			arr.add(Helpers.fromResult(rs, c));
		stmt.close();
		return arr;
	}
	
	public void updateObject(Entity obj) throws Exception{
		
		
	}
	
	public void deleteObject(Entity obj) throws Exception{
		
	}
	
	public void createTable(Class<?> c) throws Exception{
		Statement stmt = connection.createStatement();
		String sql = SQLBuilder.createSql(c);
		stmt.execute(sql);
		stmt.close();
	}

	public void itterObject(Object obj, Class<?> c) throws Exception{

		if (c.getName() == Entity.class.getName())
			return;

		itterObject(obj, c.getSuperclass());

		String sql = SQLBuilder.insertSql(c);
		PreparedStatement stmt;
		stmt = connection.prepareStatement(sql);
		stmt = Helpers.fromObject(stmt, obj, c);
		stmt.execute();
		stmt.close();
	}
	
}

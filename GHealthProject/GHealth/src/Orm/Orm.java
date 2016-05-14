package Orm;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import models.Entity;

import models.Doctor;

public class Orm {

	
	private Connection connection;
	public Orm(Connection connection){
		this.connection = connection;
	}
	public HashMap<Class,String> queries = new HashMap<Class,String>();
	public HashMap<Class,String> insertions = new HashMap<Class,String>();
	public HashMap<Class,String> updates = new HashMap<Class,String>();

	public String dataType(Class ftype) {
		String fieldType = ftype.getName();
		switch (fieldType) {
		case "java.lang.String":
			return "VARCHAR(255)";
		case "int":
			return "INTEGER";
		case "float":
			return "FLOAT";
		case "java.sql.Date":
			return "DATE";
		}
		return null;
	}

	public String createSql(Class c) {
		String name = c.getName().replace("models.", "").toLowerCase() + "s";
		String columns = "";
		String primaries = "";
		String foreigns = "";
		Field[] fields = c.getDeclaredFields();
		for (Field field : fields) {
			if (field.isAnnotationPresent(dataField.class))
				columns += field.getName() + " " + dataType(field.getType()) + ",";

			if (field.isAnnotationPresent(pkField.class))
				primaries += "PRIMARY KEY(" + field.getName() + "),";

			if (field.isAnnotationPresent(fkField.class)) {
				fkField[] f = field.getAnnotationsByType(fkField.class);
				foreigns += "FOREIGN KEY(" + field.getName() + ") REFERENCES " + f[0].target() + ",";
			}
		}

		if (c.isAnnotationPresent(extensionTable.class)) {
			extensionTable[] f = (extensionTable[]) c.getAnnotationsByType(extensionTable.class);
			columns = f[0].field() + " " + dataType(String.class) + "," + columns;
			foreigns = "FOREIGN KEY(" + f[0].field() + ") REFERENCES " + f[0].table() + "(" + f[0].field() + "),"
					+ foreigns;
			primaries = "PRIMARY KEY(" + f[0].field() + ")," + primaries;

		}

		columns = columns + primaries + foreigns;
		columns = columns.substring(0, columns.length() - 1);
		String s = String.format("CREATE TABLE %s(%s);", name, columns);

		return s;
	}

	public String insertSql(Class c) {
		String name = c.getName().replace("models.", "").toLowerCase() + "s";
		String fields = "";
		String vals = "";
		for (Field field : c.getDeclaredFields())
			if (field.isAnnotationPresent(dataField.class)) {
				fields += field.getName() + ",";
				vals = vals + "?,";
			}

		if (c.isAnnotationPresent(extensionTable.class)) {
			extensionTable[] f = (extensionTable[]) c.getAnnotationsByType(extensionTable.class);
			fields = f[0].field() + "," + fields;
			vals = vals + "?,";
		}
		String s = String.format("INSERT INTO %s(%s) VALUES(%s);", name, fields.substring(0, fields.length() - 1),
				vals.substring(0, vals.length() - 1));

		return s;
	}

	public String querySql(Class c){
		String fields = "";
		String joins = "WHERE ";
		String tables = "";
		Class origin = c;
		while (c.getName() != Entity.class.getName()) {
			String tblName = c.getName().replace("models.", "").toLowerCase() + "s";

			for (Field field : c.getDeclaredFields())
				if (field.isAnnotationPresent(dataField.class))
					fields += tblName + "." + field.getName() + " as " + field.getName() + ",";

			if (c.isAnnotationPresent(extensionTable.class)) {
				extensionTable[] f = (extensionTable[]) c.getAnnotationsByType(extensionTable.class);
				joins = joins + tblName + "." + f[0].field() + "=" + f[0].table() + "." + f[0].field() + " AND ";
			}
			tables += tblName + ",";
			c = c.getSuperclass();
		}
		joins = joins.substring(0, joins.length() - 5);
		tables = tables.substring(0, tables.length() - 1);
		String sql = String.format("SELECT %s FROM %s %s", fields.substring(0, fields.length() - 1), tables, joins);
		return sql;
	}
	
	public void saveObject(Entity obj) throws Exception{
		itterObject(obj,obj.getClass());
	}

	public void itterObject(Object obj, Class c) throws Exception{

		if (c.getName() == Entity.class.getName())
			return;

		itterObject(obj, c.getSuperclass());

		String sql = insertSql(c);
		PreparedStatement stmt;
		stmt = connection.prepareStatement(sql);
		stmt = fromObject(stmt, obj, c);
		stmt.execute();
	}
	
	public ArrayList<Entity> getObject(Class c, String where) throws Exception{
		Statement stmt = connection.createStatement();
		String sql = "";
		if(queries.containsKey(c))
			sql = queries.get(c);
		else {
			sql = querySql(c);
			queries.put(c, sql);
		}
		sql += (where != "" ? " AND " + where : "");
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList<Entity> arr = new ArrayList<Entity>();
		while(rs.next())
			arr.add(fromResult(rs, c));
		return arr;
	}
	
	public Method getGetter(Class c, String attr) throws Exception{
		String mName = "get" + attr.substring(0, 1).toUpperCase() + attr.substring(1, attr.length());
		return c.getMethod(mName);
	}
	
	public Method getSetter(Class c, String attr, Class attrType) throws Exception{
		String mName = "set" + attr.substring(0, 1).toUpperCase() + attr.substring(1, attr.length());
		return c.getMethod(mName, attrType);
	}

	public PreparedStatement fromObject(PreparedStatement stmt, Object obj, Class c) throws Exception{
		int i = 1;
		if (c.isAnnotationPresent(extensionTable.class)) {
			extensionTable[] f = (extensionTable[]) c.getAnnotationsByType(extensionTable.class);
			Method getter = getGetter(c,f[0].field());
			stmt.setObject(i, getter.invoke(obj));
			i++;
		}

		Field[] fields = c.getDeclaredFields();
		for (Field field : fields)
			if (field.isAnnotationPresent(dataField.class)) {
				Method getter = getGetter(c,field.getName());
				stmt.setObject(i, getter.invoke(obj));
				i++;
			}
		return stmt;
	}


	public Entity fromResult(ResultSet rs, Class c) throws Exception{
		Entity obj = (Entity) c.newInstance();
		while (c.getName() != Entity.class.getName()) {
			for (Field field : c.getDeclaredFields())
				if (field.isAnnotationPresent(dataField.class)) {
					Method setter = getSetter(c, field.getName(),field.getType());
					Object val = rs.getObject(field.getName());
					setter.invoke(obj, val);
				}
			c = c.getSuperclass();
		}
		return obj;

	}
}

package Orm;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import models.Entity;

@SuppressWarnings("rawtypes")
public class Orm {
	public static Connection connection;

	public static void setOrm(Connection con) {
		connection = con;
	}

	public static HashMap<Class, String> queries = new HashMap<Class, String>();
	public static HashMap<Class, String> insertions = new HashMap<Class, String>();
	public static HashMap<Class, String> updates = new HashMap<Class, String>();
	public static HashMap<Class, String> deletions = new HashMap<Class, String>();

	public static void saveObject(Entity obj) throws Exception {
		try {
			itterObject(obj, obj.getClass());
		} catch (Exception e) {
			obj.update();
		}
	}

	public static Entity getObject(Class<?> c, String where) throws Exception {
		return getObjects(c, where).get(0);
	}

	public static ArrayList<Entity> getObjects(Class<?> c, String where) throws Exception {
		Statement stmt = connection.createStatement();
		String sql = "";
		if (queries.containsKey(c))
			sql = queries.get(c);
		else {
			sql = SQLBuilder.querySql(c, where);
			queries.put(c, sql);
		}
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList<Entity> arr = new ArrayList<Entity>();
		while (rs.next())
			arr.add(Helpers.fromResult(rs, c));
		stmt.close();
		return arr;
	}

	public static void updateObject(Entity obj) throws Exception {
		Class<?> c = obj.getClass();

		while (c.getName() != Entity.class.getName()) {

			String sql = "";
			if (updates.containsKey(c))
				sql = updates.get(c);
			else {
				sql = SQLBuilder.updateSql(c);
				updates.put(c, sql);
			}
			int i = 1;

			PreparedStatement stmt = connection.prepareStatement(sql);

			for (Field field : c.getDeclaredFields()) {
				if (field.isAnnotationPresent(dataField.class)) {
					Method getter = Helpers.getGetter(c, field.getName());
					stmt.setObject(i++, getter.invoke(obj));
				}

			}
			if (c.isAnnotationPresent(extensionTable.class)) {
				extensionTable[] f = (extensionTable[]) c.getAnnotationsByType(extensionTable.class);
				Method getter = Helpers.getGetter(c, f[0].field());
				stmt.setObject(i++, getter.invoke(obj));
			}

			for (Field field : c.getDeclaredFields()) {
				if (field.isAnnotationPresent(pkField.class)) {
					Method getter = Helpers.getGetter(c, field.getName());
					stmt.setObject(i++, getter.invoke(obj));
				}
			}

			if (c.isAnnotationPresent(extensionTable.class)) {
				extensionTable[] f = (extensionTable[]) c.getAnnotationsByType(extensionTable.class);
				Method getter = Helpers.getGetter(c, f[0].field());
				stmt.setObject(i++, getter.invoke(obj));
			}

			c = c.getSuperclass();

			stmt.execute();
			stmt.close();
		}
	}

	public static void deleteObjects(Class<?> c, String where) throws Exception {
		String sql = SQLBuilder.deleteWhereSql(c, where);
		Statement stmt = connection.createStatement();
		stmt.execute(sql);
		stmt.close();
	}

	public static void deleteObject(Entity obj) throws Exception {
		Class<?> c = obj.getClass();

		while (c.getName() != Entity.class.getName()) {

			String sql = "";
			if (deletions.containsKey(c))
				sql = deletions.get(c);
			else {
				sql = SQLBuilder.deleteSql(c);
				deletions.put(c, sql);
			}
			int i = 1;

			PreparedStatement stmt = connection.prepareStatement(sql);

			for (Field field : c.getDeclaredFields()) {
				if (field.isAnnotationPresent(pkField.class)) {
					Method getter = Helpers.getGetter(c, field.getName());
					stmt.setObject(i++, getter.invoke(obj));
				}
			}

			if (c.isAnnotationPresent(extensionTable.class)) {
				extensionTable[] f = (extensionTable[]) c.getAnnotationsByType(extensionTable.class);
				Method getter = Helpers.getGetter(c, f[0].field());
				stmt.setObject(i++, getter.invoke(obj));
			}
			c = c.getSuperclass();

			stmt.execute();
			stmt.close();
		}
	}

	public static void createTable(Class<?> c) throws Exception {
		Statement stmt = connection.createStatement();
		String sql = SQLBuilder.createSql(c);
		stmt.execute(sql);
		stmt.close();
	}

	public static void itterObject(Object obj, Class<?> c) throws Exception {

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

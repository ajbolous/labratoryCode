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

import models.Entity;

import models.Doctor;

public class Orm {

	public String listAnnotated(Class c) {
		String s = "";
		Field[] fields = c.getDeclaredFields();
		for (Field field : fields) {
			if (field.isAnnotationPresent(dataField.class)) {
				s += field.getName() + " , ";
			}
		}
		return s;
	}

	public static String dataType(Class ftype) {
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

	public static String createSql(Class c) {
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

	public static class Column {
		public Class fieldType;
		public String name;
		public String target;
		public boolean isPk;
		public boolean isFk;
	}

	public static ArrayList<Column> getColumns(Class c) {
		ArrayList<Column> columns = new ArrayList<Column>();
		Field[] fields = c.getDeclaredFields();
		for (Field field : fields) {
			if (!field.isAnnotationPresent(dataField.class))
				continue;
			Column col = new Column();
			col.name = field.getName();
			col.fieldType = field.getType();
			col.isPk = field.isAnnotationPresent(pkField.class);
			col.isFk = field.isAnnotationPresent(fkField.class);

			if (col.isFk)
				col.target = field.getAnnotationsByType(fkField.class)[0].target();
			columns.add(col);
		}
		return columns;
	}

	public static void put(Object obj, Class c, Connection con) throws SQLException, IllegalArgumentException,
			IllegalAccessException, NoSuchMethodException, SecurityException, InvocationTargetException {

		if (c.getName() == Entity.class.getName())
			return;

		put(obj, c.getSuperclass(), con);

		String sql = Orm.insertSql(c);
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt = fromObject(stmt, obj, c);
		stmt.execute();

	}

	public static PreparedStatement fromObject(PreparedStatement stmt, Object obj, Class c) {
		int i = 1;
		if (c.isAnnotationPresent(extensionTable.class)) {
			extensionTable[] f = (extensionTable[]) c.getAnnotationsByType(extensionTable.class);
			String name = f[0].field();
			String mName = "get" + name.substring(0, 1).toUpperCase() + name.substring(1, name.length());
			Method m;
			try {
				m = c.getMethod(mName);
				stmt.setObject(i, m.invoke(obj));
				i++;
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | SQLException e) {
				e.printStackTrace();
			}
		}

		Field[] fields = c.getDeclaredFields();
		for (Field field : fields)
			if (field.isAnnotationPresent(dataField.class)) {
				String name = field.getName();
				String mName = "get" + name.substring(0, 1).toUpperCase() + name.substring(1, name.length());
				Method m;
				try {
					m = c.getMethod(mName);
					stmt.setObject(i, m.invoke(obj));
					i++;

				} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
						| InvocationTargetException | SQLException e) {
					e.printStackTrace();
				}
			}

		return stmt;
	}

	public static String insertSql(Class c) {
		String name = c.getName().replace("models.", "").toLowerCase() + "s";
		ArrayList<Column> columns = getColumns(c);
		String fields = "";
		String vals = "";
		Field[] cfields = c.getDeclaredFields();
		for (Field field : cfields)
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

	public static String querySql(Class c) {
		String name = c.getName().replace("models.", "").toLowerCase() + "s";
		String fields = "";

		ArrayList<Column> columns = getColumns(c);
		for (Column col : columns)
			fields = fields + col.name + ",";

		String s = String.format("SELECT %s FROM %s;", fields.substring(0, fields.length() - 1), name);

		return s;
	}

	public static Object get(Class c, Connection con)
			throws SQLException, InstantiationException, IllegalAccessException {
		Object obj = c.newInstance();

		Statement stmt = con.createStatement();

		while (c.getName() != Entity.class.getName()) {
			String sql = Orm.querySql(c);
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			obj = fromResult(rs, obj, c);
			c = c.getSuperclass();
		}
		return obj;

	}

	public static Object fromResult(ResultSet rs, Object obj, Class c) {
		try {
			Field[] fields = c.getDeclaredFields();
			for (Field field : fields)
				if (field.isAnnotationPresent(dataField.class)) {
					String name = field.getName();
					String mName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1, name.length());
					Method m = c.getMethod(mName, field.getType());
					Object val = rs.getObject(name);
					m.invoke(obj, val);
				}

			return obj;

		} catch (Exception e) {
			return null;
		}

	}
}

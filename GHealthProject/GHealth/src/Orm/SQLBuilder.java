package Orm;

import java.lang.reflect.Field;

import models.Entity;

public class SQLBuilder {


	public static String dataType(Class<?> ftype) {
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
	
	public static String createSql(Class<?> c) {
		String name = c.getName().replace("models.", "").toLowerCase() + "s";
		String columns = "";
		String primaries = "";
		String foreigns = "";
		Field[] fields = c.getDeclaredFields();
		for (Field field : fields) {
			if (field.isAnnotationPresent(dataField.class))
				columns += field.getName() + " " + dataType(field.getType()) + ",";

			if (field.isAnnotationPresent(pkField.class))
				primaries += field.getName() + ",";

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
			primaries =  f[0].field() + "," + primaries;

		}
		
		primaries = "PRIMARY KEY(" + primaries.substring(0,primaries.length()-1) + ")";
		columns = columns + primaries + foreigns;
		columns = columns.substring(0, columns.length() - 1);
		String s = String.format("CREATE TABLE %s(%s);", name, columns);

		return s;
	}

	public static String insertSql(Class<?> c) {
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

	public static String querySql(Class<?> c, String where){
		String fields = "";
		String joins = "";
		String tables = "";
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
		if(joins!=""){
			if(where!=null && where != "")
				joins = "WHERE " + joins + where;
			else
				joins = "WHERE " + joins.substring(0,joins.length()-5);
		}
		tables = tables.substring(0, tables.length() - 1);
		String sql = String.format("SELECT %s FROM %s %s", fields.substring(0, fields.length() - 1), tables, joins);
		return sql;
	}
	
}

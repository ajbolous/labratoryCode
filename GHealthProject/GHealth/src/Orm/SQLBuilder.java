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

	public static String updateSql(Class<?> c) {
		String primes = "";
		String tblName = Helpers.getTableName(c);
		String columns = "";
		for (Field field : c.getDeclaredFields()) {
			if (field.isAnnotationPresent(pkField.class))
				primes += String.format("%s=? AND ", field.getName());
			if (field.isAnnotationPresent(dataField.class))
				columns += String.format("%s=?,", field.getName());
			

			if (field.isAnnotationPresent(objectField.class)) {
				objectField[] f = (objectField[]) field.getAnnotationsByType(objectField.class);
				columns += String.format("%s=?,", f[0].field());
			}
			
		}

		if (c.isAnnotationPresent(extensionTable.class)) {
			extensionTable[] f = (extensionTable[]) c.getAnnotationsByType(extensionTable.class);
			primes += String.format("%s=? AND ", f[0].field());
			columns += String.format("%s=?,", f[0].field());
		}

		if (primes != "")
			primes = primes.substring(0, primes.length() - 5);
		columns = columns.substring(0, columns.length() - 1);
		return String.format("UPDATE %s SET %s WHERE %s;\n", tblName, columns, primes);
	}

	public static String deleteSql(Class<?> c) {
		String primes = "";
		String tblName = Helpers.getTableName(c);

		while (c.getName() != Entity.class.getName()) {
			for (Field field : c.getDeclaredFields())
				if (field.isAnnotationPresent(pkField.class))
					primes += String.format("%s=? AND ", field.getName());
			c = c.getSuperclass();
		}
		if (primes != "")
			primes = primes.substring(0, primes.length() - 5);
		return String.format("DELETE FROM %s WHERE %s;\n", tblName, primes);
	}

	public static String deleteWhereSql(Class<?> c, String where) {
		String tblName = Helpers.getTableName(c);
		return String.format("DELETE FROM %s WHERE %s", tblName, where);
	}

	public static String createSql(Class<?> c) throws Exception {
		String tblName = Helpers.getTableName(c);
		String columns = "";
		String primaries = "";
		String foreigns = "";
		Field[] fields = c.getDeclaredFields();
		for (Field field : fields) {
			if (field.isAnnotationPresent(dataField.class))
				columns += field.getName() + " " + dataType(field.getType()) + ",";

			if (field.isAnnotationPresent(pkField.class))
				primaries += field.getName() + ",";

			if (field.isAnnotationPresent(objectField.class)) {
				objectField[] f = (objectField[]) field.getAnnotationsByType(objectField.class);
				Class<?> fieldClass = field.getType();
				String table = Helpers.getTableName(field.getType());
				Field objField = fieldClass.getDeclaredField(f[0].field());

				columns += f[0].field() + " " + dataType(objField.getType()) + ",";
				foreigns += String.format("FOREIGN KEY(%s) REFERENCES %s(%s),", f[0].field(), table, f[0].field());
			}

			if (field.isAnnotationPresent(fkField.class)) {
				fkField[] f = field.getAnnotationsByType(fkField.class);
				foreigns += String.format("FOREIGN KEY(%s) REFERENCES %s,", field.getName(), f[0].target());
			}
		}

		if (c.isAnnotationPresent(extensionTable.class)) {
			extensionTable[] f = (extensionTable[]) c.getAnnotationsByType(extensionTable.class);
			columns = f[0].field() + " " + dataType(String.class) + "," + columns;
			foreigns = String.format("FOREIGN KEY(%s) REFERENCES %s(%s),", f[0].field(), f[0].table(), f[0].field())
					+ foreigns;
			primaries = f[0].field() + "," + primaries;

		}

		primaries = "PRIMARY KEY(" + primaries.substring(0, primaries.length() - 1) + "),";
		columns = columns + primaries + foreigns;
		columns = columns.substring(0, columns.length() - 1);
		String s = String.format("CREATE TABLE %s(%s);", tblName, columns);

		return s;
	}

	public static String insertSql(Class<?> c) {
		String tblName = Helpers.getTableName(c);
		String fields = "";
		String vals = "";
		for (Field field : c.getDeclaredFields()) {
			if (field.isAnnotationPresent(dataField.class)) {
				fields += field.getName() + ",";
				vals += "?,";
			}

			if (field.isAnnotationPresent(objectField.class)) {
				objectField[] f = (objectField[]) field.getAnnotationsByType(objectField.class);
				fields += f[0].field() + ",";
				vals += "?,";
			}
		}

		if (c.isAnnotationPresent(extensionTable.class)) {
			extensionTable[] f = (extensionTable[]) c.getAnnotationsByType(extensionTable.class);
			fields = f[0].field() + "," + fields;
			vals += "?,";
		}
		String s = String.format("INSERT INTO %s(%s) VALUES(%s);", tblName, fields.substring(0, fields.length() - 1),
				vals.substring(0, vals.length() - 1));

		return s;
	}

	public static String querySql(Class<?> c, String where) {
		String fields = "";
		String joins = "";
		String tables = "";
		while (c.getName() != Entity.class.getName()) {
			String tblName = Helpers.getTableName(c);

			for (Field field : c.getDeclaredFields()) {
				if (field.isAnnotationPresent(dataField.class))
					fields += String.format("%s.%s as %s,", tblName, field.getName(), field.getName());

				if (field.isAnnotationPresent(objectField.class)) {
					objectField[] f = (objectField[]) field.getAnnotationsByType(objectField.class);
					Class<?> fieldClass = field.getType();
					String table = Helpers.getTableName(field.getType());
					fields += String.format("%s.%s as %s,", tblName, f[0].field(), f[0].field());
				}

			}
			if (c.isAnnotationPresent(extensionTable.class)) {
				extensionTable[] f = (extensionTable[]) c.getAnnotationsByType(extensionTable.class);
				joins += String.format("%s.%s=%s.%s AND ", tblName, f[0].field(), f[0].table(), f[0].field());
			}
			tables += tblName + ",";
			c = c.getSuperclass();
		}
		if (joins != "") {
			if (where != null && where != "")
				joins = "WHERE " + joins + where;
			else
				joins = "WHERE " + joins.substring(0, joins.length() - 5);
		}
		tables = tables.substring(0, tables.length() - 1);
		String sql = String.format("SELECT %s FROM %s %s", fields.substring(0, fields.length() - 1), tables, joins);
		return sql;
	}

}

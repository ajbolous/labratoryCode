package Orm;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import models.Entity;

public class Helpers {
	public static Method getGetter(Class<?> c, String attr) throws Exception {
		String mName = "get" + attr.substring(0, 1).toUpperCase() + attr.substring(1, attr.length());
		return c.getMethod(mName);
	}

	public static Method getSetter(Class<?> c, String attr, Class<?> attrType) throws Exception {
		String mName = "set" + attr.substring(0, 1).toUpperCase() + attr.substring(1, attr.length());
		return c.getMethod(mName, attrType);
	}

	public static String getTableName(Class<?> c) {
		return c.getName().replace("models.", "").toLowerCase() + "s";
	}

	public static ArrayList<Field> getPrimaryFields(Class<?> c) {
		ArrayList<Field> fields = new ArrayList<Field>();
		for (Field field : c.getDeclaredFields())
			if (field.isAnnotationPresent(pkField.class))
				fields.add(field);
		return fields;
	}

	public static PreparedStatement fromObject(PreparedStatement stmt, Object obj, Class<?> c) throws Exception {
		int i = 1;
		if (c.isAnnotationPresent(extensionTable.class)) {
			extensionTable[] f = (extensionTable[]) c.getAnnotationsByType(extensionTable.class);
			Method getter = getGetter(c, f[0].field());
			stmt.setObject(i, getter.invoke(obj));
			i++;
		}

		Field[] fields = c.getDeclaredFields();
		for (Field field : fields){
			if (field.isAnnotationPresent(dataField.class)) {
				Method getter = getGetter(c, field.getName());
				stmt.setObject(i, getter.invoke(obj));
				i++;
			}
			if (field.isAnnotationPresent(objectField.class)) {
				objectField[] f = (objectField[]) field.getAnnotationsByType(objectField.class);
				Method getter = getGetter(c, field.getName());
				Entity t = (Entity)getter.invoke(obj);
				t.save();

				getter = getGetter(field.getType(), f[0].field());
				
				stmt.setObject(i, getter.invoke(t));
				i++;
			}	
		}
		return stmt;
	}

	public static Entity fromResult(ResultSet rs, Class<?> c) throws Exception {
		Entity obj = (Entity) c.newInstance();
		while (c.getName() != Entity.class.getName()) {
			for (Field field : c.getDeclaredFields()) {
				
				if (field.isAnnotationPresent(dataField.class)) {
					Method setter = getSetter(c, field.getName(), field.getType());
					Object val = rs.getObject(field.getName());
					setter.invoke(obj, val);
				}

				if (field.isAnnotationPresent(objectField.class)) {
					objectField[] f = (objectField[]) field.getAnnotationsByType(objectField.class);
					Method setter = getSetter(c, field.getName(), field.getType());
					Object val = rs.getObject(f[0].field());
					
					Entity t = Orm.getObject(field.getType(), f[0].field() + "=" + val.toString());
					setter.invoke(obj, t);
				}
			}

			c = c.getSuperclass();
		}
		return obj;

	}

}

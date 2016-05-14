package Orm;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import models.Entity;

public class Helpers {
	public static Method getGetter(Class<?> c, String attr) throws Exception{
		String mName = "get" + attr.substring(0, 1).toUpperCase() + attr.substring(1, attr.length());
		return c.getMethod(mName);
	}
	
	public static Method getSetter(Class<?> c, String attr, Class<?> attrType) throws Exception{
		String mName = "set" + attr.substring(0, 1).toUpperCase() + attr.substring(1, attr.length());
		return c.getMethod(mName, attrType);
	}
		
	
	public  static PreparedStatement fromObject(PreparedStatement stmt, Object obj, Class<?> c) throws Exception{
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


	public static Entity fromResult(ResultSet rs, Class<?> c) throws Exception{
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

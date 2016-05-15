package models;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import Orm.Orm;
import Orm.Queryable;

public abstract class Entity implements Serializable, Queryable {

	@Override
	public void save() throws Exception {
		Orm.saveObject(this);
	}

	@Override
	public void delete() throws Exception {
		Orm.deleteObject(this);
	}

	@Override
	public void update() throws Exception {
		Orm.updateObject(this);
	}

	public void createTable() throws Exception {
		Orm.createTable(this.getClass());
	}

}

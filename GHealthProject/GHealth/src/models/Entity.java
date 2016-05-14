package models;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import Orm.Orm;
import Orm.Queryable;

public abstract class Entity implements Serializable, Queryable{

	@Override
	public void save(Orm orm) throws Exception{
			orm.saveObject(this);
	}

	@Override
	public void delete(Orm orm) throws Exception{
		orm.deleteObject(this);
	}

	@Override
	public void update(Orm orm) throws Exception{
		orm.updateObject(this);
	}
	public void createTable(Orm orm) throws Exception{
		orm.createTable(this.getClass());
	}

}

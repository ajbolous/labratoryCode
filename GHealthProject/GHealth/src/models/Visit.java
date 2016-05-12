package models;

import java.sql.Date;

import Orm.dataField;
import Orm.fkField;
import Orm.pkField;

public class Visit {
	
	public static final String tableName = "visits";
	
	@dataField
	@pkField
	private int vid;
	
	@dataField
	@pkField
	@fkField(target = "records(rid)")
	private int rid;
	
	@dataField
	private Date visitDate;
	@dataField
	private String comments; 
}

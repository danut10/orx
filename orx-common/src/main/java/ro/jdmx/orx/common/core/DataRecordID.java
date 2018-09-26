package ro.jdmx.orx.common.core;

import ro.jdmx.orx.common.core.dataObject.IDataRecord;

public class DataRecordID implements IDataRecord {

	protected Integer id;
	
	/*
	 * getters & setters
	 */
	
	public Integer getId() { return this.id; }
	public DataRecordID setId(Integer id) { this.id = id; return this; }
	
}
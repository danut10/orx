package ro.jdmx.orx.common.core;

import ro.jdmx.orx.common.core.dataObject.IDataRecord;

public class DataRecord implements IDataRecord {

	protected Integer id;
	
	/*
	 * getters & setters
	 */
	
	public Integer getId() { return this.id; }
	public DataRecord setId(Integer id) { this.id = id; return this; }
	
}
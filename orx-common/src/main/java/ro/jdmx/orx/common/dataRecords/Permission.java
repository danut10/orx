package ro.jdmx.orx.common.dataRecords;

import ro.jdmx.orx.common.core.DataRecord;

public class Permission extends DataRecord {

	private String entity;
	private String code;
	
	public String getEntity() { return entity; }
	public Permission setEntity(String entity) { this.entity = entity; return this; }
	
	public String getCode() { return code; }
	public Permission setCode(String code) { this.code = code; return this; }
	
}

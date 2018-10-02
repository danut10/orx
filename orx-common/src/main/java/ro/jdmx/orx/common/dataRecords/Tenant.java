package ro.jdmx.orx.common.dataRecords;

import ro.jdmx.orx.common.core.DataRecord;

public class Tenant extends DataRecord {
	private String name;
	
	public String getName() { return name; }
	public Tenant setName(String name) { this.name = name; return this; }
}

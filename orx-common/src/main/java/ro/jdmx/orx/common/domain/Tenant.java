package ro.jdmx.orx.common.domain;

import ro.jdmx.orx.common.core.DataRecordID;

public class Tenant extends DataRecordID {
	private String name;
	
	public String getName() { return name; }
	public Tenant setName(String name) { this.name = name; return this; }
}

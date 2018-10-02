package ro.jdmx.orx.common.domain;

import ro.jdmx.orx.common.core.DataRecordID;

public class Role extends DataRecordID {

	private Tenant tenant;
	private String name;

	public String getName() { return name; }
	public Role setName(String name) { this.name = name; return this; }
	
	public Tenant getTenant() { return tenant; }
	public Role setTenant(Tenant tenant) { this.tenant = tenant; return this; }

}

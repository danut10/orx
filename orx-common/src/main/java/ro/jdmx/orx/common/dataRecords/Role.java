package ro.jdmx.orx.common.dataRecords;

import ro.jdmx.orx.common.core.DataRecord;

public class Role extends DataRecord {

	private Tenant tenant;
	private String name;

	public String getName() { return name; }
	public Role setName(String name) { this.name = name; return this; }
	
	public Tenant getTenant() { return tenant; }
	public Role setTenant(Tenant tenant) { this.tenant = tenant; return this; }

}

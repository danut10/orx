package ro.jdmx.orx.common.dataFilters;

import ro.jdmx.orx.common.core.dataObject.IDataFilter;
import ro.jdmx.orx.common.dataRecords.Role;
import ro.jdmx.orx.common.dataRecords.Tenant;

public class FUser implements IDataFilter {

	private Tenant tenant;
	private Role role;
	private String name;
	private String emailAddress;
	
	public Tenant getTenant() { return tenant; }
	public FUser setTenant(Tenant tenant) { this.tenant = tenant; return this; }
	
	public Role getRole() { return role; }
	public FUser setRole(Role role) { this.role = role; return this; }
	
	public String getName() { return name; }
	public FUser setName(String name) { this.name = name; return this; }
	
	public String getEmailAddress() { return emailAddress; }
	public FUser setEmailAddress(String emailAddress) { this.emailAddress = emailAddress; return this; }

}

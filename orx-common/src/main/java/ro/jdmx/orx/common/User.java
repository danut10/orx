package ro.jdmx.orx.common;

import ro.jdmx.orx.common.core.DataRecordID;

public class User extends DataRecordID {

	private String name;
	private String emailAddress;
	private String password;
	private Tenant tenant;

	public String getName() { return name; }
	public User setName(String name) { this.name = name; return this; }
	
	public String getEmailAddress() { return emailAddress; }
	public User setEmailAddress(String emailAddress) { this.emailAddress = emailAddress; return this; }

	public String getPassword() { return password; }
	public User setPassword(String password) { this.password = password; return this; }
	
	public Tenant getTenant() { return tenant; }
	public User setTenant(Tenant tenant) { this.tenant = tenant; return this; }

	
}

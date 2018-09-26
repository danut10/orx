package ro.jdmx.orx.common;

public class User {

	private Tenant tenant;
	private String emailAddress;
	private String password;

	public Tenant getTenant() { return tenant; }
	public User setTenant(Tenant tenant) { this.tenant = tenant; return this; }

	public String getEmailAddress() { return emailAddress; }
	public User setEmailAddress(String emailAddress) { this.emailAddress = emailAddress; return this; }

	public String getPassword() { return password; }
	public User setPassword(String password) { this.password = password; return this; }
	
	
	
	
}

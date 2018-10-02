package ro.jdmx.orx.common.dataRecords;

import ro.jdmx.orx.common.core.DataRecordID;

public class User extends DataRecordID {

	private Role role;
	private String name;
	private String emailAddress;
	private String password;

	public Role getRole() { return role; }
	public User setRole(Role role) { this.role = role; return this;	}
	
	public String getName() { return name; }
	public User setName(String name) { this.name = name; return this; }
	
	public String getEmailAddress() { return emailAddress; }
	public User setEmailAddress(String emailAddress) { this.emailAddress = emailAddress; return this; }

	public String getPassword() { return password; }
	public User setPassword(String password) { this.password = password; return this; }
	
}

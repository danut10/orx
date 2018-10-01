package ro.jdmx.orx.web.api.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.springframework.http.MediaType;

import ro.jdmx.orx.common.domain.User;

@Consumes(MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
@Produces(MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
public class RsGeneric {
	
	@GET 
	@Path("/{entityCode}")
	public List<User> readList(@PathParam("entityCode") String entityCode) {
		List<User> recordList = getMockupUserList();
		return recordList;
	}
	
	@GET 
	@Path("/{entityCode}/{id}")
	public User read(@PathParam("entityCode") String entityCode, @PathParam("id") Integer id) {
		User record = getMockupUserList().get(0);
		return record;
	}	
	
	private List<User> getMockupUserList() {
		List<User> userList = new ArrayList<>();
		userList.add((User) new User().setEmailAddress("dan.maxim@cegeka.com").setName("Dan Maxim").setPassword("dan").setId(1));
		userList.add((User) new User().setEmailAddress("andrei.pavel@cegeka.com").setName("Andrei Pavel").setPassword("andrei").setId(2));
		userList.add((User) new User().setEmailAddress("alex.polatos@cegeka.com").setName("Alex Polatos").setPassword("alex").setId(3));
		return userList;
	}
	
}

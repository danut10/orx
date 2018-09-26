package ro.jdmx.orx.web.api.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.springframework.http.MediaType;

import ro.jdmx.orx.common.User;

@Consumes(MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
@Produces(MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
public class RsGeneric {
	
	@GET 
	@Path("/{entityCode}/list")
	public List<User> readList(@PathParam("entityCode") String entityCode) {
		List<User> recordList = new ArrayList<>();
		User dan = new User().setEmailAddress("danut10@yahoo.com").setPassword("danut10");
		recordList.add(dan);
		return recordList;
	}
	
}

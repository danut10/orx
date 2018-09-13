package ro.jdmx.orx.web.api.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.springframework.http.MediaType;

@Consumes(MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
@Produces(MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
public class RsGeneric {
	
	@GET 
	@Path("/{entityCode}/list")
	public List<Object> readList(@PathParam("entityCode") String entityCode) {
		List<Object> recordList = null;
		return recordList;
	}
	
}

package ro.jdmx.orx.web1.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ro.jdmx.orx.common.dataRecords.User;

@RestController
public class RsTest {

	@GetMapping("/user/{id}")
	User read(@PathVariable Integer id) {
		User user = new User();
		user.setId(id);
		return user;
	}
}

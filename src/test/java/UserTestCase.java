import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import users.entidades.User;
import users.service.UserService;

public class UserTestCase {

	UserService userService;

	@Before
	public void init() {
		userService = new UserService();
	}

	@Test
	public void insert() {
		User u = new User("test.junit@test.com", "Junit", "junit", new Date());
		userService.inserir(u);
		List<User> asList = userService.getQuery().field("email").equalIgnoreCase("test.junit@test.com").asList();
		assertNotNull(asList);
		assertTrue(asList.size() > 0);
	}

}

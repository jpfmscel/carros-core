import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import entidades.User;
import service.UserService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserTestCase {

	UserService userService;
	String email = "test.junit@test.com";
	User u = new User(email, "Junit", "junit", new Date());

	@Before
	public void init() {
		userService = new UserService();
	}

//	@Test
	public void a_insert() {
		String resultInsert = userService.inserir(u);
		User user = userService.findByEmail(email);

		System.out.println("Resultado INSERT : " + resultInsert + " - User ID: " + user.getId());
		assertNotNull(user);
	}

//	@Test
	public void b_authenticate() {
		assertTrue(userService.authenticate(u));
	}

}

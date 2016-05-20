package test.com.h2rd.refactoring;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.h2rd.refactoring.usermanagement.User;
import com.h2rd.refactoring.usermanagement.UserDao;

public class UserDaoTest {

	UserDao userDao = UserDao.getUserDao();
	User user;

	@Before
	public void setup() {
		user = new User();
		user.setName("Fake Name");
		user.setEmail("fake@email.com");
		user.setRoles(Arrays.asList("admin", "master"));
	}

	@Test
	public void saveUserTest() {
		userDao.saveUser(user);
	}

	@Test
	public void deleteUserTest() {
		try {
			userDao.deleteUser(user);
		} catch (NullPointerException e) {
		}
	}
}
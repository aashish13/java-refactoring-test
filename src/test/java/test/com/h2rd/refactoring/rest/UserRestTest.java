package test.com.h2rd.refactoring.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.h2rd.refactoring.data.model.User;
import static org.junit.Assert.*;
import test.com.h2rd.refactoring.config.TestConstants;

public class UserRestTest {

	private static Client client;
	private static WebTarget target;
	private List<User> users=new ArrayList<User>();
	private User user0, user1, user2;

	@BeforeClass
	public static void setupClass() {
		try {
			client = ClientBuilder.newClient();
			target = client.target(TestConstants.BASE_URL);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@AfterClass
	public static void tearDown() {
		client.close();
	}

	@Before
	public void setup() {
		// initializing the users list which will be used by the test methods
		user0 = new User();
		user0.setName("test0");
		user0.setEmail("test0@test.com");
		user0.setRoles(Arrays.asList("Developer0", "Manager0"));

		user1 = new User();
		user1.setName("test1");
		user1.setEmail("test1@test.com");
		user1.setRoles(Arrays.asList("Developer1", "Manager1"));

		user2 = new User();
		user2.setName("test2");
		user2.setEmail("test2@test.com");
		user2.setRoles(Arrays.asList("Developer2", "Manager2"));

		users.add(user0);
		users.add(user1);
		users.add(user2);
	}

	@Test
	public void getUsersRestTest() {
		for (User user : users) {
			//Add all the users using post method then verify if we get all the items from get request
		}
	}

	@Test
	public void searchUsersRestTest() {

	}

	@Test
	public void putUsersRestTest() {

	}

	@Test
	public void postUsersRestTest() {

	}

	@Test
	public void updateUsersRestTest() {

	}

	@Test
	public void deleteUsersRestTest() {

	}
}
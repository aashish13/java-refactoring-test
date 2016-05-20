package test.com.h2rd.refactoring;

import com.h2rd.refactoring.usermanagement.User;
import com.h2rd.refactoring.usermanagement.UserDao;
import org.junit.Test;

import java.util.Arrays;

public class UserDaoTest {

    UserDao userDao=UserDao.getUserDao();
    User user = new User();;

    @Test
    public void saveUserTest() {
        user.setName("Fake Name");
        user.setEmail("fake@email.com");
        user.setRoles(Arrays.asList("admin", "master"));
        userDao.saveUser(user);
    }

    @Test
    public void deleteUserTest() {
        User user = new User();
        user.setName("Fake Name");
        user.setEmail("fake@email.com");
        user.setRoles(Arrays.asList("admin", "master"));

        try {
            userDao.deleteUser(user);
        } catch (NullPointerException e) {
        }
    }
}
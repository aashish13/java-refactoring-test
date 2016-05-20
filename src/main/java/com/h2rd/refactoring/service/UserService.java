/**
 * 
 */
package com.h2rd.refactoring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h2rd.refactoring.data.dao.UserDao;
import com.h2rd.refactoring.data.model.User;

/**
 * @author Aashish
 *
 */
@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	
	/**
	 * @return
	 */
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return userDao.getUsers();
	}

	/**
	 * @param user
	 */
	public boolean save(User user) {
		// TODO Auto-generated method stub
		return userDao.saveUser(user);

	}

	/**
	 * @param user
	 */
	public void update(User user) {
		// TODO Auto-generated method stub
		userDao.updateUser(user);

	}

	/**
	 * @param user
	 */
	public boolean delete(User user) {
		// TODO Auto-generated method stub
		return userDao.deleteUser(user);

	}

	/**
	 * @param name
	 * @return
	 */
	public User find(String name) {
		// TODO Auto-generated method stub
		return userDao.findUser(name);
	}

}

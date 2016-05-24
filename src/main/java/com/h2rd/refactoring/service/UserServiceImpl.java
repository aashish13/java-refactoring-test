/**
 * 
 */
package com.h2rd.refactoring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h2rd.refactoring.data.model.User;
import com.h2rd.refactoring.data.repository.UserRepository;

/**
 * @author Aashish
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepositoryStub;

	
	/* (non-Javadoc)
	 * @see com.h2rd.refactoring.service.UserService#getAll()
	 */
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return userRepositoryStub.getUsers();
	}

	/* (non-Javadoc)
	 * @see com.h2rd.refactoring.service.UserService#save(com.h2rd.refactoring.data.model.User)
	 */
	public boolean save(User user) {
		// TODO Auto-generated method stub
		return userRepositoryStub.saveUser(user);

	}

	/* (non-Javadoc)
	 * @see com.h2rd.refactoring.service.UserService#update(com.h2rd.refactoring.data.model.User)
	 */
	public void update(User user) {
		// TODO Auto-generated method stub
		userRepositoryStub.updateUser(user);

	}

	/* (non-Javadoc)
	 * @see com.h2rd.refactoring.service.UserService#delete(java.lang.String)
	 */
	public boolean delete(String name) {
		// TODO Auto-generated method stub
		return userRepositoryStub.deleteUser(name);

	}

	/* (non-Javadoc)
	 * @see com.h2rd.refactoring.service.UserService#find(java.lang.String)
	 */
	public User find(String name) {
		// TODO Auto-generated method stub
		return userRepositoryStub.findUser(name);
	}

}

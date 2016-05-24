package com.h2rd.refactoring.data.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.h2rd.refactoring.data.model.User;

@Repository
public class UserRepositoryStub implements UserRepository{
	private static List<User> users = new ArrayList<User>();
	
	/* (non-Javadoc)
	 * @see com.h2rd.refactoring.data.repository.UserRepository#saveUser(com.h2rd.refactoring.data.model.User)
	 */
	public boolean saveUser(User user) {
		return users.add(user);
	}

	/* (non-Javadoc)
	 * @see com.h2rd.refactoring.data.repository.UserRepository#getUsers()
	 */
	public List<User> getUsers() {
		try {
			return users;
		} catch (Throwable e) {
			System.out.println("error");
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see com.h2rd.refactoring.data.repository.UserRepository#deleteUser(com.h2rd.refactoring.data.model.User)
	 */
	public boolean deleteUser(String userToDelete) {
		boolean isDeleted = false;
		try {
			for (User user:users) {
				if (users.equals(userToDelete))
					isDeleted = users.remove(userToDelete);
				return isDeleted;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isDeleted;
	}

	/* (non-Javadoc)
	 * @see com.h2rd.refactoring.data.repository.UserRepository#updateUser(com.h2rd.refactoring.data.model.User)
	 */
	public void updateUser(User userToUpdate) {
		try {
			for (User user : users) {
				if (user.equals(userToUpdate)) {
					user.setEmail(userToUpdate.getEmail());
					user.setRoles(userToUpdate.getRoles());
				}
				else{
					users.add(userToUpdate);
				}
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see com.h2rd.refactoring.data.repository.UserRepository#findUser(java.lang.String)
	 */
	public User findUser(String name) {
		System.out.println("Inside find user" + users.size());

		for (User user : users) {
			System.out.println("Inside find user" + user.getName());
			if (user.getName().equals(name)) {
				return user;
			}
		}
		return null;
	}
}

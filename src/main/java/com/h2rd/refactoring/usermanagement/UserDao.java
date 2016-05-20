package com.h2rd.refactoring.usermanagement;

import java.util.ArrayList;
import java.util.Iterator;

public class UserDao {

	public ArrayList<User> users;

	private UserDao() {
		users = new ArrayList<User>();
	}

	public static UserDao userDao;

	public static UserDao getUserDao() {
		if (userDao == null) {
			userDao = new UserDao();
		}
		return userDao;
	}

	public void saveUser(User user) {

		users.add(user);
	}

	public ArrayList<User> getUsers() {
		try {
			return users;
		} catch (Throwable e) {
			System.out.println("error");
			return null;
		}
	}

	public void deleteUser(User userToDelete) {
		try {
			Iterator<User> iterator = users.iterator();
			while (iterator.hasNext()) {
				User user = iterator.next();
				if (user.getName() == userToDelete.getName()) {
					users.remove(user);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateUser(User userToUpdate) {
		try {
			for (User user : users) {
				if (user.getName() == userToUpdate.getName()) {
					user.setEmail(userToUpdate.getEmail());
					user.setRoles(userToUpdate.getRoles());
				}
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

	public User findUser(String name) {
		try {
			for (User user : users) {
				if (user.getName() == name) {
					return user;
				}
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return null;
	}
}

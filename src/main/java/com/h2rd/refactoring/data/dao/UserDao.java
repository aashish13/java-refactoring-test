package com.h2rd.refactoring.data.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.h2rd.refactoring.data.model.User;

@Repository
public class UserDao {

	@Autowired
	private ArrayList<User> users;	

	@Autowired
	private UserDao userDao;

	

	public boolean saveUser(User user) {
		return users.add(user);
	}

	public ArrayList<User> getUsers() {
		try {
			return users;
		} catch (Throwable e) {
			System.out.println("error");
			return null;
		}
	}

	public boolean deleteUser(User userToDelete) {
		boolean isDeleted = false;
		try {
			if (users.contains(userToDelete))
				isDeleted = users.remove(userToDelete);
			return isDeleted;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isDeleted;
	}

	public void updateUser(User userToUpdate) {
		try {
			for (User user : users) {
				if (user.equals(userToUpdate)) {
					user.setEmail(userToUpdate.getEmail());
					user.setRoles(userToUpdate.getRoles());
				}
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

	public User findUser(String name) {
		System.out.println("Inside find user"+users.size());
		
			for (User user : users) {
				System.out.println("Inside find user"+user.getName());
				if (user.getName().equals(name)) {
					return user;
				}
			}
			return null;
	}
}

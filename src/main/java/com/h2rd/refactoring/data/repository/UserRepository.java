/**
 * 
 */
package com.h2rd.refactoring.data.repository;

import java.util.List;

import com.h2rd.refactoring.data.model.User;

/**
 * @author Aashish
 *
 */
public interface UserRepository {

	boolean saveUser(User user);

	List<User> getUsers();

	boolean deleteUser(String name);

	void updateUser(User userToUpdate);

	User findUser(String name);

}
/**
 * 
 */
package com.h2rd.refactoring.service;

import java.util.List;

import com.h2rd.refactoring.data.model.User;

/**
 * @author Aashish
 *
 */
public interface UserService {

	/**
	 * @return
	 */
	List<User> getAll();

	/**
	 * @param user
	 */
	boolean save(User user);

	/**
	 * @param user
	 */
	void update(User user);

	/**
	 * @param user
	 */
	boolean delete(String name);

	/**
	 * @param name
	 * @return
	 */
	User find(String name);

}
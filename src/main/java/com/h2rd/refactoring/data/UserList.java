/**
 * 
 */
package com.h2rd.refactoring.data;

import java.util.ArrayList;
import java.util.List;

import com.h2rd.refactoring.data.model.User;

/**
 * @author Aashish
 *
 */
public class UserList {
	private static List<User> users=new ArrayList<User>();
	/**
	 * 
	 */
	private UserList() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the users
	 */
	public static List<User> getUsers() {
		return users;
	}
	/**
	 * @param users the users to set
	 */
	public static void setUsers(List<User> users) {
		UserList.users = users;
	}
	
	
	

}

/**
 * 
 */
package com.h2rd.refactoring.data.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Aashish
 *
 */

public class Role {
	private String name;
	/**
	 * 
	 */
	public Role() {
	}
	public Role(String name) {
		// TODO Auto-generated constructor stub
		this.name=name;
	}
	/**
	 * @return the role
	 */
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
}

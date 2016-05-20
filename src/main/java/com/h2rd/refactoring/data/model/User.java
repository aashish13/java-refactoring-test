package com.h2rd.refactoring.data.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {

	private String name;
	private String email;
	private List<String> roles;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	@Override
	public boolean equals(Object obj) {
		boolean returnValue = false;
		if (obj == null || !(obj instanceof User)) {
			returnValue = false;
		} else if (obj == this
				|| (((User) obj).getName().equals(this.getName()) && ((User) obj).getEmail().equals(this.getEmail()))) {
			returnValue = true;
		}
		return returnValue;
	}
	@Override
	public String toString() {
		return "[ Name -> "+this.getName()+" :Email->"+this.getEmail()+" :Roles->{"+this.getRoles()+"}]";
	}

}

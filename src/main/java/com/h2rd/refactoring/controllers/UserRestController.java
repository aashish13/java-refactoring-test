package com.h2rd.refactoring.controllers;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.h2rd.refactoring.data.dao.UserDao;
import com.h2rd.refactoring.data.model.User;

@Path("/users")
@Component
public class UserRestController{
	@Autowired
	public UserDao userDao;

	@GET
	public Response getUsers() {
		System.out.println("Inside"+userDao);
		GenericEntity<List<User>> usersEntity = new GenericEntity<List<User>>(userDao.getUsers()) {
		};
		return Response.status(200).entity(usersEntity).build();
	}

	@GET
	@Path("add/")
	public Response addUser(@QueryParam("name") String name, @QueryParam("email") String email,
			@QueryParam("role") List<String> roles) {
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setRoles(roles);
		userDao.saveUser(user);
		return Response.ok().entity(user).build();
	}

	@GET
	@Path("update/")
	public Response updateUser(@QueryParam("name") String name, @QueryParam("email") String email,
			@QueryParam("role") List<String> roles) {
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setRoles(roles);
		userDao.updateUser(user);
		return Response.ok().entity(user).build();
	}

	@GET
	@Path("delete/")
	public Response deleteUser(@QueryParam("name") String name, @QueryParam("email") String email,
			@QueryParam("role") List<String> roles) {
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setRoles(roles);
		userDao.deleteUser(user);
		return Response.ok().entity(user).build();
	}

	@GET
	@Path("{name}")
	public Response findUser(@PathParam("name") String name) {
		User user = userDao.findUser(name);
		return Response.ok().entity(user).build();
	}
}

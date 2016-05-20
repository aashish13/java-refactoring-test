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
import com.h2rd.refactoring.service.UserService;

@Path("/users")
@Component
public class UserRestController{
	@Autowired
	public UserService userService;

	@GET
	public Response getUsers() {
		System.out.println("Inside => "+userService);
		GenericEntity<List<User>> usersEntity = new GenericEntity<List<User>>(userService.getAll()) {
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
		userService.save(user);
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
		userService.update(user);
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
		userService.delete(user);
		return Response.ok().entity(user).build();
	}

	@GET
	@Path("{name}")
	public Response findUser(@PathParam("name") String name) {
		User user = userService.find(name);
		return Response.ok().entity(user).build();
	}
}

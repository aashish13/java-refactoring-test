package com.h2rd.refactoring.controllers;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.h2rd.refactoring.data.model.User;
import com.h2rd.refactoring.service.UserService;

@Path("/users")
@Component
public class UserRestController {

	@Autowired
	public UserService userService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllUsers() {
		List<User> userList=userService.getAll();
		if(userList.isEmpty()){
			GenericEntity<List<User>> usersEntity = new GenericEntity<List<User>>(userList) {};
	        return Response.status(200).entity(usersEntity).build();
		}
		else {
			return Response.status(Status.NOT_FOUND).build();
		}
			
	}

	@GET
	@Path("{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser(@PathParam("name") String name) {
		if (name == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		User user = userService.find(name);
		if (user == null) {
			return Response.status(Status.NOT_FOUND).build();
		} else {
			return Response.ok().entity(user).build();
		}
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addUser(@Valid User user) {
		userService.save(user);
		return Response.status(Status.ACCEPTED).build();
	}

	@PUT
	@Path("{name}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateUser(User user) {
		userService.update(user);
		return Response.ok().entity(user).build();
	}

	@DELETE
	@Path("{name}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteUser(@PathParam("name") String name) {
		userService.delete(name);
		return Response.ok().build();
	}
}
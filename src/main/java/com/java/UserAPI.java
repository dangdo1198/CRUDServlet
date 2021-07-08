package com.java;

import java.util.*;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/user")
public class UserAPI {
	private UserDao dao = new UserDao();

	// RESTful API methods go here...
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> list() {
		List<User> lisUsers = dao.getAllUser();
		return lisUsers;
	}
	
	@POST
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void insert(User user) {
      
		dao.addUser(user);
    }

}

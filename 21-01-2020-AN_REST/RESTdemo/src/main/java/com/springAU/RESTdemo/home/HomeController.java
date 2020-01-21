package com.springAU.RESTdemo.home;



import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import com.springAU.RESTdemo.model.User;

@Path("/apis")
public class HomeController {
	
	private static List<User> countries = new ArrayList<User>(); //
	
	@GET
	@Produces("application/json")
	public List<User> showUsers() {
		
		
		return countries ;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String Employee(User user) {
		if(countries.contains(user)) {
			
			return "User Already Exists" ;
		}
		else {
			countries.add(user);
			return "Successful";
		}
		
		//return countries;
	}
	
	
	@PUT
	@Produces("application/json")
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public String update(@PathParam("id") int id,User user) {
		
		user.setId(id);
		if(countries.contains(user)) {
			
			countries.get(countries.indexOf(user)).setName(user.getName());
			return "Successful";
			
		}
		else {
			
			return "User Not Exists" ;
		}
		
		
		
	}
	
	@DELETE
	@Produces("application/json")
	@Path("{id}")
	//@Consumes(MediaType.APPLICATION_JSON)
	public String delete(@PathParam("id") int id) {
		//countries = countries.stream().filter(x -> !(x.getId() == id)).collect(Collectors.toList());
		if(countries.contains(new User(id, ""))) {
			countries.remove(new User(id, ""));
			return "Deleted: " + id;
		}
		else {
			return "User Not found";
		}
		
	}
}

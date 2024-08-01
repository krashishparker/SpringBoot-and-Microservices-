package com.krashish.rest.webservices.restful_web_services.user;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {
	
	private UserDaoService service;
	

	public UserResource(UserDaoService service) {
		this.service = service;
	}

	//GET /users
    @GetMapping("/users")
	public List<User> retriveAllUsers(){
		return service.findAll();
	}
    
    //GET /users/2
    @GetMapping("/users/{id}")
    public User retriveUsers(@PathVariable int id){
		return service.findUser(id);
	}
    
    //POST /users
    
    @PostMapping("/users")
    public void createUsers(@RequestBody User user){
		 service.saveUser(user);
	}
    
    
}

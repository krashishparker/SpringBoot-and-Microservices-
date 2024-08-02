package com.krashish.rest.webservices.restful_web_services.user;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
		User user=service.findUser(id);
		
		if(user==null)
		 throw new UserNotFoundException("id not found is: "+ id);
		
		
		return user;
	}
    
    //POST /users
    
    @PostMapping("/users")
    public ResponseEntity<User> createUsers(@RequestBody User user){
		User savedUser= service.saveUser(user);
		 
		 URI location=ServletUriComponentsBuilder
				 .fromCurrentRequest()
				 .path("/{id}")
				 .buildAndExpand(savedUser.getId())
				 .toUri();
				return ResponseEntity.created(location).build();
				
		 
	}
    
    
}

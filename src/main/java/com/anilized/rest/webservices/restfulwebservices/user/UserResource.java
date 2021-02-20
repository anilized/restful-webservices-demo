package com.anilized.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {
	
	
	@Autowired
	private UserDaoService userService;
	
	//GET /users
	// retrieve All users
	@GetMapping(path = "/users")
	public List<User> retrieveAllUsers(){
		return userService.findAll();
	}
	
	
	//GET /users/{id} -> /users/1
	// retrieve user
	@GetMapping(path = "/users/{id}")
	public User getUser(@PathVariable int id) {
		User user = userService.findOne(id);
		
		if(user.getId() == null) {
			throw new UserNotFoundException("user not found");
		} else {
			return user;
		}
	}
	
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = userService.saveUser(user);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping(path = "/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User user = userService.deleteById(id);
		
		if(user.getId() == null) {
			throw new UserNotFoundException("user not found");
		}
	}
	
}

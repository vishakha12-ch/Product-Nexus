package com.example.Exitapi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.Exitapi.entity.User;
import com.example.Exitapi.repository.UserRepo;
import com.example.Exitapi.service.UserService;

/**
 * This controller class implements user api
 * @author vishakhachaudhary
 *
 */

@RestController
@CrossOrigin
public class UserController {
	
	@Autowired
	private UserRepo repo;
	
	@Autowired
	private UserService service;
	
	/**
	 * this api to get user details for the username
	 * @param username
	 * @return
	 */
	
	
	@GetMapping("/currentuser/{username}")
	public User currentuser(@PathVariable("username") String username) {
		return repo.findByUsername(username);
		
	}
	
	/**
	 * this api to used to register the user
	 * @param user
	 * @return
	 */
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody User user) {
		try {
			User register = service.register(user);
			return ResponseEntity.ok(register);
		}catch(IllegalArgumentException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}	

}

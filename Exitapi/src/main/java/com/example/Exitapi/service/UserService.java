package com.example.Exitapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.Exitapi.dto.UserDTO;
import com.example.Exitapi.entity.User;
import com.example.Exitapi.repository.UserRepo;

/**
 * this class perfoem service for user
 * @author vishakhachaudhary
 *
 */
@Service
public class UserService {
	
	@Autowired
	private UserRepo repo;
	
	/**
	 * this mehtod is used to register the user
	 * @param user
	 * @return
	 * @throws IllegalArgumentException
	 */
	
	public User register(User user) throws IllegalArgumentException {
		
		if(repo.findByEmail(user.getEmail())!= null) {
			throw new IllegalArgumentException("This e-mail is already exist");
		}
		if(repo.findByUsername(user.getUsername())!=null) {
			throw new IllegalArgumentException("This username is already exist");
		}
		
		return repo.save(user);
		
	}
	
	

}

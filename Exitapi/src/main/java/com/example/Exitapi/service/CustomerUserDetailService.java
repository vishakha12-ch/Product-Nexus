package com.example.Exitapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.Exitapi.entity.CustomerUserDetails;
import com.example.Exitapi.entity.User;
import com.example.Exitapi.repository.UserRepo;

/**
 * this class is used retrieve user information
 * @author vishakhachaudhary
 *
 */
@Service
public class CustomerUserDetailService implements UserDetailsService {
	
	@Autowired
	private UserRepo user;
    
	/**
	 * this method is used to check and return user if present in database
	 */
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = this.user.findByUsername(username);
		if(user==null) {
			System.out.print("user not found");
			throw new UsernameNotFoundException("User is not present.Please register");
		}
		return new CustomerUserDetails(user);
	}
	
	

}

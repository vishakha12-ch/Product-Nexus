package com.example.Exitapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Exitapi.Utility.JWThelp;
import com.example.Exitapi.Utility.JWTrequest;
import com.example.Exitapi.Utility.JWTresponse;
import com.example.Exitapi.repository.ProductRepo;
import com.example.Exitapi.repository.ReviewRepo;
import com.example.Exitapi.repository.UserRepo;
import com.example.Exitapi.service.CustomerUserDetailService;

/**
 * This Controller class implements stats and token for user
 * @author vishakhachaudhary
 *
 */

@RestController
@CrossOrigin
public class TokenController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private CustomerUserDetailService customerservice;
	
	@Autowired
	private JWThelp jwttoken;
	
	@Autowired
	private ProductRepo productrepo;
	
	@Autowired
	private ReviewRepo reviewrepo;
	
	@Autowired
	private UserRepo userrepo;
	
	/**
	 * this api generate token for user and authenticate user
	 * @param request
	 * @return
	 * @throws Exception
	 */
	
	@PostMapping("/gettoken")
	public ResponseEntity<?> generateToken(@RequestBody JWTrequest request) throws Exception{
		authenticate(request.getUsername(),request.getPassword());
		
		UserDetails userdetail = this.customerservice.loadUserByUsername(request.getUsername());
		String token =this.jwttoken.generateToken(userdetail);
		return ResponseEntity.ok(new JWTresponse(token));
		
		
	}
	
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
		} catch(UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("invalid user");
		}
	}
	
	/**
	 * This api to get all user count
	 * @return
	 */
	
	
	@GetMapping("/alluser")
	public Long allusers() {
		return userrepo.count();
		
	}
	
	/**
	 * this api to get all product count
	 * @return
	 */
	
	@GetMapping("/allproduct")
	public Long allproduct() {
		return productrepo.count();
	}
	
	/**
	 * this api to get all review count
	 * @return
	 */
	
	@GetMapping("/allreview")
	public Long allreview() {
		return reviewrepo.count();
	}
	
}

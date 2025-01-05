package com.example.Exitapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Exitapi.entity.User;

/**
 * user repository extend jparepository that help to perform crud opeartion on user entity
 * @author vishakhachaudhary
 *
 */
@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
	
	public User findByUsernameAndPassword(String username, String password);
	public User findByUsername(String username);
	public User findByEmail(String email);
	

}

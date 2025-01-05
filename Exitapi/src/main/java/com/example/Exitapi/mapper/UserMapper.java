package com.example.Exitapi.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.Exitapi.dto.UserDTO;
import com.example.Exitapi.entity.User;

public class UserMapper {
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private UserDTO userDto;
	
	public UserDTO usertodto(User user) {
		UserDTO userdto = mapper.map(user,UserDTO.class);
		return userdto;
		
	}
	
	public User dtotouser(UserDTO userdto) {
		User user =mapper.map(userdto, User.class);
		return user;
	}

}

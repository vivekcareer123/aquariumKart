package com.aquariumKart.backend.service;

import org.springframework.security.core.userdetails.UserDetails;

import com.aquariumKart.backend.entities.users.User;

public interface UserService {

	public User saveUser(User user);
	
	public User updateUser(User user);
	
	public User retrieveUserById(long id);
	
	public UserDetails getUserDetails(String userName);
}

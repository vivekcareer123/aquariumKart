package com.aquariumKart.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aquariumKart.backend.entities.users.User;
import com.aquariumKart.backend.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	@Override
	public User saveUser(User user) {
		User user2 = repository.save(user);
		return user2;
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User retrieveUserById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDetails getUserDetails(String userName) {
		User user = repository.findByEmail(userName);
		if (user == null) {
			throw new UsernameNotFoundException("Username is not Registered");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				user.getRoles());
	}

}

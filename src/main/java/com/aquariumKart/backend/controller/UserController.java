package com.aquariumKart.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aquariumKart.backend.entities.users.User;
import com.aquariumKart.backend.service.SecurityService;
import com.aquariumKart.backend.service.UserService;

@Controller
public class UserController {

	@Autowired
	private SecurityService securityService;

	@Autowired
	UserService userService;

	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@RequestMapping(value = "/loginUser", method = RequestMethod.POST)
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password) {
		boolean status = false;
		String loggedInStatus = "";
		status = securityService.login(email, password);
		if (status) {
			loggedInStatus = "success";
		} else {
			loggedInStatus = "failure";
		}
		return loggedInStatus;
	}

	@RequestMapping(value = "/loginUser", method = RequestMethod.POST)
	public User createEmployee(@RequestBody User user) {
		return userService.saveUser(user);
	}

}

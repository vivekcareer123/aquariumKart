package com.aquariumKart.backend;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.aquariumKart.backend.entities.users.User;
import com.aquariumKart.backend.repository.UserRepository;

@SpringBootTest
class AquariumKartApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testUser() {
		User user = new User();
		user.setUserName("vivekshankar");
		user.setPassword("Vivek@123");
		user.setEmail("vivekcareer123@gmail.com");
		user.setCountry("India");
		user.setFirstName("Vivek");
		user.setLastName("Shankar");
		user.setPassConfirm("Vivek@123");
		userRepository.save(user);

	}

	@Test
	public void fetchUser() {
		User user = userRepository.findById(1l).get();
		System.out.println(user);
	}
}

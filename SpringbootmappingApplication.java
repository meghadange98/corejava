package com.example.demo;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Gender;
import com.example.demo.entity.User;
import com.example.demo.entity.UserProfile;
import com.example.demo.repository.UserProfileRepository;
import com.example.demo.repository.UserRepository;

@SpringBootApplication
public class SpringbootmappingApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootmappingApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserProfileRepository userProfileRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//user object
		User user = new User();
		user.setName("megha");
		user.setEmail("megha@gmail.com");
		
		UserProfile userProfile = new UserProfile();
		userProfile.setAddress("Pune");
		userProfile.setBirthOfDate(LocalDate.of(1991, 3, 24));
		userProfile.setGender(Gender.FEMALE);
		userProfile.setPhoneNumber("1234567899");
		
		
		user.setUserProfile(userProfile);
		userProfile.setUser(user);
		
		userRepository.save(user);
	}

}

package com.itacademy.rest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.itacademy.rest.service.IUserService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	CommandLineRunner run(IUserService userService) {
		return args -> {
			
//			userService.saveRole(new Role(null,"ROLE_USER"));
//			userService.saveRole(new Role(null,"ROLE_VIEWER"));
//			userService.saveRole(new Role(null,"ROLE_ADMIN"));
//			
//			userService.saveUser(new AppUser(null, "John Travolta", "john", "1234", null));
//			userService.saveUser(new AppUser(null, "Will Smith", "will", "4321", null));
//			userService.saveUser(new AppUser(null, "Jim Carrey", "jim", "5678", new ArrayList<>()));
//			userService.saveUser(new AppUser(null, "Arnold Schwarzenegger", "arnold", "8765", new ArrayList<>()));
//			
//			userService.addRoleToUser("john", "ROLE_USER");
//			userService.addRoleToUser("will", "ROLE_VIEWER");
//			userService.addRoleToUser("jim", "ROLE_ADMIN");
//			userService.addRoleToUser("arnold", "ROLE_ADMIN");
//			userService.addRoleToUser("arnold", "ROLE_USER");
			
			
		};
	}
}

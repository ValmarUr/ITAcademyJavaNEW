package com.itacademy.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
//	@Bean
//	CommandLineRunner run(IUserService userService) {
//		return args -> {
//			
//			userService.saveRole(new Role(null,"ROLE_USER"));
//			userService.saveRole(new Role(null,"ROLE_MANAGER"));
//			userService.saveRole(new Role(null,"ROLE_ADMIN"));
//			userService.saveRole(new Role(null,"ROLE_SUPERADMIN"));
//			
//			userService.saveUser(new AppUser(null, "John Travolta", "john", "1234", new ArrayList<>()));
//			userService.saveUser(new AppUser(null, "Will Smith", "will", "4321", new ArrayList<>()));
//			userService.saveUser(new AppUser(null, "Jim Carrey", "jim", "5678", new ArrayList<>()));
//			userService.saveUser(new AppUser(null, "Arnold Schwarzenegger", "arnold", "8765", new ArrayList<>()));
//			
//			userService.addRoleToUser("john", "ROLE_USER");
//			userService.addRoleToUser("john", "ROLE_MANAGER");
//			userService.addRoleToUser("will", "ROLE_MANAGER");
//			userService.addRoleToUser("jim", "ROLE_ADMIN");
//			userService.addRoleToUser("arnold", "ROLE_SUPERADMIN");
//			userService.addRoleToUser("arnold", "ROLE_ADMIN");
//			userService.addRoleToUser("arnold", "ROLE_USER");
//			
//			
//		};
//	}
}

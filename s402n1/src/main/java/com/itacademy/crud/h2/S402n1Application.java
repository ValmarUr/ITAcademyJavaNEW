package com.itacademy.crud.h2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc //Swagger no funciona sin esta anotación
@SpringBootApplication
public class S402n1Application {

	public static void main(String[] args) {
		SpringApplication.run(S402n1Application.class, args);
	}

}

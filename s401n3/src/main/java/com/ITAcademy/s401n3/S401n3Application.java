package com.ITAcademy.s401n3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class S401n3Application {

	public static void main(String[] args) {
		SpringApplication.run(S401n3Application.class, args);
	}

	@GetMapping("/")
	public String hello(@RequestParam(value="name", defaultValue="WORLD") String name) {
		return String.format("HELLO %s!", name);
	}
}

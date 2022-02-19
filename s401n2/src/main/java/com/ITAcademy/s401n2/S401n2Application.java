package com.ITAcademy.s401n2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class S401n2Application {

	public static void main(String[] args) {
		SpringApplication.run(S401n2Application.class, args);
	}

	@GetMapping("/")
	public String hello(@RequestParam(value="name", defaultValue="WORLD") String name) {
		return "HELLO " + name + "!";
	}
}

package com.itacademy.rest.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Document(collection="app_users")
public class AppUser {
	@Id
	private String id;
	private String name;
	@Indexed(unique=true) @NotBlank
	private String username;
	private String password;
	private Collection<Role> roles = new ArrayList<>();
}

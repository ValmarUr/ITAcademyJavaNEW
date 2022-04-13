package com.itacademy.rest.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Document(collection="players")
public class Player {
	
	@Id 
	private String id;
	@Indexed(unique=true) @NotBlank
	private String name = "ANONYMOUS";
	private Date registerDate = new Date();
	private String successRate = "0";
	private List<Game> games = new ArrayList<Game>();
}

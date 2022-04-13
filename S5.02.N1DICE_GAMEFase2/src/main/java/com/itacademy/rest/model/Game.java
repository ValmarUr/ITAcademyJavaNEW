package com.itacademy.rest.model;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Game {

	@Id
	private String id;
	private int dice1;
	private int dice2;
	private boolean victory;
	
}

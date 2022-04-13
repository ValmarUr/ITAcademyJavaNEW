package com.itacademy.rest.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity(name="Player")
@Table(	name="players",
		uniqueConstraints = {
				@UniqueConstraint(name = "player_name_unique", columnNames = "name")
		}
)
public class Player {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO, generator="player_sequence")
	private Long id;
	
	@NotBlank
	@Column(nullable=false
			//columnDefinition = "TEXT" // Datatype definition
			//unique=true --> ugly constraint name
			)
	private String name = "ANONYMOUS";
	
	@Column(name = "register_date", // it automatically changes from registerDate to register_date
			nullable=false)
	private Date registerDate = new Date();
	
	private String successRate = "0";
	
}

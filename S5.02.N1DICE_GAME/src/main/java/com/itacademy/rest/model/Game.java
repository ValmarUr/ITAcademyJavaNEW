package com.itacademy.rest.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name="games")
public class Game {

	@Id @GeneratedValue(strategy=GenerationType.AUTO, generator="game_sequence")
	private Long id;
	
	private int dice1;
	
	private int dice2;
	
	private boolean victory;
	
	@ManyToOne(fetch = FetchType.LAZY, optional=false)
	@JoinColumn(name="player_id", nullable=false)
	@JsonIgnore
	private Player player;
}

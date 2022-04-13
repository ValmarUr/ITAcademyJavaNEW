package com.itacademy.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itacademy.rest.model.Player;
import com.itacademy.rest.service.IRankingService;

@RestController
@RequestMapping("/players/ranking")

public class RankingController {
	
	@Autowired
	private IRankingService rankingSevice;

	
	
	@GetMapping("")
	public ResponseEntity<String> getRanking() {
		
		// GET /players/ranking: retorna el ranking  mig de tots els   jugadors del sistema .  És a dir, el  percentatge mig  d’èxits.
		return ResponseEntity.ok().body(this.rankingSevice.getRanking());
	}
	
	@GetMapping("/loser")
	public ResponseEntity<Player> getLoser() {
		
		// GET /players/ranking/loser: retorna el jugador  amb pitjor percentatge d’èxit
		return ResponseEntity.ok().body(this.rankingSevice.getLoser());
	}
	
	@GetMapping("/winner")
	public ResponseEntity<Player> getWinner() {
		
		// GET /players/ranking/winner: retorna el  jugador amb  pitjor percentatge   d’èxit
		return ResponseEntity.ok().body(this.rankingSevice.getWinner());
	}
	
}

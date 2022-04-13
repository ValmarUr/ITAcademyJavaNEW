package com.itacademy.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itacademy.rest.model.Player;
import com.itacademy.rest.service.IPlayerService;

@RestController
@RequestMapping("/players")
public class PlayerController {
	
	@Autowired
	private IPlayerService playerService;

	
	@PostMapping("") //create new player
	public ResponseEntity<Player> createPlayer(@Valid @RequestBody Player player) {
		
		// POST: /players : crea un jugador
		return ResponseEntity.status(HttpStatus.CREATED).body(this.playerService.createPlayer(player));
	}
	
	@PutMapping("") //edit player's name
	public ResponseEntity<Player> updatePlayer(@Valid @RequestBody Player player) {
		
		// PUT /players : modifica el nom del jugador
		return ResponseEntity.ok().body(this.playerService.updatePlayer(player));	
	}
	
	@GetMapping("") //return all player's list with %succesRate
	public ResponseEntity<List<Player>> getAllPlayers() {
		
		// GET /players/: retorna el llistat de tots  els jugadors del sistema  amb el seu  percentatge mig  d’èxits
		List<Player> players = this.playerService.getAllPlayers();
	    
	    if (players.isEmpty())		return new ResponseEntity<List<Player>>(HttpStatus.NO_CONTENT);
	    else 						return ResponseEntity.ok(players);
	}
}

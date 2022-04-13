package com.itacademy.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itacademy.rest.model.Game;
import com.itacademy.rest.service.IGameService;

@RestController
@RequestMapping("/players")
//@CrossOrigin
public class GameController {
	
	@Autowired
	private IGameService gameService;

	@PostMapping("/{id}/games") //user(id) play a game
	public ResponseEntity<Game> playGame(@PathVariable Long id) {
		
		// POST /players/{id}/games/ : un jugador específic realitza una tirada  dels daus.
		return ResponseEntity.status(HttpStatus.CREATED).body(this.gameService.playGame(id));
	}
	
	@DeleteMapping("/{id}/games") //delete ALL games from user(id)
	public ResponseEntity<?> deleteAllGames(@PathVariable Long id) {
		
		// DELETE /players/{id}/games: elimina les tirades del jugador	
		this.gameService.deleteAllGames(id);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@GetMapping("/{id}/games") //return all games list from user(id)	---> format: || dice1Value || dice2Value || gameResult ||
	public ResponseEntity<List<Game>> getAllGames(@PathVariable Long id) {
		
		// GET /players/{id}/games: retorna el llistat de jugades per un jugador. 
		List<Game> games = this.gameService.getAllGames(id);
	    
	    if (games.isEmpty())		return new ResponseEntity<List<Game>>(HttpStatus.NO_CONTENT);
	    else 						return ResponseEntity.ok(games);
	}
	
}

package com.itacademy.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itacademy.rest.exception.ResourceNotFoundException;
import com.itacademy.rest.model.Game;
import com.itacademy.rest.model.Player;
import com.itacademy.rest.repository.IPlayerRepository;

@Service
public class CGameServiceImpl implements IGameService {

	@Autowired
	private IPlayerRepository playerRepo;
	
	
	@Override
	public Game playGame(String id) {
		
		Optional<Player> playerDb = playerRepo.findById(id);
		
		Game game = null;
		
		if(playerDb.isPresent()) {
			
			int firstRoll = throwDice();
			int secondRoll = throwDice();
			boolean victory;
			if(firstRoll + secondRoll == 7) victory = true;
			else							victory = false;
			
			Player updatedPlayer = updateSuccessRate(playerDb.get(), victory);
			
			game = new Game(null, firstRoll, secondRoll, victory);
			updatedPlayer.getGames().add(game);
			
			playerRepo.save(updatedPlayer);
			
		}else {
			throw new ResourceNotFoundException("Player with id = " + id + " not found.");
		}
	
		return game;
	}

	@Override
	public void deleteAllGames(String id) {
		
		Optional<Player> playerDb = playerRepo.findById(id);
		
		if(playerDb.isPresent()) {
			
			Player player = playerDb.get();
			
			player.getGames().clear();
			player.setSuccessRate("0");
			
			this.playerRepo.save(player);
			
		}else 						
			throw new ResourceNotFoundException("Player with id = " + id + " not found.");
	}

	@Override
	public List<Game> getAllGames(String id) {
		return this.playerRepo.findById(id).get().getGames();
	}
	
	private int throwDice() {
		
		int min = 1;
		int max = 6;
		
		int result = (int)(Math.random() * (max - min + 1) + min);
	
		return result;
	}
	
	private Player updateSuccessRate(Player player, boolean victory) {
		
		int gamesPlayed = player.getGames().size();
		int oldSuccesRate = Integer.parseInt(player.getSuccessRate()); 
		
		int wins = Math.round(gamesPlayed * ((float)oldSuccesRate / 100));
		
		if(victory) wins++;
		
		gamesPlayed++;
		int newSuccessRate = (wins * 100) / gamesPlayed;
		player.setSuccessRate(Integer.toString(newSuccessRate));
		

		return player;
	}
	
//	private Integer generateUniqueId() {
//	    Game latestGame = playerRepo.findTopOrderByIdDesc(); // latest session
//	    return Optional.ofNullable(latestGame).map(Game::getId).orElse(-1) + 1;
//	}

}

package com.itacademy.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itacademy.rest.exception.ResourceNotFoundException;
import com.itacademy.rest.model.Game;
import com.itacademy.rest.model.Player;
import com.itacademy.rest.repository.IGameRepository;
import com.itacademy.rest.repository.IPlayerRepository;

@Service
public class GameServiceImpl implements IGameService {

	@Autowired
	private IGameRepository gameRepo;
	
	@Autowired
	private IPlayerRepository playerRepo;
	
	
	@Override
	public Game playGame(Long id) {
		
		Optional<Player> playerDb = playerRepo.findById(id);
		
		Game game = null;
		
		if(playerDb.isPresent()) {
			
			int firstRoll = throwDice();
			int secondRoll = throwDice();
			boolean victory;
			if(firstRoll + secondRoll == 7) victory = true;
			else							victory = false;
			
			Player updatedPlayer = updateSuccessRate(playerDb.get(), victory);
			playerRepo.save(updatedPlayer);
			
			game = new Game(null, firstRoll, secondRoll, victory, updatedPlayer);
			
			gameRepo.save(game); //dentro del isPresent mejor?
		}else {
			throw new ResourceNotFoundException("Player with id = " + id + " not found.");
		}
		
		//System.out.println(game);
		return game;
	}

	@Override
	public void deleteAllGames(Long id) {
		
		Optional<Player> playerDb = playerRepo.findById(id);
		
		if(playerDb.isPresent()) {
			this.gameRepo.deleteByPlayerId(id);		
			Player updatePlayer = playerDb.get();
			updatePlayer.setSuccessRate("0");
			this.playerRepo.save(updatePlayer);
		}else {
			throw new ResourceNotFoundException("Player with id = " + id + " not found.");
		}

	}

	@Override
	public List<Game> getAllGames(Long id) {
		return this.gameRepo.findByPlayerId(id);
	}
	
	private int throwDice() {
		
		int min = 1;
		int max = 6;
		
		int result = (int)(Math.random() * (max - min + 1) + min);
	
		return result;
	}
	
	private Player updateSuccessRate(Player player, boolean victory) {
		
		int gamesPlayed = getAllGames(player.getId()).size();
		int oldSuccesRate = Integer.parseInt(player.getSuccessRate()); 
		
		int wins = Math.round(gamesPlayed * ((float)oldSuccesRate / 100));
		
		if(victory) wins++;
		
		gamesPlayed++;
		int newSuccessRate = (wins * 100) / gamesPlayed;
		player.setSuccessRate(Integer.toString(newSuccessRate));
		
		//System.out.println("UPDATE//  GP="+gamesPlayed+ " OSR:"+oldSuccesRate+"/NSR:"+newSuccessRate+"   wins="+wins);
		
		return player;
	}

}

package com.itacademy.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itacademy.rest.model.Player;
import com.itacademy.rest.repository.IPlayerRepository;

@Service
public class CRankingServiceImpl implements IRankingService {
	
	@Autowired
	private IPlayerRepository playerRepo;
	

	@Override
	public String getRanking() {
		
		List<Player> listDb = this.playerRepo.findAll();
		
		int totalPlayers = listDb.size();
		int sumSuccessRate = 0;
		
		for(Player player : listDb) {
			int successRate = Integer.parseInt(player.getSuccessRate());
			sumSuccessRate += successRate;
		}
		
		int ranking;
		if (sumSuccessRate > 0 )	ranking = sumSuccessRate/totalPlayers;
		else						ranking = 0;
		
		String result = "Ranking: " + Integer.toString(ranking) + "%";
		

		return result;
	}

	@Override
	public Player getLoser() {
		
		List<Player> listDb = this.playerRepo.findAll();
		
		Player loser = null;
		int min = 100;
		
		for(Player player : listDb) {
			
			int successRate = Integer.parseInt(player.getSuccessRate());
			
			if(successRate < min) {
				min = successRate;
				loser = player;
			}
		}
		
		System.out.println(loser);
		return loser;
	}

	@Override
	public Player getWinner() {
		
		List<Player> listDb = this.playerRepo.findAll();
		
		Player winner = null;
		int max = 0;
		
		for(Player player : listDb) {
			
			int successRate = Integer.parseInt(player.getSuccessRate());
			
			if(successRate > max) {
				max = successRate;
				winner = player;
			}
		}
		
		return winner;
	}
	
//	public List<Player> sortedListBySuccessRate(){
//		
//		List<Player> listDb = this.playerRepo.findAll();
//				
//		//listDb.stream().sorted(Comparator.comparing(Player::getSuccesRate).collect(Collectors.toList()));
//	}
	

}

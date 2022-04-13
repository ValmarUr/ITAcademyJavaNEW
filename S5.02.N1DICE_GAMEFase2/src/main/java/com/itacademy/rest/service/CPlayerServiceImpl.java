package com.itacademy.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itacademy.rest.exception.ResourceNotFoundException;
import com.itacademy.rest.model.Player;
import com.itacademy.rest.repository.IPlayerRepository;

@Service 
public class CPlayerServiceImpl implements IPlayerService {

	@Autowired
	private IPlayerRepository playerRepo;
	
	
	@Override
	public Player createPlayer(Player player) {
		//System.out.println(player);
		return playerRepo.save(player);
	}
	
	@Override
	public List<Player> getAllPlayers() {
		
		List<Player> listDb = this.playerRepo.findAll();
		
		listDb.forEach((player) -> {
			player.setSuccessRate(player.getSuccessRate()+"%");
		});
		
		return this.playerRepo.findAll();
	}
	
	@Override
	public Player updatePlayer(Player player) {


		String id = player.getId();
		
		Optional<Player> playerDb = this.playerRepo.findById(id);
		
//		if(e.getName()==null || e.getName().equals("")) {
//			throw new EmployeeBodyFormatException("Name can't be null or void");
//		}
		
		if(playerDb.isPresent()) {
			Player playerUpdate = playerDb.get();
			playerUpdate.setName(player.getName());
			playerRepo.save(playerUpdate);
			return playerUpdate;
		}else {
			throw new ResourceNotFoundException("Player with id = " + id + " not found.");
		}
//		
//		return null;
	}

}

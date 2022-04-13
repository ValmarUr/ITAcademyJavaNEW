package com.itacademy.rest.service;

import java.util.List;

import com.itacademy.rest.model.Game;

public interface IGameService {

	Game playGame(Long id);
	
	void deleteAllGames(Long id);

	List<Game> getAllGames(Long id);

}

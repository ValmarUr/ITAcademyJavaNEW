package com.itacademy.rest.service;

import java.util.List;

import com.itacademy.rest.model.Game;

public interface IGameService {

	Game playGame(String id);
	
	void deleteAllGames(String id);

	List<Game> getAllGames(String id);

}

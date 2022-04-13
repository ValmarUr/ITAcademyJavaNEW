package com.itacademy.rest.service;

import com.itacademy.rest.model.Player;

public interface IRankingService {

	String getRanking();
	
	Player getLoser();
	
	Player getWinner();
	
}

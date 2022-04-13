package com.itacademy.rest.service;

import java.util.List;

import com.itacademy.rest.model.Player;

public interface IPlayerService {

	Player createPlayer(Player player);

	List<Player> getAllPlayers();

	Player updatePlayer(Player player);

}

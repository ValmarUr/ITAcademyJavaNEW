package com.itacademy.rest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.itacademy.rest.model.Player;

@Repository
public interface IPlayerRepository extends MongoRepository<Player, String> {
	
//	List<Player> findBySuccessRate
	
	//findByAgeOrderByLastnameDesc

}

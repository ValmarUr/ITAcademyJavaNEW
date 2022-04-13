package com.itacademy.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itacademy.rest.model.Player;

@Repository
public interface IPlayerRepository extends JpaRepository<Player, Long> {
	
//	List<Player> findBySuccessRate
	
	//findByAgeOrderByLastnameDesc

}

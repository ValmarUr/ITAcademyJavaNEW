package com.itacademy.rest.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itacademy.rest.model.Game;

@Repository
public interface IGameRepository extends JpaRepository<Game, Long> {

	List<Game> findByPlayerId(Long id);

	@Transactional
	void deleteByPlayerId(Long id);
}

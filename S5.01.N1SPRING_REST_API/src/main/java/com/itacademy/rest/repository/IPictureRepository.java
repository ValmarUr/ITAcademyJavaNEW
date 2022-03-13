package com.itacademy.rest.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itacademy.rest.model.Picture;

@Repository
public interface IPictureRepository extends JpaRepository<Picture, Long> {

	List<Picture> findByShopId(Long id);

	@Transactional
	void deleteByShopId(Long id);
}

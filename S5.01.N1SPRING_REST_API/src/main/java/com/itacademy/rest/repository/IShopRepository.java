package com.itacademy.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itacademy.rest.model.Shop;

@Repository
public interface IShopRepository extends JpaRepository<Shop, Long> {

}

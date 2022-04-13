package com.itacademy.rest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.itacademy.rest.model.AppUser;
@Repository
public interface IUserRepository extends MongoRepository<AppUser, String>{
	AppUser findByUsername(String username);
}

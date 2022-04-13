package com.itacademy.rest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.itacademy.rest.model.Role;
@Repository
public interface IRoleRepository extends MongoRepository<Role, String>{
	Role findByName(String name);

}

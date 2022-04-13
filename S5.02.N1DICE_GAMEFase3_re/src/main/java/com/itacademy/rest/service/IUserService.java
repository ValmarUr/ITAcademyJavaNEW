package com.itacademy.rest.service;

import java.util.List;

import com.itacademy.rest.model.AppUser;
import com.itacademy.rest.model.Role;

public interface IUserService {
	AppUser saveUser(AppUser appUser);
	Role saveRole(Role role);
	void addRoleToUser(String username, String roleName);
	AppUser getUser(String username);
	List<AppUser> getUsers();
}

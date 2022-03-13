package com.itacademy.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itacademy.rest.model.Shop;
import com.itacademy.rest.service.IShopService;

@RestController
@RequestMapping("/api/v1")
public class ShopController {
	
	@Autowired
	private IShopService service;

	@PostMapping("/shops")
	public ResponseEntity<Shop> createShop(@Valid @RequestBody Shop shop){
		
//		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(this.service.createShop(shop));
//		}catch(JobNotExistingException exception) {
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Non Valid Job! Options: Intern, Salaryman, Manager and Boss", exception);
//		}catch(EmployeeBodyFormatException exception) {
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Non valid employee body received. Send a request body with name and job", exception);
//		}
	}
	
	@GetMapping("/shops")
	public ResponseEntity<List<Shop>> getAllShops(){
		
	    List<Shop> shops = this.service.getAllShops();
	    
	    if (shops.isEmpty())		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    else 						return ResponseEntity.ok(shops);
	}
}

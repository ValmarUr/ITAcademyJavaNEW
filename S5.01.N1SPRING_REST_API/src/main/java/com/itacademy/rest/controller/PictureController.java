package com.itacademy.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itacademy.rest.model.Picture;
import com.itacademy.rest.service.IShopService;

@RestController
@RequestMapping("/api/v1")
public class PictureController {
	
	@Autowired
	private IShopService service;

	@PostMapping("/shops/{shopId}/pictures")
	public ResponseEntity<Picture> createPicture(@PathVariable long shopId,@Valid @RequestBody Picture picture){
		
//		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(this.service.createPicture(picture, shopId));
//		}catch(JobNotExistingException exception) {
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Non Valid Job! Options: Intern, Salaryman, Manager and Boss", exception);
//		}catch(EmployeeBodyFormatException exception) {
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Non valid employee body received. Send a request body with name and job", exception);
//		}
	}
	
	@GetMapping("/shops/{shopId}/pictures")
	public ResponseEntity<List<Picture>> getAllPicturesById(@PathVariable long shopId){
		
	    List<Picture> pictures = this.service.getAllPictures(shopId);
	    
	    if (pictures.isEmpty())		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    else 						return ResponseEntity.ok(pictures);
	}
	
	
	@DeleteMapping("/shops/{shopId}/pictures")
	public ResponseEntity<?> deleteAllPictures(@PathVariable long shopId){
		
//		try {
			this.service.deleteAllPictures(shopId);
			//return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.OK);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//		} catch (EmployeeNotFoundException exception) {
//			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee Not Found", exception);
//		}
	}
}
